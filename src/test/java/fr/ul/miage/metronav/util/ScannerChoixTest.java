package fr.ul.miage.metronav.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerChoixTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalPrintStream = System.out;
    public HashMap<Integer, String> choix = new HashMap<>();

    public String sep = System.getProperty("line.separator");


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
        choix.put(1, "Normal");
        choix.put(2, "Simple");
        choix.put(3, "Composé");
        String input = "1";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerChoix scc = new ScannerChoix(choix, inputStream);
        int result = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez");

        assertEquals(1, result);

    }

    @Test
    public void testNegativeInvalidInputChoix(){

        choix.put(1, "Normal");
        choix.put(2, "Simple");
        choix.put(3, "Composé");

        String input = "-1";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerChoix scc = new ScannerChoix(choix, inputStream);
        int result = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez");

        String output = outputStream.toString();


        String expectedOutput =
                "Choisissez quel type d'itinéraire vous souhaitez"+sep+
                "1. Normal"+sep+
                "2. Simple"+sep+
                "3. Composé"+sep+
                "Bien essayé ^^"+sep+
                "Erreur : Veuillez entrer un nombre parmi ceux donnés."+sep;


        assertEquals(expectedOutput, output);
    }

    @Test
    public void testOutOfBoundInputChoix(){
        choix.put(1, "Normal");
        choix.put(2, "Simple");
        choix.put(3, "Composé");

        String input = "4";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ScannerChoix scc = new ScannerChoix(choix, inputStream);
        int result = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez");

        String output = outputStream.toString();



        String expectedOutput =
                "Choisissez quel type d'itinéraire vous souhaitez"+sep+
                        "1. Normal"+sep+
                        "2. Simple"+sep+
                        "3. Composé"+sep+
                        "Erreur : Veuillez entrer un nombre parmi ceux donnés."+sep;


        assertEquals(expectedOutput, output);
    }
}
