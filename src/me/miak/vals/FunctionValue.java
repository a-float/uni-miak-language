package me.miak.vals;

import me.miak.MyVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.List;

public class FunctionValue extends Value {

    private final List<String> args;
    private final ParserRuleContext body;

    public FunctionValue(List<String> args, ParserRuleContext body) {
        super(Type.FUNC, null);
        this.args = args;
        this.body = body;
    }

//    @Override
//    public boolean isFunction() { return true; }

    @Override
    public Value call(MyVisitor visitor, List<Value> callArgs){
        if(callArgs.size() != this.args.size()){
            throw new RuntimeException("Function expected " + args.size() + " arguments but got " + callArgs.size());
        }
        visitor.contextManager.pushContext();
        for(int i = 0; i < this.args.size(); i++){
            visitor.contextManager.declare(args.get(i), false, callArgs.get(i));
        }
        Value toReturn = visitor.visit(this.body);
        visitor.isReturningFromFunction = false;
        visitor.contextManager.popContext();

        return toReturn;
    }
}
