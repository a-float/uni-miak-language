package me.miak;

public class StringValue extends Value {
    public StringValue(String value){
        super(value);
    }

    public Boolean getBool(){
        return this.getValue().toString().length() > 0;
    }
}
