/**
 * MIPL: Mining Integrated Programming Language
 *
 * File: DefaultMatrixOperations.java
 * Author: 
 * Reviewer: 
 * Description: Matrix Operations Default Implementations
 *
 */
package edu.columbia.mipl.matops;

import edu.columbia.mipl.datastr.*;

public class DefaultMatrixOperations implements MatrixOperations {
	boolean checkDimensionSame(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		return (arg1.getRow() == arg2.getRow() && arg1.getCol() == arg2.getCol());
	}

	public PrimitiveArray add(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		if (!checkDimensionSame(arg1, arg2))
			/* throw new UncompatiableMatrixDimensionException() */;

		PrimitiveDoubleArray a1 = (PrimitiveDoubleArray) arg1;
		PrimitiveDoubleArray a2 = (PrimitiveDoubleArray) arg2;
		PrimitiveDoubleArray result = new PrimitiveDoubleArray(arg1.getRow(), arg1.getCol());
		double[] data1 = a1.getData();
		double[] data2 = a2.getData();
		double[] data = result.getData();

		int i;
		int j;
		int offset = 0;
		int pos;

		for (i = 0; i < arg1.getRow(); i++) {
			pos = offset;
			for (j = 0; j < arg1.getCol(); j++) {
				data[pos] = data1[pos] + data2[pos];
				pos++;
			}
			offset += arg1.getPaddedRow();
		}

		return result;
	}

	public PrimitiveArray add(final PrimitiveArray arg1, double arg2) {
		PrimitiveDoubleArray a1 = (PrimitiveDoubleArray) arg1;
		PrimitiveDoubleArray result = new PrimitiveDoubleArray(arg1.getRow(), arg1.getCol());
		double[] data1 = a1.getData();
		double[] data = result.getData();

		int i;
		int j;
		int offset = 0;
		int pos;

		for (i = 0; i < arg1.getRow(); i++) {
			pos = offset;
			for (j = 0; j < arg1.getCol(); j++) {
				data[pos] = data1[pos] + arg2;
				pos++;
			}
			offset += arg1.getPaddedRow();
		}

		return result;
	}

	public PrimitiveArray sub(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		return null;
	}

	public PrimitiveArray sub(final PrimitiveArray arg1, double arg2) {
		return null;
	}

	public PrimitiveArray cellmult(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		return null;
	}
	public PrimitiveArray mult(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		return null;
	}
	public PrimitiveArray mult(final PrimitiveArray arg1, final double arg2) {
		return null;
	}

	public PrimitiveArray celldiv(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		return null;
	}
	public PrimitiveArray div(final PrimitiveArray arg1, final PrimitiveArray arg2) {
		return null;
	}
	public PrimitiveArray div(final PrimitiveArray arg1, final double arg2) {
		return null;
	}

	public void assign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void addassign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void addassign(PrimitiveArray arg1, double arg2) {
	}
	public void subassign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void subassign(PrimitiveArray arg1, double arg2) {
	}

	public void cellmultassign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void multassign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void multassign(PrimitiveArray arg1, double arg2) {
	}
	public void celldivassign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void divassign(PrimitiveArray arg1, final PrimitiveArray arg2) {
	}
	public void divassign(PrimitiveArray arg1, double arg2) {
	}

	public PrimitiveArray transpose(final PrimitiveArray arg1) {
		return null;
	}
	public PrimitiveArray inverse(final PrimitiveArray arg1) {
		return null;
	}

	public double sum(final PrimitiveArray arg1) {
		return 0;
	}
	public double mean(final PrimitiveArray arg1) {
		return 0;
	}
	public PrimitiveArray rowsum(final PrimitiveArray arg1) {
		return null;
	}
	public PrimitiveArray rowmean(final PrimitiveArray arg1) {
		return null;
	}
}
