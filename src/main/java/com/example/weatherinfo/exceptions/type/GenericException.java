package com.example.weatherinfo.exceptions.type;

import com.example.weatherinfo.util.ErrorCode;
import javax.validation.constraints.NotNull;

public class GenericException extends RuntimeException {
    @NotNull
    private final ErrorCode errorCode;

    public GenericException(@NotNull final String message, @NotNull final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public GenericException(@NotNull final String message, @NotNull final ErrorCode errorCode, @NotNull final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    @NotNull
    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
