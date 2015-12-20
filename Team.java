/**************************************************************
* This class is used for making TeamWC objects
* 
* it has standard constructor, setter and getter methods
* with one override method:
* .toString()
* for printing all relevant variables in a table
* 
* @author	Elvis Milas, email: milas.elvis@gmail.com
* @version	1.0, December 2015
**************************************************************/


public class Team { 			

	private String name;
	private double strength;
	private int Pts, W, D, L, GF, GA, PK;
		
	// constructor //////////////////////////////////////////
	public Team(String name, int strength) {
		setName(name);
		setStrength(strength);
	}

	// Setters //////////////////////////////////////////////
	public void setName(String name) {
		this.name = name;
	}
	// set strength for the team
	public void setStrength(double strength) {
		this.strength = strength;
	}

	public void setPts(int pts) {
		Pts += pts;
	}

	public void setW(int w) {
		W += w;
	}

	public void setD(int d) {
		D += d;
	}

	public void setL(int l) {
		L += l;
	}

	public void setGF(int gF) {
		GF += gF;
	}
	
	public void resetGF(int gF){
		GF = gF;
	}
	
	public void setGA(int gA) {
		GA += gA;
	}
	
	
	public void setPK(int pK) {
		PK += pK;
	}
	
	public void resetPK(int pK){
		PK = pK;
	}

	// Getters //////////////////////////////////////////////
	public String getName() {
		return name;
	}
	
	public double getStrength() {
		return strength;
	}
	
	public int getPts() {
		return Pts;
	}

	public int getW() {
		return W;
	}

	public int getD() {
		return D;
	}

	public int getL() {
		return L;
	}

	public int getGF() {
		return GF;
	}

	public int getGA() {
		return GA;
	}
	
	// getter for goal difference
	public int getGD() {
		return GF-GA;
	}
	
	public int getPK() {
		return PK;
	}

	///////////// Override //////////////////////
	@Override
	public String toString(){
		return String.format("%-20s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t", name, Pts, W, D, L, GF, GA, this.getGD());
		//return  name + "          \t" + Pts + "\t" + W + "\t" + D + "\t" + L + "\t" + GF + "\t" + GA + "\t" + this.getGD();
	}

} // end of class