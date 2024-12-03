import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        ArrayList<String[]> lineData = new ArrayList<>();
        int safe = fileData.size();
        System.out.println(safe);
        for (String line : fileData) {
            lineData.add(line.split(" "));
        }

        for (String[] lineArray : lineData) {
            ArrayList<Integer> differences = new ArrayList<>();
            boolean reduced = false;
            int strike = 0;
            for (int i = 1; i < lineArray.length; i++) {
                differences.add(Integer.parseInt(lineArray[i - 1]) - Integer.parseInt(lineArray[i]));
                if ((Math.abs((Integer.parseInt(lineArray[i - 1]) - Integer.parseInt(lineArray[i]))) < 1) || ((Math.abs(Integer.parseInt(lineArray[i - 1]) - Integer.parseInt(lineArray[i])) > 3))) {
                    if (strike > 0) {
                        safe--;
                        reduced = true;
                        break;
                    } else {
                        i++;
                        strike++;
                        differences.removeLast();
                    }
                }
            }
            System.out.println(differences);
            if (!reduced) {
                boolean reduce = false;
                boolean positive = differences.getFirst() > 0;
                for (Integer difference : differences) {
                    if (positive) {
                        if (difference < 0) {
                            if (strike > 0) {
                                reduce = true;
                            } else {
                                strike++;
                            }
                        }
                    } else {
                        if (difference > 0) {
                            if (strike > 0) {
                                reduce = true;
                            } else {
                                strike++;
                            }
                        }
                    }
                }
                if (reduce) {
                    safe--;
                }
            }
        }

        System.out.println(safe);

        System.out.println(Arrays.toString(lineData.get(0)));

        System.out.println(fileData);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
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
