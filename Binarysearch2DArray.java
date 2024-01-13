import java.util.Arrays;

//Complete last 20 minutes
public class Binarysearch2DArray {
    public static void main(String[] args){

        //Case 1. If element == target , ans found
        //Case 2. If element < target , row++
        //Case 3. If element > target ,  column--
        //Lower bound and upper bound eg , [0,0] lb , [0,4] ub the first and last element of that row
        //Time complexity 2N

        //For row column sorter matrix
        int[][] array = {
            {10,20,30,40},
            {15,25,35,45},
            {28,29,37,49},
            {33,34,38,50}
        };
        int target= 50;
        System.out.println("The index of element found in row column sorted 2D array is:"+ Arrays.toString(search2DBinaryRowCol(array, target)));

        //For a sorted matrix

        //If elemet == target, found ans
        //If element > target, ignore rows after it 
        //If element < target , ignore rows above it
        //Bounds 1, row start : 0 (0,0) (LB) ; row end : 3 (3,0) (UB)
        //IN THE END WHEN TWO ROWS ARE REMAINING 
        //Check whethere the mid column you are at contains the answer
        //If not consider 4 parts
        //Do simple binary search on them
        //Time Complexity : O(Log(N) + Log(M))
        /*int[][] sortedMatrix ={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int target2 = 14;*/
        System.out.println("The index of element found in sorted 2D array is:");
    }

    static int[] search2DBinaryRowCol(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length-1;
        while (row< matrix.length && col >= 0){
            if (matrix[row][col]==target){
                return new int[]{row, col};
            }
            else if(matrix[row][col]<target){
                row++;
            }else {
                col--;
            }
        }

        return new int[]{-1,-1};
    }

    static int[] search2DSortedMatrixBinary(int[][] arr, int target){
        int rows = arr.length ;
        int col = arr[0].length;
        // Be cautious matrix can be empty so we need to add a check for that
        if (rows==1){
            return binarySearch(arr, 0, 0, col -1, target);

        }

        //Run the loop till two rows are remaining
        int rowStart =0;
        int rowEnd= rows-1;
        int midCol = col/2;
        while(rowStart< (rowEnd-1)){
            //while this is true it will have more that two rowsa which we are trying to eleminate
            int mid = rowStart + (rowEnd - rowStart)/2;
            if (arr[mid][midCol]==target){
                return new int[]{mid, midCol};
            } else if(arr[mid][midCol]< target){
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }
        //Now we have two rows
        //Check whethere the target is in the column of two rows 


        return new int[]{-1,-1};
    }

    //For the END two rows left 
    static int[] binarySearch(int[][] arr, int row, int colStart , int colEnd, int target){

        while(colStart <= colEnd){
            int mid = colStart + (colEnd - colStart)/2 ;
            if(arr[row][mid]== target){
                return new int[]{row, mid};
            }else if (arr[row][mid]< target){
                colStart = mid+ 1;
            }else {
                colEnd = mid -2;
            }
        }

        return new int[]{-1,-1};
    }
    
}
