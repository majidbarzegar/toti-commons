package com.totishop.commondto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<R> {
    private R result;
    private MessageDto messageDto;


    public static <R> ResponseDto<R> success(R result, String text) {
        return new ResponseDto<>(
                result,
                new MessageDto(200, text, MessageType.SUCCESS)
        );
    }

    public static <R> ResponseDto<R> success(R result, String text, int code) {
        return new ResponseDto<>(
                result,
                new MessageDto(code, text, MessageType.SUCCESS)
        );
    }

    public static <R> ResponseDto<R> error(String text, int code) {
        return new ResponseDto<>(
                null,
                new MessageDto(code, text, MessageType.ERROR)
        );
    }
}
