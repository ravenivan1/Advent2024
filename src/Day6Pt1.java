import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6Pt1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        int positionCount = 0;
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] map = new String[rows][columns];
        boolean leftRoom = false;
        int direction = 1;
        int guardLocationRow = -1;
        int guardLocationColumn = -1;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                map[row][column] = fileData.get(row).substring(column, column + 1);
                if (map[row][column].equals("^")) {
                    guardLocationRow = row;
                    guardLocationColumn = column;
                }
            }
        }

        while (!leftRoom) {
            try {
                switch (direction) {
                    case 1: // up
                        if (!map[guardLocationRow-1][guardLocationColumn].equals("#") ) {
                            map[guardLocationRow][guardLocationColumn] = "X";
                            guardLocationRow--;
                        } else {
                            direction = 2;
                        }
                        break;
                    case 2: // right
                        if (!map[guardLocationRow][guardLocationColumn + 1].equals("#")) {
                            map[guardLocationRow][guardLocationColumn] = "X";
                            guardLocationColumn++;
                        } else {
                            direction = 3;
                        }
                        break;
                    case 3: // down
                        if (!map[guardLocationRow+1][guardLocationColumn].equals("#")) {
                            map[guardLocationRow][guardLocationColumn] = "X";
                            guardLocationRow++;
                        } else {
                            direction = 4;
                        }
                        break;
                    case 4: // left
                        if (!map[guardLocationRow][guardLocationColumn-1].equals("#")) {
                            map[guardLocationRow][guardLocationColumn] = "X";
                            guardLocationColumn--;
                        } else {
                            direction = 1;
                        }
                        break;
                }
            } catch (Exception e) {
                map[guardLocationRow][guardLocationColumn] = "X";
                leftRoom = true;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (map[row][column].equals("X")) {
                    positionCount++;
                }
            }
        }

        System.out.println(positionCount);

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
