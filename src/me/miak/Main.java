package me.miak;

import me.miak.parser.LangLexer;
import me.miak.parser.LangParser;
import me.miak.vals.NullValue;
import me.miak.vals.Value;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        String file = args.length == 1 ? args[0] : "./resources/main.lang";
        String input = args.length == 2 ? args[1] : null;
        CharStream inputStream;
        if (input == null) {
            inputStream = CharStreams.fromFileName(file);
        } else {
            inputStream = CharStreams.fromString(input);
        }
//        System.out.println(inputStream);
        runParser(inputStream, new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public static void runParser(CharStream inputStream, BufferedWriter outStream) {
        LangLexer lexer = new LangLexer(inputStream);
        LangParser parser = new LangParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        List<String> parseErrors = new ArrayList<>();
        parser.addErrorListener(new MyErrorListener(parseErrors));
        ParseTree tree = parser.parse();
        if(parseErrors.size() > 0){
            System.out.println("Found " + parseErrors.size() + " errors while parsing:");
            parseErrors.forEach(System.out::println);
            return;
        }
        MyVisitor visitor = new MyVisitor(outStream);
        Value res = visitor.visit(tree);
        try {
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (res != NullValue.getInstance()) System.out.println("Program returned " + res.getString());
    }
}