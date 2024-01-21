import java.util.Arrays;

//REQUIRES RECURSION

public class QuickSort {
    public static void main(String[] args){

        //PIVOT : Choose any element -- after first pass all the elements < pivot will be on LHS of pivot .
        //All the elements > pivot will be on RHS of pivot
        //After every pass pivot will be at the correct position 
        //The LHS AND RHS repeat the same process with recurssion 
        int[] array = {5, 4, 3, 2, 1};

        //How to pick pivot ?
        //-- Random element 
        //-- Corner element
        //-- Middle element

        //RECURANCE RELATION : T(N) =T(k) + T(N-k-1) + O(N)            IMP
        //Time complexcity : Worst Case = O(N^2) | Best Case = O(NlogN)
        System.out.println("The original array is :" + Arrays.toString(array));
        quickSort(array, 0 , array.length -1);
        System.out.println("The sorted array is :" + Arrays.toString(array));
        System.out.println("EXCELLENT WORK !");

        //Notes
        //-Not stable 
        //-In-plane i.e. why preferred for arrays instead of Merge sort , merge sort takes O(N) extra space 
        //-Merge sort is better in linked list due to memory allocations = not continuous

        //HYBRID SORTING ALGORITHMS : merge sort + insertion sort 
        //Works well with partially sorted data

        //Arrays.sort(arr); ---- uses Quick Sort, Insertion sort is used , heap sort is used 

    }

    static void quickSort(int[] nums, int low, int high){
        if ( low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s+ (e-s)/2;
        int pivot = nums[m];

        while( s <= e) {
            while (nums[s] < pivot ){
                s++;
            }
            while (nums[e] > pivot ){
                e--;
            }
            if (s <= e){
               int temp = nums[s];
               nums[s] = nums[e];
               nums[e] = temp; 

               s++;
               e--;

            }
        }
        //now my pivot is at correct index , please sort two halves 
    quickSort(nums, low, e);
    quickSort(nums, s, high);
    }
    
}
