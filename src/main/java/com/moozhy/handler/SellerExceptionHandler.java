package com.moozhy.handler;

import com.moozhy.vo.ResultVO;
import com.moozhy.config.ProjectUrlConfig;
import com.moozhy.exception.ResponseBankException;
import com.moozhy.exception.SellException;
import com.moozhy.exception.SellerAuthorizeException;
import com.moozhy.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Amboo Chou on 2018/4/2.
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://sqmax.natapp1.cc/sell/wechat/qrAuthorize?returnUrl=http://sqmax.natapp1.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException(){

    }
}
