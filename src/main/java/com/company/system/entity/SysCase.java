//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_case")
public class SysCase {
    @TableId(
            value = "caseid",
            type = IdType.AUTO
    )
    private Integer caseid;
    private String casetlt;
    private String casebody;
    private String casetarget;
    private Integer casepv;
    private String caselike;
    private String caseimgsrc;
    private String casestarttime;
    private String caseendtime;
    private String casecreattime;
    private String casezhuangtai;
    private String caseiszancun;
    private String caseupdatetime;

    public SysCase() {
    }

    public Integer getCaseid() {
        return this.caseid;
    }

    public String getCasetlt() {
        return this.casetlt;
    }

    public String getCasebody() {
        return this.casebody;
    }

    public String getCasetarget() {
        return this.casetarget;
    }

    public Integer getCasepv() {
        return this.casepv;
    }

    public String getCaselike() {
        return this.caselike;
    }

    public String getCaseimgsrc() {
        return this.caseimgsrc;
    }

    public String getCasestarttime() {
        return this.casestarttime;
    }

    public String getCaseendtime() {
        return this.caseendtime;
    }

    public String getCasecreattime() {
        return this.casecreattime;
    }

    public String getCasezhuangtai() {
        return this.casezhuangtai;
    }

    public String getCaseiszancun() {
        return this.caseiszancun;
    }

    public String getCaseupdatetime() {
        return this.caseupdatetime;
    }

    public void setCaseid(Integer caseid) {
        this.caseid = caseid;
    }

    public void setCasetlt(String casetlt) {
        this.casetlt = casetlt;
    }

    public void setCasebody(String casebody) {
        this.casebody = casebody;
    }

    public void setCasetarget(String casetarget) {
        this.casetarget = casetarget;
    }

    public void setCasepv(Integer casepv) {
        this.casepv = casepv;
    }

    public void setCaselike(String caselike) {
        this.caselike = caselike;
    }

    public void setCaseimgsrc(String caseimgsrc) {
        this.caseimgsrc = caseimgsrc;
    }

    public void setCasestarttime(String casestarttime) {
        this.casestarttime = casestarttime;
    }

    public void setCaseendtime(String caseendtime) {
        this.caseendtime = caseendtime;
    }

    public void setCasecreattime(String casecreattime) {
        this.casecreattime = casecreattime;
    }

    public void setCasezhuangtai(String casezhuangtai) {
        this.casezhuangtai = casezhuangtai;
    }

    public void setCaseiszancun(String caseiszancun) {
        this.caseiszancun = caseiszancun;
    }

    public void setCaseupdatetime(String caseupdatetime) {
        this.caseupdatetime = caseupdatetime;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof SysCase)) {
            return false;
        } else {
            SysCase other = (SysCase)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label167: {
                    Integer this$caseid = this.getCaseid();
                    Integer other$caseid = other.getCaseid();
                    if(this$caseid == null) {
                        if(other$caseid == null) {
                            break label167;
                        }
                    } else if(this$caseid.equals(other$caseid)) {
                        break label167;
                    }

                    return false;
                }

                String this$casetlt = this.getCasetlt();
                String other$casetlt = other.getCasetlt();
                if(this$casetlt == null) {
                    if(other$casetlt != null) {
                        return false;
                    }
                } else if(!this$casetlt.equals(other$casetlt)) {
                    return false;
                }

                label153: {
                    String this$casebody = this.getCasebody();
                    String other$casebody = other.getCasebody();
                    if(this$casebody == null) {
                        if(other$casebody == null) {
                            break label153;
                        }
                    } else if(this$casebody.equals(other$casebody)) {
                        break label153;
                    }

                    return false;
                }

                String this$casetarget = this.getCasetarget();
                String other$casetarget = other.getCasetarget();
                if(this$casetarget == null) {
                    if(other$casetarget != null) {
                        return false;
                    }
                } else if(!this$casetarget.equals(other$casetarget)) {
                    return false;
                }

                label139: {
                    Integer this$casepv = this.getCasepv();
                    Integer other$casepv = other.getCasepv();
                    if(this$casepv == null) {
                        if(other$casepv == null) {
                            break label139;
                        }
                    } else if(this$casepv.equals(other$casepv)) {
                        break label139;
                    }

                    return false;
                }

                String this$caselike = this.getCaselike();
                String other$caselike = other.getCaselike();
                if(this$caselike == null) {
                    if(other$caselike != null) {
                        return false;
                    }
                } else if(!this$caselike.equals(other$caselike)) {
                    return false;
                }

                label125: {
                    String this$caseimgsrc = this.getCaseimgsrc();
                    String other$caseimgsrc = other.getCaseimgsrc();
                    if(this$caseimgsrc == null) {
                        if(other$caseimgsrc == null) {
                            break label125;
                        }
                    } else if(this$caseimgsrc.equals(other$caseimgsrc)) {
                        break label125;
                    }

                    return false;
                }

                label118: {
                    String this$casestarttime = this.getCasestarttime();
                    String other$casestarttime = other.getCasestarttime();
                    if(this$casestarttime == null) {
                        if(other$casestarttime == null) {
                            break label118;
                        }
                    } else if(this$casestarttime.equals(other$casestarttime)) {
                        break label118;
                    }

                    return false;
                }

                String this$caseendtime = this.getCaseendtime();
                String other$caseendtime = other.getCaseendtime();
                if(this$caseendtime == null) {
                    if(other$caseendtime != null) {
                        return false;
                    }
                } else if(!this$caseendtime.equals(other$caseendtime)) {
                    return false;
                }

                label104: {
                    String this$casecreattime = this.getCasecreattime();
                    String other$casecreattime = other.getCasecreattime();
                    if(this$casecreattime == null) {
                        if(other$casecreattime == null) {
                            break label104;
                        }
                    } else if(this$casecreattime.equals(other$casecreattime)) {
                        break label104;
                    }

                    return false;
                }

                label97: {
                    String this$casezhuangtai = this.getCasezhuangtai();
                    String other$casezhuangtai = other.getCasezhuangtai();
                    if(this$casezhuangtai == null) {
                        if(other$casezhuangtai == null) {
                            break label97;
                        }
                    } else if(this$casezhuangtai.equals(other$casezhuangtai)) {
                        break label97;
                    }

                    return false;
                }

                String this$caseiszancun = this.getCaseiszancun();
                String other$caseiszancun = other.getCaseiszancun();
                if(this$caseiszancun == null) {
                    if(other$caseiszancun != null) {
                        return false;
                    }
                } else if(!this$caseiszancun.equals(other$caseiszancun)) {
                    return false;
                }

                String this$caseupdatetime = this.getCaseupdatetime();
                String other$caseupdatetime = other.getCaseupdatetime();
                if(this$caseupdatetime == null) {
                    if(other$caseupdatetime != null) {
                        return false;
                    }
                } else if(!this$caseupdatetime.equals(other$caseupdatetime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysCase;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        Integer $caseid = this.getCaseid();
        int result1 = result * 59 + ($caseid == null?43:$caseid.hashCode());
        String $casetlt = this.getCasetlt();
        result1 = result1 * 59 + ($casetlt == null?43:$casetlt.hashCode());
        String $casebody = this.getCasebody();
        result1 = result1 * 59 + ($casebody == null?43:$casebody.hashCode());
        String $casetarget = this.getCasetarget();
        result1 = result1 * 59 + ($casetarget == null?43:$casetarget.hashCode());
        Integer $casepv = this.getCasepv();
        result1 = result1 * 59 + ($casepv == null?43:$casepv.hashCode());
        String $caselike = this.getCaselike();
        result1 = result1 * 59 + ($caselike == null?43:$caselike.hashCode());
        String $caseimgsrc = this.getCaseimgsrc();
        result1 = result1 * 59 + ($caseimgsrc == null?43:$caseimgsrc.hashCode());
        String $casestarttime = this.getCasestarttime();
        result1 = result1 * 59 + ($casestarttime == null?43:$casestarttime.hashCode());
        String $caseendtime = this.getCaseendtime();
        result1 = result1 * 59 + ($caseendtime == null?43:$caseendtime.hashCode());
        String $casecreattime = this.getCasecreattime();
        result1 = result1 * 59 + ($casecreattime == null?43:$casecreattime.hashCode());
        String $casezhuangtai = this.getCasezhuangtai();
        result1 = result1 * 59 + ($casezhuangtai == null?43:$casezhuangtai.hashCode());
        String $caseiszancun = this.getCaseiszancun();
        result1 = result1 * 59 + ($caseiszancun == null?43:$caseiszancun.hashCode());
        String $caseupdatetime = this.getCaseupdatetime();
        result1 = result1 * 59 + ($caseupdatetime == null?43:$caseupdatetime.hashCode());
        return result1;
    }

    public String toString() {
        return "SysCase(caseid=" + this.getCaseid() + ", casetlt=" + this.getCasetlt() + ", casebody=" + this.getCasebody() + ", casetarget=" + this.getCasetarget() + ", casepv=" + this.getCasepv() + ", caselike=" + this.getCaselike() + ", caseimgsrc=" + this.getCaseimgsrc() + ", casestarttime=" + this.getCasestarttime() + ", caseendtime=" + this.getCaseendtime() + ", casecreattime=" + this.getCasecreattime() + ", casezhuangtai=" + this.getCasezhuangtai() + ", caseiszancun=" + this.getCaseiszancun() + ", caseupdatetime=" + this.getCaseupdatetime() + ")";
    }
}
