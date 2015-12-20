/******************************************************************************
* This class is used for simulating matches between two teams
* It has four similar methods:
* 
* .simulate(Team, Team)			simulates game W/O penalties (PK)
* .siumulatePK(Team, Team)		simulates game with penalties if it ends draw
* .simulateNC(Team, Team)		simulates game W/O comments & W/O PK
* .simulateNCPK(Team, Team)		simulates game W/O comments & with PK
* 
* @author	Elvis Milas, email: milas.elvis@gmail.com
* @version	1.0, December 2015
******************************************************************************/

import java.util.concurrent.TimeUnit;

public class Game {
	
	private static int ball = 0;
	private static boolean team1HasBall = false;
	private static boolean team2HasBall = false;
	private static boolean gameInProgress = false;

	// Simulate game without penalties
	public static void simulate(Team team1 , Team team2 ){
		// variable for clock start
		long startTime = System.nanoTime();
		// declaring team variables and calculating percentage of possible win (90 / ((90+80)/100))
		double t1pow = (team1.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		double t2pow = (team2.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		int t1goal = 0;
		int t2goal = 0;	
		// deciding who has the ball first
		double coinToss = Math.random();
			if (coinToss <= 0.5){
				team1HasBall = true;
				team2HasBall = false;
				System.out.println(team1.getName() + " has the ball first");
				ball = 5;
				gameInProgress = true;
			} else {
				team2HasBall = true;
				team1HasBall = false;
				System.out.println(team2.getName() + " has the ball first");
				ball = -5;
				gameInProgress = true;
			} // end of if coin toss
		
		///////////////////////////////// SIUMULATING GAME /////////////////////////////////////
		while (gameInProgress){
			//******************************* While team1 has the ball ************************************//
			while (team1HasBall){
				double r1 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case 6: if (r1 < t1pow){
        			System.out.println(team1.getName() + " tries a long pass");
					ball = 5;
        		} else {
        			System.out.println("Recounter, " + team2.getName() + " cuts the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 5: if (r1 < t1pow){
        			System.out.println(team1.getName() + " is dribbling the ball");
					ball = 4;
        		} else {
        			System.out.println(team1.getName() + " has lost the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 4: if (r1 < t1pow){
        			System.out.println(team1.getName() + " is making some action");
					ball = 3;
        		} else {
        			System.out.println(team2.getName() + " steals the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 3: if (r1 < t1pow){
        			System.out.println(team1.getName() + " has made an excellent pass!");
					ball = 2;
        		} else {
        			System.out.println(team2.getName() + " has intercepted the pass");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 2: if (r1 < t1pow){
        			System.out.println("It's a chance, " + team1.getName() + " is shooting!!");
					ball = 1;
        		} else {
        			System.out.println(team2.getName() + " has blocked the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 1: if (r1 < t1pow){
	            			t1goal += 1;
	            			System.out.println(team1.getName() + " has scored a GOOOOOOOAAAAAL!!!");
    						team1HasBall = false;
    						team2HasBall = true;
    						ball = -6;
	            		} else {
	            			System.out.println("WOW a great save from " + team2.getName() + " goalkeeper");
	            			team1HasBall = false;
							team2HasBall = true;
							ball = -6;
	            		}
				}
			} // end of team1 has the ball
			
			//******************************* While team2 has the ball ************************************//
			while (team2HasBall){
				double r2 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case -6: if (r2 < t2pow){
        			System.out.println(team2.getName() + " tries a long pass");
					ball = -5;
        		} else {
        			System.out.println("Recounter, " + team1.getName() + " cuts the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -5: if (r2 < t2pow){
        			System.out.println(team2.getName() + " is dribbling the ball");
					ball = -4;
        		} else {
        			System.out.println(team2.getName() + " has lost the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -4: if (r2 < t2pow){
        			System.out.println(team2.getName() + " is making some action");
					ball = -3;
        		} else {
        			System.out.println(team1.getName() + " steals the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -3: if (r2 < t2pow){
        			System.out.println(team2.getName() + " has made an excellent pass!");
					ball = -2;
        		} else {
        			System.out.println(team1.getName() + " has intercepted the pass");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -2: if (r2 < t2pow){
        			System.out.println("It's a chance, " + team2.getName() + " is shooting!!");
					ball = -1;
        		} else {
        			System.out.println(team1.getName() + " has cuts the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -1: if (r2 < t2pow){
	            			t2goal += 1;
	            			System.out.println(team2.getName() + " has scored a GOOOOOOOAAAAAL!!!");
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		} else {
	            			System.out.println("WOW a great save from " + team1.getName() + " goalkeeper");
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		}
				}
			} // end of team2 has the ball
			
			
			// declaring variables for game duration
			long endTime = System.nanoTime();			// system nanotime when program was finished 
			long duration = endTime - startTime;		// duration is equal to endtime minus starttime
			
			// duration is converted value from nanotime to msec.
			duration = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS);	
			    
			if (duration >= 3){
				System.out.println(duration);
			//if ((t1goal > 0) || (t2goal > 0) ){			// alternative way to end game
				gameInProgress = false;
					team1.setGF(t1goal);					// adding scored goals and recieved goals for both teams
					team2.setGF(t2goal);
					team1.setGA(t2goal);
					team2.setGA(t1goal);
				
				if (t1goal > t2goal){						// adding points if team1 wins
					team1.setPts(3);
					team1.setW(1);
					team2.setL(1);
				} else if (t1goal < t2goal){				// adding points if team2 wins
					team2.setPts(3);
					team2.setW(1);
					team1.setL(1);
				} else {									// adding points if it's draw
					team1.setD(1);
					team2.setD(1);
					team1.setPts(1);
					team2.setPts(1);
				}
				
				System.out.println("\tFinal score:\t" + team1.getName() + " " + t1goal + ":" + t2goal + " " + team2.getName() + "\n");
				
			} // end of duration
		} // end of game in progress	
	} // end of method .simulate
	
	// Simulate game with penalties in case of a draw match
	public static void simulatePK(Team team1 , Team team2 ){
		// variable for clock start
		long startTime = System.nanoTime();
		// declaring team variables and calculating percentage of possible win (90 / ((90+80)/100))
		double t1pow = (team1.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		double t2pow = (team2.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		int t1goal = 0;
		int t2goal = 0;	
		// deciding who has the ball first
		double coinToss = Math.random();
			if (coinToss <= 0.5){
				team1HasBall = true;
				team2HasBall = false;
				System.out.println(team1.getName() + " has the ball first");
				ball = 5;
				gameInProgress = true;
			} else {
				team2HasBall = true;
				team1HasBall = false;
				System.out.println(team2.getName() + " has the ball first");
				ball = -5;
				gameInProgress = true;
			} // end of if coin toss
		
		///////////////////////////////// SIUMULATING GAME /////////////////////////////////////
		while (gameInProgress){
			//************** While Team1 has the ball ***************//
			while (team1HasBall){
				double r1 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case 6: if (r1 < t1pow){
        			System.out.println(team1.getName() + " tries a long pass");
					ball = 5;
        		} else {
        			System.out.println("Recounter, " + team2.getName() + " cuts the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 5: if (r1 < t1pow){
        			System.out.println(team1.getName() + " is dribbling the ball");
					ball = 4;
        		} else {
        			System.out.println(team1.getName() + " has lost the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 4: if (r1 < t1pow){
        			System.out.println(team1.getName() + " is making some action");
					ball = 3;
        		} else {
        			System.out.println(team2.getName() + " steals the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 3: if (r1 < t1pow){
        			System.out.println(team1.getName() + " has made an excellent pass!");
					ball = 2;
        		} else {
        			System.out.println(team2.getName() + " has intercepted the pass");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 2: if (r1 < t1pow){
        			System.out.println("It's a chance, " + team1.getName() + " is shooting!!");
					ball = 1;
        		} else {
        			System.out.println(team2.getName() + " has blocked the ball");
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 1: if (r1 < t1pow){
	            			t1goal += 1;
	            			System.out.println(team1.getName() + " has scored a GOOOOOOOAAAAAL!!!");
    						team1HasBall = false;
    						team2HasBall = true;
    						ball = -6;
	            		} else {
	            			System.out.println("WOW a great save from " + team2.getName() + " goalkeeper");
	            			team1HasBall = false;
							team2HasBall = true;
							ball = -6;
	            		}
				}
			} // end of team1 has the ball
			
			//************** While Team2 has the ball ***************//
			while (team2HasBall){
				double r2 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case -6: if (r2 < t2pow){
        			System.out.println(team2.getName() + " tries a long pass");
					ball = -5;
        		} else {
        			System.out.println("Recounter, " + team1.getName() + " cuts the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -5: if (r2 < t2pow){
        			System.out.println(team2.getName() + " is dribbling the ball");
					ball = -4;
        		} else {
        			System.out.println(team2.getName() + " has lost the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -4: if (r2 < t2pow){
        			System.out.println(team2.getName() + " is making some action");
					ball = -3;
        		} else {
        			System.out.println(team1.getName() + " steals the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -3: if (r2 < t2pow){
        			System.out.println(team2.getName() + " has made an excellent pass!");
					ball = -2;
        		} else {
        			System.out.println(team1.getName() + " has intercepted the pass");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -2: if (r2 < t2pow){
        			System.out.println("It's a chance, " + team2.getName() + " is shooting!!");
					ball = -1;
        		} else {
        			System.out.println(team1.getName() + " has cuts the ball");
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -1: if (r2 < t2pow){
	            			t2goal += 1;
	            			System.out.println(team2.getName() + " has scored a GOOOOOOOAAAAAL!!!");
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		} else {
	            			System.out.println("WOW a great save from " + team1.getName() + " goalkeeper");
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		}
				}
			} // end of team2 has the ball
			
			
			// declaring variables for game duration
			long endTime = System.nanoTime();			// system nanotime when program was finished 
			long duration = endTime - startTime;		// duration is equal to endtime minus starttime
			
			// duration is converted value from nanotime to msec.
			duration = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS);	
			    
			if (duration >= 3){								// end the game if duration is more or equal to 3 miliseconds
				//System.out.println(duration);
			//if ((t1goal > 0) || (t2goal > 0) ){			// alternative way to end game
				gameInProgress = false;
					team1.setGF(t1goal);					// adding scored goals and recieved goals for both teams
					team2.setGF(t2goal);
					team1.setGA(t2goal);
					team2.setGA(t1goal);
				
				if (t1goal > t2goal){						// adding points if team1 wins
					team1.setPts(3);
					team1.setW(1);
					team2.setL(1);
				} else if (t1goal < t2goal){				// adding points if team2 wins
					team2.setPts(3);
					team2.setW(1);
					team1.setL(1);
				} else {									// adding points if it's draw
					team1.setD(1);
					team2.setD(1);
					team1.setPts(1);
					team2.setPts(1);
				}
				// printing out the score
				System.out.println("\tFinal score:\t" + team1.getName() + " " + t1goal + ":" + t2goal + " " + team2.getName() + "\n");
			} // end of duration
	
		} // end of game in progress	
		
		// if game ends with draw, winner is decided with penalty shoot-out
		if (t1goal == t2goal){
			System.out.println("Penalty shoot-out");
			int pk1 = 0;
			int pk2 = 0;
			
			for (int i = 1; i <= 5; i++){
				double pkr = Math.random();
				if (pkr < 0.5){
					System.out.println(i + ": " + team1.getName() + " has scored!");
					pk1 += 1;
				} else {
					System.out.println(i + ": " + team1.getName() + " missed :(");
				}
			}
			
			for (int i = 1; i <= 5; i++){
				double pkr = Math.random();
				if (pkr < 0.5){
					System.out.println(i + ": " + team2.getName() + " has scored!");
					pk2 += 1;
				} else {
					System.out.println(i + ": " + team2.getName() + " missed :(");
				}
			} // end of PK
				
			team1.setPK(pk1);
			team2.setPK(pk2);
			
			System.out.println("\tFinal score after penalties:\t" + team1.getName() + " " + t1goal + "(" + team1.getPK() + ")" + ":" + "("+ team2.getPK() +")" + t2goal + " " + team2.getName() + "\n");
			
			// if the score after first series of 5 shots is draw then we have Sudden death
			if (pk1 == pk2){
				System.out.println("\nIt's draw! The winner will be decided with - Sudden death\n");
				while (pk1 == pk2){
					double sdr1 = Math.random();
					double sdr2 = Math.random();
					if (sdr1 > 0.5 && sdr2 > 0.5){
						System.out.println(team1.getName() + " has scored!");
						System.out.println(team2.getName() + " has scored!");
						pk1 += 1;
						pk2 += 1;
					} else if (sdr1 > 0.5 && sdr2 < 0.5){
						System.out.println(team1.getName() + " has scored!");
						System.out.println(team2.getName() + " missed :(");
						pk1 += 1;
					} else if (sdr1 < 0.5 && sdr2 > 0.5){
						System.out.println(team1.getName() + " missed :(");
						System.out.println(team2.getName() + " has scored!");
						pk2 += 1;
					}
				} // end of sudden death
				
				team1.setPK(pk1);
				team2.setPK(pk2);
				
				// printout final score after Sudden death
				System.out.println("\tFinal score after Sudden death:\t" + team1.getName() + " " + t1goal + "(" + team1.getPK() + ")" + ":" + "("+ team2.getPK() +")" + t2goal + " " + team2.getName() + "\n");
				
			} // end of Sudden death
		} // end of penalty shoot-out
	} // end of method .simulateWP (with penalties)
	
	// Simulate game without penalties
	public static void simulateNC(Team team1 , Team team2 ){
		// variable for clock start
		long startTime = System.nanoTime();
		// declaring team variables and calculating percentage of possible win (90 / ((90+80)/100))
		double t1pow = (team1.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		double t2pow = (team2.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		int t1goal = 0;
		int t2goal = 0;	
		// deciding who has the ball first
		double coinToss = Math.random();
			if (coinToss <= 0.5){
				team1HasBall = true;
				team2HasBall = false;
				ball = 5;
				gameInProgress = true;
			} else {
				team2HasBall = true;
				team1HasBall = false;
				ball = -5;
				gameInProgress = true;
			} // end of if coin toss
		
		///////////////////////////////// SIUMULATING GAME /////////////////////////////////////
		while (gameInProgress){
			//******************************* While team1 has the ball ************************************//
			while (team1HasBall){
				double r1 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case 6: if (r1 < t1pow){
					ball = 5;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 5: if (r1 < t1pow){
					ball = 4;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 4: if (r1 < t1pow){
					ball = 3;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 3: if (r1 < t1pow){
					ball = 2;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 2: if (r1 < t1pow){
					ball = 1;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 1: if (r1 < t1pow){
	            			t1goal += 1;
    						team1HasBall = false;
    						team2HasBall = true;
    						ball = -6;
	            		} else {
	            			team1HasBall = false;
							team2HasBall = true;
							ball = -6;
	            		}
				}
			} // end of team1 has the ball
			
			//******************************* While team2 has the ball ************************************//
			while (team2HasBall){
				double r2 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case -6: if (r2 < t2pow){
					ball = -5;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -5: if (r2 < t2pow){
					ball = -4;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -4: if (r2 < t2pow){
					ball = -3;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -3: if (r2 < t2pow){
					ball = -2;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -2: if (r2 < t2pow){
					ball = -1;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -1: if (r2 < t2pow){
	            			t2goal += 1;
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		} else {
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		}
				}
			} // end of team2 has the ball
			
			
			// declaring variables for game duration
			long endTime = System.nanoTime();			// system nanotime when program was finished 
			long duration = endTime - startTime;		// duration is equal to endtime minus starttime
			    
			if (duration >= 150000){
				//System.out.println(duration);
			//if ((t1goal > 0) || (t2goal > 0) ){			// alternative way to end game
				gameInProgress = false;
					team1.setGF(t1goal);					// adding scored goals and recieved goals for both teams
					team2.setGF(t2goal);
					team1.setGA(t2goal);
					team2.setGA(t1goal);
				
				if (t1goal > t2goal){						// adding points if team1 wins
					team1.setPts(3);
					team1.setW(1);
					team2.setL(1);
				} else if (t1goal < t2goal){				// adding points if team2 wins
					team2.setPts(3);
					team2.setW(1);
					team1.setL(1);
				} else {									// adding points if it's draw
					team1.setD(1);
					team2.setD(1);
					team1.setPts(1);
					team2.setPts(1);
				}
				
				System.out.println("\tFinal score:\t" + team1.getName() + " " + t1goal + ":" + t2goal + " " + team2.getName() + "\n");
				
			} // end of duration
		} // end of game in progress	
	} // end of method .simulateNC (no comments, no PK)
	
	// Simulate game with penalties in case of a draw match
	public static void simulateNCPK(Team team1 , Team team2 ){
		// variable for clock start
		long startTime = System.nanoTime();
		// declaring team variables and calculating percentage of possible win example: (90 / ((90+80)/100))
		double t1pow = (team1.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		double t2pow = (team2.getStrength() / ((team1.getStrength() + team2.getStrength())/100));
		int t1goal = 0;
		int t2goal = 0;	
		// deciding who has the ball first
		double coinToss = Math.random();
			if (coinToss <= 0.5){
				team1HasBall = true;
				team2HasBall = false;
				ball = 5;
				gameInProgress = true;
			} else {
				team2HasBall = true;
				team1HasBall = false;
				ball = -5;
				gameInProgress = true;
			} // end of if coin toss
		
		///////////////////////////////// SIUMULATING GAME /////////////////////////////////////
		while (gameInProgress){
			//************** While Team1 has the ball ***************//
			while (team1HasBall){
				double r1 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case 6: if (r1 < t1pow){
					ball = 5;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 5: if (r1 < t1pow){
					ball = 4;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 4: if (r1 < t1pow){
					ball = 3;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 3: if (r1 < t1pow){
					ball = 2;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 2: if (r1 < t1pow){
					ball = 1;
        		} else {
        			team1HasBall = false;
					team2HasBall = true;
					ball = -6;
        		}
	            break;
	            case 1: if (r1 < t1pow){
	            			t1goal += 1;
    						team1HasBall = false;
    						team2HasBall = true;
    						ball = -6;
	            		} else {
	            			team1HasBall = false;
							team2HasBall = true;
							ball = -6;
	            		}
				}
			} // end of team1 has the ball
			
			//************** While Team2 has the ball ***************//
			while (team2HasBall){
				double r2 = (1+Math.random()*(100));
				
				switch (ball){
				
	            case -6: if (r2 < t2pow){
					ball = -5;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -5: if (r2 < t2pow){
					ball = -4;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -4: if (r2 < t2pow){
					ball = -3;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -3: if (r2 < t2pow){
					ball = -2;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -2: if (r2 < t2pow){
					ball = -1;
        		} else {
        			team2HasBall = false;
					team1HasBall = true;
					ball = 6;
        		}
	            break;
	            case -1: if (r2 < t2pow){
	            			t2goal += 1;
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		} else {
	            			team2HasBall = false;
	            			team1HasBall = true;
	            			ball = 6;
	            		}
				}
			} // end of team2 has the ball
			
			
			// declaring variables for game duration
			long endTime = System.nanoTime();			// system nanotime when program was finished 
			long duration = endTime - startTime;		// duration is equal to endtime minus starttime
			    
			if (duration >= 150000){						// end the game if duration is more or equal to 3 miliseconds
				//System.out.println(duration);
			//if ((t1goal > 0) || (t2goal > 0) ){			// alternative way to end game
				gameInProgress = false;
					team1.setGF(t1goal);					// adding scored goals and recieved goals for both teams
					team2.setGF(t2goal);
					team1.setGA(t2goal);
					team2.setGA(t1goal);
				
				if (t1goal > t2goal){						// adding points if team1 wins
					team1.setPts(3);
					team1.setW(1);
					team2.setL(1);
				} else if (t1goal < t2goal){				// adding points if team2 wins
					team2.setPts(3);
					team2.setW(1);
					team1.setL(1);
				} else {									// adding points if it's draw
					team1.setD(1);
					team2.setD(1);
					team1.setPts(1);
					team2.setPts(1);
				}
			} // end of duration			
		} // end of game in progress
		
		if ((t1goal != t2goal)){
			System.out.println("\tFinal score:\t" + team1.getName() + " " + t1goal + ":" + t2goal + " " + team2.getName() + "\n");
		}
		
		// if game ends with draw, winner is decided with penalty shoot-out
		int pk1 = 0;				// declaring variables for penalties and sudden death
		int pk2 = 0;
		int sd1 = 0;
		int sd2 = 0;
		
		if (t1goal == t2goal){
			
			for (int i = 1; i <= 5; i++){
				double pkr = Math.random();
				if (pkr < 0.5){
					pk1 += 1;
				}
			}
			
			for (int i = 1; i <= 5; i++){
				double pkr = Math.random();
				if (pkr < 0.5){
					pk2 += 1;
				}
			}
				
			team1.setPK(pk1);
			team2.setPK(pk2);
			
			// if the score after first series of 5 shots is draw then we have Sudden death
			if (pk1 == pk2){
				while (sd1 == sd2){
					double sdr1 = Math.random();
					double sdr2 = Math.random();
					if (sdr1 > 0.5 && sdr2 > 0.5){
						sd1 += 1;
						sd2 += 1;
					} else if (sdr1 > 0.5 && sdr2 < 0.5){
						sd1 += 1;
					} else if (sdr1 < 0.5 && sdr2 > 0.5){
						sd2 += 1;
					}
				}
				
				team1.setPK(sd1);
				team2.setPK(sd2);
					
			} // end of Sudden death
		} // end of penalty shoot-out

		// printout final score after penalties or sudden death
		if (pk1 != pk2){
			System.out.println("\tFinal score after penalties:\t" + team1.getName() + " " + t1goal + "(" + team1.getPK() + ")" + ":" + "("+ team2.getPK() +")" + t2goal + " " + team2.getName() + "\n");
		}
		
		if (sd1 != sd2){
			System.out.println("\tFinal score after sudden death:\t" + team1.getName() + " " + t1goal + "(" + team1.getPK() + ")" + ":" + "("+ team2.getPK() +")" + t2goal + " " + team2.getName() + "\n");
		}
	} // end of method .simulateNCWP (with penalties no comments)
} // end of class