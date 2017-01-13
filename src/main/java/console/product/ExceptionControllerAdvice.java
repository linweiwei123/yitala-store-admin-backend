package console.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import common.ErrorResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(ex.getMessage()!=null?ex.getMessage():"系统错误请联系管理员");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
    
}
