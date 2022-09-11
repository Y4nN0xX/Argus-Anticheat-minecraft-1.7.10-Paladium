package fr.paladium.argus.utils.heap.datastructures;

import fr.paladium.argus.utils.heap.datastructures.Type;

public class Value<T> {
    public final Type type;
    public final T value;

    public Value(Type type, T value) {
        this.value = value;
        this.type = type;
    }

    public String toString() {
        return this.value.toString();
    }
}
