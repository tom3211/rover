package com.sree.rover;

public enum Turn {
	Left ('L'),
	Right('R') ;
	private Character code  ;
	private Turn(Character code) {
		this.code = code ;
	}
	
	public static Turn getTurn(char code) {
		for(Turn v : Turn.values()) {
			if(v.code.charValue()==code)
				return v ;
		}
		return null ;
	}
}
