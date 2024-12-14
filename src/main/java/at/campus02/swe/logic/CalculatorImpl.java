package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

		//sin and cos only need ONE var
		ArrayList<Operation> onlyPopOnce = new ArrayList<>();
		onlyPopOnce.add(Operation.cos);
		onlyPopOnce.add(Operation.sin);
		onlyPopOnce.add(Operation.dotproduct);

		double b = pop();
		double a = 0.0;

		//check if you need more than 1 var
		if (!onlyPopOnce.contains(op))
			a = pop();

		switch (op) {
			case add:
				return a + b;
			case sub:
				return a - b;
			case div:
				double c = a / b;
				if (Double.isInfinite(c))
					throw new CalculatorException("Division by zero");
				return c;
			case mul:
				return a * b;
			//implement mod
			case mod:
				if (b == 0.0)
					throw new CalculatorException("Mod by zero");
				return a % b;
			//implement sin
			case sin:
				return Math.sin(Math.toRadians(b));
			//implement cos
			case cos:
				return Math.cos(b);
			case dotproduct:
				return CalcDotProduct(b);
		}
		return 0;
	}

	private double CalcDotProduct(double dimension) throws CalculatorException{
		int dimensionToInt = (int) Math.floor(dimension);

		if(dimensionToInt < 2 )
			throw new CalculatorException("Dimension of vector is illegal.");

		ArrayList<Double> VectorA = GetVectorList(dimensionToInt);
		ArrayList<Double> VectorB = GetVectorList(dimensionToInt);

		double result = 0.0;
		for (int i = 0; i < VectorA.size(); i++) {
			result += VectorA.get(i) * VectorB.get(i);
		}

		return result;
	}

	private ArrayList<Double> GetVectorList(int dimension) throws CalculatorException {
		ArrayList<Double> tempList = new ArrayList<>();

		for (int i = 0; i < dimension ; i++) {
			tempList.add(pop());
		}
		Collections.reverse(tempList);

		return tempList;
	}


	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

}
