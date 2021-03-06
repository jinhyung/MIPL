package edu.columbia.mipl.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import edu.columbia.mipl.datastr.*;

public class WritableArray extends PrimitiveDoubleArray implements Writable, WritableComparable<WritableArray>  {
	long pos;
	int operation;
	int size;
	double operand;
	int rowPos;

	public WritableArray() {

		super(0, 0);
//		System.out.println("WritableArray()");
	}
	
	public WritableArray(int row, int col, long pos) {
		super(row, col);
		this.pos = pos;
//		System.out.println("WritableArray(int row, int col, long pos)");
	}

	public WritableArray(int row, int col, double[] data, long pos) {
		super(row, col, data);
		this.pos = pos;
//		System.out.println("WritableArray(int row, int col, double[] data, long pos)");
	}
	
	public boolean isFirstMatrix() {
		return (operation != 0);
	}
	
	public void setOperand(double operand) {
		this.operand = operand;
	}
	
	public void setOperation(int op) {
		this.operation = op;
	}
	
	public void setRowPos(int rowPos) {
		this.rowPos = rowPos;
	}
	
	public int getRowPos() {
		return rowPos;
	}
	
	public double getOperand() {
		return operand;
	}
	
	public int getOperation() {
		return operation;
	}

	public long getPos() {
		return pos;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void putData(double d, int row, int col) {
		double[] data = getData();
		int paddedCol = getPaddedCol();
		data[row * paddedCol + col] = d;
	}

	public void readFields(DataInput in) throws IOException {
//		System.out.println("readFields");
		int i;
		int j;
		
		int row = in.readInt();
		int col = in.readInt();
		int paddedCol = in.readInt();
		
		
		size = in.readInt();
		operation = in.readInt();
		
		pos = in.readLong();
		
		operand = in.readFloat();
		rowPos = in.readInt();
		
		
		
//		System.out.println("read " + row + " " + col + " " + paddedCol + " " + size + " " + operation);

		double[] data = getData();
//		System.out.println("read data = " + data.length);
		if (getRow() < row)
			increaseRow(row - getRow());
		if (getCol() < col)
			increaseCol(col - getCol());
		
		data = getData();
//		System.out.println("read data = " + data.length);

		for (i = 0; i < row; i++)
			for (j = 0; j < col; j++) {
				data[i * paddedCol + j] = in.readDouble();
//				System.out.print(data[i * paddedCol + j] + " ");
			}
		
//		System.out.println();
		
//		System.out.println("read data = " + data.length);
		
		setRow(row);
		setCol(col);
//		System.out.println("read data = " + data.length);
//		System.out.println("read " + getRow() + " " + getCol() + " " + paddedCol);
	}
	public void write(DataOutput out) throws IOException {
		int i;
		int j;
		double[] data = getData();
		int row = getRow();
		int col = getCol();
		int paddedCol = getPaddedCol();
		
		

//		System.out.println("write " + row + " " + col + " " + paddedCol + " " + size + " " + operation);
		out.writeInt(row);
		out.writeInt(col);
		out.writeInt(paddedCol);
		out.writeInt(size);
		out.writeInt(operation);

		
		out.writeLong(pos);
		
		out.writeFloat((float) operand);
		
		out.writeInt(rowPos);

		for (i = 0; i < row; i++)
			for (j = 0; j < col; j++) {
				out.writeDouble(data[i * paddedCol + j]);
//				System.out.print(data[i * paddedCol + j] + " ");
			}
//		System.out.println("write data = " + data.length);
//		System.out.println();
	}

	@Override
	public int compareTo(WritableArray arr) {
		return (int) (arr.pos - pos);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		double[] data = getData();
		int row = getRow();
		int col = getCol();
		int paddedCol = getPaddedCol();
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				sb.append(data[i * paddedCol + j] + " ");

		return sb.toString();
	}
	
	public int getSize() {
		return getRow() * getCol();
	}
	
}
