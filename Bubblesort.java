import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args){
        //It is also know as SINKING SORT or EXCHANGE SORT 
        
        //With pass one 1st largest element will be at the end
        //With the second pass the 2nd largest element will be in the second last place
        //Hence with every pass the remaining largest number will move to the end before the numberlarger than it 
        //Time Complexcity : Best case O(N) when array is sorted 
        //                   Worst case O(N^2) when array is sorted in opposite
        //Space complexity = O(1) constant , which means no extra space required ;also know as inplace sorting algorithm


        int[] array = { 40,20 ,56, 11, 24 , 30, 2, 7};
        bubbleSort(array);
        System.out.println("The bubble sorted array is :"+ Arrays.toString(array));

    }

    static void bubbleSort(int[] arr){
        boolean swapped ;
        //run the steps N-1 times
        for(int i= 0; i<arr.length; i++){
            swapped = false;
            //for each step, max item will come at the last respective index 
            for(int j =1; j<arr.length-i /* or arr.length -1 */ ; j++){
                //sawap if the item is smaller than previous item
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            //If you did not swap for any particular value of i that means the array is sorted hence stop the program
            if(!swapped){ //!false = true
                break;
            }
        }
    }
}
