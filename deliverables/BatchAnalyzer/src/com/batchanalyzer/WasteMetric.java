package com.batchanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class WasteMetric
{
	private static int wasteMetric = 0;
	
	public static void main (String[] args) 
	{
		// determine the waste metric for a batch of entries
		if (args.length > 0) 
        {
			// calculate swap values for entries and generate waste metric
			List<EntrySwap> entrySwaps = getWasteMetric(args[0]);
			
			if (entrySwaps != null && entrySwaps.size() > 0)
			{
				// output total waste metric
				String alert = "Waste Metric: " + String.valueOf(wasteMetric);
				Main.lastAlert = alert;
	            System.out.println(alert);
			}
        }
		else
        {
			// filename not provided
			String alert = "Missing filename.";
			Main.lastAlert = alert;
            System.out.println(alert);
		}
	}
	
	public static List<EntrySwap> getWasteMetric (String filename) 
	{
		// calculate the waste metric using data in filename
		wasteMetric = 0;
		int rankValue1 = 0;
		int rankValue2 = 0;
		int rankDifference = 0;
		int maxDifference = 0;
		EntrySwap entrySwap1 = null;
		List<EntrySwap> swapEntries = new ArrayList<EntrySwap>();		
		List<Entry>	batchEntries = Main.createEntries(filename);

		// list of entries will be null or empty if not valid
		if (batchEntries != null && batchEntries.size() > 0)
		{			
			for (int i = 0; i < batchEntries.size() - 1; i++)
			{
				if (batchEntries.get(i).getSuit().equals(batchEntries.get(i + 1).getSuit()))
				{
					// same suit, add difference of the ranks to wasteMetric
					rankValue1 = Main.getRankValue(batchEntries.get(i).getRank());
					rankValue2 = Main.getRankValue(batchEntries.get(i + 1).getRank());
					rankDifference = java.lang.Math.abs(rankValue1 - rankValue2);
					wasteMetric += rankDifference;					
				}
				else if (batchEntries.get(i).getColor().equals(batchEntries.get(i + 1).getColor()))
				{
					// same color, add 2x difference of the ranks to wasteMetric
					rankValue1 = Main.getRankValue(batchEntries.get(i).getRank());
					rankValue2 = Main.getRankValue(batchEntries.get(i + 1).getRank());
					rankDifference = java.lang.Math.abs((rankValue1 - rankValue2) * 2);							
					wasteMetric += rankDifference;
				}
				else if (!batchEntries.get(i).getColor().equals(batchEntries.get(i + 1).getColor()))
				{
					// if entries have different color, add 3x difference of the ranks to wasteMetric
					rankValue1 = Main.getRankValue(batchEntries.get(i).getRank());
					rankValue2 = Main.getRankValue(batchEntries.get(i + 1).getRank());
					rankDifference = java.lang.Math.abs((rankValue1 - rankValue2) * 3);							
					wasteMetric += rankDifference;
				}
				
				// check for maximum waste reduction
				if (rankDifference > maxDifference)
				{						
					// this pair of entries produces greater reduction, add to top of list
					entrySwap1 = new EntrySwap(batchEntries.get(i), batchEntries.get(i + 1), rankDifference, 0);
					maxDifference = rankDifference;
					swapEntries.add(0, entrySwap1);
				}
			}	
			
			// update the total wasteMetric in the swap entries
			swapEntries.get(0).setWasteMetricValue(wasteMetric);
			swapEntries.get(1).setWasteMetricValue(wasteMetric);			
        } 
		return swapEntries;
	}
}