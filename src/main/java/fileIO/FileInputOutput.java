package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileInputOutput {

    public static void readFromFile(String inputFilename) {
        try (FileReader f = new FileReader(inputFilename);
             BufferedReader br = new BufferedReader(f);) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("No such file: " + inputFilename);
        }
    }

    public static void printToFile(String outputFile) {
        int[] numbers = {9, 6, 3, 5, 2, 4};
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            for (int i = 0; i < numbers.length; i++) {
                pw.println(numbers[i]);
            }
        }
        catch (IOException e) {
            System.out.println("Error writing to a file " + outputFile);
        }
    }

    public static void main(String[] args) {
        readFromFile("input.txt");
        printToFile("output.txt");
    }
}
