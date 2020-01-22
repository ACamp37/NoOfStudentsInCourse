package cms;

import java.util.ArrayList;

public class Course implements Comparable<Course> {
	private int id; //Mapping needed here. Unique keys
	private String name;
	private String departmentName;  
	
/*	public Course(String text) {  
		String[] values = text.split("\t");
		for(int i=0;i<text.length();++i) {
			switch(i) { //May consider hardcoding as oppose to switch. But will try with switch
			case 0: id = Integer.parseInt(values[i]); break;
			case 1: name = values[i]; break; 
			case 2: departmentName = values[i]; break;
			}
		}
	} */
	
	public Course(String text) {
		String[] values = text.split("\t");
		id = Integer.parseInt(values[0]);
		name = values[1];
		if("NULL".equals(values[2])) departmentName = null; else
		departmentName = values[2];
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	
	@Override
	public String toString() {
		return String.format("%d\n%s\n%s", id, name, departmentName);  
			
	}
	
	@Override 
	public boolean equals(Object o) { 
		if(!getClass().isInstance(o)) return false; //For now
		Course c = (Course)o;
		//The method should return true only if all fields are equal. 
		//Like this student, vs that student. 
		//Course c = Course(o); Come back too <--
		return id == c.id && name.equals(c.name) && departmentName.equals(c.departmentName); 
	}
	
	@Override
	//Natural Sorting
	public int compareTo(Course o) {
		return name.compareTo(o.name); //All is sorted but element 76. Needs some logic.
	}
}
