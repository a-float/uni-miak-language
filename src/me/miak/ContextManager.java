package me.miak;

import me.miak.vals.Type;
import me.miak.vals.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContextManager {
    private final Stack<Map<String, Value>> contextStack;

    public ContextManager() {
        this.contextStack = new Stack<>();
        this.contextStack.push(new HashMap<>());
    }

    /**
     * @param id id of the wanted variable
     * @return the top context containing variable with name == id
     */
    private Map<String, Value> getStackWithVariable(String id) {
        for (int i = this.contextStack.size() - 1; i >= 0; i--) {
            Map<String, Value> variables = this.contextStack.get(i);
            if (variables.containsKey(id)) {
                return variables;
            }
        }
        return null;
    }

    public int getStackSize(){
        return this.contextStack.size();
    }

    /**
     * @param id id of the variable
     * @return value of the variable id if it is defined
     */
    public Value get(String id) {
        Map<String, Value> variables = this.getStackWithVariable(id);
        if (variables == null) {
            throw new RuntimeException("Variable " + id + " is not defined");
        }
        return variables.get(id);
    }

    /**
     * @return the context from the top of the stack - the local scope
     */
    public Map<String, Value> getTopContext() {
        return this.contextStack.peek();
    }

    /**
     * @param id variable id
     * @param value value to assign to the given id
     * @return value if assignment was successfully
     */
    public Value assign(String id, Value value) {
        Map<String, Value> variables = this.getStackWithVariable(id);
        if (variables == null) throw new RuntimeException("Variable " + id + " is not defined");
        Value oldValue = variables.get(id);
        if (oldValue.getClass().equals(value.getClass())) {
            variables.put(id, value);
        } else throw new RuntimeException("Invalid assignment type for variable " + id);
        return value;
    }

    public Value declare(String type, String id, Value value) {
        return this.declare(Type.stringToType(type), id, value);
    }

    /**
     * @param type type of the declared variable
     * @param id name of the declared variable
     * @param value value to be assigned. If null, assigns a default value
     * @return the assigned value
     */
    public Value declare(Type type, String id, Value value) {
        Map<String, Value> variables = this.getTopContext();
        Value defaultValue = Value.getDefaultValueFromType(type);
        if (value == null) value = defaultValue;

        // TODO remove the class check below?
        if (value.getType() == Type.FUNC || value.getClass().equals(defaultValue.getClass())) {
            if (!variables.containsKey(id)) {
                variables.put(id, value);
            } else throw new RuntimeException("Variable " + id + " is already defined");
        } else throw new RuntimeException("Type error. Tried to assign " + value.getValue() + " to type " + type);
        return value;
    }

    /**
     * created an empty context on the top of the stack
     */
    public void pushContext() {
        this.contextStack.push(new HashMap<>());
    }

    /**
     * pops the topmost context
     */
    public void popContext() {
        this.contextStack.pop();
    }

    public void startFunction() {
        this.pushContext();
    }
}
