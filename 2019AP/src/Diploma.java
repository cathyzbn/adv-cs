
public class Diploma {
	
	String theName, theCourse;
	
	public Diploma(String name, String course){
		
		theName = name;
		theCourse = course;
		
	}
	
	public String toString() {
		
		String output = "This certifies that \n" + theName + "\nhas completed a course in " + theCourse;
		return output;
		
	}
	
}

