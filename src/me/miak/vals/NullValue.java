package me.miak.vals;

public class NullValue extends Value{

    static NullValue staticNull = new NullValue();

    public static NullValue getInstance(){
        return staticNull;
    }

    private NullValue() {
        super(Type.NULL, null);
    }

    @Override
    public String getString(){
        return "null";
    }
}
