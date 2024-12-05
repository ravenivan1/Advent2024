import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
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
                
            }
        }


    }

    public static boolean checkTop(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkBottom(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkLeft(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkRight(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkDiagonalTopLeft(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkDiagonalTopRight(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkDiagonalBottomLeft(String[][] wordSearch, int row, int column) {

        return false;
    }

    public static boolean checkDiagonalBottomRight(String[][] wordSearch, int row, int column) {

        return false;
    }
    
    public static boolean checkMatch(String[][] wordSearch, int row, int column) {
        
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
