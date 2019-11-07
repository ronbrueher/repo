package com.batchanalyzer;

/**
 *
 * @author rbrueher
 * @since Nov 06, 2019
 */
public class Entry
{
	private String				rank;
	
	private String				suit;
	
	private String				color;
	
	/**
	 * Create Entry object that corresponds to a batch entry.
	 * 
	 * @param String rank The rank value.
	 * @param String suit The suit value.
	 */
	public Entry(String rank, String suit)
	{
		this.setRank(rank);
		this.setSuit(suit);
	}
	
	/**
	 * Get the rank of the entry.
	 * 
	 * @return The rank value.
	 */
	public String getRank()
	{
		return rank;
	}

	/**
	 * Set the rank.
	 * 
	 * @param String The rank value.
	 */
	public void setRank(String rank)
	{
		if (rank != null)
		{
			this.rank = rank;
		}
	}
	
	/**
	 * Get the suit of the entry.
	 * 
	 * @return The suit value.
	 */
	public String getSuit()
	{
		return suit;
	}

	/**
	 * Set the suit.
	 * 
	 * @param String The suit value.
	 */
	public void setSuit(String suit)
	{
		if (suit != null)
		{
			this.suit = suit;
			
			if (suit.equals("C") || suit.equals("S")) 
			{
				setColor("Black");
			}
			else if (suit.equals("H") || suit.equals("D")) 
			{
				setColor("Red");
			}
		}
	}
	
	/**
	 * Get the color of the entry.
	 * 
	 * @return The color value.
	 */
	public String getColor()
	{
		return color;
	}
	
	/**
	 * Set the color.
	 * 
	 * @param String The color value.
	 */
	private void setColor(String color)
	{
		if (color != null)
		{
			this.color = color;
		}
	}
}