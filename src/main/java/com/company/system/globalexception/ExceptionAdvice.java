//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.globalexception;

import com.company.system.exception.ServiceExcetion;
import com.company.system.vo.SysResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    public ExceptionAdvice() {
    }

    @ExceptionHandler({ServiceExcetion.class})
    @ResponseBody
    public SysResult ServiceException(Exception e) {
        e.printStackTrace();
        return SysResult.build(Integer.valueOf(1), e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public SysResult defaultException(Exception e) {
        e.printStackTrace();
        return SysResult.build(Integer.valueOf(1), "系统错误,请联系管理员");
    }
}
