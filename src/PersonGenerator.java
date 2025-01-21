// PersonGenerator.java
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> personRecords = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        boolean addMore = true;
        while (addMore) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name:");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr., Mrs., Ms., Dr., etc.)");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1000, 9999);

            String record = String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
            personRecords.add(record);

            addMore = SafeInput.getYNConfirm(in, "Do you want to add another person?");

            for( String p: personRecords)
                System.out.println(p);


            try {
                OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

                for(String rec : personRecords) {
                    writer.write(rec, 0, rec.length());
                    writer.newLine();
                }

                writer.close();
                System.out.println("Data file written!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }
