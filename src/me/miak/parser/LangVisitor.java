// Generated from C:\Users\mati8\Desktop\Semestr5\MIAK\Lang\resources\Lang.g4 by ANTLR 4.9.3

package me.miak.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(LangParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(LangParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(LangParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDefinition(LangParser.FunDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funDefinitionArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDefinitionArgs(LangParser.FunDefinitionArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(LangParser.FunCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunArgs(LangParser.FunArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#outStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStat(LangParser.OutStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#declarationWithAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationWithAssignment(LangParser.DeclarationWithAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(LangParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#conditionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBlock(LangParser.ConditionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#statBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatBlock(LangParser.StatBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(LangParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#forStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(LangParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#iterable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterable(LangParser.IterableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunExpr(LangParser.FunExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(LangParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(LangParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(LangParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(LangParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(LangParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(LangParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexedExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedExpr(LangParser.IndexedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(LangParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(LangParser.MultiplicationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(LangParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(LangParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(LangParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexSingle}
	 * labeled alternative in {@link LangParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexSingle(LangParser.IndexSingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexRange}
	 * labeled alternative in {@link LangParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexRange(LangParser.IndexRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(LangParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(LangParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(LangParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(LangParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(LangParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link LangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullAtom(LangParser.NullAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LangParser.TypeContext ctx);
}