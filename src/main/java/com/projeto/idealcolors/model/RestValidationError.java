package com.projeto.idealcolors.model;

public record RestValidationError(
        Integer code,
        String field,
        String message
) {}
