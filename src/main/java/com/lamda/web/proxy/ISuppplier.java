package com.lamda.web.proxy;

@FunctionalInterface
public interface ISuppplier<T> {
    public T get();
}
