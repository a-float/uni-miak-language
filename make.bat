:: 1% is the grammar file name without .g4 2% is the starting token
SET GRAMMAR_PATH=C:\Users\mati8\Desktop\Semestr5\MIAK\src\me\miak
@echo Generating antlr files...
@call antlr4 %GRAMMAR_PATH% %1
::@echo Compiling...
::@call javac -cp %classpath% %GRAMMAR_PATH%\parser\%2*.java
@echo Done!
::grun %GRAMMAR_PATH%\parser\%1 %2 -gui