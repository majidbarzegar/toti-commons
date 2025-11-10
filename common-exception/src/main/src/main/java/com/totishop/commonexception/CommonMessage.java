package com.totishop.commonexception;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
public enum CommonMessage implements Message {
    SERVICE_EXCEPTION(1001),
    ;

    private final int code;

    CommonMessage(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getKey() {
        return name();
    }

}
