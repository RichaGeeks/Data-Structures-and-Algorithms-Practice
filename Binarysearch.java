public class Binarysearch {
    public static void main(String[] args){

        //Here we assume the array is sorted 
        //Sorted array is in ascending or descending order
        //Algorithm
        //1. First find the middle element
        //2. Check if the target element is greater than the middle element search in right else check left
        //3. If middle element is target element therefore answer is found
        //middle element = start index + end index / 2
        //Then check gain for the rest of the array with the same method 
        //At start, If start < target , it means element not found vise versa in ascending array 
        //The array is getting divide by N/2^k , N is array 
        //N/2^k =1 (last level left)
        //log(N)= log(2^k)
        //logN = klog2
        //k = logN/ log2
        //Total comparisions in the worst case = logN

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 7;
        System.out.println("The target element found at index: "+ binarySearch(arr, target));

        // Order agnostic array
        int[] arrAsc = {1, 3, 5, 6, 9, 12, 14, 20, 23};
        int[] arrDes = {23, 20, 14, 12, 9, 6, 5, 3, 1};
        int target2 = 20;
        System.out.println("Thr target element in the order agnostic array found at index: "+ binarySearchOdrAgn(arrAsc,target2)); 
        System.out.println("Thr target element in the order agnostic array found at index: "+ binarySearchOdrAgn(arrDes,target2));
    } 

    //return the index 
    // return -1 if it does not exist
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            //find middle element
            //int mid = (start+end)/2
            //there might be a possibility where (start + end) exceeds the limit of java
            int mid = start +(end - start)/2; //It is the same formula but in a better way
            
            if(target< arr[mid]){
                end =mid -1;
            } else if (target> arr[mid]){
                start = mid + 1;
            } else {
                //ans found 
                return mid;
            }
        }
        return -1;
    }

    //If it is given that array is in descending order 
    //Target > middle search in left , hence end = mid - 1
    //Target < middle search in right , hence start = mid +1

    //Order agnostic binary search
    static int binarySearchOdrAgn(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        //Find whethere the array is ascending or descending

        /*boolean isAsc;
        if (arr[start] < arr[end]){
            isAsc = true;

        } else {
            isAsc = false;
        } */
        // 2nd method for checking

        boolean isAsc = arr[start] < arr[end];

        while(start<=end){
            
            int mid = start +(end - start)/2; //It is the same formula but in a better way
            
            if(arr[mid]== target){
                return mid;
            }

            //For ASCENDING
            if (isAsc){
                if(target< arr[mid]){
                    end =mid -1;
                } else if (target> arr[mid]){ // Can add just else over here , I added else if for understanding
                    start = mid + 1;
                }
            } //For DESCENDING
            else {
                if(target > arr[mid]){
                    end = mid -1;
                } else if (target < arr[mid]){ // Can add just else over here , I added else if for understanding
                    start = mid + 1;
                }
            }
            
        }
        return -1;
    }
}
