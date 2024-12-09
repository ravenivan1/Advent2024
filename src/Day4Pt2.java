import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Pt2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        int xmasCount = 0;


        int rows = fileData.size();
        System.out.println(rows);
        int columns = fileData.get(0).length();
        System.out.println(columns);
        String[][] wordSearch = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = fileData.get(row).substring(column, column+1);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (checkXMAS(wordSearch, row, column)) xmasCount++;
            }
        }

        System.out.println(xmasCount);


    }

    public static boolean checkXMAS(String[][] wordSearch, int row, int column) {
        try {
            String word1 = wordSearch[row-1][column-1] + wordSearch[row][column] + wordSearch[row+1][column+1];
            String word2 = wordSearch[row+1][column-1] + wordSearch[row][column] + wordSearch[row-1][column+1];
            return (word1.equals("MAS") || word1.equals("SAM")) && (word2.equals("MAS") || word2.equals("SAM"));
        } catch (Exception e) {
            return false;
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
