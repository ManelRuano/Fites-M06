package cat.iesesteveterradas.fites;

import java.io.File;
import java.util.ArrayList;

/**
 * Objectius de l'exercici:
 * - Comprova l'existència del fitxer filePaht.
 * - Determina si el fitxer és ocult.
 * - Mostra la data de l'última modificació.
 * - Verifica si el fitxer pot ser modificat.
 * - Llista els arxius dins d'un directori basePath.
 */

public class Exercici0 {

    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/exercici0/";
        String filePath = basePath + "Exercici0.dat";
        
        File file = new File(filePath);
        
        boolean existeix = file.exists();
        System.out.println("L'arxiu existeix: " + existeix);

        boolean ocult = file.isHidden();
        System.out.println("L'arxiu és ocult: " + ocult);

        long modificatMillis = file.lastModified();
        java.util.Date modificat = new java.util.Date(modificatMillis);
        System.out.println("Última modificació: " + modificat);

        boolean esPotModificar = file.canWrite();
        System.out.println("L'arxiu es pot modificar: " + esPotModificar);

        File[] arxius = file.getParentFile().listFiles();
        if (arxius != null) {
            ArrayList<String> llistaArxius = new ArrayList<>();
            for (File arxiu : arxius) {
                llistaArxius.add(arxiu.getName());
            }
            System.out.println("La llista d'arxius d'aquesta carpeta és: " + llistaArxius);
            
        } else {
            System.out.println("La carpeta no conté arxius.");
        }
    }
}
