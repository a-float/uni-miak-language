:: 1% is the grammar file name without .g4 2% is the starting token
@set GRAMMAR_PATH=C:\Users\mati8\Desktop\Semestr5\MIAK\Lang\resources
@set OUTPUT_PATH=C:\Users\mati8\Desktop\Semestr5\MIAK\Lang\src\me\miak
@echo Generating antlr files...
@java org.antlr.v4.Tool %GRAMMAR_PATH%\%1.g4 -o %OUTPUT_PATH%\parser -visitor
::@echo Compiling...
::@call javac -cp %classpath% %GRAMMAR_PATH%\parser\%2*.java
@echo Done!
::grun %GRAMMAR_PATH%\parser\%1 %2 -gui