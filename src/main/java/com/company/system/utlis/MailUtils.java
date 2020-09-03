//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.utlis;

import com.company.system.exception.ServiceExcetion;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
    public static final Logger LOGGER = LogManager.getLogger("");
    @Autowired
    JavaMailSenderImpl javaMailSender;

    public MailUtils() {
    }

    public Integer sendMail(String name, String tel, String content) {
        MimeMessage mailMessage = this.javaMailSender.createMimeMessage();

        try {
            if(name != null && !"".equals(name)) {
                if(tel != null && !"".equals(tel)) {
                    MimeMessageHelper e = new MimeMessageHelper(mailMessage, true, "utf-8");
                    e.setFrom("1969188163@qq.com");
                    e.setTo("401187784@qq.com");
                    e.setSubject("【云顶空间客户需求沟通邮件】");
                    String s = "客户姓名：" + name + "\n" + "\n" + "客户电话：" + tel + "\n" + "\n" + "客户需求：" + content + "\n" + "\n" + "                               请及时沟通哦~！" + "\n" + "\n" + "                                           此邮件为系统自动发送   请勿回复！";
                    e.setText(s);
                    this.javaMailSender.send(mailMessage);
                    LOGGER.info("邮件发送成功...");
                    return Integer.valueOf(1);
                } else {
                    throw new ServiceExcetion("请填写电话哦");
                }
            } else {
                throw new ServiceExcetion("请填写姓名哦");
            }
        } catch (Exception var7) {
            LOGGER.error("邮件发送发生异常:" + var7.getMessage(), var7);
            return Integer.valueOf(2);
        }
    }
}
