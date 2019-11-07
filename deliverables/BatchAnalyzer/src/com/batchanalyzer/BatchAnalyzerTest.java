package com.batchanalyzer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class BatchAnalyzerTest
{	
	@Test
	public void testMissingFilename() throws Exception
	{
		// WasteMetric - test for missing filename in command
		String[] args = {};
		WasteMetric.main(args); 
		assertEquals("Missing filename not handled: ", "Missing filename.", Main.lastAlert);
		
		// IsInvalidBatch - test for missing filename in command
		IsInvalidBatch.main(args);  
		assertEquals("Missing filename not handled: ", "Missing filename.", Main.lastAlert);
		
		// OneSwapRecommendation - test for missing filename in command
		OneSwapRecommendation.main(args);
		assertEquals("Missing filename not handled: ", "Missing filename.", Main.lastAlert);
		
		// TwoSwapRecommendation - test for missing filename in command
		TwoSwapRecommendation.main(args);
		assertEquals("Missing filename not handled: ", "Missing filename.", Main.lastAlert);
	}
	
	@Test
	public void testInvalidFilename() throws Exception
	{
		// WasteMetric - test for invalid filename in command
		String[] args = {"batch-xx.json"};
		WasteMetric.main(args); 
		assertEquals("Invalid filename not handled: ", "File not found: batch-xx.json", Main.lastAlert);
		
		// IsInvalidBatch - test for invalid filename in command
		IsInvalidBatch.main(args);  
		assertEquals("Invalid filename not handled: ", "File not found: batch-xx.json", Main.lastAlert);
		
		// OneSwapRecommendation - test for invalid filename in command
		OneSwapRecommendation.main(args);
		assertEquals("Invalid filename not handled: ", "File not found: batch-xx.json", Main.lastAlert);
		
		// TwoSwapRecommendation - test for invalid filename in command
		TwoSwapRecommendation.main(args);
		assertEquals("Invalid filename not handled: ", "File not found: batch-xx.json", Main.lastAlert);
	}
	
	@Test
	public void testInvalidRank() throws Exception
	{
		// WasteMetric - test for invalid rank in batch
		String[] args = {"batch-14.json"};
		WasteMetric.main(args); 
		assertEquals("Invalid rank not handled: ", "Batch is invalid - unknown rank: 11", Main.lastAlert);
		
		// IsInvalidBatch - test for invalid rank in batch
		IsInvalidBatch.main(args);  
		assertEquals("Invalid rank not handled: ", "Batch is invalid - unknown rank: 11", Main.lastAlert);
		
		// OneSwapRecommendation - test for invalid rank in batch
		OneSwapRecommendation.main(args);
		assertEquals("Invalid rank not handled: ", "Batch is invalid - unknown rank: 11", Main.lastAlert);
		
		// TwoSwapRecommendation - test for invalid rank in batch
		TwoSwapRecommendation.main(args);
		assertEquals("Invalid rank not handled: ", "Batch is invalid - unknown rank: 11", Main.lastAlert);
	}
	
	@Test
	public void testInvalidSuit() throws Exception
	{
		// WasteMetric - test for invalid suit in batch
		String[] args = {"batch-15.json"};
		WasteMetric.main(args); 
		assertEquals("Invalid suit not handled: ", "Batch is invalid - unknown suit: T", Main.lastAlert);
		
		// IsInvalidBatch - test for invalid suit in batch
		IsInvalidBatch.main(args);  
		assertEquals("Invalid suit not handled: ", "Batch is invalid - unknown suit: T", Main.lastAlert);
		
		// OneSwapRecommendation - test for invalid suit in batch
		OneSwapRecommendation.main(args);
		assertEquals("Invalid suit not handled: ", "Batch is invalid - unknown suit: T", Main.lastAlert);
		
		// TwoSwapRecommendation - test for invalid suit in batch
		TwoSwapRecommendation.main(args);
		assertEquals("Invalid suit not handled: ", "Batch is invalid - unknown suit: T", Main.lastAlert);
	}
	
	@Test
	public void testDuplicateEntry() throws Exception
	{
		// WasteMetric - test for duplicate entries in batch
		String[] args = {"batch-17.json"};
		WasteMetric.main(args); 
		assertEquals("Duplicate entries not handled: ", "Batch is invalid - duplicate entry: 4H", Main.lastAlert);
		
		// IsInvalidBatch - test for duplicate entries in batch
		IsInvalidBatch.main(args);  
		assertEquals("Duplicate entries not handled: ", "Batch is invalid - duplicate entry: 4H", Main.lastAlert);
		
		// OneSwapRecommendation - test for duplicate entries in batch
		OneSwapRecommendation.main(args);
		assertEquals("Duplicate entries not handled: ", "Batch is invalid - duplicate entry: 4H", Main.lastAlert);
		
		// TwoSwapRecommendation - test for duplicate entries in batch
		TwoSwapRecommendation.main(args);
		assertEquals("Duplicate entries not handled: ", "Batch is invalid - duplicate entry: 4H", Main.lastAlert);
	}
	
	@Test
	public void testTooManyEntries() throws Exception
	{
		// WasteMetric - test for too many entries in batch
		String[] args = {"batch-18.json"};
		WasteMetric.main(args); 
		assertEquals("Too many entries not handled: ", "Batch is invalid - expected 52 entries, but received 53", Main.lastAlert);
		
		// IsInvalidBatch - test for too many entries in batch
		IsInvalidBatch.main(args);  
		assertEquals("Too many entries not handled: ", "Batch is invalid - expected 52 entries, but received 53", Main.lastAlert);
		
		// OneSwapRecommendation - test for too many entries in batch
		OneSwapRecommendation.main(args);
		assertEquals("Too many entries not handled: ", "Batch is invalid - expected 52 entries, but received 53", Main.lastAlert);
		
		// TwoSwapRecommendation - test for too many entries in batch
		TwoSwapRecommendation.main(args);
		assertEquals("Too many entries not handled: ", "Batch is invalid - expected 52 entries, but received 53", Main.lastAlert);
	}
	
	@Test
	public void testTooFewEntries() throws Exception
	{
		// WasteMetric - test for too few entries in batch
		String[] args = {"batch-19.json"};
		WasteMetric.main(args); 
		assertEquals("Too few entries not handled: ", "Batch is invalid - expected 52 entries, but received 51", Main.lastAlert);
		
		// IsInvalidBatch - test for too few entries in batch
		IsInvalidBatch.main(args);  
		assertEquals("Too few entries not handled: ", "Batch is invalid - expected 52 entries, but received 51", Main.lastAlert);
		
		// OneSwapRecommendation - test for too few entries in batch
		OneSwapRecommendation.main(args);
		assertEquals("Too few entries not handled: ", "Batch is invalid - expected 52 entries, but received 51", Main.lastAlert);
		
		// TwoSwapRecommendation - test for too few entries in batch
		TwoSwapRecommendation.main(args);
		assertEquals("Too few entries not handled: ", "Batch is invalid - expected 52 entries, but received 51", Main.lastAlert);
	}
	
	@Test
	public void testWasteMetric() throws Exception
	{
		// test WasteMetric for expected results
		String[] args = {"batch-00.json"};
		WasteMetric.main(args); 
		assertEquals("Unexpected results for WasteMetric: ", "Waste Metric: 335", Main.lastAlert);
	}
	
	@Test
	public void testIsInvalidBatch() throws Exception
	{
		// test IsInvalidBatch for expected results
		String[] args = {"batch-00.json"};
		IsInvalidBatch.main(args); 
		assertEquals("Unexpected results for IsInvalidBatch: ", "Batch is valid.", Main.lastAlert);
		
		args[0] = "batch-14.json";
		IsInvalidBatch.main(args); 
		assertEquals("Unexpected results for IsInvalidBatch: ", "Batch is invalid - unknown rank: 11", Main.lastAlert);
	}
	
	@Test
	public void testOneSwapRecommendation() throws Exception
	{
		// test OneSwapRecommendation for expected results
		String[] args = {"batch-00.json"};
		OneSwapRecommendation.main(args); 
		assertEquals("Unexpected results for OneSwapRecommendation: ", "By swapping QS and 2H, you could reduce the waste metric from 335 to 311.", Main.lastAlert);
	}
	
	@Test
	public void testTwoSwapRecommendation() throws Exception
	{
		// test TwoSwapRecommendation for expected results
		String[] args = {"batch-00.json"};
		TwoSwapRecommendation.main(args); 
		assertEquals("Unexpected results for TwoSwapRecommendation: ", "By swapping QS and 2H, then swapping AS and 8H, you could reduce the waste metric from 335 to 290.", Main.lastAlert);
	}
}