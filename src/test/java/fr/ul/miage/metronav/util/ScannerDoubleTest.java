package fr.ul.miage.metronav.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerDoubleTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalPrintStream = System.out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalPrintStream);
    }



    @Test
    public void testValidInputDouble(){

        String input = "45.43215";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerDouble scd = new ScannerDouble(inputStream);
        Double result = scd.getValidDoubleInput("Entrez un double : ");

        assertEquals(45.43215, result);

    }

    @Test
    public void testNegativeValidInputDouble(){

        String input = "-2.5678\r\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerDouble scd = new ScannerDouble(inputStream);
        Double result = scd.getValidDoubleInput("Entrez un double Négatif : ");

        assertEquals(-2.5678, result);
    }


    @Test
    public void testInValidThenValidInputDouble(){

        String input1 = "Invalid Value\r\n";
        String input2 = "45.43215\r\n";

        String input = input1 + input2;


        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerDouble scd = new ScannerDouble(inputStream);
        Double result = scd.getValidDoubleInput("Entrez un double : ");

        String output = outputStream.toString();

        String expectedOutput = "Entrez un double : Erreur : Veuillez entrer un nombre décimal valide.\n" +
                "Entrez un double : ";


        assertEquals(45.43215, result);
        assertEquals(expectedOutput, output);
    }


}
