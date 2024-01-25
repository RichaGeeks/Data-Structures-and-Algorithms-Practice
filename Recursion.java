public class Recursion{
    public static void main(String[] args){
        //While a function has not finished execution it remains in the stack 

        //When a function finishes execution it is removed from the stack and the flow of program is restored to where the function was called  

        print(0);
        //Recursion : Function calling itself 
        //Why recursion ?
        //Ans: It helps us in solving bigger complex problems in a simpler way .
        //You can convert recursion solutions into iterations and vice versa. 
        //Space complexity is not constant because of recursive calls 
        //It helps us in breaking down bigger problems to smaller problems .
        
        //VISUALIZING RECURSION : vvvimp (recursive tree)

        //Q.1 
        System.out.println(fibo(6));

        //STEPS TP UNDERSTAND A PROBLEM  vvvimp
        // Identify if you can break down problem into smaller problems 
        //Write the recurrence relation if needed 
        //Draw the recursive tree
        //About the tree : 
          //a. See the flow of functions , how they are getting in stuck
          //b. Identify and focus on left tree calls and right tree calls 
    }
    //Recursive function to print till 5
    static void print(int n ){
        //Base condition in recursion : a condition where our recursion will stop making new calls
        //No base condition , function will keep happening  , stack will be filled again and again , memory of computer will exceed the limit -- stack overflow error  
        if (n==5){
            System.out.println(n);
            return;
        } 
        System.out.println(n);

        //RECURSIVE CALL 
        //IF YOU ARE CALLING A FUNCTION AGAIN AND AGAIN YOU CAN TREAT IT AS A SEPERATE CALL IN THE STACK 

        //THIS IS ACALLED TAIL RECURSION 
        //Since this is the last function call 
        print(n+1);

    }

    //Question 1 Find nth fibonacci number using recursion
    //0,1,1,2,3,5,8,13....
    static int fibo(int n){
        //Fibo(N) = Fibo(N-1) + Fibo(N-2)  recurrence relation

        //base condition 
        if (n< 2) {
            return n;
        }

        //This is not tail recursion
        return fibo(n-1) + fibo(n-2);
    }
}