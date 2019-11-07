package com.batchanalyzer;

/**
 *
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class EntrySwap
{
	private Entry				swapEntry1;
	
	private Entry				swapEntry2;
	
	private int					swapValue;
	
	private int					wasteMetricValue;
	
	/**
	 * Create EntrySwap object that represents two batch entries 
	 * that could be swapped to reduce waste metric.
	 * 
	 * @param String swapEntry1 The first Entry object to be swapped.
	 * @param String swapEntry2 The second Entry object to be swapped.
	 * @param int swapValue The reduction in waste metric provided by the swap.
	 * @param int wasteMetric The total waste metric.
	 */
	public EntrySwap(Entry swapEntry1, Entry swapEntry2, int swapValue, int wasteMetric)
	{
		setSwapEntry1(swapEntry1);
		setSwapEntry2(swapEntry2);
		setSwapValue(swapValue);
		setWasteMetricValue(wasteMetric);
	}
	
	/**
	 * Get the first swap entry.
	 * 
	 * @return The swap entry value.
	 */
	public Entry getSwapEntry1()
	{
		return swapEntry1;
	}

	/**
	 * Set the first swap entry.
	 * 
	 * @param Entry The swap entry.
	 */
	public void setSwapEntry1(Entry swapEntry)
	{
		if (swapEntry != null)
		{
			this.swapEntry1 = swapEntry;
		}
	}
	
	/**
	 * Get the second swap entry.
	 * 
	 * @return The swap entry.
	 */
	public Entry getSwapEntry2()
	{
		return swapEntry2;
	}

	/**
	 * Set the second swap entry.
	 * 
	 * @param Entry The swap entry.
	 */
	public void setSwapEntry2(Entry swapEntry)
	{
		if (swapEntry != null)
		{
			this.swapEntry2 = swapEntry;
		}
	}
		
	/**
	 * Get the value of the swap.
	 * 
	 * @return The swap value.
	 */
	public int getSwapValue()
	{
		return swapValue;
	}

	/**
	 * Set the swap value.
	 * 
	 * @param int The swap value.
	 */
	public void setSwapValue(int swapValue)
	{
		this.swapValue = swapValue;
	}
	
	/**
	 * Get the value of the waste metric.
	 * 
	 * @return The waste metric value.
	 */
	public int getWasteMetricValue()
	{
		return wasteMetricValue;
	}

	/**
	 * Set the waste metric value.
	 * 
	 * @param int The waste metric value.
	 */
	public void setWasteMetricValue(int wasteMetric)
	{
		this.wasteMetricValue = wasteMetric;
	}
}