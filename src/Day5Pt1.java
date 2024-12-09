import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        ArrayList<String[]> rules = new ArrayList<>();
        ArrayList<String[]> updates = new ArrayList<>();

        for (String line : fileData) {
            if (line.contains("|")) {
                String[] rule = line.split("\\|");
                rules.add(rule);
            }
            if (line.contains(",")) {
                String[] update = line.split(",");
                updates.add(update);
            }
        }
        
        for (String[] update : updates) {
            for (int i = 0; i < update.length; i++) {
                
            }
        }


    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
