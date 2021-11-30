package me.miak.vals;

import me.miak.ContextManager;
import me.miak.MyVisitor;
import me.miak.parser.LangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class FunctionValue extends Value {

    private final List<Pair<Type, String>> args;
    private final ParserRuleContext body;

    public FunctionValue(List<Pair<Type, String>> args, ParserRuleContext body) {
        super(Type.FUNC, null);
        this.args = args;
        this.body = body;
    }

    @Override
    public Value call(MyVisitor visitor, List<Value> callArgs){
        if(callArgs.size() != this.args.size()){
            throw new RuntimeException("Function expected " + args.size() + " arguments but got " + callArgs.size());
        }
        visitor.contextManager.startFunction();
        for(int i = 0; i < this.args.size(); i++){
            visitor.contextManager.declare(args.get(i).a, args.get(i).b, callArgs.get(i));
        }
        Value toReturn = visitor.visit(this.body);
        visitor.isReturningFromFunction = false;
        visitor.contextManager.popContext();

        return toReturn;
    }
}
