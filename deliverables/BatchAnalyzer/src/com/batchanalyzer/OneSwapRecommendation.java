package com.batchanalyzer;

import java.util.List;

/**
 *
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class OneSwapRecommendation
{
	public static void main (String[] args) 
	{
		// determine which two entries, that if swapped, would generate greatest reduction in waste metric
		if (args.length > 0) 
        {
			// get list of EntrySwap objects containing swap values and total waste metric
			List<EntrySwap> entrySwaps = WasteMetric.getWasteMetric(args[0]);
			
			// list of entries will be null or empty if not valid
			if (entrySwaps != null && entrySwaps.size() > 0)
			{			
				// calculate reduction in waste metric
				EntrySwap entrySwap1 = entrySwaps.get(0);
				int reduction = entrySwap1.getWasteMetricValue() - entrySwap1.getSwapValue(); 
				
				// output swap objects that have the highest swap value
				String alert = "By swapping " + entrySwap1.getSwapEntry1().getRank() + entrySwap1.getSwapEntry1().getSuit() +
						" and " + entrySwap1.getSwapEntry2().getRank() + entrySwap1.getSwapEntry2().getSuit() +
						", you could reduce the waste metric from " + String.valueOf(entrySwap1.getWasteMetricValue()) + " to " + String.valueOf(reduction) + ".";
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
}