package me.miak;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.List;

public class MyErrorListener extends BaseErrorListener {

    private final List<String> errors;

    public MyErrorListener(List<String> errors){
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
         this.errors.add("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
