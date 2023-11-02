package cat.iesesteveterradas.fites;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Objectiu de l'exercici:
 * - Llegir el fitxer 'Exercici1.java'.
 * - Crear un nou fitxer 'Exercici1out.txt'.
 * - Invertir el text de cada línia utilitzant 'giraText'.
 *
 * Exemple:
 * - Si 'Exercici1.java' comença amb "package cat.iesesteveterradas.fites;",
 *   en 'Exercici1Solucio.txt' es convertirà en ";setif.sadatsevetsertei.tac egakcap".
 *
 * Ubicació del fitxer de sortida:
 * - Emmagatzemar a 'data/exercici1' dins del directori data/exercici1
 */

public class Exercici1 {
    public static void main(String[] args) {
        String basePathIn = System.getProperty("user.dir") + "/src/main/java/cat/iesesteveterradas/fites/";
        String basePathOut = System.getProperty("user.dir") + "/data/exercici1/";
        String filePathIn = basePathIn + "Exercici1.java";
        String filePathOut = basePathOut + "Exercici1Solucio.txt";

        try {
            FileWriter fOut = new FileWriter(filePathOut);
            File file = new File(filePathIn);
            Scanner scaner = new Scanner(file);

            while (scaner.hasNextLine()) {
                String line = scaner.nextLine();
                String reversedLine = giraText(line);
                fOut.write(reversedLine + "\n");
            }

            scaner.close();
            fOut.close();
            System.out.println("Proceso completado. Resultado en " + filePathOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathOut))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.printf("%d: %s%n", lineNumber++, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String giraText(String text) {
        StringBuilder reversedText = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversedText.append(text.charAt(i));
        }
        return reversedText.toString();
    }
    
}
