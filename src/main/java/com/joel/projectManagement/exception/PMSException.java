package com.joel.projectManagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PMSException extends Exception{
    private List<PMSError> errors;

    public PMSException (List<PMSError> errors) {
        this.errors = errors;
    }
}
