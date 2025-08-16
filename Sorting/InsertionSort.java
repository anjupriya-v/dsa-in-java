import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    int[] insertionSort(int[] arr) {
        int temp, j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        InsertionSort qs = new InsertionSort();
        int res[] = qs.insertionSort(arr);
        System.out.println("Sorted Array" + Arrays.toString(res));
        sc.close();
    }
}
