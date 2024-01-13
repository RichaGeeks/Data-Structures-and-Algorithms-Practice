public class Stringbuilder{
    public static void main(String[] args){
        /*int a = 10;*/
        /*int[] arr = {2, 3, 4, 5, 6};*/
        String name = "Richa Suryawanshi";
        //DATATYPE VARIABLE = OBJECT;
        System.out.println(name);
        //String is not most commonly used in java 
        //Every string that you create is an object of type string

        String xname = "Richa";
        String yname = "Richa";
        String zname = yname;
        System.out.println(xname == yname); //True
        System.out.println(zname == xname);


        //Seperate String pool in heap memory 
        //When two variable have same values it is pointed to the same object in pool memory 
        //Only one object is created
        //Use case makes program more optimized
        System.out.println(xname);
        xname = "Suryawanshi";
        System.out.println(xname);
        
        //How to create different objects of same value
        String x = new String( "Richa");
        String y = new String("Richa");
        System.out.println(x == y); //False
        //This will create two new different objects outside the pool but in heap
        //When you only need to check value use .equals method
        System.out.println(x.equals(y)); //True it does not care if they are pointing to same object or not
        System.out.println(x.charAt(0));


    }
}
