/*
    @ author Will Ross 3734692
*/

import java.util.Scanner;

public class Assignment2{
    // main class for calling methoods and scannning inputs
    public static void main(Strings[] args){

        // intialize both arrays to properly read in rational numbers
        int numerator[];
        int denominator[];

        //set up scanner and read in the length
        Scanner sc = new Scanner(System.in);
        System.out.println("How many inputs would you like to enter?");
        int length = sc.nextInt();

        //set both arrays for the length
        numerator = new int[length];
        denominator = new int[length];

        //fill the arrays with the inputs and check to make sure that they are only rational numbers
        sc.useDelimiter("/");

        for(int i = 0; i < length; i++){

            numerator[i] = sc.nextInt();
            denominator[i] = sc.nextInt();
            System.out.println(numerator[i] + "/" + denominator[i]);

        }
        
        sc.close();
    }


}


/* 
import java.util.Scanner;

public class Assignment2{


    public static void main(String[] args){
        double input[];
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers would you like to take the average of?");
        input = new double[sc.nextInt()];

        System.out.println("Enter a number then press enter and repeat");
        for(int i = 0; i < input.length; i++){
            if(sc.hasNextDouble()){
                    input[i] = sc.nextDouble();
            }
            else{
                System.out.println("Make sure that the input is rational numbers only, try again.");
                System.exit(0);
            }
            
        }
        sc.close();

        
        System.out.println("The average of the numbers you entered is: " + inputAverage(input));
        System.out.println("The greatest number that was submitted was: " + getGreatestNumber(input));
        System.out.println("The smallest number that was submitted was: " + getSmallestNumber(input));
    }

    public static double inputAverage(double input[]){
        double toReturn = 0;
        int total = 0;

        for(int i = 0; i < input.length; i++){
            total += input[i];
        }

        toReturn = ((total)/ input.length);
        return toReturn;
        
    }
    public static double getGreatestNumber(double input[]){
        double current = input[0];
        for(int i = 1; i < input.length; i++){
            if(current < input[i]){
                current = input[i];
            }
        }
        return current;
    }

    public static double getSmallestNumber(double input[]){
        double current = input[0];
        for(int i = 1; i < input.length; i++){
            if(current > input[i]){
                current = input[i];
            }
        }
        return current;
    }

    public static double getRational(String in){

        double output = 0.0;
        output = parseDouble(in);
        return 0;
    }
    
    public static double setRational(double in){
        double dem = 0;
        for(int i = 0; i < 10000; i += 10){
            if(in % i == 0){
                dem = i;
            }
        }
        return dem;
    }

} 

*/