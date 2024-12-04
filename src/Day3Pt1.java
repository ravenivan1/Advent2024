import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Pt1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        ArrayList<String> matches = new ArrayList<>();
        int sum = 0;
        String regex = "mul\\(\\d+,\\d+\\)";

        for (String lineData : fileData) {
            Matcher m = Pattern.compile(regex).matcher(lineData);

            while (m.find()) {
                matches.add(m.group());
            }
        }

        for (String match: matches) {
            String bothNums = match.substring(match.indexOf("(") + 1, match.length()-1);
            String[] nums = bothNums.split(",");
            sum += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
        }
        
        System.out.println(sum);


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
