import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args){
        //Time complexity  WORST CASE : O(N^2)  BEST CASE : O(N)
        //No of swaps reduce as compared to bubble sort 
        //Its Adaptive 
        //Its Stable
        //Used for smaller values of N 
        // Works well when array is partially sorted 
        //Therefore it takes part in hybrid sorting algorithm
        int[] array ={ 4, 0, 5, 1, 2, 3};
        insertionSort(array); 
        System.out.println(Arrays.toString(array));
        
    }
    static void insertionSort(int[] arr){
        for(int i = 0; i < arr.length - 1 /* Else i <= arr.length - 2 same thing*/ ; i++){
            for(int j= i+1; j>0 ;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr,j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    //Copied from selection sort algorithm 
    private static void swap(int[] arr, int first ,int second){
        int temp = arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }
}
