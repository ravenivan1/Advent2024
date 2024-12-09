import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Pt1 {
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
                if (checkTop(wordSearch,row,column)) xmasCount++;
                if (checkBottom(wordSearch,row,column)) xmasCount++;
                if (checkLeft(wordSearch,row,column)) xmasCount++;
                if (checkRight(wordSearch,row,column)) xmasCount++;
                if (checkDiagonalTopLeft(wordSearch,row,column)) xmasCount++;
                if (checkDiagonalTopRight(wordSearch,row,column)) xmasCount++;
                if (checkDiagonalBottomLeft(wordSearch,row,column)) xmasCount++;
                if (checkDiagonalBottomRight(wordSearch,row,column)) xmasCount++;
            }
        }

        System.out.println(xmasCount);


    }

    public static boolean checkTop(String[][] wordSearch, int row, int column) {
        if (row - 3 < 0) return false;
        String xmas = wordSearch[row][column] + wordSearch[row-1][column] + wordSearch[row-2][column] + wordSearch[row-3][column];
        return xmas.equals("XMAS");
    }

    public static boolean checkBottom(String[][] wordSearch, int row, int column) {
        if (row + 3 > wordSearch.length - 1) return false;
        String xmas = wordSearch[row][column] + wordSearch[row+1][column] + wordSearch[row+2][column] + wordSearch[row+3][column];
        return xmas.equals("XMAS");
    }

    public static boolean checkLeft(String[][] wordSearch, int row, int column) {
        if (column - 3 < 0) return false;
        String xmas = wordSearch[row][column] + wordSearch[row][column-1] + wordSearch[row][column-2] + wordSearch[row][column-3];
        return xmas.equals("XMAS");
    }

    public static boolean checkRight(String[][] wordSearch, int row, int column) {
        if (column + 3 > wordSearch[0].length-1) return false;
        String xmas = wordSearch[row][column] + wordSearch[row][column+1] + wordSearch[row][column+2] + wordSearch[row][column+3];
        return xmas.equals("XMAS");
    }

    public static boolean checkDiagonalTopLeft(String[][] wordSearch, int row, int column) {
        if (column - 3 < 0 || row - 3 < 0) return false;
        String xmas = wordSearch[row][column] + wordSearch[row-1][column-1] + wordSearch[row-2][column-2] + wordSearch[row-3][column-3];
        return xmas.equals("XMAS");
    }

    public static boolean checkDiagonalTopRight(String[][] wordSearch, int row, int column) {
        if (column + 3 > wordSearch[0].length-1 || row - 3 < 0) return false;
        String xmas = wordSearch[row][column] + wordSearch[row-1][column+1] + wordSearch[row-2][column+2] + wordSearch[row-3][column+3];
        return xmas.equals("XMAS");
    }

    public static boolean checkDiagonalBottomLeft(String[][] wordSearch, int row, int column) {
        if (column - 3 < 0 || row + 3 > wordSearch.length-1) return false;
        String xmas = wordSearch[row][column] + wordSearch[row+1][column-1] + wordSearch[row+2][column-2] + wordSearch[row+3][column-3];
        return xmas.equals("XMAS");
    }

    public static boolean checkDiagonalBottomRight(String[][] wordSearch, int row, int column) {
        if (column + 3 > wordSearch[0].length-1 || row + 3 > wordSearch.length-1) return false;
        String xmas = wordSearch[row][column] + wordSearch[row+1][column+1] + wordSearch[row+2][column+2] + wordSearch[row+3][column+3];
        return xmas.equals("XMAS");
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
