import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<String> leftList = new ArrayList<>();
        ArrayList<String> rightList = new ArrayList<>();
        int total = 0;

        for (String fileDatum : fileData) {
            leftList.add(fileDatum.substring(0, 5));
            rightList.add(fileDatum.substring(8));
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        for (int i = 0; i < leftList.size(); i++) {
            total += Math.abs(Integer.parseInt(leftList.get(i)) - Integer.parseInt(rightList.get(i)));
        }

        System.out.println(total);


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
