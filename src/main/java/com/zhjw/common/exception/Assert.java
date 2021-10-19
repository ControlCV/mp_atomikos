package com.zhjw.common.exception;

import org.springframework.util.StringUtils;

/**
 * @author zhjw
 * @date 2021/8/10 14:58
 * @apiNote 帮助验证参数的断言工具
 */
public class Assert {
    /**
     * 值不能为空，如果是空则报错
     *
     * @param value 需要检验的值
     * @param defaultMsg 返回的错误信息
     */
    public static void isNotBlank(String value, String defaultMsg) {
        if (StringUtils.hasText(value)){
            throw new BizException(defaultMsg);
        }
    }

    /**
     * 参数不能为空，为空报错
     *
     * @param type  需要校验的参数
     * @param defaultMsg 返回的错误信息
     */
    public static void isNotNull(Object type, String defaultMsg) {
        if (type == null){
            throw new BizException(defaultMsg);
        }
    }

}
