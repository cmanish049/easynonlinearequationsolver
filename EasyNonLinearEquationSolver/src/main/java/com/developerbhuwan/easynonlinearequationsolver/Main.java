/*
 * Date : 2013-06-14
 * Author : Bhuwan Prasad Upadhyay
 * Website : http://www.developerbhuwan.com
 */
package com.developerbhuwan.easynonlinearequationsolver;

/**
 *
 * @author Bhuwan Pd. Upadhyay
 */
import java.util.Scanner;

public class Main {

    private static Scanner input;
    private static Scanner input2;
    private static Scanner input3;
    private static Scanner input4;
    private static Scanner input5;

    public static void main(String[] args) {

        input4 = new Scanner(System.in);
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("                                               ");
        System.out.println("                                               ");
        System.out.println("                 ##### @@@@                    ");
        System.out.println("                 #     @                       ");
        System.out.println("                 ###   @@@@                    ");
        System.out.println("                 #        @                    ");
        System.out.println("                 ##### @@@@                    ");
        System.out.println("                                               ");
        System.out.println("*       Easy Non Linear Equation Solver	   ");
        System.out.println("*     Developer By: Bhuwan Prasad Upadhyay     ");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println();
        System.out.println("..........................................................");
        System.out.println("Select your choice to find root of nonlinear equations.");
        System.out.println("\t1. Bisection Method");
        System.out.println("\t2. False Position Method");
        System.out.println("\t3. Secant Method");
        System.out.println("\t4. Newton Raphson Method");
        System.out.println("\t5. Exit");
        System.out.println("..........................................................");
        System.out.printf("%s", "choice=");
        int choice = input4.nextInt();
        System.out.println("..........................................................");
        switch (choice) {
            case 1:
                System.out.println("gdeans$bhuwan.com:# Loading Bisection Kernel");
                callBisection();
                break;
            case 2:
                System.out.println("gdeans$bhuwan.com:# Loading FalsePosition Kernel");
                callFalsePostion();
                break;
            case 3:
                System.out.println("gdeans$bhuwan.com:# Loading Secant Kernel");
                callSecant();
                break;
            case 4:
                System.out.println("gdeans$bhuwan.com:# Loading NewtonRaphson Kernel");
                callNewton();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("..........................................................");
                System.out.println("Your selection was wrong.");
                System.out.println("..........................................................");
        }
    }

    public static void callBisection() {

        BisectionMethod bisect = new BisectionMethod();
        input2 = new Scanner(System.in);
        System.out.println("....................................................");
        System.out.println("Enter the two initial values:");
        System.out.printf("%s", "value1=");
        double a = input2.nextDouble();
        System.out.printf("\n%s", "value2=");
        double b = input2.nextDouble();
        System.out.println("....................................................");
        if (bisect.calculateFunctionalValue(a) * bisect.calculateFunctionalValue(b) > 0) {
            System.out.println("....................................................");
            System.out.println("Sorry,Your initial values does not bracket any root.");
            System.out.println("....................................................");
        } else if (bisect.calculateFunctionalValue(a) > 0) {
            bisect.calculateRoot(a, b);
        } else if (bisect.calculateFunctionalValue(b) > 0) {
            bisect.calculateRoot(b, a);
        }
    }

    private static void callFalsePostion() {
        FalsePositionMethod falsee = new FalsePositionMethod();
        input = new Scanner(System.in);
        System.out.println("....................................................");
        System.out.println("Enter the two initial values:");
        System.out.printf("%s", "value1=");
        double a = input.nextDouble();
        System.out.printf("\n%s", "value2=");
        double b = input.nextDouble();
        System.out.println("....................................................");
        if (falsee.calculateFunctionalValue(a) * falsee.calculateFunctionalValue(b) > 0) {
            System.out.println("....................................................");
            System.out.println("Sorry,Your initial values does not bracket any root.");
            System.out.println("....................................................");
        } else if (falsee.calculateFunctionalValue(a) > 0) {
            falsee.calculateRoot(a, b);
        } else if (falsee.calculateFunctionalValue(b) > 0) {
            falsee.calculateRoot(b, a);
        }

    }

    private static void callSecant() {
        SecantMethod secant = new SecantMethod();
        input5 = new Scanner(System.in);
        System.out.println("....................................................");
        System.out.println("Enter the two initial values:");
        System.out.printf("%s", "value1=");
        double a = input5.nextDouble();
        System.out.printf("\n%s", "value2=");
        double b = input5.nextDouble();
        System.out.println("....................................................");
        if (Math.abs(secant.calculateFunctionalValue(a)) >= Math.abs(secant.calculateFunctionalValue(b))) {
            secant.calculateRoot(a, b);
        } else {
            secant.calculateRoot(b, a);
        }

    }

    private static void callNewton() {
        NewtonRaphsonMethod newton = new NewtonRaphsonMethod();
        input3 = new Scanner(System.in);
        System.out.println("....................................................");
        System.out.println("Enter the initial value.");
        System.out.printf("%s", "value1=");
        double a = input3.nextDouble();
        System.out.println("....................................................");
        newton.calculateRoot(a);

    }
}
