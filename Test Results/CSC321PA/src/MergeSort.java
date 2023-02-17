import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
    private static void merge(int arr[], int left, int middle, int right)
    {
        int num1 = middle - left + 1;
        int num2 = right - middle;

        int Left[] = new int[num1];
        int Right[] = new int[num2];

        for (int i = 0; i < num1; ++i)
            Left[i] = arr[left + i];
        for (int j = 0; j < num2; ++j)
            Right[j] = arr[middle + 1 + j];

        int i = 0;
        int j = 0;

        int k = left;
        while (i < num1 && j < num2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            }
            else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        while (i < num1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        while (j < num2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    private static void sort(int arr[], int left, int right)
    {
        if (left < right) {
            int m = left + (right - left) / 2;
            sort(arr, left, m);
            sort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }

    public static void main(String[] args) throws IOException {
        //***----------------Note must change file path for this to work!-------------------------------------------***
        File dir = new File("C:\\Users\\Jayden\\Desktop\\TestFiles");
        File[] files = dir.listFiles();

        for (File file : files) {
            System.out.println("Im sorting " + file + " Using merge sort");
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
                        sort(numbers, 0, (line.length()-1));
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
