package br.com.gom.person.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;
    private String httpStatus;

    public ExceptionResponse(Date timestamp, String message, String details, String httpStatus) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public String getHttpStatus() {
        return httpStatus;
    }
}
