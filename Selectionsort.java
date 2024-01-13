import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args){
        //Select the largest element and put it at its correct index 
        //Select the second largest element and put it at its correct position
        //Continue 
        //Same can be done for selecting smallest element then putting it at its correct index
        //Continue
        //Time complexity O(N^2)
        //Worst case and Best case Complexity = O(N^2) same 
        //Not stable 
        //It performs well on small list / array

        int[] array = {3, 1,-22, 5, 4, 2 };
        selectionSort(array);
        System.out.println("The sorted array by selection sort is : "+ Arrays.toString(array));


    }

    static void selectionSort(int[] arr){
        for(int i =0; i< arr.length; i++){
            //Find the maximum item in the remaining arrray and swap with correct index
            int lastIndex = arr.length - i - 1 ;
            int maxIndex = getMaxIndex( arr, 0, lastIndex);

            swap(arr, maxIndex, lastIndex);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end){

        int max = start;
        for(int i = start; i<= end; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] arr, int first ,int second){
        int temp = arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }
   
}
