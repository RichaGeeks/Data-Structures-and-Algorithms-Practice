import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        //Divide array into two
        //Then sort both the parts
        //Then merge both the parts
        int[] array = {8, 3, 4, 12, 5, 6};
        System.out.println("The sorted array is : ");
    }
    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        //this creates a new coppy of an array
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
       
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
       
        return merge(left , right);
    }
   
    private static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length ];


        return new int[]{1,2}; 
       
    }
}
