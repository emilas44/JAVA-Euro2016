/**************************************************************
* This is the main method for simulating whole EURO 2016
* using three classes: 
* 						class Team 
* 						class Game
* 
* @author	Elvis Milas, email: milas.elvis@gmail.com
* @version	1.0, December 2015
**************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Euro2016main {

		public static void main(String[] args) {
			// declaring variable for pausing the code at certain points
			Scanner pause = new Scanner(System.in);
			
			System.out.println("*****************************************************************");
			System.out.println("*\tThis JAVA code simulates whole UEFA Euro 2016\t\t*");
			System.out.println("*\tChampionship in France, from groups till final game.\t*");
			System.out.println("*\tTeams from EURO 2016 are used for this simulation,\t*");
			System.out.println("*\tbut you can change the source code if you have it :)\t*");
			System.out.println("*****************************************************************");
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
		///////////////////////////////// Football World Cup simulation ///////////////////////////////////////////////////////////// 	
			// declaring group A
			Team A1 = new Team("Albania", 71);
			Team A2 = new Team("France", 85);
			Team A3 = new Team("Romania", 74);
			Team A4 = new Team("Switzerland", 80);
			
			// simulating all matches in group A
			Game.simulateNC(A2, A3);
			Game.simulateNC(A1, A4);
			Game.simulateNC(A3, A4);
			Game.simulateNC(A2, A1);
			Game.simulateNC(A4, A2);
			Game.simulateNC(A3, A1);
			
			// creating a List for table
			List<Team> tableA = new ArrayList<Team>();
			
			// adding teams to the ArrayList
			tableA.add(A1);
			tableA.add(A2);
			tableA.add(A3);
			tableA.add(A4);
			
			// sorting teams for printout
			Collections.sort(tableA, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			System.out.println("GROUP A");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			for (Team team : tableA){
				System.out.println(team);
			}
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			// declaring group B
			Team B1 = new Team("England", 83);
			Team B2 = new Team("Russia", 77);
			Team B3 = new Team("Slovakia", 74);
			Team B4 = new Team("Wales", 75);
			
			// simulating all matches in group B
			Game.simulateNC(B4, B3);
			Game.simulateNC(B1, B2);
			Game.simulateNC(B2, B3);
			Game.simulateNC(B1, B4);
			Game.simulateNC(B3, B1);
			Game.simulateNC(B2, B4);
			
			// creating a List for table
			List<Team> tableB = new ArrayList<Team>();
			
			// adding teams to the List
			tableB.add(B1);
			tableB.add(B2);
			tableB.add(B3);
			tableB.add(B4);
			
			// sorting teams inside List for table printout
			Collections.sort(tableB, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			System.out.println("GROUP B");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			
			for (Team team : tableB){
				System.out.println(team);
			}
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			// declaring group C
			Team C1 = new Team("Germany", 85);
			Team C2 = new Team("Northern Ireland", 70);
			Team C3 = new Team("Poland", 77);
			Team C4 = new Team("Ukraine", 76);
			
			// simulating all matches in group C
			Game.simulateNC(C3, C2);
			Game.simulateNC(C1, C4);
			Game.simulateNC(C4, C2);
			Game.simulateNC(C1, C3);
			Game.simulateNC(C2, C1);
			Game.simulateNC(C4, C3);
			
			// creating a List for table
			List<Team> tableC = new ArrayList<Team>();
			
			// adding teams to the ArrayList
			tableC.add(C1);
			tableC.add(C2);
			tableC.add(C3);
			tableC.add(C4);
			
			// sorting teams for printout
			Collections.sort(tableC, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			System.out.println("GROUP C");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			for (Team team : tableC){
				System.out.println(team);
			}
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			// declaring group D
			Team D1 = new Team("Croatia", 79);
			Team D2 = new Team("Czech Republik", 76);
			Team D3 = new Team("Spain", 86);
			Team D4 = new Team("Turkey", 76);
			
			// simulating all matches in group D
			Game.simulateNC(D4, D1);
			Game.simulateNC(D3, D2);
			Game.simulateNC(D2, D1);
			Game.simulateNC(D3, D4);
			Game.simulateNC(D1, D3);
			Game.simulateNC(D2, D4);
			
			// creating a List for table
			List<Team> tableD = new ArrayList<Team>();
			
			// adding teams to the List
			tableD.add(D1);
			tableD.add(D2);
			tableD.add(D3);
			tableD.add(D4);
			
			// sorting teams inside List for table printout
			Collections.sort(tableD, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			System.out.println("GROUP D");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			
			for (Team team : tableD){
				System.out.println(team);
			}
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			// declaring group E
			Team E1 = new Team("Belgium", 83);
			Team E2 = new Team("Italy", 84);
			Team E3 = new Team("Ireland", 76);
			Team E4 = new Team("Sweden", 76);
			
			// simulating all matches in group E
			Game.simulateNC(E3, E4);
			Game.simulateNC(E1, E2);
			Game.simulateNC(E2, E4);
			Game.simulateNC(E1, E3);
			Game.simulateNC(E4, E1);
			Game.simulateNC(E2, E3);
			
			// creating a List for table
			List<Team> tableE = new ArrayList<Team>();
			
			// adding teams to the ArrayList
			tableE.add(E1);
			tableE.add(E2);
			tableE.add(E3);
			tableE.add(E4);
			
			// sorting teams for printout
			Collections.sort(tableE, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			System.out.println("GROUP E");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			for (Team team : tableE){
				System.out.println(team);
			}
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			// declaring group F
			Team F1 = new Team("Austria", 75);
			Team F2 = new Team("Hungary", 72);
			Team F3 = new Team("Iceland", 72);
			Team F4 = new Team("Portugal", 82);
			
			// simulating all matches in group F
			Game.simulateNC(F1, F2);
			Game.simulateNC(F4, F3);
			Game.simulateNC(F3, F2);
			Game.simulateNC(F4, F1);
			Game.simulateNC(F3, F1);
			Game.simulateNC(F2, F4);
			
			// creating a List for table
			List<Team> tableF = new ArrayList<Team>();
			
			// adding teams to the List
			tableF.add(F1);
			tableF.add(F2);
			tableF.add(F3);
			tableF.add(F4);
			
			// sorting teams inside List for table printout
			Collections.sort(tableF, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			System.out.println("GROUP F");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			
			for (Team team : tableF){
				System.out.println(team);
			}
			
			
			// creating a List for table
			List<Team> table3 = new ArrayList<Team>();
			
			table3.add(tableA.get(2));
			table3.add(tableB.get(2));
			table3.add(tableC.get(2));
			table3.add(tableD.get(2));
			table3.add(tableE.get(2));
			table3.add(tableF.get(2));
			
			// sorting teams inside List for table printout
			Collections.sort(table3, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if (t1.getPts() > t2.getPts()){
						return -1;
					} else if((t1.getPts() == t2.getPts()) && (t1.getGD() >= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return -1;
					} else if ((t1.getPts() == t2.getPts()) && (t1.getGD() <= t2.getGD()) && (t1.getGF() > t2.getGF())){
						return 1;
					}
			
					return 0;
				}
			});
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
		    
		    // Ranking 3rd teams from groups and priniting them out
			System.out.println("Ranking of third-placed teams");
			
			System.out.println("\t\t\t" + "Pts\t"+"W\t"+"D\t"+"L\t"+"GF\t"+"GA\t"+"GD");
			
			for (Team team : table3){
				System.out.println(team);
			}
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
		
			
			System.out.println("\n***************** END OF GROUP PHASE ****************************\n");
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			// getting the teams who passed the group
			System.out.println("\nQualified teams for knockout phase: ");
			System.out.println("\t\nA1: " + tableA.get(0).getName() + "\nA2: " + tableA.get(1).getName());
			System.out.println("\t\nB1: " + tableB.get(0).getName() + "\nB2: " + tableB.get(1).getName());
			System.out.println("\t\nC1: " + tableC.get(0).getName() + "\nC2: " + tableC.get(1).getName());
			System.out.println("\t\nD1: " + tableD.get(0).getName() + "\nD2: " + tableD.get(1).getName());
			System.out.println("\t\nE1: " + tableE.get(0).getName() + "\nE2: " + tableE.get(1).getName());
			System.out.println("\t\nF1: " + tableF.get(0).getName() + "\nF2: " + tableF.get(1).getName());
			System.out.println();
			System.out.println("\t\n31st: " + table3.get(0).getName() + "\n32nd: " + table3.get(1).getName());
			System.out.println("\t\n33rd: " + table3.get(2).getName() + "\n34th: " + table3.get(3).getName());
			
			System.out.println("\n************************ KNOCKOUT PHASE *************************\n");
			
			// reseting all field goals to 0
			tableA.get(0).resetGF(0);
			tableA.get(1).resetGF(0);
			tableB.get(0).resetGF(0);
			tableB.get(1).resetGF(0);
			tableC.get(0).resetGF(0);
			tableC.get(1).resetGF(0);
			tableD.get(0).resetGF(0);
			tableD.get(1).resetGF(0);
			tableE.get(0).resetGF(0);
			tableE.get(1).resetGF(0);
			tableF.get(0).resetGF(0);
			tableF.get(1).resetGF(0);
			table3.get(0).resetGF(0);
			table3.get(1).resetGF(0);
			table3.get(2).resetGF(0);
			table3.get(3).resetGF(0);
		      
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			System.out.println("\n************************** 1/8 FINALS ****************************\n");
		    

			System.out.println("\t" + tableA.get(1).getName() +" vs "+ tableC.get(1).getName() + "\n");
			System.out.println("\t" + tableD.get(0).getName() +" vs "+ table3.get(0).getName() + "\n");
			System.out.println("\t" + tableB.get(0).getName() +" vs "+ table3.get(1).getName() + "\n");
			System.out.println("\t" + tableF.get(0).getName() +" vs "+ tableE.get(1).getName() + "\n");
			System.out.println("\t" + tableC.get(0).getName() +" vs "+ table3.get(2).getName() + "\n");
			System.out.println("\t" + tableE.get(0).getName() +" vs "+ tableD.get(1).getName() + "\n");
			System.out.println("\t" + tableA.get(0).getName() +" vs "+ table3.get(3).getName() + "\n");
			System.out.println("\t" + tableB.get(1).getName() +" vs "+ tableF.get(1).getName() + "\n");

			
			System.out.println("\n");
			
			Game.simulateNCPK(tableA.get(1), tableC.get(1));
			Game.simulateNCPK(tableD.get(0), table3.get(0));
			Game.simulateNCPK(tableB.get(0), table3.get(1));
			Game.simulateNCPK(tableF.get(0), tableE.get(1));
			Game.simulateNCPK(tableC.get(0), table3.get(2));
			Game.simulateNCPK(tableE.get(0), tableD.get(1));
			Game.simulateNCPK(tableA.get(0), table3.get(3));
			Game.simulateNCPK(tableB.get(1), tableF.get(1));

			
			List<Team> first = new ArrayList<Team>();
			List<Team> second = new ArrayList<Team>();
			List<Team> third = new ArrayList<Team>();
			List<Team> fourth = new ArrayList<Team>();
			List<Team> fifth = new ArrayList<Team>();
			List<Team> sixth = new ArrayList<Team>();
			List<Team> seventh = new ArrayList<Team>();
			List<Team> eighth = new ArrayList<Team>();
			
			// adding teams to the List
			first.add(tableA.get(1));
			first.add(tableC.get(1));
			second.add(tableD.get(0));
			second.add(table3.get(0));
			third.add(tableB.get(0));
			third.add(table3.get(1));
			fourth.add(tableF.get(0));
			fourth.add(tableE.get(1));
			fifth.add(tableC.get(0));
			fifth.add(table3.get(2));
			sixth.add(tableE.get(0));
			sixth.add(tableD.get(1));
			seventh.add(tableA.get(0));
			seventh.add(table3.get(3));
			eighth.add(tableB.get(1));
			eighth.add(tableF.get(1));
					
			// sorting teams inside List for table printout
			Collections.sort(first, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(second, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(third, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(fourth, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(fifth, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(sixth, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(seventh, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(eighth, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			System.out.println("************************* 1/4 FINALS ******************************\n");
			
			first.get(0).resetGF(0); first.get(0).resetPK(0); 
			second.get(0).resetGF(0); second.get(0).resetPK(0);
			fifth.get(0).resetGF(0); fifth.get(0).resetPK(0);
			third.get(0).resetGF(0); third.get(0).resetPK(0);
			fourth.get(0).resetGF(0); fourth.get(0).resetPK(0);
			fifth.get(0).resetGF(0); fifth.get(0).resetPK(0);
			sixth.get(0).resetGF(0); sixth.get(0).resetPK(0);
			seventh.get(0).resetGF(0); seventh.get(0).resetPK(0);
			eighth.get(0).resetGF(0); eighth.get(0).resetPK(0);
			
			System.out.println("\t" + first.get(0).getName() + " vs " + second.get(0).getName() + "\n");
			System.out.println("\t" + third.get(0).getName() + " vs " + fourth.get(0).getName() + "\n");
			System.out.println("\t" + fifth.get(0).getName() + " vs " + sixth.get(0).getName() + "\n");
			System.out.println("\t" + seventh.get(0).getName() + " vs " + eighth.get(0).getName() + "\n");
			
			System.out.println("\n");
			
			Game.simulateNCPK(first.get(0), second.get(0));
			Game.simulateNCPK(third.get(0), fourth.get(0));
			Game.simulateNCPK(fifth.get(0), sixth.get(0));
			Game.simulateNCPK(seventh.get(0), eighth.get(0));
			
			List<Team> W = new ArrayList<Team>();
			List<Team> X = new ArrayList<Team>();
			List<Team> Y = new ArrayList<Team>();
			List<Team> Z = new ArrayList<Team>();
			
			W.add(first.get(0));
			W.add(second.get(0));
			X.add(third.get(0));
			X.add(fourth.get(0));
			Y.add(fifth.get(0));
			Y.add(sixth.get(0));
			Z.add(seventh.get(0));
			Z.add(eighth.get(0));

			
			Collections.sort(W, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(X, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(Y, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(Z, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			System.out.println("********************** 1/2 FINALS *********************************\n");
			
			W.get(0).resetGF(0); W.get(0).resetPK(0); 
			X.get(0).resetGF(0); X.get(0).resetPK(0);
			Y.get(0).resetGF(0); Y.get(0).resetPK(0);
			Z.get(0).resetGF(0); Z.get(0).resetPK(0);
			
			System.out.println(W.get(0).getName() + " vs " + X.get(0).getName() + "\n");
			System.out.println(Y.get(0).getName() + " vs " + Z.get(0).getName() + "\n");
			
			System.out.println("\n");
			
			Game.simulateNCPK(W.get(0), X.get(0));
			Game.simulateNCPK(Y.get(0), Z.get(0));
			
			List<Team> one = new ArrayList<Team>();
			List<Team> two = new ArrayList<Team>();
			
			one.add(W.get(0));
			one.add(X.get(0));
			two.add(Y.get(0));
			two.add(Z.get(0));
			
			Collections.sort(one, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			Collections.sort(two, new Comparator<Team>() {
				public int compare(Team t1, Team t2) {
					
					if ((t1.getGF() > t2.getGF()) || (t1.getPK() > t2.getPK())){
						return -1;
					} else if ((t1.getGF() < t2.getGF()) || (t1.getPK() < t2.getPK())){
						return 1;
					}
			
					return 0;
				}
			});
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			System.out.println("******************* Match for 3rd place *********************\n");
			
			one.get(1).resetGF(0); one.get(1).resetPK(0); 
			two.get(1).resetGF(0); two.get(1).resetPK(0);
			
			System.out.println(one.get(1).getName() + " vs " + two.get(1).getName());
			
			System.out.println("\n");
			
			Game.simulateNCPK(one.get(1), two.get(1));
			
			// pause
			System.out.println("\nPress Enter 2x to continue...\n");
		    while(!pause.nextLine().equals(""));
		    pause.nextLine();
			
			System.out.println("******************* FINAL ***********************************\n");
			
			one.get(0).resetGF(0); one.get(0).resetPK(0); 
			two.get(0).resetGF(0); two.get(0).resetPK(0);
		    
			System.out.println(one.get(0).getName() + " vs " + two.get(0).getName());
			
			System.out.println("\n");
			
			Game.simulateNCPK(one.get(0), two.get(0));
			
			
			// close the scanner so the compiler doesn't complain
			pause.close();
		} // end of main
} // end of class
