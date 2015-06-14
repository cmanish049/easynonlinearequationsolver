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
public class FalsePositionMethod {
	private final double RELATIVE_ERROR = 0.00001;
	private double 	x0,
					f0,
					f1,
					f2,
					errorCalculate;
	private int noOfIteration = 0;
	public double calculateFunctionalValue(double x){
		
		double functionalValue = Math.sin(x)-x+2;
		return functionalValue;
		
	}
	
	public double calculateRoot(double x1,double x2){
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("* Solution By False Position Method		          *");
                System.out.println("* Non Linear Eq is: f(x) = sin(x) - x +2      *");
		System.out.println("* @Compiled By: Bhuwan Prasad Upadhyay        *");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|   It. No.  |     x1      |      x2       |      f(x1)    |      f(x2)    |      x0      |     f(x0)    |Relative Error|");
		System.out.println("|------------|-------------|---------------|---------------|---------------|--------------|--------------|--------------|");
		for(;;){
			++noOfIteration;
		double XiTH = x0;
		f1 = ((int)(calculateFunctionalValue(x1)*10000+0.5))/10000.0;
		f2 = ((int)(calculateFunctionalValue(x2)*10000+0.5))/10000.0;
		x0 = ((int)((((x1*f2)-(x2*f1))/(f2-f1))*10000+0.5))/10000.0;
		f0 = ((int)(calculateFunctionalValue(x0)*10000+0.5))/10000.0;
		double Xiplus1TH = x0;
		if(noOfIteration == 1){
			System.out.printf("\t%d\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f",noOfIteration,x1,x2,f1,f2,x0,f0);
			System.out.printf("\t\t%c%c%c\n",'.','.','.');
			if(f0 > 0)
				 x1 = x0;
			else
				 x2 = x0;
				 continue;
		}
		else{
			errorCalculate = Math.abs((Xiplus1TH - XiTH)/Xiplus1TH)*100;
			displayTable(x1,x2);
		if(errorCalculate>RELATIVE_ERROR){
			if(f0 > 0)
			 x1 = x0;
			else
			 x2 = x0;
			continue;	
		}
		else{
			break;
		}
		}
		}
		return x0;
	}
	
	public void displayTable(double x1,double x2){
		System.out.printf("\t%d\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%f\n",noOfIteration,x1,x2,f1,f2,x0,f0,errorCalculate);
		}
}
