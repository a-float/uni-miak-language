package me.miak;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContextManager {
    private final Stack<Map<String, Value>> contextStack;

    public ContextManager() {
        this.contextStack = new Stack<>();
        this.contextStack.push(new HashMap<>());
    }


    public Value get(String id) {
        for (int i = this.contextStack.size() - 1; i >= 0; i--) {
            Map<String, Value> variables = this.contextStack.get(i);
            if (variables.containsKey(id)) {
                return variables.get(id);
            }
        }
        throw new RuntimeException("Variable " + id + " is not defined.");
    }

    public Map<String, Value> getTopContext() {
        return this.contextStack.peek();
    }

    public Value assign(String id, Value value){
        Map<String, Value> variables = this.getTopContext();
        if (variables.containsKey(id)) {
            Value oldValue = variables.get(id);
            if (oldValue.getClass().equals(value.getClass())) {
                variables.put(id, value);
            } else throw new RuntimeException("Invalid assignment type for variable " + id);
        } else throw new RuntimeException(id + " is not defined");
        return value;
    }

    public Value declare(String type, String id, Value value) {
        Map<String, Value> variables = this.getTopContext();
        Value defaultValue = Value.getDefaultValueFromType(type);
        if (value == null) value = defaultValue;

        if (value.getClass().equals(defaultValue.getClass())) {
            if (!variables.containsKey(id)) {
                variables.put(id, value);
            } else throw new RuntimeException("Type error. Tried to assign " + value.getValue() + " to type " + type);
        } else throw new RuntimeException("Variable " + id + " already defined");
        return value;
    }

    public void pushContext() {
        this.contextStack.push(new HashMap<>());
    }

    public void popContext() {
        this.contextStack.pop();
    }
}
