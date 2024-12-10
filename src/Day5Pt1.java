import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<int[]> rules = new ArrayList<>();
        ArrayList<int[]> updates = new ArrayList<>();
        ArrayList<int[]> validUpdates = new ArrayList<>();

        for (String line : fileData) {
            if (line.contains("|")) {
                String[] rule = line.split("\\|");
                int[] ruleConvert = new int[rule.length];
                for (int i = 0; i < rule.length; i++) {
                    ruleConvert[i] = Integer.parseInt(rule[i]);
                }
                rules.add(ruleConvert);
            }
            if (line.contains(",")) {
                String[] update = line.split(",");
                int[] updateConvert = new int[update.length];
                for (int i = 0; i < update.length; i++) {
                    updateConvert[i] = Integer.parseInt(update[i]);
                }
                updates.add(updateConvert);
            }
        }

        for (int[] update : updates) {
            ArrayList<int[]> validRules = new ArrayList<>();
            for (int[] rule : rules) {
                if (checkValidRule(rule, update)) validRules.add(rule);
            }
            System.out.println(validRules);
            System.out.println(checkValidUpdate(validRules, update));;
            System.out.println();
        }


    }

    public static boolean checkValidRule(int[] rule, int[] update) {
        int num1 = rule[0];
        int num2 = rule[1];
        boolean num1Found = false;
        boolean num2Found = false;
        for (int num : update) {
            if (num == num1) {
                num1Found = true;
            }
            if (num == num2) {
                num2Found = true;
            }
        }
        return num1Found && num2Found;
    }

    public static boolean checkValidUpdate(ArrayList<int[]> validRules, int[] update) {
        for (int[] rule : validRules) {
            int indexFirst = -1;
            int indexSecond = -1;
            for (int i = 0; i < update.length; i++) {
                if (update[i] == rule[0]) {
                    indexFirst = i;
                }
                if (update[i] == rule[1]) {
                    indexSecond = i;
                }
            }
            if (indexFirst > indexSecond) return false;
        }
        return true;
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
