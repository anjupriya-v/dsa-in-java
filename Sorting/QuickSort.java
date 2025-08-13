import java.util.*;
public class QuickSort{
    int partition(int[] arr, int low, int high){
        int pivot = arr[high], i = low, j = low;
        while(i <= high){
            if(arr[i]<= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }
    int[] quickSort(int[] arr, int low, int high){
        if(low <= high){
            int partition = partition(arr,low,high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
        return arr;
    }
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr [] = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i< n;i++){
            arr[i] = sc.nextInt();
        }
        QuickSort qs = new QuickSort();
        int res[] = qs.quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array"+ Arrays.toString(res));
        sc.close();
    }
}