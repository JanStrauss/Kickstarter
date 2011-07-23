package me.simplex.pluginkickstarter.util;

public enum PriorityType {
	Lowest, 
	Low, 
	Normal, 
	High, 
	Highest, 
	Monitor;

	public PriorityType[] giveTypeAsArray() {
		PriorityType[] ret = new PriorityType[6];
		ret[0] = Lowest;
		ret[1] = Low;
		ret[2] = Normal;
		ret[3] = High;
		ret[4] = Highest;
		ret[5] = Monitor;
		return ret;
	}
}
