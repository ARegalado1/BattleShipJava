import java.util.Random;
import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		
		
		int [][] map = new int[10][10];
		
		//Intro
		System.out.println("** Welcome to Battle Ships game ** \n\n Right now, the sea is empty...\n" );
		
		int leftNum = 0;
		int rightNum = 0;
		
		System.out.println("   0123456789");
		
		//nested for loop to create map
		for (int row = 0; row < map.length; row++) {
			System.out.print(leftNum + " |");
			leftNum++; // ascending column on the left
			for (int col = 0; col < map[row].length; col++) {
				
				map[row][col] = 0; //set every value in 2D array to 0. Player ships will be 1. Comp ships 2? 
				System.out.print(" ");
			}
			System.out.print("| " + rightNum); 
			rightNum++; // ascending column on the right 
			System.out.println();
		}
		
		System.out.println("   0123456789");
		
		System.out.print("\n\n"); //Create some space 
		
		
		//Now to deploy the players ships 
		
		Scanner playerInput = new Scanner(System.in);
		
		//asking the player where to place his ships
		
		System.out.println("Place your 5 ships!");
		
		for (int p1Ship = 0; p1Ship < 5; p1Ship++) {
				int p1ShipNum = p1Ship + 1;
			System.out.print("Enter X coordinate for your ship " + p1ShipNum + ":");
	        int x = playerInput.nextInt();
	        //if input is greater than 9 throw error
	        	if (x > 9) {
	        		System.out.println("Error. Please enter a coordinate between 0 & 9");
	        		System.out.print("Enter X coordinate for your ship " + p1ShipNum + ":");
	    	        x = playerInput.nextInt();
	        	}
	        
	        System.out.print("Enter Y coordinate for your ship " + p1ShipNum + ":");
	        int y = playerInput.nextInt();
	        //if input is greater than 10 throw error
        		if (y > 9) {
        			System.out.println("Error. Please enter a coordinate between 0 & 9");
        			System.out.print("Enter Y coordinate for your ship " + p1ShipNum + ":");
        			y = playerInput.nextInt();
        		}
        		
        	
        		//Still inside the for loop. 
        		//if the ship is already placed in that spot, need to throw error, and ask for 
        		//a new position for that same ship. 
        	if (map[x][y] == 1) {
        		System.out.println("Error. There is already a ship in that spot.");
        		System.out.println("Please pick a new spot for ship " + p1ShipNum );
        		p1Ship = p1Ship -1; 
        	}
        	
        	map[x][y] = 1; 	// Spots where p1 ship is located is a 1, empty spots are 0	
        		
        }
		

		
		//Now to show the player where he has deployed his ships
		
		System.out.println("\nHere are your ships coordinates: ");
		
		System.out.println("   0123456789");
		
		//nested for loop to re-create map to show updated values, set leftNum & rightNum = 0 again.
		leftNum = 0;
		rightNum = 0;
		
		for (int row = 0; row < map.length; row++) {
				System.out.print(leftNum + " |");
				leftNum++; // ascending column on the left
			for (int col = 0; col < map[row].length; col++) {
				
				//if statement to show @ ship location, if value=1 there is a ship there. 
				
				if (map[row][col] == 0) {
					System.out.print(" ");
						}else if (map[row][col] == 1) {
					System.out.print("@");
				}
				
				
			}
				System.out.print("| " + rightNum); 
				rightNum++; // ascending column on the right 
				System.out.println();
		}
		
		System.out.println("   0123456789");
		
		
		
		//Now to place computer ships
		
		System.out.println("\nComputer is deploying ships.");
		
		Random compNum = new Random();
		
		for (int p2Ship = 0; p2Ship < 5; p2Ship++) {
			int x = compNum.nextInt(10); //random number between 1-10  
			int y = compNum.nextInt(10); //random number between 1-10

    	
    		//Still inside the for loop. 
    		//if a ship is already placed in that spot, need computer to pick new spot
			if (map[x][y] == 1 || map[x][y] == 2) {
	    		p2Ship = p2Ship -1; 
	    	}
	    	
	    	map[x][y] = 2; 	// Spots where a ship is located is a 1, empty spots are 0, player 1 spots are 1.
	    	int p2ShipNum = p2Ship + 1;
	    	System.out.println(p2ShipNum + ". Ship DEPLOYED");
    		
		}
				
		
		//Test to see if computer placed ships and where
		//Commented out, un-comment to test placed ships
		/*
		
		System.out.println("   0123456789");
		
		//nested for loop to re-create map to show updated values, set leftNum & rightNum = 0 again.
		leftNum = 0;
		rightNum = 0;
		
		for (int row = 0; row < map.length; row++) {
				System.out.print(leftNum + " |");
				leftNum++; // ascending column on the left
			for (int col = 0; col < map[row].length; col++) {
				
				//if statement to show @ p1 ship location, and C at comp ship location
				
				if (map[row][col] == 0) {
					System.out.print(" ");
						}else if (map[row][col] == 1) {
							System.out.print("@");
						}else if (map[row][col] == 2) {
							System.out.print("C");
						}
				
				
			}
				System.out.print("| " + rightNum); 
				rightNum++; // ascending column on the right 
				System.out.println();
		}
		
		System.out.println("   0123456789");
		*/
			
		
		//All ships are placed. Time to play.
		
		
		System.out.println("--------------------");
		System.out.println("BATTLE!");		
		
		//0 is empty spot
		//1 is p1 ship location
		//2 is computer ship location
		//3 is sunk p1 ship
		//4 is sunk computer ship
		//5 is p1 miss
		//6 is a computer miss 
		
		
		int x = 12;
		int turnNum = 1;
		
		int p1RemainingShips = 0;
		int compRemainingShips = 0;
		
		
		while (x == 12) {
			
			
			
			
			//Player's turn
			System.out.println("Turn " + turnNum);
			System.out.println("YOUR TURN");
			//P1 turn to attack
			System.out.println("Enter X coordinate: ");
			int xAttack = playerInput.nextInt();
				if (xAttack > 9) {
	    			System.out.println("Error. Please enter a coordinate between 0 & 9");
	    			xAttack = playerInput.nextInt();
	    			}
			System.out.println("Enter Y coordinates: ");
			int yAttack = playerInput.nextInt();
				if (yAttack > 9) {
	    			System.out.println("Error. Please enter a coordinate between 0 & 9");
	    			yAttack = playerInput.nextInt();
	    			}
				
				// avoid p1 attacking the same spot, ask for another attack
				// just have p1 repeat attack unless its empty or its a enemy ship 
			while(map[xAttack][yAttack] == 3 | map[xAttack][yAttack] == 4 | map[xAttack][yAttack] == 5 ) { 
				
				if(map[xAttack][yAttack] == 3) {
						System.out.println("Sorry, that is one of your sunk ships, try again");
				}
				if(map[xAttack][yAttack] == 4) {
					System.out.println("Sorry, you already sunk that ship");
				}
				if(map[xAttack][yAttack] == 5) {
					System.out.println("Sorry, you attacked that coordinate before, it was a miss");
				}
								
				System.out.println("Enter X coordinate: ");
				xAttack = playerInput.nextInt();
					if (xAttack > 9) {
		    			System.out.println("Error. Please enter a coordinate between 0 & 9");
		    			xAttack = playerInput.nextInt();
		    			}
				System.out.println("Enter Y coordinates: ");
				yAttack = playerInput.nextInt();
					if (yAttack > 9) {
			    		System.out.println("Error. Please enter a coordinate between 0 & 9");
			    		yAttack = playerInput.nextInt();
			    		}
				}
				
				
			
				
			if (map[xAttack][yAttack] == 1) {
				// this is where a p1 ship is placed. sunk own ship
				System.out.println("Oh no, you sunk your own ship! Watch your fire! ");
				map[xAttack][yAttack] = 3; 
					}else if (map[xAttack][yAttack] == 2) {//this is where an enemy ship is located
						System.out.println("BOOM! You sunk an enemy ship!");
						map[xAttack][yAttack] = 4;
					}else {//miss
						System.out.println("Sorry, you missed");
						map[xAttack][yAttack] = 5;
					}
			
					
			
			
			//Computer turn to attack
			System.out.println("\nCOMPUTER'S TURN");
			xAttack = compNum.nextInt(10);
			yAttack = compNum.nextInt(10);
			
			while(map[xAttack][yAttack] == 6 | map[xAttack][yAttack] == 4) { // avoid the computer attacking the same spot
				xAttack = compNum.nextInt(10);
				yAttack = compNum.nextInt(10);
			}
			
			if (map[xAttack][yAttack] == 1) {
				// this is where a p1 ship is placed, computer hits. 
				System.out.println("The Computer sunk one of your ships!");
				map[xAttack][yAttack] = 3; 
					}else if (map[xAttack][yAttack] == 2) {//this is where a computer ship is located
						System.out.println("The Computer sunk one of its own ships");
						map[xAttack][yAttack] = 4;
					}else {//miss
						System.out.println("Computer missed");
						map[xAttack][yAttack] = 6;
					}
			
			//Now show the map again, with hits and misses.	
			
			System.out.println();			
			System.out.println("   0123456789");
			
			//nested for loop to re-create map to show updated values, set leftNum & rightNum = 0 again.
			leftNum = 0;
			rightNum = 0;
			p1RemainingShips = 0;
			compRemainingShips = 0;
			
			for (int row = 0; row < map.length; row++) {
					System.out.print(leftNum + " |");
					leftNum++; // ascending column on the left
				for (int col = 0; col < map[row].length; col++) {
					
					//if statement to show @ ship location, if value=1 there is a ship there. 
					
					if (map[row][col] == 1) {
								System.out.print("@");
								p1RemainingShips++;
							}else if (map[row][col] == 3) {
								System.out.print("X");
							}else if (map[row][col] == 4) {
								System.out.print("!");
							}else if (map[row][col] == 5) {
								System.out.print("-");
							}else if (map[row][col] == 2) {
								System.out.print(" ");
								compRemainingShips++;
							}else{
								System.out.print(" ");
							}
					
					
				}
					System.out.print("| " + rightNum); 
					rightNum++; // ascending column on the right 
					System.out.println();
			}
			
			System.out.println("   0123456789");
			
			System.out.println("Your ships: " + p1RemainingShips + " | Computer Ships: " + compRemainingShips);
			
			System.out.println("Key: (@ = your ship) (X = your sunk ship) (! = computer sunk ship) (- = miss)");
			System.out.println("----------------------------------------------------");
			turnNum++;
		
			if (compRemainingShips == 0) {
				System.out.println("Hooray! You win the battle! ");
				x = 11;
			}else if (p1RemainingShips == 0) {
				System.out.println("The computer has beat you. It is becoming sentient. SkyNet is taking over");
				x = 11;
			}
		}
		
		playerInput.close();
		
		
	}

}