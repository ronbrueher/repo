package com.batchanalyzer;

import java.util.List;

/**
 *
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class IsInvalidBatch
{
	public static void main (String[] args) 
	{
		// determine if entries in batch are valid
		if (args.length > 0) 
        {
			// first argument is name of file that contains batch data
			boolean isInvalid = isInvalidBatch(args[0]);
			if (!isInvalid)
			{
				// valid batch
				String alert = "Batch is valid.";
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
	
	public static boolean isInvalidBatch (String filename) 
	{
		boolean isInvalid = true;
		
		// create list of batch entries
		List<Entry>	batchEntries = Main.createEntries(filename);
		
		// list of entries will be null or empty if not valid
		if (batchEntries != null && batchEntries.size() > 0)
		{
			isInvalid = false;			
		}
		return isInvalid;
	}
}