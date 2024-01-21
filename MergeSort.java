import java.util.Arrays;

//REQUIRES RECURSION
public class MergeSort {
    public static void main(String[] args) {

        //TIME COMPLEXITY  =  O(N * logN)

        //Divide array into two
        //Then sort both the parts
        //Then merge both the parts
        int[] array = {8, 3, 4, 12, 5, 6};
        //Original array is not modified in this process 
        //It return a new array 
        int[] newarr = mergeSort(array);
        System.out.println("The sorted array is : " + Arrays.toString(newarr));
        System.out.println("The original array stays the same : " + Arrays.toString(array));
        mergeSortInPlace(array, 0, array.length);
        System.out.println("The sorted array is : " + Arrays.toString(array));
        System.out.println("The original array is modified : " + Arrays.toString(array));
        System.out.println("EXCELLENT WORK !");
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
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length & j < second.length) {
            if(first[i] < second[j]){
                mix[k]= first[i];
                i++;
            }
            else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        //It may be possible that one of the array is not complete 
        //The add all the rest of elements 
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j< second.length){
            mix[k]= second[j];
            j++;
            k++;
        }
        return mix;   
    }

    //IN PLACE MERGE SORT 
    //I didn,t understand this part 
    static void mergeSortInPlace(int[] arr, int start, int end){
        if(end - start==1){
            return;
        }
        int mid = (start + end)/2;
        //this creates a new coppy of an array
        mergeSortInPlace(arr, start, mid);
       
        mergeSortInPlace(arr, mid, end);
       
        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid & j < end) {
            if(arr[i] < arr[j]){
                mix[k]= arr[i];
                i++;
            }
            else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        //It may be possible that one of the array is not complete 
        //The add all the rest of elements 
        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j< end){
            mix[k]= arr[j];
            j++;
            k++;
        }
        //Modifying the original array instead of return
        for (int l = 0; l < mix.length; l++){

            arr[start + l] = mix[l];
        }
    }
}
