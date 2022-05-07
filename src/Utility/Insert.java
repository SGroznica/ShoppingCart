package Utility;

import java.math.BigDecimal;
import java.util.Scanner;

public class Insert {





    public static int inputInt(Scanner input, String messege) {
        int i=0;
        while(true) {
            System.out.print(messege + ": ");
            try {
                i = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input has to be number");
                continue;
            }

            if(i<1) {
                System.out.println("Number can't be negative");
                continue;
            }
            return i;
        }
    }

    public static int inputInt( Scanner input, String messege, int min, int max) {
        int i=0;
        while(true) {
            System.out.print(messege + ": ");
            try {
                i = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input has to be a number");
                continue;
            }

            if(i<min || i>max) {
                System.out.println("Number has to be between " + min + " and " + max);
                continue;
            }
            return i;
        }
    }

    public static BigDecimal inputBigDecimal(Scanner input, String messege) {
        BigDecimal i=BigDecimal.ZERO;
        while(true) {
            System.out.print(messege + ": ");
            try {
                i = new BigDecimal(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input has to be a number");
                continue;
            }

            if(i.compareTo(BigDecimal.ONE) < 0) {
                System.out.println("Number has to be positive");
                continue;
            }
            return i;
        }
    }


    public static String inputString(Scanner input, String messege) {
        String s="";
        while(true) {
            System.out.print(messege + ": ");
            s = input.nextLine();
            if(s.length()==0) {
                System.out.println( "Input is required");
                continue;
            }
            return s;
        }
    }

}
