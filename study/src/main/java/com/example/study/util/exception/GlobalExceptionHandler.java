package com.example.study.util.exception;

import com.example.study.util.R;
import com.example.study.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 异常处理器
 *
 * @author zj998
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public R handleException(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return R.error("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public R notFount(RuntimeException e) {
        logger.error("运行时异常:", e);
        return R.error(e.getMessage());
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RuoyiException.class)
    public R handleWindException(RuoyiException e) {
        return R.error(e.getCode(), e.getMessage());
    }

    /**
     * 数据库中已存在该记录
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

    /**
     * 异常处理机制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        logger.error(e.getMessage(), e);
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            StringBuilder buffer = new StringBuilder();
            buffer.append("数据校验不通过, 原因：");
            List<ObjectError> errors = bindingResult.getAllErrors();
            JSONObject json = new JSONObject();
            for (ObjectError error : errors) {
                buffer.append(" ").append(error.getDefaultMessage());
                json.set(((FieldError) error).getField(), error.getDefaultMessage());
            }
            return R.error(500, buffer.toString(), json);
        }
        return R.error("服务器错误，请联系管理员");
    }

    /**
     * 异常处理机制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UncategorizedSQLException.class)
    public R handleUncategorizedSQLException (UncategorizedSQLException e) {
        logger.error(e.getMessage(), e);
        return R.error("请检查输入的内容,请勿输入表情");
    }

    /**
     * 捕捉UnauthorizedException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public R handle401(UnauthorizedException e) {
        return R.error(401, e.getMessage());
    }

    @ExceptionHandler(ValidateCodeException.class)
    public R handle401(ValidateCodeException e) {
        return R.error(e.getMessage());
    }
}