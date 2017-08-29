package com.sree.rover;

public class RoverLocation {
	private Direction dir ;
	private int x ;
	private int y ;
	public RoverLocation(String parameters) {
		String[] values = parameters.split(" ");
		if(values.length != 3) {
			System.out.println("Invalid Rover Location " + parameters);
			throw new RuntimeException() ;
		}
		dir = Direction.getDirection(values[2]) ;
		if(dir == null) {
			System.out.println("Invalid Rover Direction " + values[2]);
			throw new RuntimeException() ;
		}

		try {
			x = Integer.parseInt(values[0]) ;
			y = Integer.parseInt(values[1]) ;
		} catch(Exception e) {
			System.out.println("Invalid Rover location  x=" + values[0] + "  y=" + values[1]);
			throw new RuntimeException() ;
		}

	}
	public RoverLocation(Direction dir,int x, int y) {
		this.dir = dir ;
		this.x = x ;
		this.y = y ;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void move() {
		switch(dir)  {
		case North:
			 y +=1 ;
			break ;
		case South:
			 y -=1 ;
			break ;
		case East:
			 x +=1 ;
			break ;
		case West:
			 x -=1 ;
			break ;
		
		}
	}
	public void changeDirection(Turn turn ) {
		switch(turn) {
		case Left :
			dir = dir.turnLeft();
			break ;
		case Right :
			dir = dir.turnRight();
			break ;
		}
	}
	public String toString() {
		return x + " " + y + " " + dir.getCode() ;
	}
}
