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
public class SecantMethod {
	private final double RELATIVE_ERROR = 0.00001;
	private double 	x3,
					f3,
					f1,
					f2,
					errorCalculate;
	private int noOfIteration = 0;
	public double calculateFunctionalValue(double x){
		
		double functionalValue =x*Math.sin(x)-1;
		return functionalValue;
		
	}
	
	public double calculateRoot(double x1,double x2){
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("* Solution By Secant Method		          *");
                System.out.println("* Non Linear Eq is: f(x) = x.sin(x) - 1       *");
		System.out.println("* @Compiled By: Bhuwan Prasad Upadhyay        *");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|   It. No.  |     x1      |      x2       |      f(x1)    |      f(x2)    |      x3      |     f(x3)    |Relative Error|");
		System.out.println("|------------|-------------|---------------|---------------|---------------|--------------|--------------|--------------|");
		for(;;){
			++noOfIteration;
		double XiTH = x3;
		f1 = ((int)(calculateFunctionalValue(x1)*10000+0.5))/10000.0;
		f2 = ((int)(calculateFunctionalValue(x2)*10000+0.5))/10000.0;
		x3 = ((int)((((x1*f2)-(x2*f1))/(f2-f1))*10000+0.5))/10000.0;
		f3 = ((int)(calculateFunctionalValue(x3)*10000+0.5))/10000.0;
		double Xiplus1TH = x3;
		if(noOfIteration == 1){
			System.out.printf("\t%d\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f",noOfIteration,x1,x2,f1,f2,x3,f3);
			System.out.printf("\t\t%c%c%c\n",'.','.','.');
			 x2 = x1;
			 x1 = x3;
			 continue;
		}
		else{
			errorCalculate = Math.abs((Xiplus1TH - XiTH)/Xiplus1TH)*100;
			displayTable(x1,x2);
		if(errorCalculate>RELATIVE_ERROR){
			
			 x2 = x1;
			 x1 = x3;
			continue;	
		}
		else{
			break;
		}
		}
		}
		return x3;
	}
	
	public void displayTable(double x1,double x2){
		System.out.printf("\t%d\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%f\n",noOfIteration,x1,x2,f1,f2,x3,f3,errorCalculate);
		}
}