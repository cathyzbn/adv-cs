package AP2018;

public class FrogSimulation {
	
	private int goalDistance;
	private int maxHops;
	
	public FrogSimulation(int dist, int numHops) {
		goalDistance = dist;
		maxHops = numHops;
	}
	
	public boolean simulate() {
		
		int current = 0;
		for(int i=0; i<maxHops; i++) {
			current += hopDistance();
			if(current>=goalDistance) {return true;}
		}
		
		return false;
	}
	
	public double runSimulations(int num) {
		
		double success = 0;
		for(int i=0; i<num; i++) {
			if(simulate()) {success += 1;}
		}
		return success/num;
	}
	

}
