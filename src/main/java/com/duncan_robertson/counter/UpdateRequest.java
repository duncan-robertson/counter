package com.duncan_robertson.counter;

import javax.validation.constraints.NotNull;

enum Operation {
    ADD,
    SUB
}

public class UpdateRequest {
    @NotNull(message="operation property must be set to either ADD or SUB")
    private Operation operation;

    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
