package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

		//sin and cos only need ONE var
		ArrayList<Operation> operationsOnlyNeedOneInput = new ArrayList<>();
		operationsOnlyNeedOneInput.add(Operation.cos);
		operationsOnlyNeedOneInput.add(Operation.sin);

		double b = pop();
		double a = 0.0;

		//check if you need more than 1 var
		if (!operationsOnlyNeedOneInput.contains(op))
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
		}
		return 0;
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
