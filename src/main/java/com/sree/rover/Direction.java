package com.sree.rover;

public enum Direction {
	North("N",0),
	East("E",1),
	South("S",2),
	West("W",3);
	private int value ;
	private String code = null ;
	private Direction(String code, int value) {
		this.value = value ;
		this.code = code ;
	}
	
	public Direction turnLeft() {
		int newValue = (value + (Direction.values().length -1)) %4 ;
		return getDirection(newValue);
	}
	
	public Direction turnRight() {
		int newValue = (value + (Direction.values().length +1)) %4 ;
		return getDirection(newValue);
	}
	
	public int getValue() {
		return value ;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static Direction getDirection(int value) {
		for(Direction dir : Direction.values()) {
			if(dir.value == value)
				return dir ;
		}
		return null ;
	}
	public static Direction getDirection(String code) {
		for(Direction dir : Direction.values()) {
			if(dir.getCode().equalsIgnoreCase(code))
				return dir ;
		}
		return null ;
	}
	public static void main(String[] argv) {
		Direction north = Direction.North ;
		for(int i = 0 ; i < 8 ; i++) {
			north = north.turnLeft() ;
			System.out.println(" left " + north.toString());
		}
	}
}
