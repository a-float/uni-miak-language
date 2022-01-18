package me.miak.vals;

public class BoolValue extends Value {
    public BoolValue(Boolean value) {
        super(Type.BOOL, value);
    }

    public Boolean getBool() {
        return (boolean) this.getValue();
    }

    @Override
    public Value and(Value other) {
        if (other.getType() == Type.BOOL) {
            return new BoolValue((boolean) this.getValue() && (boolean) other.getValue());
        } else throw new UnsupportedOperationException("and operation between not booleans");
    }

    @Override
    public Value or(Value other) {
        if (other.getType() == Type.BOOL) {
            return new BoolValue((boolean) this.getValue() || (boolean) other.getValue());
        } else throw new UnsupportedOperationException("or operation between not booleans");
    }

    @Override
    public Value not() {
        return new BoolValue(!(boolean) this.getValue());
    }
}
