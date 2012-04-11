/*
 * MIPL: Mining Integrated Programming Language
 *
 * File: UnboundColMatrix.java
 * Author: YoungHoon Jung <yj2244@columbia.edu>
 * Reviewer: Younghoon Jeon <yj2231@columbia.edu>
 * Description: Built-in Unbound Cols Matrix 
 */
package edu.columbia.mipl.builtin.matrix;

import java.util.*;
import java.lang.reflect.*;

import edu.columbia.mipl.datastr.*;

public class UnboundColMatrix extends UnboundMatrix {

	public UnboundColMatrix(PrimitiveMatrix<Double> m) {
		if (m.getCol() != 1)
			assert (false);

		setData(m.getData());
	}

	public int getRow() {
		return getData().getRow();
	}

	public  String getName() {
		return "ucol";
	}

	public Double getValue(int row, int col) {
		return (Double) getData().getValue(row, 0);
	}
}
