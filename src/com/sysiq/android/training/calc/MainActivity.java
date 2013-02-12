package com.sysiq.android.training.calc;

import org.apache.commons.lang3.StringUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	// Digits
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button dot;

	// Operations
	Button plus;
	Button minus;
	Button divide;
	Button multiply;
	Button result;
	Button clear;

	// text field
	TextView text;
	int curOperation = 0;// 1-plus, 2-minus, 3-multiply, 4-divide
	//
	boolean isOperationLastClick = false;
	private Calc calc = new Calc();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);
		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		divide = (Button) findViewById(R.id.divide);
		multiply = (Button) findViewById(R.id.multiply);
		clear = (Button) findViewById(R.id.clear);
		result = (Button) findViewById(R.id.result);
		text = (TextView) findViewById(R.id.text);
		dot = (Button) findViewById(R.id.dot);

		one.setOnClickListener((OnClickListener) this);
		two.setOnClickListener((OnClickListener) this);
		three.setOnClickListener((OnClickListener) this);
		four.setOnClickListener((OnClickListener) this);
		five.setOnClickListener((OnClickListener) this);
		six.setOnClickListener((OnClickListener) this);
		seven.setOnClickListener((OnClickListener) this);
		eight.setOnClickListener((OnClickListener) this);
		nine.setOnClickListener((OnClickListener) this);
		zero.setOnClickListener((OnClickListener) this);
		plus.setOnClickListener((OnClickListener) this);
		minus.setOnClickListener((OnClickListener) this);
		divide.setOnClickListener((OnClickListener) this);
		multiply.setOnClickListener((OnClickListener) this);
		result.setOnClickListener((OnClickListener) this);
		text.setOnClickListener((OnClickListener) this);
		clear.setOnClickListener((OnClickListener) this);
		dot.setOnClickListener((OnClickListener) this);
	}

	@Override
	public void onClick(View src) {
		if (isOperationLastClick && src.getId() != R.id.plus
				&& src.getId() != R.id.minus && src.getId() != R.id.divide
				&& src.getId() != R.id.multiply) {
			text.setText("");
			isOperationLastClick = false;
		}
		switch (src.getId()) {
		case R.id.one:
			text.append("1");
			break;
		case R.id.two:
			text.append("2");
			break;
		case R.id.three:
			text.append("3");
			break;
		case R.id.four:
			text.append("4");
			break;
		case R.id.five:
			text.append("5");
			break;
		case R.id.six:
			text.append("6");
			break;
		case R.id.seven:
			text.append("7");
			break;
		case R.id.eight:
			text.append("8");
			break;
		case R.id.nine:
			text.append("9");
			break;
		case R.id.zero:
			text.append("0");
			break;
		case R.id.dot:
			if (StringUtils.isBlank(text.getText()))
				text.append("0.");
			else if (!text.getText().toString().contains("."))
				;
			text.append(".");
			break;
		case R.id.plus:
			if (curOperation != 1 && curOperation != 0)
				doPreviousOperation(curOperation,
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick);
			else {
				text.setText(String.valueOf(calc.sum(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick)));
			}
			isOperationLastClick = true;
			curOperation = 1;
			break;
		case R.id.minus:
			if (curOperation != 2 && curOperation != 0)
				doPreviousOperation(curOperation,
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick);
			else {
				text.setText(String.valueOf(calc.minus(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick)));
			}
			isOperationLastClick = true;
			curOperation = 2;
			break;
		case R.id.multiply:
			if (curOperation != 3 && curOperation != 0)
				doPreviousOperation(curOperation,
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick);
			else {
				text.setText(String.valueOf(calc.multiply(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick)));
			}
			isOperationLastClick = true;
			curOperation = 3;
			break;
		case R.id.divide:
			if (curOperation != 4 && curOperation != 0)
				doPreviousOperation(curOperation,
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick);
			else {
				text.setText(calc.divide(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick));
			}
			isOperationLastClick = true;
			curOperation = 4;
			break;
		case R.id.clear:
			text.setText("");
			curOperation = 0;
			calc.clear();
			break;
		case R.id.result:
			switch (curOperation) {
			case 1:
				text.setText(String.valueOf(calc.sum(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick)));
				break;
			case 2:
				text.setText(String.valueOf(calc.minus(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick)));
				break;
			case 3:
				text.setText(String.valueOf(calc.multiply(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick)));
				break;
			case 4:
				text.setText(calc.divide(
						Double.parseDouble(String.valueOf(text.getText())),
						isOperationLastClick));
				break;
			}
		}
	}

	private void doPreviousOperation(int operation, double num, boolean flag) {
		switch (operation) {
		case 1:
			text.setText(String.valueOf(calc.sum(
					Double.parseDouble(String.valueOf(text.getText())),
					isOperationLastClick)));
			break;
		case 2:
			text.setText(String.valueOf(calc.minus(
					Double.parseDouble(String.valueOf(text.getText())),
					isOperationLastClick)));
			break;
		case 3:
			text.setText(String.valueOf(calc.multiply(
					Double.parseDouble(String.valueOf(text.getText())),
					isOperationLastClick)));
			break;
		case 4:
			text.setText(calc.divide(
					Double.parseDouble(String.valueOf(text.getText())),
					isOperationLastClick));
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
