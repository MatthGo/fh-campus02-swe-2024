package at.campus02.swe.parser;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class EndToEndTest {

	@Test
	public void TestParserTest01Xml() throws Exception {

		//Hint: echter Calculator
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/test01.xml"));

		assertEquals(3.0, result, 0); // 1 + 2 = 3
	}

	@Test
	public void TestMod() throws Exception {

		//Hint: echter Calculator
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/testmod.xml"));

		assertEquals(1.0, result, 0); // 5%2 = 1
	}
	@Test
	public void TestSin() throws Exception {

		//Hint: echter Calculator
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/TestSin.xml"));

		assertEquals(0.0, result, 0); // sin 0 = 0
	}
	@Test
	public void TestCos() throws Exception {

		//Hint: echter Calculator
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/TestCos.xml"));

		assertEquals(1.0, result, 0); // cos 0 = 1
	}

	@Test
	public void TestDotproduct() throws Exception {

		//Hint: echter Calculator
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/TestDotproduct.xml"));

		assertEquals(14.0, result, 0); // cos 0 = 1
	}



}
