package com.totishop.commonexception;


import lombok.Getter;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;
    private final String key;
    private final Object[] args;

    public BusinessException(Message message, Object... args) {
        super(message.toString());
        this.key = message.getKey();
        this.code = message.getCode();
        this.args = args;
    }

    public BusinessException(Message message) {
        super(message.toString());
        this.key = message.getKey();
        this.code = message.getCode();
        this.args = null;
    }

}
