package com.batchanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class Main
{
	public static int numEntries = 52;
	public static String lastAlert = "";
	
	public static void main (String[] args) 
	{
		if (args.length > 1) 
        { 
			// first argument is name of the batch file containing sample data
			// second argument is name of the capability to execute
			switch (args[1]) 
			{
				case "WasteMetric":
					WasteMetric.main(args);
					break;
		        case "IsInvalidBatch":
		        	IsInvalidBatch.main(args);
					break;
		        case "OneSwapRecommendation":
		        	OneSwapRecommendation.main(args);
					break;
		        case "TwoSwapRecommendation":
		        	TwoSwapRecommendation.main(args);
					break;
			}
        } 
		else
        {
			// filename was not provided
			String alert = "Missing filename.";
			lastAlert = alert;
            System.out.println(alert);            
		}
	}
	
	public static int getRankValue(String rank)
	{
		// convert rank string to an integer value
		int rankValue = 0;
				
		if (rank.equals("J") || rank.equals("Q") || rank.equals("K"))
		{
			// face cards have rank of 10
			rankValue = 10;
		}
		else if (rank.equals("A"))
		{
			// ace has rank of 1
			rankValue = 1;
		}
		else if (rank.equals("2") || rank.equals("3") || rank.equals("4") || 
				 rank.equals("5") || rank.equals("6") || rank.equals("7") || 
				 rank.equals("8") || rank.equals("9") || rank.equals("10"))
		{
			// all others have rank of face value
			rankValue = Integer.valueOf(rank);
		}

		return rankValue;
	}
	
	public static Entry getEntry(String entry)
	{
		// create Entry object from entry string
		Entry batchEntry = new Entry(entry.substring(0, entry.length() - 1), entry.substring(entry.length() - 1));
		return batchEntry;
	}
	
	public static List<Entry> createEntries(String filename)
	{
		List<Entry> batchEntries = new ArrayList<Entry>();
		
		// determine if batch entries are valid and generate list of Entry objects
		try {
			// get the batch from the sample data file
			String path = "src/com/batchanalyzer/resources/" + filename;
			String strBatch = new String(Files.readAllBytes(Paths.get(path)));
			JSONArray batch = new JSONArray(strBatch);
			boolean valid = true;
			
			// check if count of entries matches expected number
			if (batch.length() != numEntries) 
			{
				valid = false;
				String alert = "Batch is invalid - expected " + String.valueOf(numEntries) + " entries, but received " + String.valueOf(batch.length());
				lastAlert = alert;
				System.out.println(alert);
			}
			else
			{
				// loop through entries in batch and create Entry objects
				for (int i = 0; i < batch.length(); i++)
				{
					Entry entry = getEntry(batch.getString(i));
					
					// check for duplicate entries
					if (isDuplicate(entry, batchEntries))
					{
						String alert = "Batch is invalid - duplicate entry: " + entry.getRank() + entry.getSuit();
						lastAlert = alert;
						System.out.println(alert);					
						valid = false;
						break;
					}
					
					// check that rank is valid
					if (getRankValue(entry.getRank()) == 0)
					{
						String alert = "Batch is invalid - unknown rank: " + entry.getRank();
						lastAlert = alert;
						System.out.println(alert);
						valid = false;
						break;
					}
					
					// check that suit is valid
					if (!entry.getSuit().equals("C") && !entry.getSuit().equals("D") && !entry.getSuit().equals("H") && !entry.getSuit().equals("S"))
					{
						String alert = "Batch is invalid - unknown suit: " + entry.getSuit();
						lastAlert = alert;
						System.out.println(alert);
						valid = false;
						break;
					} 
					
					batchEntries.add(entry);					
				}
			}
				
			if (!valid)
			{
				batchEntries = null;
			}	
		} 
		catch (IOException e) 
		{
			// invalid filename entered on command line
			String alert = "File not found: " + filename;
			lastAlert = alert;
			System.out.println(alert);
			batchEntries = null;
		}
		
		return batchEntries;
	}
	
	public static boolean isDuplicate(Entry entry, List<Entry> batchEntries)
	{
		// returns boolean indicating if the Entry already exists in the batch
		boolean isDuplicate = false;
		
		for (int i = 0; i < batchEntries.size(); i++)
		{
			if (entry.getRank().equals(batchEntries.get(i).getRank()) && 
					entry.getSuit().equals(batchEntries.get(i).getSuit()))
			{
				isDuplicate = true;
				break;
			}
		}
		return isDuplicate;
	}
	
	public static String getLastErrorMessage()
	{
		// returns the last error message generated - used for testing
		return lastAlert;
	}
}