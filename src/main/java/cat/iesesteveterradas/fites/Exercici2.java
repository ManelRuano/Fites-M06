package cat.iesesteveterradas.fites;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Objectius de l'exercici:
 * - Llegeix el fitxer 'Exercici2.dat'.
 * - Fixa't en el programa 'Exercici2write.java' per veure com s'ha genereat el fitxer.
 * - Crea objectes 'Exercici2persona' amb les dades llegides.
 * - Mostra les dades de cada persona en una línia diferent.
 * - El programa ha de gestionar qualsevol quantitat de persones dins de l'arxiu.
 *
 * Nota: Executa primner Exercici2write.java (No cal fer cap canvi) i mira el codi per entendre
 * què fa.
 */


public class Exercici2 {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/exercici2/";
        String filePath = basePath + "Exercici2.dat";
        // Llegir les dades del fitxer amb DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                String nom = dis.readUTF();
                String cognom = dis.readUTF();
                int edat = dis.readInt();
                Exercici2persona persona = new Exercici2persona(nom,cognom,edat);  
                System.out.println(persona.toString());             
            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema llegint el fitxer: " + e.getMessage());
        }


    }
}
