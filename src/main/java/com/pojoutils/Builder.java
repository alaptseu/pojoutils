package com.pojoutils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Alex L.
 */
public interface Builder<T> {

    Supplier<T> getInstantiator();

    List<Consumer<T>> getInstanceModifiers();

    default T build() {
        T value = getInstantiator().get();
        List<Consumer<T>> instanceModifiers = getInstanceModifiers();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }

}
