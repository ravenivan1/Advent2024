import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day7Input.txt");
        ArrayList<Long> numsResults = new ArrayList<>();
        ArrayList<int[]> nums = new ArrayList<>();
        for (String line : fileData) {
            String[] array = line.split(" ");
            Long numResult = Long.parseLong(array[0].substring(0, array[0].length()-1));
            int[] numbers = new int[array.length-1];
            for (int i = 0; i < array.length-1; i++) {
                numbers[i] = Integer.parseInt(array[i+1]);
            }
            numsResults.add(numResult);
            nums.add(numbers);
            System.out.println((int) Math.pow(2, numbers.length-1));
            System.out.println(numResult);
            System.out.println(Arrays.toString(numbers));

        }
        System.out.println(fileData);
    }

    public boolean checkValid(long numResult, int[] nums) {
        int arrangements = (int) Math.pow(2, nums.length-1);
        for (int i = 0; i < nums.length; i++) {

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
