package me.miak;
import me.miak.parser.LangBaseVisitor;
import me.miak.parser.LangParser;

public class MyVisitor extends LangBaseVisitor<Value> {

    @Override
    public Value visitAssignment(LangParser.AssignmentContext ctx){
        System.out.println("Assignment to " + ctx.ID().getText());
        return new Value(null);
    }

}
