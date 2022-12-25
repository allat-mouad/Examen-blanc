package com.example.openapi.commands;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@NoArgsConstructor

public abstract class BaseCommand<T> {
    @TargetAggregateIdentifier
    protected T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
