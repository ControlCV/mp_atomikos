package com.zhjw.common.response;

/**
 * 响应编码枚举
 * 
 * @author zhjw
 *
 */
public enum ResponseCode {

    //操作成功
	SUCCESS("200", "base_success", "操作成功"),
	//系统异常
	ERROR("500", "base_error", "系统异常"),
	//系统操作失败
	FAIL("500", "base_fail", "系统操作失败"),
	//系统操作超时
	TIME_OUT("500", "base_time_out", "操作超时"),


	//未认证
	UNAUTHORIZED("401", "", "未认证"),
	//token缺失，非法请求
	UNAUTHORIZED_TOKEN_NOT_FOUND("401", "token_not_found", "token缺失，非法请求"),
	//token解析失败
	UNAUTHORIZED_TOKEN_PARSE_ERROR("401", "token_parse_error", "token解析失败"),
	//没有操作权限
	UNAUTHORIZED_PERMISSSION_DENIED("401", "permission_denied", "没有操作权限"),


	//没有登录,或登录已过期
	ACCOUNT_NO_LOGIN("401", "account_no_login", "没有登录,或登录已过期"),
	//帐号已过期"
	ACCOUNT_EXPIRED("403", "account_expired", "帐号已过期"),
	//帐号已禁用
	ACCOUNT_DISABLED("403", "account_disabled", "帐号已禁用"),
	//帐号已锁定
	ACCOUNT_LOCKED("403", "account_locked", "帐号已锁定"),
	//已经存在相同的登录账号
	Account_REPEAT("403","account_repeat","已经存在相同的登录账号"),
	//密码过期
	ACCOUONT_PASSWORD_EXPIRED("403", "password_expired", "密码过期"),
	//用户名或密码错误
	ACCOUNT_PASSWORD_WORNG("403", "account_password_worng", "用户名或密码错误"),
	//找不到该帐号
	ACCOUNT_USERNAME_NOT_FOUND("401", "account_username_not_found", "找不到该帐号"),
	//session会话异常
	ACCOUNT_SESSIOIN_EXPIRED("403", "account_session_expired", "session会话异常"),
	//验证码异常
	ACCOUNT_CAPTCHA_NOT_FOUND("403","account_captcha_not_found","验证码异常"),
	//验证码有误
	ACCOUNT_CAPTCHA_WORNG("403","account_captcha_worng","验证码有误"),


	//不支持当前请求方法
	METHOD_NO_SUPPORT("405","base_method_no_support", "不支持当前请求方法"),
	//参数格式,无法解析
	PARAMETER_CANNOT_BE_PARSE("403","unable_to_parse","参数格式,无法解析"),
	//参数不能为空
	PARAMETER_CANNOT_BE_EMPTY("403","query_condition_cannot_be_empty","参数不能为空"),
	//参数不完整
	PARAMETER_INCOMPLETE("403","parameter_incomplete","参数不完整"),
	//参数异常
	PARAMETER_ERROR("400", "base_param_error", "参数异常"),

	//外部接口失败
	EXTENAL_INTERFACE_ERROR("500","extenal_interface_error","外部接口失败"),
	EXTENAL_INTERFACE_RESPONSE_FAIL("0","extenal_interface_error","外部接口响应失败"),
	EXTENAL_INTERFACE_RESPONSE_SUCCESS("1","extenal_interface_error","外部接口响应成功"),
	EXTENAL_INTERFACE_OPERATE_FAIL("0","extenal_interface_error","外部接口业务操作失败"),
	EXTENAL_INTERFACE_OPERATE_SUCCESS("1","extenal_interface_error","外部接口业务操作成功"),

	//数据库操作异常
	DATABASE_OPERATE_ERROR("403","database_operate_error","数据库操作异常"),
	//输入的参数长度超标
	DATABASE_LENGTH_ERROR("403","database_length_error","输入的参数长度超标"),
	//输入的参数类型或格式有误
	DATABASE_PARSE_ERROR("403","database_parse_error","输入的参数类型或格式有误"),
	//数据异常
	DATA_ERROR("403","data_error","数据异常"),
	//数据不存在
	DATA_NOT_EXIST("403","data_not_exist","数据不存在"),
	
	//文件不存在
	FILE_NOT_EXIST("403","file_not_exist","文件不存在"),

	//请粘贴由公众号发布的微信文章链接
	WECHAT_RELEASE_FALSE("403","","请粘贴由公众号发布的微信文章链接"),

	//上传失败，请重试或换个链接
	WECHAT_ANALYSIS_FALSE("403","","上传失败，请重试或换个链接"),

	//来晚了，内容已下架
	WECHAT_CONTEXT_OFFLOAD("402","","来晚了，内容已下架")
	;

	
	private String httpCode;
	private String code;
	private String msg;

	private ResponseCode(String code, String httpCode, String msg) {
		this.httpCode = httpCode;
		this.code = code;
		this.msg = msg;
	}
	public String getHttpCode() {
		return httpCode;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}

}
