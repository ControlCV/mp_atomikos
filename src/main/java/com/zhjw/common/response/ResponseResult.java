package com.zhjw.common.response;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 请求返回包装模型实体
 * 说明：
 * 1. requestId,version,source即请求链接中的参数
 * 2. 所有的返回业务实体，即是泛型实体
 * 
 * @author zhjw
 * @param <T> 返回的泛型实体
 */

@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(ResponseResult.class);

	public static final String SUCCESS = ResponseCode.SUCCESS.getCode();
	public static final String SUCCESS_MESSAGE = ResponseCode.SUCCESS.getMsg();
	public static final String ERROR =  ResponseCode.ERROR.getCode();
	public static final String ERROR_MESSAGE = ResponseCode.ERROR.getMsg();


	/**
	 * 请求编号
	 */
    public String requestId;

	/**
	 * 响应编号
	 */
	public String responseId;

	/**
	 * 接⼝版本
	 */
	public String version;

	/**
	 * 请求来源
	 */
	public String source;

	/**
	 * 状态码，200为正常
	 */
    private String code;

	/**
	 * 描述信息
	 */
	private String message;

	/**
	 * 结果数据
	 */
	private T data;
	
	public static  <T> ResponseResult<T> success(){
		ResponseResult<T> res = new ResponseResult<T>(SUCCESS, SUCCESS_MESSAGE);
		return res;
	}
	public static  <T> ResponseResult<T> success(T t){
		ResponseResult<T> res = new ResponseResult<T>(SUCCESS, SUCCESS_MESSAGE);
		res.setData(t);
		return res;
	}
	public static  <T> ResponseResult<T> fail(){
		ResponseResult<T> res = new ResponseResult<T>(ERROR, ERROR_MESSAGE);
		return res;
	}
    public static <T> ResponseResult<T> fail(ResponseCode responseCode) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(responseCode.getCode());
        responseResult.setMessage(responseCode.getMsg());
        return responseResult;
    }
	public static  <T> ResponseResult<T> fail(String errorMessage){
		ResponseResult<T> res = new ResponseResult<T>(ERROR, errorMessage);
		return res;
	}
	public static  <T> ResponseResult<T> fail(String code, String errorMessage){
		ResponseResult<T> res = new ResponseResult<T>(code, errorMessage);
		return res;
	}
	public ResponseResult(String resultCode, String resultMsg) {
		super();
		this.setCode(resultCode);
		this.setMessage(resultMsg);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseResult() {

	}
	
}
