import java.util.Scanner;

public class Rational{
    public static void main(String[] agrs) {
        int numerator[];
        int denominator[];

        Scanner sc = new Scanner(System.in);
        System.out.println("How many inputs would you like to enter?");
        int length = sc.nextInt();
        sc.nextLine();

        numerator = new int[length];
        denominator = new int[length];
        System.out.println("Enter rational number in the format (numerator/denominator):\nThen press enter to type a new number.");
        for (int i = 0; i < length; i++) {

            String current = sc.nextLine();
            String[] currentNums = current.split("/");

            if (currentNums.length != 2) {
                System.out.println("Invalid input format. Please use the format (numerator/denominator).");
                i--;
                continue;
            }
            try {
                numerator[i] = Integer.parseInt(currentNums[0]);
                denominator[i] = Integer.parseInt(currentNums[1]);
                System.out.println("Read: " + numerator[i] + "/" + denominator[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric input. Please enter valid integers for numerator and denominator.");
                i--;
            }
        }

        String average = getAverage(numerator, denominator, length);
        System.out.println("The average rational number is: " + average);

        String max = getMax(numerator, denominator, length);
        System.out.println("The max rational number is: " + max);

        String min = getMin(numerator, denominator, length);
        System.out.println("The min rational number is: " + min);

        sc.close();
    }

    public static String toString(int top, int bottom) {
        return top + "/" + bottom;
    }

    private static int greatestCommonDen(int top, int bottom) {
        if (top == 0)
            return bottom;
        return greatestCommonDen(bottom % top, top);
    }

    private static int lowestCommonDen(int top, int bottom) {
        return (top * bottom) / greatestCommonDen(top, bottom);
    }

    private static String getAverage(int[] numerator, int[] denominator, int count) {
        int commonDenominator = denominator[0] * count;
        for (int i = 1; i < denominator.length; i++) {
            commonDenominator = lowestCommonDen(commonDenominator, denominator[i] * count);
        }

        int totalSumNumerator = 0;
        for (int i = 0; i < numerator.length; i++) {
            totalSumNumerator += (numerator[i] * (commonDenominator / (denominator[i] * count)));
        }

        int greatestCommonDen = greatestCommonDen(totalSumNumerator, commonDenominator);
        return toString(totalSumNumerator / greatestCommonDen, commonDenominator / greatestCommonDen);
    }
    private static String getMax(int[] numerator, int[] denominator, int count){
        double max = 0.0; 
        int maxIndex = -1;
		for (int i = 0; i < numerator.length; i++) {
            double current = (double) numerator[i] / denominator[i];
    
            if (current > max) {
                max = current;
                maxIndex = i;
            }
        }  
        return toString(numerator[maxIndex], denominator[maxIndex]);  
    }
    private static String getMin(int[] numerator, int[] denominator, int count){
        double min = 1.0; 
        int minIndex = -1;
		for (int i = 0; i < numerator.length; i++) {
            double current = (double) numerator[i] / denominator[i];
    
            if (current < min) {
                min = current;
                minIndex = i;
            }
        }  
        return toString(numerator[minIndex], denominator[minIndex]);  
    }

    
}
