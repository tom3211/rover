package com.sree.rover;

import java.util.Scanner;

public class RoverNavigator {
	private MarsDimensions md = null ;
	public RoverNavigator(MarsDimensions md) {
		this.md = md ;
	}
	public void moveRover(RoverLocation currLocation, String moves) {
		char[] moveChars = moves.toCharArray() ;
		for(char move : moveChars) {
			if(move == 'M') {
				currLocation.move(); 
				if(md.isValidLocation(currLocation) == false) {
					System.out.println("Invalid move " + move);
					throw new RuntimeException(" Invalid move ") ;
				}
			} else {
				Turn turn = Turn.getTurn(move) ;
				if(turn == null) {
					System.out.println("Invalid turn " + move);
					throw new RuntimeException("") ;
					
				}
				currLocation.changeDirection(turn);
			}
		}
		
	}
	public static void main(String[] argv) {
		Scanner in = new Scanner(System.in) ;
		String line = in.nextLine();
		String[] values = line.split(" ");
		RoverNavigator navigator = null ;
		try {
			int maxX = Integer.parseInt(values[0]);
			int maxY = Integer.parseInt(values[1]);
			MarsDimensions md = new MarsDimensions(maxX, maxY) ;
			navigator = new RoverNavigator(md);
		} catch(Exception e) {
			System.out.println("Exception in parsing mars dimensions " + line);
			in.close();
			throw new RuntimeException() ;
		}
		boolean run = true ; 
		while(run) {
			line = in.nextLine();
			if(line.equalsIgnoreCase("q")) {
				System.out.println("Exiting ");
				break ;
			}
			RoverLocation roverLocation = new RoverLocation(line) ;
			String moves = in.nextLine() ;
			navigator.moveRover(roverLocation, moves);
			System.out.println(roverLocation);
		}
		in.close(); 
	}
}
