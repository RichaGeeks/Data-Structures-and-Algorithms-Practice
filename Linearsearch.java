import java.util.Arrays;

public class Linearsearch {
    public static void main(String[] args){
       System.out.println("HELLO WORLD");
       //let you = 10;
       int[] nums ={1,2,3,4,5,6,7,8,9};
       int target= 5;
       int ans = linearsearch(nums, target);
       System.out.println("Element found at index :"+ans);
       
       //Q2
       String name = "Richa";
       char target2 = 'c';
       System.out.println("Char in string : "+searchString(name, target2));
       System.out.println(Arrays.toString(name.toCharArray()));

       //Q2 write start end ect for question 3 and output statement

       //Q3 
       int[] numarr= {15 ,78 ,89 ,22,90,12,23,15,64, 24};
       System.out.println("The minimum number is: "+searchMinNum(numarr));

       //Q4
       int[][] array = {
        {12, 3, 4},
        {18, 12, 22, 95},
        {78, 23}
       };
       int element = 22;
       int[] ans2 = search2DArray(array, element);
       System.out.println("Taregt elemnt in 2D array at index: "+ Arrays.toString(ans2));

       //Q4 Max in 2D array
       System.out.println("The max element in the array is :" +search2DArrayMax(array));

       //Q5 Even number of digits 
       int[] even = {1, 132, 3, 4, 5, 678, 1764, 82, 96, 10, 11, 12, 13, 14 };
       System.out.println("Number of Even digits in the array :"+ searchEvenDigits(even)); 

       //Q6 Max wealth in 2D array for accounts
       int[][] bank = {
        {2 ,3, 4}, {5, 8}, {3, 2, 1}
       };
       System.out.println("The wealth of the richest person is :"+ searchMaxWealth2D(bank));
    }
// Search in the array return index if item found else -1
    static int linearsearch(int[] arr, int target){
        if (arr.length==0){
            return -1;

        }
        for(int index=0; index<arr.length; index++){
            //check element at every index for target
            int element = arr[index];
            if (element == target){
                return index ;
            }
        }
        // target not found 
        return -1;
    } 
    // Question 1 Search in string 
    static boolean searchString(String str, char target) {
        if(str.length()==0){
            return false;
        }
        for (int i =0; i<str.length(); i++){
            if (target == str.charAt(i)){
                return true;
            }
        }
        return false;

    }

        // Question 1 Search in string 
    static boolean searchString2(String str, char target) {
        if(str.length()==0){
            return false;
        }
        for (char ch : str.toCharArray()){
            if (ch == target){
                return true;
            }
        }
        return false;
    }

    //Question 2 seach in range 
    static boolean searchInRange(int start, int end, int[] arr, int target){
        if (arr.length==0){
            return false;
        }
        for(int index = start; index<= end ; index++){
            // rest of the code here 
            // same 
        }
        return false;
    }

    //Question 3 find minimum number 
    static int searchMinNum(int[] arr){
        if (arr.length==0){
            return Integer.MAX_VALUE;
        }
        int num = arr[0];
        for(int i =1; i< arr.length;i++){
            if(arr[i]< num){
                num = arr[i];
            }
        }
        return num;
    }

    //Question 4 search in 2D array
    static int[] search2DArray(int[][] arr, int target){
        for(int row = 0; row<arr.length; row++){
            for(int col = 0; col< arr[row].length; col++){
                if (arr[row][col]== target){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};

    }

    //Search max in 2D array
    // This can also be written in for each loop
    //Similarly can be done for minimum element
    static int search2DArrayMax(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int row = 0; row<arr.length; row++){
            for(int col = 0; col< arr[row].length; col++){
                if (arr[row][col]> max){
                    max= arr[row][col];
                }
            }
        }
        return max;

    }

    //Question 5 In an array of integers return how many of then contain an even number for digits
    //For eg. 103 contains 3 digits that odd number of digits 
    //And 1764 contains 4 digits that is even number of digits 
    static int searchEvenDigits(int[] nums){
        int count = 0;
        for (int num : nums ){
            if (even(num)){
                count++;
            }
        }
        return count;
    }

    //function to check whether the number of digits is even or odd for Question 5
    //for eg. 1764 has 4 digits therefore even returns true 
    static boolean even(int num ){
        int numberOfDigits = digits(num);
            if(numberOfDigits% 2 == 0){
                return true;
            }
            return false;
    }
    
    //function to check the number of digits
    static int digits(int num){
        // if the number in array is negative we have to convert it 
        if (num < 0){
            num = num* -1;
        }
        if (num == 0){
            return 1;
        }
        int count = 0;
        while (num>0){
            count++;
            num= num/10;
        }
        return count;
    }
    // second way for digits 
    // return(int)(Math.log(num)+1)
    //also should convert to positive if negative first

    //Question 6 2D array is given where arr[i][j] ia amount of money the i ^th customer has in the j ^th bank 
    //Return the wealth that the richest customer has 
    //Wealth is the amount of money they have in their bank accounts 
    //The richest customer is the customer that has the maximum wealth 
    //Similar as 2D array max question solved earlier
    //For eg. arr = [[1,2,3],[5,7],[2,1,4]]
    //Person one has 3 bank accounts and their wealth is 1+2+3 = 6
    //Simlarly person 3 has 3 bank accounts with total wealth of 2+1+4=7 therefore is the richest person
    static int searchMaxWealth2D(int[][] arr){
        //person = row
        //account = col
        int maxWealth = Integer.MIN_VALUE;
        for (int person = 0; person< arr.length; person++ ){
            int rowSum=0;
            //Takes sum for every person
            for (int account=0 ; account < arr[person].length; account ++){
                rowSum += arr[person][account];
            }
            //now we have sum of accounts of person
            //check with overall maxWealth 
            if(rowSum >maxWealth){
                maxWealth = rowSum;
            }
        }
        return maxWealth;
    }
}
