package dev.sumantakumar.springbootssrf.exception;

import org.springframework.boot.http.client.FilteredHostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SsrfExceptionHandler {

    @ExceptionHandler(FilteredHostException.class)
    public ProblemDetail handleFilteredHostException(FilteredHostException e) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN,
                "Request to %s is forbidden".formatted(e.getHost()));
        problem.setTitle("🔒 Destination Blocked ");
        return problem;
    }
}
