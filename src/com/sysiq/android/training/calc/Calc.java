package com.sysiq.android.training.calc;

public class Calc {

	double res;
	double firstNumber = 0;
	boolean haveFirstNumber = false;

	public double sum(double num, boolean flag) {
		if (!haveFirstNumber && !flag){
			haveFirstNumber=true;
			firstNumber=num;
			return res=firstNumber;
		} else if (haveFirstNumber && flag)
			return res;
		else {
			firstNumber = num;
			res = res + firstNumber;			
			return res;
		}
	}

	public String divide(double num, boolean flag) {
		if (!haveFirstNumber && !flag){
			haveFirstNumber=true;
			firstNumber=num;
			return String.valueOf(res=firstNumber);
		} else if (haveFirstNumber && flag)
			return String.valueOf(res);
		else {
			if (num==0)
				return "Can not divide on zero!!";
			firstNumber = num;
			res = res / firstNumber;			
			return String.valueOf(res);
		}
	}

	public double minus(double num, boolean flag) {
		if (!haveFirstNumber && !flag){
			haveFirstNumber=true;
			firstNumber=num;
			return res=firstNumber;
		} else if (haveFirstNumber && flag)
			return res;
		else {
			firstNumber = num;
			res = res - firstNumber;			
			return res;
		}
	}
	
	public double multiply(double num, boolean flag) {
		if (!haveFirstNumber && !flag){
			haveFirstNumber=true;
			firstNumber=num;
			return res=firstNumber;
		} else if (haveFirstNumber && flag)
			return res;
		else {
			firstNumber = num;
			res = res * firstNumber;			
			return res;
		}
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}

	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public void clear() {
		firstNumber = 0;
		res = 0;
		haveFirstNumber = false;		
	}
}
