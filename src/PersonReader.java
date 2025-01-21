// PersonReader.java
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner fileScanner = new Scanner(file)) {
                System.out.printf("%-6s %-10s %-10s %-6s %-4s\n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("========================================");
                while (fileScanner.hasNextLine()) {
                    String[] data = fileScanner.nextLine().split(", ");
                    System.out.printf("%-6s %-10s %-10s %-6s %-4s\n", data[0], data[1], data[2], data[3], data[4]);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("File selection cancelled.");
        }
    }
}