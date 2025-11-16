package com.totishop.commonexception;

import com.totishop.commondto.ResponseDto;
import com.totishop.commonmessage.MessageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.totishop.commonmessage.CommonMessage.SERVICE_EXCEPTION;


/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */

@ControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final MessageService messageService;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseDto<?>> handle(BusinessException ex) {
        String text;
        Integer code;
        if (ex.getKey().isBlank()) {
            text = messageService.getMessage(SERVICE_EXCEPTION.getKey());
            code = SERVICE_EXCEPTION.getCode();
        } else {
            text = messageService.getMessage(ex.getKey(), ex.getArgs());
            code = ex.getCode();
        }
        return new ResponseEntity<>(
                ResponseDto.error(text, code),
                HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex) {
        LOGGER.error("exception occur: ", ex);
        return new ResponseEntity<>(
                ResponseDto.error(
                        messageService.getMessage(SERVICE_EXCEPTION.getKey()),
                        SERVICE_EXCEPTION.getCode()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
