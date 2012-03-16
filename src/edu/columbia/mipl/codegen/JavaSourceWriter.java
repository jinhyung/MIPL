/*
 * MIPL: Mining Integrated Programming Language
 *
 * File: JavaSourceWriter.java
 * Author: YoungHoon Jung <yj2244@columbia.edu>
 * Reviewer: Younghoon Jeon <yj2231@columbia.edu>
 * Description: JavaSourceWriter
 */
package edu.columbia.mipl.codegen;

import java.io.*;
import java.util.*;

import edu.columbia.mipl.runtime.*;
import edu.columbia.mipl.datastr.*;

public class JavaSourceWriter extends InstructionWriter {

	Stack<String> stack;
	Writer out;

	public JavaSourceWriter() {
		String output = "MiplProgram"; /* Should be read from Configuration */

		stack = new Stack<String>();

		File file = new File(output + ".java");
		try {
			out = new BufferedWriter(new FileWriter(file));

			out.write("import edu.columbia.mipl.runtime.*;\n");
			out.write("\n");
			out.write("public class " + output + " {\n");
			out.write("	public static void main(String[] args) {\n");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String getName() {
		return "JavaSrc";
	}

	public void createTerm(Term.Type type, double value) {
		stack.push("new Term(Term.Type.NUMBER, " + value + ")");
	}

	public void createTerm(Term.Type type, Term term1, Expression expr1) {
	// Term.Type.IS
	}

	public void createTerm(Term.Type type, Expression expr1, Expression expr2) {
		switch (type) {
			case EQ:
				break;
			case LT:
				break;
			case LE:
				break;
			case GT:
				break;
			case GE:
				break;
			case NE:
				break;
		}

	}

	public void createTerm(Term.Type type, String name,
										PrimitiveMatrix<Double> matrix) {
	// Term.Type.MATRIX
	}

	public void createTerm(Term.Type type, Term term1, Term term2) {
		switch (type) {
			case ANDTERMS:
				break;
			case ORTERMS:
				break;
		}
	}

	public void createTerm(Term.Type type, Term term1) {
	// Term.Type.NOTTERM
	}

	public void createTerm(Term.Type type, String name, List<Term> arguments) {
		switch (type) {
			case REGEXTERM:
				break;
			case TERM:
				break;
		}
	}

	public void createTerm(Term.Type type, String name) {
		switch (type) {
			case VARIABLE:
				break;
			case QUERYALL:
				break;
			case REGEXQUERYALL:
				break;
			case STRING:
				break;
		}
	}

	public void createTerm(Term.Type type, Expression expr1) {
	// Term.Type.EXPRESSION

	}

	public void createExpression(Expression.Type type, Term term1) {
	// Term.Type.Term

	}

	public void createExpression(Expression.Type type, Expression expr1,
									Expression expr2) {
		switch (type) {
			case MINUS:
				break;
			case PLUS:
				break;
			case MULTI:
				break;
			case DIVIDE:
				break;
		}
	}

	public void createFact(Fact.Type type, Term term) {
	// Fact.Type.FACT

	}

	public void createFact(Fact.Type type, String name, List<String> names,
							List<Term> terms) {
	// Fact.Type.MATRIXASFACTS

	}

	public void createRule(Term term, Term source) {

	}

	public void createQuery(Term term) {

	}

	public void createJob(String name, List<Term> args, List<JobStmt> stmts) {

	}

	public void createJobStmt(JobStmt.Type type, JobExpr expr, JobStmt stmt1,
								JobStmt stmt2) {
		switch (type) {
			case IF:
				break;
			case WHILE:
				break;
			case DOWHILE:
				break;
		}
	}

	public void createJobStmt(JobStmt.Type type, List<JobStmt> stmts) {
	// JobStmt.Type.COMPOUND

	}

	public void createJobStmt(JobStmt.Type type, JobExpr expr) {
	// Maybe should use helper functions for this as tasks are really different
		switch (type) {
			case RETURN:
				break;
			case EXPR:
				break;
		}
	}

	public void createJobStmt(JobStmt.Type type) {
	// JobStmt.Type.NULL. Do nothing depending on how we handle function return

	}

	public void finish() {
		try {
			out.write("	}\n");
			out.write("}\n");
			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}