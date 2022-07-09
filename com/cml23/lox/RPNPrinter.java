package com.cml23.lox;

import com.cml23.lox.Expr.Binary;
import com.cml23.lox.Expr.Grouping;
import com.cml23.lox.Expr.Literal;
import com.cml23.lox.Expr.Unary;

//Chapter 5 challenge -- RPN visitor class

public class RPNPrinter implements Expr.Visitor<String> {

  String print(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public String visitBinaryExpr(Binary expr) {
    return convert(expr.operator.lexeme, expr.left, expr.right);
  }

  @Override
  public String visitGroupingExpr(Grouping expr) {
    return convert("group", expr.expression);
  }

  @Override
  public String visitLiteralExpr(Literal expr) {
    if (expr.value == null) {
      return "nil";
    }
    return expr.value.toString();
  }

  @Override
  public String visitUnaryExpr(Unary expr) {
    return convert(expr.operator.lexeme, expr.right);
  }

  private String convert(String name, Expr... exprs) {
    StringBuilder builder = new StringBuilder();
    for (Expr expr : exprs) {
      builder.append(expr.accept(this));
      builder.append(" ");
    }
    builder.append(name);
    return builder.toString();

  }
}
