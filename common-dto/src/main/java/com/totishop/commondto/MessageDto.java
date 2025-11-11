package com.totishop.commondto;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
public record MessageDto(Integer code,
                         String text,
                         MessageType type) {
}
