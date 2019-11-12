
public class DiplomaWithHonors extends Diploma {

	public DiplomaWithHonors(String name, String major) {
		super(name, major);
	}
	
	public String toString() {
		String output = super.toString() + "\n*** with honors ***";
		return output;
	}
}
