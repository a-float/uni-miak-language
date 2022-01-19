// Generated from C:\Users\mati8\Desktop\Semestr5\MIAK\Lang\resources\Lang.g4 by ANTLR 4.9.3

package me.miak.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(LangParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(LangParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(LangParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(LangParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(LangParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(LangParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunDefinition(LangParser.FunDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunDefinition(LangParser.FunDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funDefinitionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunDefinitionArgs(LangParser.FunDefinitionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funDefinitionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunDefinitionArgs(LangParser.FunDefinitionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funCall}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(LangParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funCall}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(LangParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunArgs(LangParser.FunArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunArgs(LangParser.FunArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#outStat}.
	 * @param ctx the parse tree
	 */
	void enterOutStat(LangParser.OutStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#outStat}.
	 * @param ctx the parse tree
	 */
	void exitOutStat(LangParser.OutStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#declarationWithAssignment}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationWithAssignment(LangParser.DeclarationWithAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#declarationWithAssignment}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationWithAssignment(LangParser.DeclarationWithAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(LangParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(LangParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#conditionBlock}.
	 * @param ctx the parse tree
	 */
	void enterConditionBlock(LangParser.ConditionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#conditionBlock}.
	 * @param ctx the parse tree
	 */
	void exitConditionBlock(LangParser.ConditionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#statBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatBlock(LangParser.StatBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#statBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatBlock(LangParser.StatBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(LangParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(LangParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(LangParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(LangParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#iterable}.
	 * @param ctx the parse tree
	 */
	void enterIterable(LangParser.IterableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#iterable}.
	 * @param ctx the parse tree
	 */
	void exitIterable(LangParser.IterableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunExpr(LangParser.FunExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunExpr(LangParser.FunExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(LangParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(LangParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(LangParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(LangParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(LangParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(LangParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(LangParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(LangParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(LangParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(LangParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LangParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LangParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexedExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexedExpr(LangParser.IndexedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexedExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexedExpr(LangParser.IndexedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(LangParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(LangParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(LangParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(LangParser.MultiplicationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(LangParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(LangParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(LangParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(LangParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(LangParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(LangParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexSingle}
	 * labeled alternative in {@link LangParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndexSingle(LangParser.IndexSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexSingle}
	 * labeled alternative in {@link LangParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndexSingle(LangParser.IndexSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexRange}
	 * labeled alternative in {@link LangParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndexRange(LangParser.IndexRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexRange}
	 * labeled alternative in {@link LangParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndexRange(LangParser.IndexRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(LangParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(LangParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(LangParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(LangParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(LangParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(LangParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(LangParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(LangParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(LangParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(LangParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNullAtom(LangParser.NullAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNullAtom(LangParser.NullAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LangParser.TypeContext ctx);
}