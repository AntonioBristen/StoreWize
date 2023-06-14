package com.cerberobeta.StoreWize.exception;

public class RestResponseException extends Exception {
    private static final long serialVersionUID = 1L;
    private final int httpStatus;
    private final String responseBody;
    public RestResponseException(int httpStatus, String responseBody, Throwable cause) {
        super(cause);
        this.httpStatus = httpStatus;
        this.responseBody = responseBody;
    }
    public int getHttpStatus() {
        return httpStatus;
    }
    public String getResponseBody() {
        return responseBody;
    }
}
