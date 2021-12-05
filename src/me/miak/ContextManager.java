package me.miak;

import me.miak.vals.NullValue;
import me.miak.vals.Value;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

class VarData{
    private boolean isConstant;
    public VarData(boolean isConstant){this.isConstant = isConstant;}
    public boolean getIsConstant(){return this.isConstant;}
}

public class ContextManager {
    private final Stack<Map<String, Pair<VarData, Value>>> contextStack;

    public ContextManager() {
        this.contextStack = new Stack<>();
        this.contextStack.push(new HashMap<>());
    }

    /**
     * @param id id of the wanted variable
     * @return the top context containing variable with name == id
     */
    private Map<String, Pair<VarData, Value>> getStackWithVariable(String id) {
        for (int i = this.contextStack.size() - 1; i >= 0; i--) {
            Map<String, Pair<VarData, Value>> variables = this.contextStack.get(i);
            if (variables.containsKey(id)) {
                return variables;
            }
        }
        return null;
    }

    /**
     * @param id id of the variable
     * @return value of the variable id if it is defined
     */
    public Value get(String id) {
        Map<String, Pair<VarData, Value>> variables = this.getStackWithVariable(id);
        if (variables == null) {
            throw new NoSuchElementException("Variable " + id + " is not defined");
        }
        return variables.get(id).b;
    }

    /**
     * @return the context from the top of the stack - the local scope
     */
    public Map<String, Pair<VarData, Value>> getTopContext() {
        return this.contextStack.peek();
    }

    /**
     * @param id variable id
     * @param value value to assign to the given id
     * @return value if assignment was successfully
     */
    public Value assign(String id, Value value) {
        Map<String, Pair<VarData, Value>> variables = this.getStackWithVariable(id);
        if(variables != null){
            Pair<VarData, Value> pair = variables.get(id);
            if(pair.a.getIsConstant())throw new RuntimeException("Tried to change the value of a constant variable " + id);
            else variables.put(id, new Pair<>(pair.a, value));
        }
        else {
            throw new NoSuchElementException("Variable " + id + " is not defined");
        }
        return value;
    }

    /**
     * @param id name of the declared variable
     * @param isConst os the variable constant
     * @param value value to be assigned. If null, assigns null
     * @return the assigned value
     */
    public Value declare(String id, boolean isConst, Value value){
        Map<String, Pair<VarData, Value>> variables = this.getTopContext();
        if (value == null) value = NullValue.getInstance();
            if (!variables.containsKey(id)) {
                variables.put(id, new Pair<>(new VarData(isConst), value));
            } else throw new RuntimeException("Variable " + id + " is already defined");
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
}
