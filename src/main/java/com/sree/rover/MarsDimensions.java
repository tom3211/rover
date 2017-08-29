package com.sree.rover;

public class MarsDimensions {
	private int maxX ;
	private int minX = 0 ;
	private int maxY ;
	private int minY = 0 ;
	
	public MarsDimensions(int maxX, int maxY) {
		this.maxX = maxX ;
		this.maxY = maxY ;
	}
	
	public boolean isValidLocation(RoverLocation loc) {
		if(loc.getX() >= minX && loc.getX() <= maxX && 
				loc.getY() >= minY && loc.getY() <= maxY )
			return true ;
		System.out.println(" invalid location " + loc.getX() + " y " + loc.getY() +
				" marsDimensions " + toString());
		return false ;
	}
	
	public String toString() {
		return "(" + minX  + "," + minY + ") " + "/ (" + maxX  + "," + maxY + ") ";
	}
}
