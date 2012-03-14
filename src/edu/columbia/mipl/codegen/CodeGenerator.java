/*
 * MIPL: Mining Integrated Programming Language
 *
 * File: CodeGenerator.java
 * Author: YoungHoon Jung <yj2244@columbia.edu>
 * Reviewer: Younghoon Jeon <yj2231@columbia.edu>
 * Description: CodeGenerator
 */
package edu.columbia.mipl.codegen;

import java.util.*;

import edu.columbia.mipl.runtime.*;
import edu.columbia.mipl.runtime.traverse.*;

public class CodeGenerator extends RuntimeTraverser {
	InstructionWriter writer;

	public CodeGenerator() {
		String target = "JVM"; /* read this from Configuration */
		writer = InstructionWriterFactory.getInstructionWriter(target);
	}

	public void reachTerm(Term term) {
		switch (term.getType()) {
			case NUMBER:
				writer.createTerm(Term.Type.NUMBER, term.getValue());
				break;
			case TERM:
				break;
		}
	}

	public void reachExpression(Expression expr) {
	}

	public void reachFact(Fact fact) {
	}

	public void reachRule(Rule rule) {
	}

	public void reachQuery(Query query) {
	}

	public void reachJob(Job job) {
	}

	public void reachJobStmt(JobStmt jstmt) {
	}

	public void reachJobExpr(JobExpr jexpr) {
	}

	public void finish() {
		writer.finish();
	}
}
