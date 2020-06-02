package com.lamda.web.proxy;

@FunctionalInterface
public interface IFuntion<T,R> {
    public R apply(T t);
}
