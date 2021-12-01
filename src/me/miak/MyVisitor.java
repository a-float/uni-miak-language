package me.miak;

import me.miak.parser.LangBaseVisitor;
import me.miak.parser.LangParser;
import me.miak.vals.*;
import org.antlr.v4.runtime.misc.Pair;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MyVisitor extends LangBaseVisitor<Value> {

    public final ContextManager contextManager = new ContextManager();
    public boolean isReturningFromFunction = false;
    private final Writer outWriter;
    public MyVisitor(Writer outStream){
        super();
        this.outWriter = outStream;
    }

    @Override
    public Value visitFunDefinition(LangParser.FunDefinitionContext ctx) {
        String type = ctx.TYPE().getText();
        String id = ctx.ID().getText();
        List<Pair<Type, String>> args = new ArrayList<>();
        LangParser.FunDefinitionArgsContext actx = ctx.funDefinitionArgs();
        for (int i = 0; i < actx.TYPE().size(); i++) {
            Pair<Type, String> arg = new Pair<>(Type.stringToType(actx.TYPE(i).getText()), actx.ID(i).getText());
            args.add(arg);
        }
        Value fun = new FunctionValue(args, ctx.expr() != null ? ctx.expr() : ctx.statBlock());
        contextManager.declare(type, id, fun);
        return NullValue.getInstance();
    }

    @Override
    public Value visitFunCall(LangParser.FunCallContext ctx) {
        String id = ctx.ID().getText();
        Value fun = contextManager.get(id);
        if (fun.getType() != Type.FUNC) throw new RuntimeException("Variable " + id + " is not a function");
        List<Value> args = new ArrayList<>();
        LangParser.FunArgsContext actx = ctx.funArgs();
        for (int i = 0; i < actx.expr().size(); i++) {
            args.add(visit(actx.expr(i)));
        }
        return fun.call(this, args);
    }

    @Override
    public Value visitIterable(LangParser.IterableContext ctx) {
        if (ctx.ID() != null) {
            return contextManager.get(ctx.ID().getText());
        } else {
            return visit(ctx.range());
        }
    }

    @Override
    public Value visitOutStat(LangParser.OutStatContext ctx) {
        String data = visit(ctx.expr()).getString();
        try {
            if (ctx.PRINT() != null) this.outWriter.write(data+"\n");
            else if (ctx.DEBUG() != null) this.outWriter.write(data+"\n");
            else throw new UnsupportedOperationException("Invalid out operation");
        } catch(IOException e){
            System.out.println("Could not print/debug to out stream");
            e.printStackTrace();
        }
        return NullValue.getInstance();
    }

    @Override
    public Value visitMacro(LangParser.MacroContext ctx) {
        return super.visitMacro(ctx);
    }

    @Override
    public Value visitAssignment(LangParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value newValue = visit(ctx.expr());
        return contextManager.assign(id, newValue); // returns assigned value
    }

    @Override
    public Value visitDeclaration(LangParser.DeclarationContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.TYPE().getText();
        Value defaultValue = contextManager.declare(type, id, null);
        return NullValue.getInstance();
    }

    @Override
    public Value visitDeclarationWithAssignment(LangParser.DeclarationWithAssignmentContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.TYPE().getText();
        Value value = visit(ctx.expr());
        return contextManager.declare(type, id, value); // returns assigned value
    }

    @Override
    public Value visitIfStat(LangParser.IfStatContext ctx) {
        for (LangParser.ConditionBlockContext condBlockCtx : ctx.conditionBlock()) {
            if (visit(condBlockCtx.expr()).getBool()) {
                return visit(condBlockCtx.statBlock());
            }
        }
        if(ctx.statBlock() != null) return visit(ctx.statBlock());
        return NullValue.getInstance();
    }

    @Override
    public Value visitConditionBlock(LangParser.ConditionBlockContext ctx) {
        return visit(ctx.statBlock());
    }

    @Override
    public Value visitStatBlock(LangParser.StatBlockContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Value visitBlock(LangParser.BlockContext ctx) {
        for (int i = 0; i < ctx.stat().size(); i++) {
            Value toReturn = visit(ctx.stat(i));
            if (this.isReturningFromFunction) return toReturn;
        }
        return NullValue.getInstance();
    }

    @Override
    public Value visitStat(LangParser.StatContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Value visitReturnStat(LangParser.ReturnStatContext ctx) {
        Value toReturn = visit(ctx.expr());
        // super important I'm so smart wow.
        // If the order is different nested function calls mess up the isReturning value
        isReturningFromFunction = true;
        return toReturn;
    }

    @Override
    public Value visitWhileStat(LangParser.WhileStatContext ctx) {
        Value toReturn = NullValue.getInstance();
        while (visit(ctx.expr()).getBool() && !this.isReturningFromFunction){
            toReturn = visit(ctx.statBlock());
        }
        return toReturn;
    }

    @Override
    public Value visitForStat(LangParser.ForStatContext ctx) {
        String type = ctx.TYPE().getText();
        String id = ctx.ID().getText();
        IterableValue iterable = (IterableValue) visit(ctx.iterable());
        contextManager.pushContext();
        contextManager.declare(type, id, iterable.getStart());
        Value nextRes = iterable.next();
        Value toReturn = NullValue.getInstance();
        while (nextRes.getType() != Type.BOOL && !this.isReturningFromFunction) {
            toReturn = visit(ctx.statBlock());
            contextManager.assign(id, nextRes);
            nextRes = iterable.next();
        }
        contextManager.popContext();
        return NullValue.getInstance();
    }

    @Override
    public Value visitNotExpr(LangParser.NotExprContext ctx) {
        return visit(ctx.expr()).not();
    }

    @Override
    public Value visitIndexedExpr(LangParser.IndexedExprContext ctx) {
        return super.visitIndexedExpr(ctx);
    }

    @Override
    public Value visitUnaryMinusExpr(LangParser.UnaryMinusExprContext ctx) {
        return visit(ctx.expr()).unaryMinus();
    }

    @Override
    public Value visitMultiplicationExpr(LangParser.MultiplicationExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        if (ctx.MULT() != null) return left.mult(right);
        else if (ctx.DIV() != null) return left.div(right);
        else return left.mod(right);
    }

    @Override
    public Value visitOrExpr(LangParser.OrExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        return left.or(right);
    }

    @Override
    public Value visitParExpr(LangParser.ParExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Value visitAdditiveExpr(LangParser.AdditiveExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        if (ctx.PLUS() != null) return left.add(right);
        else return left.subtract(right);
    }

    @Override
    public Value visitPowExpr(LangParser.PowExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        return left.pow(right);
    }

    @Override
    public Value visitRelationalExpr(LangParser.RelationalExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        if (ctx.LT() != null) return left.lessThan(right);
        else if (ctx.GT() != null) return left.lessThan(right).not();
        else if (ctx.LTEQ() != null) return left.lessOrEqualThan(right);
        else return left.moreOrEqualThan(right);
    }

    @Override
    public Value visitEqualityExpr(LangParser.EqualityExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        if (ctx.EQ() != null) return left.equal(right);
        else return left.equal(right).not();
    }

    @Override
    public Value visitAndExpr(LangParser.AndExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        return left.and(right);
    }

    @Override
    public Value visitIndexSingle(LangParser.IndexSingleContext ctx) {
        return super.visitIndexSingle(ctx);
    }

    @Override
    public Value visitIndexRange(LangParser.IndexRangeContext ctx) {
        return super.visitIndexRange(ctx);
    }

    @Override
    public Value visitRange(LangParser.RangeContext ctx) {
        Value start = visit(ctx.expr(0));
        Value stop = visit(ctx.expr(1));
        Value step = ctx.expr(2) != null ? visit(ctx.expr(2)) : null;
        IterableValue iterable;
        if (step == null) {
            iterable = new IterableValue(start, stop);
        } else {
            iterable = new IterableValue(start, stop, step);
        }
        return iterable;
    }

    @Override
    public Value visitNumberAtom(LangParser.NumberAtomContext ctx) {
        if (ctx.INT() != null) return new IntValue(Integer.parseInt(ctx.INT().getText()));
        throw new RuntimeException("Not integer atom: " + ctx.getText());
    }

    @Override
    public Value visitBooleanAtom(LangParser.BooleanAtomContext ctx) {
        if (ctx.TRUE() != null) return new BoolValue(true);
        else return new BoolValue(false);
    }

    @Override
    public Value visitIdAtom(LangParser.IdAtomContext ctx) {
        String id = ctx.ID().getText();
        return contextManager.get(id);
    }

    @Override
    public Value visitStringAtom(LangParser.StringAtomContext ctx) {
        String string = ctx.STRING().getText();
        return new StringValue(string.substring(1, string.length() - 1));
    }

    @Override
    public Value visitNilAtom(LangParser.NilAtomContext ctx) {
        return NullValue.getInstance();
    }

}
