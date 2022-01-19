package me.miak.vals;

public class StringValue extends Value {
    public StringValue(String value){
        super(Type.STRING, value);
    }

    public Boolean getBool(){
        return this.getValue().toString().length() > 0;
    }

    @Override
    public Value add(Value other) {
        return new StringValue(this.getValue().toString() + other.getValue().toString());
    }

    @Override
    public BoolValue not(){ return new BoolValue(!this.getBool());}
}
