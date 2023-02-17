import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InsertionSort {
    private static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) throws IOException {
        File dir = new File("C:\\Users\\Jayden\\Desktop\\TestFiles");
        File[] files = dir.listFiles();

        for (File file : files) {
            System.out.println("Im sorting " + file + " Using Insertion sort");
            if (file.isFile()) {
                BufferedReader inputStream = null;
                String line;
                try {
                    inputStream = new BufferedReader(new FileReader(file));
                    while ((line = inputStream.readLine()) != null) {
                        int[]numbers = new int[line.length()];
                        for(int i = 0; i < line.length(); i++){
                            numbers[i] = Character.getNumericValue(line.charAt(i));
                        }
                        sort(numbers);
                        System.out.println(Arrays.toString(numbers));
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
    }
}
