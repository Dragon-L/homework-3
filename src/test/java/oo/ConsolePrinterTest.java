package oo;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConsolePrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_Print_Content_To_Output_Stream_When_I_Want_To_Print_It() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("print me to console");

        assertThat(outContent.toString(), is("print me to console"));
    }

    @Test
    public void should_Can_Print_Special_Character() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("@#$%^&*\n");

        assertThat(outContent.toString(), is("@#$%^&*\n"));
    }
}