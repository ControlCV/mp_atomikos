package com.zhjw.common.exception;

/**
 * @author zhjw
 * @date 2021/8/10 14:58
 * 功能描述: 自定义业务异常
 */
public class BizException extends RuntimeException {
    private String code;

	private static final long serialVersionUID = -1260198679814923178L;

	public BizException() {
        super();
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String code, String message){
	    super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
