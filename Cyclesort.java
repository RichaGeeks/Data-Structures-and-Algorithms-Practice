import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Cyclesort {
    //Very important pattern for AMAZON , GOOGLE , MICROSOFT 
    public static void main(String[] args){
        //HERE WE WANT TO SOLVE IN 1 FOR LOOP 
        //When given no.s from range 1 to N USE CYCLIC SORT 
        //V V V V V V IMP line above
        //check the number and swap with its correct index i.e. value -1 
        //Worst case : O(N)
        int[] array = {3, 5, 2, 1, 4};
        //After sorting : index = value - 1 ,because {1,2,3,4,5}
        cycleSort(array);
        System.out.println(Arrays.toString(array));

        //Question 1
        //Given an array nums containing n distinct numbers in range [0, n], return the only number in the range that is missing from the array 
        //Follow up: could u implement using only O(1) extra space complexity and O(n) runtime complexity
        //No.s from 0 till N : tOTAL THERE WILL BE N + 1 numbers 

        //CASE 1 : When N is present in the array 
        //eg. N=4, arr= {4, 0 ,2, 1}  
        //Actually should be {0,1,2,3,4} i.e. N+1= 5 numbers
        //index = element here 
        int[] nums = {4, 0, 2, 1}; // Here n = 4
        // index 4 does not exist in the missing array there ignore when 4 comes
        //Therefore after sorting arr will be {0, 1, 2, 4}
        //After check whethere index = element when not return answer
        System.out.println("The missing number is : "+ missingNum(nums));

        //CASE 2 : When N is not in  the array 
        int[] nums2 = { 1, 0 ,3 ,2 };
        //Here N = 4  i.e. Answer = N = 4
        System.out.println("The missing number is : "+ missingNum(nums2));

        //Question 2 
        //INCOMPLETE CHECK AGAIN
        //CHECKED AGAIN AND COMPLETED 
        //GOOGLE question
        //Given an array numbers of n integers where nums[i] is range  [1,n] , return an array of all the integers in the range [1,n] that do not appear in nums
        int[] numbers = {1, 2, 4, 5, 8, 7, 7, 1};
        //Here N = 8
        //Array after sorting = {};
        //List<Integer> ans = missingNums(numbers);  //THIS WAS THE ERROR 
        System.out.println("The missing numbers are : " + missingNums(numbers));

        //Question 3
        //MICROSOFT question
        int[] arr ={ 1, 3, 4, 2, 2 };
        System.out.println("The duplicate number is :"+ findDuplicate(arr));

        //Question 4
        //Array arrdup of length n in the range [1, n] each int appears once or twice return an array of integer that returns twice 
        int[] arrdup = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("The duplicate numbers are :" + findDuplicates(arrdup));
        //After sorting {1, 2, 3, 4, 3, 2, 7, 8};
        //Then find the wrong indexes 

        //Question 5
        //Set mismatch 
        //set of integers from [1, n] one is duplicated instead of a number 
        //Find the number that occurs twice and the number that is missing and return them in the form of an array

        int[] mismatch = {2, 1, 4, 2, 6, 5};
        // after sorting {1, 3, 2, 4, 5, 6,}
        //missing number = index + 1
        //duplicate no. = no. at the missing index
        int[] answer = mismatch(mismatch);
        System.out.println("The duplicate number is :" + answer[0] +" The missing number is :"+ answer[1]);
        
        //Question 6
        //First missing positive 
        //given unsorted integer array positivemissing return the smallest missing positive integer
        //Hard question because not given [1,n] or [0,n]
        //First sort it in the ascending order
        //Ignore elements that are negative and greater that the length of the array
        //start checking from no. 1 does it exist then 2 ....
        //This is your hint that you are going to use cyclic sort because you are searching from no. 1 no. 2 no. 3 ans so on
        int[] missingpositive = {3, 4, -1, 1};
        //after sorting ascending order {-1, 1, 3, 4}
        //after sorting with cyclic sort {1, -1, 3, 4}
        //index 1 not correct hence ans 
        System.out.println("The First Missing Positive Number is :"+ missingpositive(missingpositive));

        System.out.println("EXCELENT WORK.");
    }
    //ALGORITHM
    static void cycleSort(int[] arr){
        int i =0;
        while (i< arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct] ){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    //Copied from selection sort and insertion sort algorithm 
    private static void swap(int[] arr, int first ,int second){
        int temp = arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }

    //Q1 Missing no.
    static int missingNum(int[] arr){
        int i =0;
        while (i< arr.length){
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct] ){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //search for first missing number 
        for(int index =0; index < arr.length; index++){
            if(arr[index] != index ){
                return index;   
            }
        }
        //Case 2 
        return arr.length;
    } 
    
    //Q2 Missing numbers and duplicate no.s
    static List<Integer> missingNums(int[] arr){
        int i =0;
        while (i< arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct] ){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //Just find missing numbers
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index ++ ){
            if (arr[index] !=  index +1 ) {
                ans.add(index+1);
            }
        }
        return ans;
    }

    //Q3 Find the duplicate value
    static int findDuplicate(int[] arr){
        int i =0;
        while (i< arr.length){

            if (arr[i] != i+1){
                int correct = arr[i] - 1;
                if(arr[i] < arr.length && arr[i] != arr[correct] ){
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
            
        }
        return -1;
    }  

    static List<Integer> findDuplicates(int[] arr){
        int i = 0; 
        while (i< arr.length){
            int correct = arr[i] -1;
            if(arr[i] != arr[correct] ){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //Just find missing numbers
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index ++ ){
            if (arr[index] !=  index +1 ) {
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    static int[] mismatch(int[] arr){
        int i =0;
        while (i< arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct] ){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //search for first missing number 
        for(int index =0; index < arr.length; index++){
            if(arr[index] != index + 1){
                return new int[] {arr[index], index+1 };   
            }
        }
        //In case there is nothing wrong return {-1,1}
        return new int[] {-1,-1};
    }

    //Q 6
    static int missingpositive(int[] arr){
        int i =0;
        while (i< arr.length){
            int correct = arr[i]-1;
            if(arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[correct] ){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //search for first missing number 
        for(int index =0; index < arr.length; index++){
            if(arr[index] != index + 1 ){
                return index + 1;   
            }
        }
        //case 2
        return arr.length + 1;
    }
}
