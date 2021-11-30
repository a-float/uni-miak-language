package me.miak.vals;

public enum Type {
    NULL,
    INT,
    BOOL,
    STRING,
    FUNC,
    ITERABLE;

    public static Type stringToType(String typeName){
        return switch(typeName){
            case "null" -> NULL;
            case "int" -> INT;
            case "bool" -> BOOL;
            case "string" -> STRING;
            case "func" -> FUNC;
            case "iterable" -> ITERABLE;
            default -> throw new IllegalArgumentException("Invalid type name: "+ typeName);
        };
    }
}
