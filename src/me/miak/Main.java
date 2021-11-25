package me.miak;

import me.miak.parser.LangLexer;
import me.miak.parser.LangParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {
    public static void main(String[] args) throws Exception {
        CharStream inputStream = CharStreams.fromFileName("./tests/bool_test.lang");
//        System.out.println(inputStream);
        LangLexer lexer = new LangLexer(inputStream);
        LangParser parser = new LangParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        MyVisitor visitor = new MyVisitor();
        visitor.visit(tree);
    }
}