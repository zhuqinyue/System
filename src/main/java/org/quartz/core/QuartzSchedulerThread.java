//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.quartz.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.quartz.JobPersistenceException;
import org.quartz.SchedulerException;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.core.JobRunShell;
import org.quartz.core.QuartzScheduler;
import org.quartz.core.QuartzSchedulerResources;
import org.quartz.spi.JobStore;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.TriggerFiredBundle;
import org.quartz.spi.TriggerFiredResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzSchedulerThread extends Thread {
    private QuartzScheduler qs;
    private QuartzSchedulerResources qsRsrcs;
    private final Object sigLock;
    private boolean signaled;
    private long signaledNextFireTime;
    private boolean paused;
    private AtomicBoolean halted;
    private Random random;
    private static long DEFAULT_IDLE_WAIT_TIME = 30000L;
    private long idleWaitTime;
    private int idleWaitVariablness;
    private final Logger log;
    private static final long MIN_DELAY = 20L;
    private static final long MAX_DELAY = 600000L;

    QuartzSchedulerThread(QuartzScheduler qs, QuartzSchedulerResources qsRsrcs) {
        this(qs, qsRsrcs, qsRsrcs.getMakeSchedulerThreadDaemon(), 5);
    }

    QuartzSchedulerThread(QuartzScheduler qs, QuartzSchedulerResources qsRsrcs, boolean setDaemon, int threadPrio) {
        super(qs.getSchedulerThreadGroup(), qsRsrcs.getThreadName());
        this.sigLock = new Object();
        this.random = new Random(System.currentTimeMillis());
        this.idleWaitTime = DEFAULT_IDLE_WAIT_TIME;
        this.idleWaitVariablness = 7000;
        this.log = LoggerFactory.getLogger(this.getClass());
        this.qs = qs;
        this.qsRsrcs = qsRsrcs;
        this.setDaemon(setDaemon);
        if(qsRsrcs.isThreadsInheritInitializersClassLoadContext()) {
            this.log.info("QuartzSchedulerThread Inheriting ContextClassLoader of thread: " + Thread.currentThread().getName());
            this.setContextClassLoader(Thread.currentThread().getContextClassLoader());
        }

        this.setPriority(threadPrio);
        this.paused = true;
        this.halted = new AtomicBoolean(false);
    }

    void setIdleWaitTime(long waitTime) {
        this.idleWaitTime = waitTime;
        this.idleWaitVariablness = (int)((double)waitTime * 0.2D);
    }

    private long getRandomizedIdleWaitTime() {
        return this.idleWaitTime - (long)this.random.nextInt(this.idleWaitVariablness);
    }

    void togglePause(boolean pause) {
        Object var2 = this.sigLock;
        synchronized(this.sigLock) {
            this.paused = pause;
            if(this.paused) {
                this.signalSchedulingChange(0L);
            } else {
                this.sigLock.notifyAll();
            }

        }
    }

    void halt(boolean wait) {
        Object interrupted = this.sigLock;
        synchronized(this.sigLock) {
            this.halted.set(true);
            if(this.paused) {
                this.sigLock.notifyAll();
            } else {
                this.signalSchedulingChange(0L);
            }
        }

        if(wait) {
            boolean interrupted1 = false;

            try {
                while(true) {
                    try {
                        this.join();
                        break;
                    } catch (InterruptedException var9) {
                        interrupted1 = true;
                    }
                }
            } finally {
                if(interrupted1) {
                    Thread.currentThread().interrupt();
                }

            }
        }

    }

    boolean isPaused() {
        return this.paused;
    }

    public void signalSchedulingChange(long candidateNewNextFireTime) {
        Object var3 = this.sigLock;
        synchronized(this.sigLock) {
            this.signaled = true;
            this.signaledNextFireTime = candidateNewNextFireTime;
            this.sigLock.notifyAll();
        }
    }

    public void clearSignaledSchedulingChange() {
        Object var1 = this.sigLock;
        synchronized(this.sigLock) {
            this.signaled = false;
            this.signaledNextFireTime = 0L;
        }
    }

    public boolean isScheduleChanged() {
        Object var1 = this.sigLock;
        synchronized(this.sigLock) {
            return this.signaled;
        }
    }

    public long getSignaledNextFireTime() {
        Object var1 = this.sigLock;
        synchronized(this.sigLock) {
            return this.signaledNextFireTime;
        }
    }

    public void run() {
        int acquiresFailed = 0;

        label218:
        while(!this.halted.get()) {
            try {
                Object var31 = this.sigLock;
                synchronized(this.sigLock) {
                    for(; this.paused && !this.halted.get(); acquiresFailed = 0) {
                        try {
                            this.sigLock.wait(1000L);
                        } catch (InterruptedException var22) {
                            ;
                        }
                    }

                    if(this.halted.get()) {
                        break;
                    }
                }

                if(acquiresFailed > 1) {
                    try {
                        long var30 = computeDelayForRepeatedErrors(this.qsRsrcs.getJobStore(), acquiresFailed);
                        Thread.sleep(var30);
                    } catch (Exception var21) {
                        ;
                    }
                }

                int var311 = this.qsRsrcs.getThreadPool().blockForAvailableThreads();
                if(var311 > 0) {
                    long now = System.currentTimeMillis();
                    this.clearSignaledSchedulingChange();

                    List triggers;
                    try {
                        triggers = this.qsRsrcs.getJobStore().acquireNextTriggers(now + this.idleWaitTime, Math.min(var311, this.qsRsrcs.getMaxBatchSize()), this.qsRsrcs.getBatchTimeWindow());
                        acquiresFailed = 0;
                        if(this.log.isDebugEnabled()) {
                            ;
                        }
                    } catch (JobPersistenceException var24) {
                        if(acquiresFailed == 0) {
                            this.qs.notifySchedulerListenersError("An error occurred while scanning for the next triggers to fire.", var24);
                        }

                        if(acquiresFailed < 2147483647) {
                            ++acquiresFailed;
                        }
                        continue;
                    } catch (RuntimeException var25) {
                        if(acquiresFailed == 0) {
                            this.getLog().error("quartzSchedulerThreadLoop: RuntimeException " + var25.getMessage(), var25);
                        }

                        if(acquiresFailed < 2147483647) {
                            ++acquiresFailed;
                        }
                        continue;
                    }

                    long waitTime;
                    long timeUntilContinue;
                    Object i;
                    if(triggers != null && !triggers.isEmpty()) {
                        now = System.currentTimeMillis();
                        waitTime = ((OperableTrigger)triggers.get(0)).getNextFireTime().getTime();

                        for(timeUntilContinue = waitTime - now; timeUntilContinue > 2L; timeUntilContinue = waitTime - now) {
                            i = this.sigLock;
                            synchronized(this.sigLock) {
                                if(this.halted.get()) {
                                    break;
                                }

                                if(!this.isCandidateNewTimeEarlierWithinReason(waitTime, false)) {
                                    try {
                                        now = System.currentTimeMillis();
                                        timeUntilContinue = waitTime - now;
                                        if(timeUntilContinue >= 1L) {
                                            this.sigLock.wait(timeUntilContinue);
                                        }
                                    } catch (InterruptedException var20) {
                                        ;
                                    }
                                }
                            }

                            if(this.releaseIfScheduleChangedSignificantly(triggers, waitTime)) {
                                break;
                            }

                            now = System.currentTimeMillis();
                        }

                        if(!triggers.isEmpty()) {
                            Object var32 = new ArrayList();
                            boolean goAhead = true;
                            i = this.sigLock;
                            synchronized(this.sigLock) {
                                goAhead = !this.halted.get();
                            }

                            if(goAhead) {
                                try {
                                    List var33 = this.qsRsrcs.getJobStore().triggersFired(triggers);
                                    if(var33 != null) {
                                        var32 = var33;
                                    }
                                } catch (SchedulerException var23) {
                                    this.qs.notifySchedulerListenersError("An error occurred while firing triggers \'" + triggers + "\'", var23);
                                    int result = 0;

                                    while(true) {
                                        if(result >= triggers.size()) {
                                            continue label218;
                                        }

                                        this.qsRsrcs.getJobStore().releaseAcquiredTrigger((OperableTrigger)triggers.get(result));
                                        ++result;
                                    }
                                }
                            }

                            for(int var34 = 0; var34 < ((List)var32).size(); ++var34) {
                                TriggerFiredResult var35 = (TriggerFiredResult)((List)var32).get(var34);
                                TriggerFiredBundle bndle = var35.getTriggerFiredBundle();
                                Exception exception = var35.getException();
                                if(exception instanceof RuntimeException) {
                                    this.getLog().error("RuntimeException while firing trigger " + triggers.get(var34), exception);
                                    this.qsRsrcs.getJobStore().releaseAcquiredTrigger((OperableTrigger)triggers.get(var34));
                                } else if(bndle == null) {
                                    this.qsRsrcs.getJobStore().releaseAcquiredTrigger((OperableTrigger)triggers.get(var34));
                                } else {
                                    JobRunShell shell = null;

                                    try {
                                        shell = this.qsRsrcs.getJobRunShellFactory().createJobRunShell(bndle);
                                        shell.initialize(this.qs);
                                    } catch (SchedulerException var26) {
                                        this.qsRsrcs.getJobStore().triggeredJobComplete((OperableTrigger)triggers.get(var34), bndle.getJobDetail(), CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_ERROR);
                                        continue;
                                    }

                                    if(!this.qsRsrcs.getThreadPool().runInThread(shell)) {
                                        this.getLog().error("ThreadPool.runInThread() return false!");
                                        this.qsRsrcs.getJobStore().triggeredJobComplete((OperableTrigger)triggers.get(var34), bndle.getJobDetail(), CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_ERROR);
                                    }
                                }
                            }
                        }
                    } else {
                        now = System.currentTimeMillis();
                        waitTime = now + this.getRandomizedIdleWaitTime();
                        timeUntilContinue = waitTime - now;
                        i = this.sigLock;
                        synchronized(this.sigLock) {
                            try {
                                if(!this.halted.get() && !this.isScheduleChanged()) {
                                    this.sigLock.wait(timeUntilContinue);
                                }
                            } catch (InterruptedException var17) {
                                ;
                            }
                        }
                    }
                }
            } catch (RuntimeException var29) {
                this.getLog().error("Runtime error occurred in main trigger firing loop.", var29);
            }
        }

        this.qs = null;
        this.qsRsrcs = null;
    }

    private static long computeDelayForRepeatedErrors(JobStore jobStore, int acquiresFailed) {
        long delay;
        try {
            delay = jobStore.getAcquireRetryDelay(acquiresFailed);
        } catch (Exception var5) {
            delay = 100L;
        }

        if(delay < 20L) {
            delay = 20L;
        }

        if(delay > 600000L) {
            delay = 600000L;
        }

        return delay;
    }

    private boolean releaseIfScheduleChangedSignificantly(List<OperableTrigger> triggers, long triggerTime) {
        if(!this.isCandidateNewTimeEarlierWithinReason(triggerTime, true)) {
            return false;
        } else {
            Iterator i$ = triggers.iterator();

            while(i$.hasNext()) {
                OperableTrigger trigger = (OperableTrigger)i$.next();
                this.qsRsrcs.getJobStore().releaseAcquiredTrigger(trigger);
            }

            triggers.clear();
            return true;
        }
    }

    private boolean isCandidateNewTimeEarlierWithinReason(long oldTime, boolean clearSignal) {
        Object var4 = this.sigLock;
        synchronized(this.sigLock) {
            if(!this.isScheduleChanged()) {
                return false;
            } else {
                boolean earlier = false;
                if(this.getSignaledNextFireTime() == 0L) {
                    earlier = true;
                } else if(this.getSignaledNextFireTime() < oldTime) {
                    earlier = true;
                }

                if(earlier) {
                    long diff = oldTime - System.currentTimeMillis();
                    if(diff < (this.qsRsrcs.getJobStore().supportsPersistence()?70L:7L)) {
                        earlier = false;
                    }
                }

                if(clearSignal) {
                    this.clearSignaledSchedulingChange();
                }

                return earlier;
            }
        }
    }

    public Logger getLog() {
        return this.log;
    }
}
