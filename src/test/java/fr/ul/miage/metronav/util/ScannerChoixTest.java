package fr.ul.miage.metronav.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerChoixTest {

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
    public void testValidInputChoix(){

        String input = "1";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerChoix scc = new ScannerChoix(inputStream);
        int result = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez");

        assertEquals(1, result);

    }

    @Test
    public void testNegativeInvalidInputChoix(){

        String input = "-1";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerChoix scc = new ScannerChoix(inputStream);
        int result = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez");

        String output = outputStream.toString();

        String expectedOutput = "Choisissez quel type d'itinéraire vous souhaitez : \n1. Normal\n 2. Simple\n3. Composé\nBien essayé ^^\nErreur : Veuillez entrer un nombre parmi ceux donnés.";

        assertEquals(expectedOutput, output);
    }


    @Test
    public void testInValidThenValidInputDouble(){

        String input1 = "Invalid Value\r\n";
        String input2 = "45.43215\r\n";

        String input = input1 + input2;


        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerDouble scd = new ScannerDouble(inputStream);
        Double result = scd.getValidDoubleInput("Choisissez quel type d'itinéraire vous souhaitez");

        String output = outputStream.toString();

        String expectedOutput = "Entrez un double : Erreur : Veuillez entrer un nombre décimal valide.\n" +
                "Entrez un double : ";


        assertEquals(45.43215, result);
        assertEquals(expectedOutput, output);
    }


}
