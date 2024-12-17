import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day13Input.txt");
        System.out.println(fileData);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
        ArrayList<String[]> clawMachines = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i = i+3) {
            String[] clawMachine = new String[3];
            clawMachine[0] = fileData.get(i);
            clawMachine[1] = fileData.get(i+1);
            clawMachine[2] = fileData.get(i+2);
            clawMachines.add(clawMachine);
        }

        for (String[] clawMachine : clawMachines) {
//            Matcher m = Pattern.compile("X+\\d+").matcher(clawMachine[0]);
            int buttonAX = giveNum(clawMachine[0], "X\\+(\\d+)");
            int buttonBX = giveNum(clawMachine[1], "X\\+(\\d+)");
            int buttonAY = giveNum(clawMachine[0], "Y\\+(\\d+)");
            int buttonBY = giveNum(clawMachine[1], "Y\\+(\\d+)");
            int exactX = giveNum(clawMachine[2], "X=\\d+");
            int exactY = giveNum(clawMachine[2], "Y=\\d+");
            System.out.print(buttonAX + " ");
            System.out.print(buttonBX + " ");
            System.out.print(buttonAY + " ");
            System.out.print(buttonBY + " ");
            System.out.print(exactX + " ");
            System.out.print(exactY + " ");
            System.out.println();
        }

        System.out.println(Arrays.toString(clawMachines.get(0)));
        System.out.println(Arrays.toString(clawMachines.get(1)));
        System.out.println(Arrays.toString(clawMachines.get(2)));
    }

    public static int giveNum(String string, String regex) {
        Matcher m = Pattern.compile(regex).matcher(string);
        String matched = "";
        while (m.find()) {
            matched = m.group();
        }
        return Integer.parseInt(matched.substring(2));
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
