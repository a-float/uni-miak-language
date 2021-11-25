package me.miak;

public class Value {
    final Object value;

    public Value(Object value) {
        this.value = value;
    }

    public static Value getDefaultValueFromType(String type) {
        return switch (type) {
            case "int" -> new IntValue(0);
            case "bool" -> new BoolValue(false);
            default -> throw new IllegalArgumentException("Unknown type: " + type);

        };
    }

    public Object getValue() {
        return value;
    }

    public BoolValue equal(Value other) {
        if (other == null) return new BoolValue(false);
        return new BoolValue(this.getValue() == other.getValue());
    }

    public Value add(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value pow(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value unaryMinus() {
        throw new UnsupportedOperationException();
    }

    public Value subtract(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value mult(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value mod(Value right) {
        throw new UnsupportedOperationException();
    }

    public Value div(Value right) {
        throw new UnsupportedOperationException();
    }

    public Value and(Value right) {
        throw new UnsupportedOperationException();
    }

    public Value or(Value right) {
        throw new UnsupportedOperationException();
    }

    public Value not() {
        throw new UnsupportedOperationException();
    }
}
