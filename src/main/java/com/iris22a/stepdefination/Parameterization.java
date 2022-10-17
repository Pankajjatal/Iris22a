package com.iris22a.stepdefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {
	int x, y, r = 0;
	float f, g;
	String fruiteName;

	@Given("I have two numbers {int} and {int}")
	public void acceptTwoNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@When(" I add them")
	public void addNumbers() {
		this.r = x + y;
	}

	@Then("Print the result")
	public void displayResult() {
		System.out.println("Result : " + r);
	}

	@Given("I have two numbers {float} and {float}")
	public void vacceptTwoFloats(float x, float y) {
		f = x;
		g = y;
	}

	@Then("Display numbers")
	public void display() {
		System.out.println(f + "\t" + g);
	}

	@Given("I have a fruite {string}")
	public void acceptFruite(String fruite) {
		fruiteName = fruite;
	}

	@Then("Display it's color {string")
	public void displayColor(String color) {
		System.out.println(fruiteName + " is " + color);
	}

	/*
	 * @Given("I have following <states>") public void acceptCities(List<String>
	 * states) { System.out.println("===============STATES=============="); for
	 * (String state : states) { System.out.println(state); }
	 */
	/*
	 * @Given("I have following <states>") public void
	 * acceptCities(Map<String,List<String>>states) {
	 * System.out.println("===============STATES=============="); Set<Entry<String,
	 * List<String>>>keys=states.entrySet(); for (Entry key : keys) {
	 * System.out.println(key.getKey()+"/t"+key.getValue()); }
	 */

	@Given("I have following <states>")
	public void acceptCities(DataTable states) {
		System.out.println("===============STATES==============");
		Map<String, List> statDetails = states.asMap(String.class, List.class);

		Set<Map.Entry<String, List>> entries = statDetails.entrySet();
		for (Entry<String, List> entry : entries) {
			List<String> data = entry.getValue();
			System.out.println(entry.getKey() + "\t" + data.get(0) + "\t" + data.get(1));
		}
	}

	@Given("I have {int} and {int}")
	public void acceptNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Then("print if their addition is prime")
	public void isPrime() {
		System.out.println("Checking: " + r);
		int count = 0;
		for (int i = 0; i < r; i++) {
			if (r % i == 0) {
				count++;
			}
			if (count > 2) {
				break;
			}
		}
		if (count <= 2) {
			System.out.println("Number " + r + "is prime");
		} else {
			System.out.println("Number " + r + "is NOT prime");
		}
	}

	@Given("I have {int}")
	public void getRowNumber(int rowNum) {
		FileInputStream fis=null;
		try {
			 fis = new FileInputStream("\"C:\\Users\\Pankaj Jatal\\Documents\\Numbers.xlsx\"");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=book.getSheetAt(0);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(1);
		x=(int) cell.getNumericCellValue();
		cell=row.getCell(2);
		y=(int)cell.getNumericCellValue();
		
	}
}
