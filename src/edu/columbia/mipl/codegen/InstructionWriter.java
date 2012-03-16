/*
 * MIPL: Mining Integrated Programming Language
 *
 * File: InstructionWriter.java
 * Author: YoungHoon Jung <yj2244@columbia.edu>
 * Reviewer: Younghoon Jeon <yj2231@columbia.edu>
 * Description: InstructionWriter
 */
package edu.columbia.mipl.codegen;

import java.util.*;

import edu.columbia.mipl.runtime.*;
import edu.columbia.mipl.datastr.*;

public abstract class InstructionWriter {
	public enum Method {
		PRE,
		IN,
		POST,
	};

	InstructionWriter() {
		InstructionWriterFactory.registerInstructionWriter(this);
	}

	public abstract String getName();

	public abstract void createTerm(Term.Type type, Term term1,
										Expression expr1);
	public abstract void createTerm(Term.Type type, Expression expr1,
										Expression expr2);
	public abstract void createTerm(Term.Type type, String name,
										PrimitiveMatrix<Double> matrix);
	public abstract void createTerm(Term.Type type, Term term1, Term term2);
	public abstract void createTerm(Term.Type type, Term term1);
	public abstract void createTerm(Term.Type type, String name,
										List<Term> arguments);
	public abstract void createTerm(Term.Type type, double value);
	public abstract void createTerm(Term.Type type, String name);
	public abstract void createTerm(Term.Type type, Expression expr1);

	public abstract void createExpression(Expression.Type type, Term term);
	public abstract void createExpression(Expression.Type type, Expression expr1,
											Expression expr2);

	public abstract void createFact(Fact.Type type, Term term);
	public abstract void createFact(Fact.Type type, String name,
										List<String> names, List<Term> terms);

	public abstract void createRule(Term term, Term source);

	public abstract void createQuery(Term term);

	public abstract void createJob(String name, List<Term> args,
									List<JobStmt> stmts);

	public abstract void createJobStmt(JobStmt.Type type, JobExpr expr,
										JobStmt stmt1, JobStmt stmt2);
	public abstract void createJobStmt(JobStmt.Type type, List<JobStmt> stmts);
	public abstract void createJobStmt(JobStmt.Type type, JobExpr expr);
	public abstract void createJobStmt(JobStmt.Type type);

	public abstract void finish();
}