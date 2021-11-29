package me.miak;

public class StringValue extends Value {
    public StringValue(String value){
        super(value);
    }

    public Boolean getBool(){
        return this.getValue().toString().length() > 0;
    }

    @Override
    public Value add(Value other) {
        return new StringValue(this.getValue().toString() + other.getValue().toString());
    }
}
