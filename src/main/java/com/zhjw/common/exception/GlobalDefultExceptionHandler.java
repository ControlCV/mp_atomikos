package com.zhjw.common.exception;


import com.zhjw.common.response.ResponseCode;
import com.zhjw.common.response.ResponseResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.stream.Collectors;

/**
 * @author zhjw
 * @date 2021/8/10 14:58
 * 功能描述: 自定义全局异常拦截处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalDefultExceptionHandler {

	/**
	 * 空指针异常处理
	 * @param e NullPointerException
	 * @return ResponseResult
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResponseResult handler(NullPointerException e) {
		print(e, true);
		return(ResponseResult.fail("空指针异常"));
	}

	/**
	 * text.parse 解析失败处理
	 * @param e NullPointerException
	 * @return ResponseResult
	 */
	@ExceptionHandler(ParseException.class)
	public ResponseResult handler(ParseException e) {
		print(e, true);
		return(ResponseResult.fail("解析异常"));
	}

	/**
	 * 路径不存在异常拦截处理
	 * @param e NoHandlerFoundException
	 * @return ResponseResult
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseResult handler(NoHandlerFoundException e) {
		print(e, true);
		return(ResponseResult.fail("不存在路径"));
	}

	/**
	 * 方法参数不合法异常拦截处理
	 * @param e MethodArgumentNotValidException
	 * @return ResponseResult
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseResult handler(MethodArgumentNotValidException e) {
		print(e, true);
		String message = e.getBindingResult().getAllErrors().stream().map(MessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
		return(ResponseResult.fail(message));
	}

	/**
	 * 参数不可读书异常拦截处理
	 * @param e HttpMessageNotReadableException
	 * @return ResponseResult
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseResult handler(HttpMessageNotReadableException e) {
		print(e, true);
		return(ResponseResult.fail("参数异常"));
	}

	/**
	 * 参数缺失异常拦截处理
	 * @param e  MissingServletRequestParameterException
	 * @return ResponseResult
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseResult handler(MissingServletRequestParameterException e) {
		print(e, true);
		return(ResponseResult.fail("缺少参数"));
	}

	/**
	 * 参数缺失异常拦截处理
	 * @param e MissingServletRequestPartException
	 * @return ResponseResult
	 */
	@ExceptionHandler(MissingServletRequestPartException.class)
	public ResponseResult handler(MissingServletRequestPartException e) {
		print(e, true);
		return(ResponseResult.fail("缺少参数"));
	}


	/**
	 * 文件超大小上传异常拦截处理
	 * @param e MaxUploadSizeExceededException
	 * @return ResponseResult
	 */
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseResult handler(MaxUploadSizeExceededException e) {
		print(e, true);
		return(ResponseResult.fail("文件最大只能上传"+e.getMaxUploadSize()));
	}

	/**
	 * 请求超时异常拦截处理
	 * @param e SocketTimeoutException
	 * @return ResponseResult
	 */
	@ExceptionHandler(SocketTimeoutException.class)
	public ResponseResult handler(SocketTimeoutException e) {
		print(e, true);
		return(ResponseResult.fail(ResponseCode.TIME_OUT.getMsg()));
	}

	/**
	 * 自定义异常拦截处理
	 * @param e BizException
	 * @return ResponseResult
	 */
	@ExceptionHandler(BizException.class)
	public ResponseResult handler(BizException e) {
		print(e, true);
		return(ResponseResult.fail(e.getMessage()));
	}

	/**
	 * 异常拦截处理
	 * @param e  Exception
	 * @return ResponseResult
	 */
	@ExceptionHandler(Exception.class)
	public ResponseResult handler(Exception e) {
		print(e, true);
		return(ResponseResult.fail(ResponseCode.FAIL.getMsg()));
	}

    /**
     * 日志打印
     * @param e Exception
     * @param printStackTrace printStackTrace
     */
    private void print(Exception e, boolean printStackTrace) {
    	if (printStackTrace) {
    		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
    				.getRequest();
    		StringBuffer url = request.getRequestURL();
    		log.error(" requestUrl={} | e={}", url,  e );
		}
    }

}
