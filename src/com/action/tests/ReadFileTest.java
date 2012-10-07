package com.action.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.action.ReadFile;

public class ReadFileTest {
	
	private String mTestInputLocation = "C:/Users/Ben Tiggelaar/workspace/ProfitTranslaterTesting/src/test_small_input_tab_delimited.txt";

	@Test
	public void emptyConstructor() {
		ReadFile readFile = new ReadFile();
		assertNotNull(readFile);
	}
	
	@Test
	public void stringConstructor() {
		ReadFile readFile = new ReadFile(mTestInputLocation);
		assertNotNull(readFile);
		assertNotNull(readFile.getPaymentEbayFees());
		assertNotNull(readFile.getPaymentReceivedList());
		assertNotNull(readFile.getPaymentSentList());
		assertNotNull(readFile.getRefundList());
		
	}
	
	/**
	 * Checks the size of each payment list
	 */
	@Test
	public void genericListCounts() {
		ReadFile readFile = new ReadFile(mTestInputLocation);
		assertTrue(readFile.getPaymentEbayFees().size() == 0);
		assertTrue(readFile.getPaymentReceivedList().size() == 9);
		//System.out.println("size: " + readFile.getPaymentSentList().size());

		//TODO should be 4, but is 6...(item title is wrong)
		assertTrue(readFile.getPaymentSentList().size() == 4);
		assertTrue(readFile.getRefundList().size() == 2);
		assertTrue(readFile.getmLineNumber() > 1);
	}

	
	@Before
	public void setup() {
		
	}
	

}
