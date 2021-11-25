package me.miak;

import me.miak.parser.LangBaseVisitor;
import me.miak.parser.LangParser;

import java.util.HashMap;

public class MyVisitor extends LangBaseVisitor<Value> {

    final HashMap<String, Value> variables = new HashMap<>();

    @Override
    public Value visitFunDefinition(LangParser.FunDefinitionContext ctx) {
        return super.visitFunDefinition(ctx);
    }

    @Override
    public Value visitFunArgs(LangParser.FunArgsContext ctx) {
        return super.visitFunArgs(ctx);
    }

    @Override
    public Value visitIterable(LangParser.IterableContext ctx) {
        return super.visitIterable(ctx);
    }

    @Override
    public Value visitOutStat(LangParser.OutStatContext ctx) {
        String data = visit(ctx.expr()).getValue().toString();
        if(ctx.PRINT() != null) System.out.println(data);
        else if(ctx.DEBUG() != null) System.out.println(data);
        else throw new UnsupportedOperationException("Invalid out operation");
        return null;
    }

    @Override
    public Value visitMacro(LangParser.MacroContext ctx) {
        return super.visitMacro(ctx);
    }

    @Override
    public Value visitAssignment(LangParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        if (variables.containsKey(id)) {
            Value oldValue = variables.get(id);
            Value newValue = visit(ctx.expr());
            if (oldValue.getClass().equals(newValue.getClass())) {
                variables.put(id, newValue);
            } else throw new RuntimeException("Invalid assignment type for variable " + id);
        } else throw new RuntimeException(id + " is not defined");
        return null;
    }

    @Override
    public Value visitDeclaration(LangParser.DeclarationContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.TYPE().getText();
        Value defaultValue = Value.getDefaultValueFromType(type);
        if (!variables.containsKey(id)) {
            variables.put(id, defaultValue);
        } else throw new RuntimeException("Variable " + id + " already defined");
        return null;
    }

    @Override
    public Value visitDeclarationWithAssignment(LangParser.DeclarationWithAssignmentContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.TYPE().getText();
        Value defaultValue = Value.getDefaultValueFromType(type);
        Value value = visit(ctx.expr());
        if (value.getClass().equals(defaultValue.getClass())) {
            if (!variables.containsKey(id)) {
                variables.put(id, value);
            } else throw new RuntimeException("Type error. Tried to assign " + value.getValue() + " to type " + type);
        } else throw new RuntimeException("Variable " + id + " already defined");
        return null;
    }

    @Override
    public Value visitIfStat(LangParser.IfStatContext ctx) {
        return super.visitIfStat(ctx);
    }

    @Override
    public Value visitConditionBlock(LangParser.ConditionBlockContext ctx) {
        return super.visitConditionBlock(ctx);
    }

    @Override
    public Value visitStatBlock(LangParser.StatBlockContext ctx) {
        return super.visitStatBlock(ctx);
    }

    @Override
    public Value visitWhileStat(LangParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public Value visitForStat(LangParser.ForStatContext ctx) {
        return super.visitForStat(ctx);
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
        return super.visitRelationalExpr(ctx);
    }

    @Override
    public Value visitEqualityExpr(LangParser.EqualityExprContext ctx) {
        Value left = visit(ctx.expr(0));
        Value right = visit(ctx.expr(1));
        return left.equal(right);
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
        return super.visitRange(ctx);
    }

    @Override
    public Value visitNumberAtom(LangParser.NumberAtomContext ctx) {
        if (ctx.INT() != null) return new IntValue(Integer.parseInt(ctx.INT().getText()));
        throw new RuntimeException("Not integer atom");
    }

    @Override
    public Value visitBooleanAtom(LangParser.BooleanAtomContext ctx) {
        if (ctx.TRUE() != null) return new BoolValue(true);
        else return new BoolValue(false);
    }

    @Override
    public Value visitIdAtom(LangParser.IdAtomContext ctx) {
        String id = ctx.ID().getText();
        if(variables.containsKey(id)){
            return variables.get(id);
        } else throw new RuntimeException(id + " is not defined");
    }

    @Override
    public Value visitStringAtom(LangParser.StringAtomContext ctx) {
        String string = ctx.STRING().getText();
        return new StringValue(string.substring(1, string.length()-1));
    }

    @Override
    public Value visitNilAtom(LangParser.NilAtomContext ctx) {
        return null;
    }

}
