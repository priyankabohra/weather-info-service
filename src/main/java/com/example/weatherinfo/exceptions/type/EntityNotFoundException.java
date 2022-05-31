package com.example.weatherinfo.exceptions.type;

import com.example.weatherinfo.util.ErrorCode;
import javax.validation.constraints.NotNull;

/**
 * This is the type EntityNotFoundException.
 */
public class EntityNotFoundException extends GenericException {
    public EntityNotFoundException(@NotNull final String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
