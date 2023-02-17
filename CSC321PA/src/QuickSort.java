import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args) throws IOException {
        //***----------------Note must change file path for this to work!-------------------------------------------***
        File dir = new File("C:\\Users\\Jayden\\Desktop\\TestFiles");
        File[] files = dir.listFiles();

        for (File file : files) {
            System.out.println("Im sorting " + file + " Using quick sort");
            if (file.isFile()) {
                BufferedReader inputStream = null;
                String line;
                try {
                    inputStream = new BufferedReader(new FileReader(file));
                    while ((line = inputStream.readLine()) != null) {
                        //main function here
                        int[]numbers = new int[line.length()];
                        for(int i = 0; i < line.length(); i++){
                            numbers[i] = Character.getNumericValue(line.charAt(i));
                        }
                        //System.out.println(Arrays.toString(numbers));
                        quickSort(numbers, 0, (line.length()-1));
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
