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
public class NewtonRaphsonMethod {

    private final double RELATIVE_ERROR = 0.00001;
    private double x2,
            fx1,
            dfx1,
            errorCalculate;
    private int noOfIteration = 0;

    public double calculateFunctionalValue(double x) {

        double functionalValue = x + 2 - Math.exp(x);
        return functionalValue;

    }

    public double calculateDerivativeFunctionalValue(double x) {

        double derivativefunctionalValue = 1 - Math.exp(x);
        return derivativefunctionalValue;

    }

    /**
     * @param x1
     * @return
     */
    public double calculateRoot(double x1) {

        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("* Solution By Newton Rapson's Method		          *");
        System.out.println("* Non Linear Eq is: f(x) = 1 - e^(x)          *");
        System.out.println("* @Compiled By: Bhuwan Prasad Upadhyay        *");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|   It. No.  |     x1      |      f(x1)    |      f'(x1)   |      x2       |Relative Error|");
        System.out.println("|------------|-------------|---------------|---------------|---------------|--------------|");
        for (;;) {
            ++noOfIteration;
            double XiTH = x2;
            fx1 = ((int) (calculateFunctionalValue(x1) * 10000 + 0.5)) / 10000.0;
            dfx1 = ((int) (calculateDerivativeFunctionalValue(x1) * 10000 + 0.5)) / 10000.0;
            x2 = ((int) ((x1 - (fx1 / dfx1)) * 10000 + 0.5)) / 10000.0;
            double Xiplus1TH = x2;
            if (noOfIteration == 1) {
                System.out.printf("\t%d\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f", noOfIteration, x1, fx1, dfx1, x2);
                System.out.printf("\t\t%c%c%c\n", '.', '.', '.');
                if (dfx1 != 0) {
                    x1 = x2;
                    continue;
                } else {
                    System.out.println("Sorry,Your initial guess doesn't bracket any root with accuracy 0.0001.");
                    System.out.println("***error: f'(x1)=0; which is impossible for Newton Raphson Method.****");
                    break;
                }
            } else {
                errorCalculate = Math.abs((Xiplus1TH - XiTH) / Xiplus1TH) * 100;
                displayTable(x1, x2);
                if (errorCalculate > RELATIVE_ERROR) {
                    if (dfx1 != 0) {
                        x1 = x2;
                        continue;
                    } else {
                        System.out.println("Sorry,Your initial guess doesn't bracket any root with accuracy 0.0001.");
                        System.out.println("***error: f'(x1)=0; which is impossible for Newton Raphson Method.****");
                        break;
                    }

                } else {
                    break;
                }
            }
        }
        return x2;
    }

    public void displayTable(double x1, double x2) {
        System.out.printf("\t%d\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%f\n", noOfIteration, x1, fx1, dfx1, x2, errorCalculate);
    }
}
