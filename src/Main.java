// Main.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        int id = 1;

        HashTable hashTableDivision = new HashTable(1000, 0); 
        HashTable hashTableMultiplicative = new HashTable(1000, 1); 

        try {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
   
            String headerLine = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] bussines = line.split(splitBy);
                try {
                    
                    int key = id;
                    String data = "ID=" + bussines[0] + ", Name=" + bussines[1] + ", Address=" + bussines[2] + ", City=" + bussines[3] + ", State= " + bussines[4];


                    hashTableDivision.insert(key, data);
                    hashTableMultiplicative.insert(key, data);

                    System.out.println("[" + id + "] Business [ID=" + bussines[0] + ", Name=" + bussines[1] + ", Address=" + bussines[2] + ", City=" + bussines[3] + ", State= " + bussines[4] + "]");
                    id++;
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing key as integer for line: " + line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int searchKey = 5; 
        long startTime, endTime, durationDivision, durationMultiplicative;

     
        startTime = System.nanoTime();
        List<String> searchDataDivision = hashTableDivision.search(searchKey);
        endTime = System.nanoTime();
        durationDivision = endTime - startTime;

        if (searchDataDivision != null) {
            System.out.println("Datos encontrados para la llave" + searchKey + " (Hash de division):");
            for (String data : searchDataDivision) {
                System.out.println(data);
            }
        } else {
            System.out.println("Datos no encontrados para la llave" + searchKey + " (Hash de division)");
        }
        System.out.println("Duracion de busqueda (Hash de division): " + durationDivision + " nanosegundos");

   
        startTime = System.nanoTime();
        List<String> searchDataMultiplicative = hashTableMultiplicative.search(searchKey);
        endTime = System.nanoTime();
        durationMultiplicative = endTime - startTime;

        if (searchDataMultiplicative != null) {
            System.out.println("Datos encontrados para la llave" + searchKey + " (Hash multiplicativo):");
            for (String data : searchDataMultiplicative) {
                System.out.println(data);
            }
        } else {
            System.out.println("Datos no encontrados para la llave" + searchKey + " (Hash multiplicativo)");
        }
        System.out.println("Duracion de busqueda (Hash multiplicativo): " + durationMultiplicative + " nanosegundos");
    }
}





