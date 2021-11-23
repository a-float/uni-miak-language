package me.miak;

import me.miak.parser.LangBaseListener;
import me.miak.parser.LangLexer;
import me.miak.parser.LangParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;


class MyListener extends LangBaseListener {
    HashMap<String, Integer> vars = new HashMap<>();
    ArrayList<String> errors = new ArrayList<>();

    @Override
    public void exitDeclaration(LangParser.DeclarationContext ctx) {
        if(vars.containsKey(ctx.ID().getText())){
            errors.add("Redeclaration of " + ctx.TYPE().getText() + ' ' + ctx.ID());
        }
        else {
            if (ctx.EQ() == null) {  // just the declaration
                vars.put(ctx.ID().getText(), null);
            }
            else{
                vars.put(ctx.ID().getText(), ctx.expr().value);
            }
        }
        System.out.printf("EXIT type: %s id %s\n", ctx.TYPE(), ctx.ID());
    }

    @Override
    public void exitAssignment(LangParser.AssignmentContext ctx) {
        if(!vars.containsKey(ctx.ID().getText())){
            errors.add(ctx.ID().getText() + " has not been declared yet");
        }
        else{
            vars.put(ctx.ID().getText(), ctx.expr().value);
        }
    }

    @Override
    public void exitExpr(LangParser.ExprContext ctx){
        System.out.printf("EXIT EXPR %s value is %s\n", ctx.getText(), ctx.value);
    }

    @Override
    public void exitProg(LangParser.ProgContext ctx){
        System.out.println(this.vars);
        System.out.println(this.errors);
    }
}

public class App {
    public static void main(String[] args) {
        CharStream inputStream = CharStreams.fromString(
                """
                        int a = 2*2;
                        int b;
                        b = 32;
                        while(b != 40){
                        b = b + a;
                        }
                        
                        """.stripIndent());
        System.out.println(inputStream);
        LangLexer lexer = new LangLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        parser.setBuildParseTree(true);
        LangParser.ProgContext tree = parser.prog();
        MyListener listener = new MyListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }
}