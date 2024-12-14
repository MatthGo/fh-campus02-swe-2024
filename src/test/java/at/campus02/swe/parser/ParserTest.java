package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);

        verifyNoMoreInteractions(cal);
    }

	@Test
	public void testParserTestMod() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/testmod.xml"));

		verify(cal).push(5.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.mod);

		verifyNoMoreInteractions(cal);
	}

    @Test
    public void testParserTesTDotProduct() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/TestDotproduct.xml"));

        verify(cal).push(1.0);
        verify(cal).push(3.0);
        verify(cal, times(2)).push(2.0 );
        verify(cal).push(4.0);
        verify(cal).perform(Operation.dotproduct);

        verifyNoMoreInteractions(cal);
    }
}
