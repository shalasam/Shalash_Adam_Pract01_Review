// ProductReader.java
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner fileScanner = new Scanner(file)) {
                System.out.printf("%-10s %-15s %-15s %-10s %-10s\n", "======================ProductID", "Name", "Category", "Price", "Quantity");
                System.out.println("===========================================================");
                while (fileScanner.hasNextLine()) {
                    String[] data = fileScanner.nextLine().split(",\\s*");
                    if (data.length == 5) {
                        System.out.printf("%-10s %-15s %-15s %-10s %-10s\n", data[0], data[1], data[2], data[3], data[4]);
                    } else {
                        System.out.println("Invalid record found: " + String.join(", ", data));
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("File selection cancelled.");
        }
    }
}