package com.pojoutils.builder;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Alex L.
 */
public class PredicateBuilder<T> extends GenericBuilder<T> {

    private List<Predicate<T>> predicates;

    public PredicateBuilder(Supplier<T> instantiator, List<Predicate<T>> predicates) {
        super(instantiator);
        this.predicates = predicates;
    }

    public T build() {
        T value = getInstantiator().get();
        List<Consumer<T>> instanceModifiers = getInstanceModifiers();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        verifyPredicates(value);
        instanceModifiers.clear();
        return value;
    }

    private void verifyPredicates(T value) {
        List<Predicate<T>> violated = predicates.stream()
            .filter(e -> !e.test(value)).collect(Collectors.toList());
        if (!violated.isEmpty()) {
            throw new IllegalStateException(value.toString()
                + " violates predicates " + violated);
        }
    }

}
