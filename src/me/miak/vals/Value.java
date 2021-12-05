package me.miak.vals;

import me.miak.MyVisitor;
import org.antlr.v4.runtime.misc.Triple;

import java.util.List;

public abstract class Value {
    final private Object value;
    final private Type type;

    public Value(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public Type getType() {
        return this.type;
    }

    // TODO test and possibly fix getCopy method
    public Value getCopy() {
        Value toReturn;
        switch (this.getType()) {
            case NULL -> toReturn = this;
            case INT -> toReturn = new IntValue((int) this.getValue());
            case STRING -> toReturn = new StringValue(this.getValue().toString());
            case BOOL -> toReturn = new BoolValue((boolean) this.getValue());
            case ITERABLE -> {
                Triple<Value, Value, Value> data = (Triple<Value, Value, Value>) this.getValue();
                toReturn = new RangeValue(data.a, data.b, data.c);
            }
            default -> throw new IllegalArgumentException("No copy defined for " + this.getType());
        }
        return toReturn;
    }

    public Boolean getBool() {
        return this.getValue() != null;
    }

    public BoolValue equal(Value other) {
        if (other == null) return new BoolValue(false);
        return new BoolValue(this.getValue().equals(other.getValue()));
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

    public Value mod(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value div(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value and(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value or(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value not() {
        throw new UnsupportedOperationException();
    }

    public Value lessThan(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value lessOrEqualThan(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value moreOrEqualThan(Value other) {
        throw new UnsupportedOperationException();
    }

    public Value call(MyVisitor visitor, List<Value> callArgs){
        throw new UnsupportedOperationException();
    }

    public String getString(){
        return this.getValue().toString();
    }
}
