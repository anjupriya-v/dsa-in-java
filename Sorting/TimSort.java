import java.util.*;

public class TimSort{
    public static int[] timeSort(int[] arr,int n, int MIN_RUN){
        int left = 0, right = MIN_RUN, mid;
        for(int i = 0;i< n; i+=MIN_RUN){
            left = i;
            right = Math.min((MIN_RUN+left)-1, n-1);
            TimSort.insertionSort(arr, left, right);
        }

        for(int size = MIN_RUN; size < n ; size *=2){
            for(int i = 0;i< n;i+=(2*size)){
                left = i;
                mid = (left + size) - 1;
                right = Math.min((left+(2*size))-1, n-1);
                if(mid < right){
                    TimSort.mergeSort(arr,left,mid,right);
                }
            }
        }
        return arr;
    }
    public static void insertionSort(int[] arr, int low, int high){
        int key,j;
        for(int i=low+1;i<= high;i++){
            key = arr[i];
            j = i - 1;
            while(j >= low && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]= key;
        }
    }
    public static void mergeSort(int[] arr, int left, int mid, int right){
        int n1 = (mid - left) + 1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid+1, R, 0, n2);
        int i =0, j=0, k = left;
        while(i < n1 && j < n2){
            if(L[i]<=R[j]){
                arr[k++] = L[i];
                i++;
            }
            else{
                arr[k++] = R[j];
                j++;
            }
        }
        while(i < n1){
            arr[k++]= L[i];
            i++;
        }
        while(j < n2){
            arr[k++]= R[j];
            j++;
        }
    }
    public static void main(String args []){
        int n, MIN_RUN = 4; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements");
        for(int i = 0 ; i< n; i++){
            arr[i]= sc.nextInt();
        }
        int result[] = TimSort.timeSort(arr,n, MIN_RUN);
        System.out.println("Sorted Array "+ Arrays.toString(result));
        sc.close();
    }
}