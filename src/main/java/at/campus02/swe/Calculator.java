package at.campus02.swe;

public interface Calculator {

	//added mod, sin, cos
    enum Operation {
        add, sub, mul, div, mod, sin, cos
    };

    void push(double value);

    double pop() throws CalculatorException;

    double perform(Operation op) throws CalculatorException;

    void clear();
}
