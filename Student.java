package cms;

public class Student implements Comparable<Student> {
	private int id; //Mapping need here as well. Unique keys
	private String firstName;
	private String lastName;
	private String street; 
	private String streetDetail; //Has some numbering in it. 
	private String city; 
	private String state; 
	private int postalCode; 
	private int majorId; 
	
	//My main constuctor 
	public Student(String text) {
		String[] values = text.split("\t");
		id = Integer.parseInt(values[0]);
		firstName = values[1];
		lastName = values[2];
		street = values[3];
		if("NULL".equals(values[4])) streetDetail = null; else
			streetDetail = values[4];
		city = values[5];
		state = values[6];
		postalCode = Integer.parseInt(values[7]);
		majorId = Integer.parseInt(values[8]);
	}

	//This constructor holds my values 
	public Student(int id, String firstName, String lastName, String street, String streetDetail,
			String city, String state, int postalCode, int majorId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.streetDetail = streetDetail;
		this.city = city;
		this.state = state; 
		this.postalCode = postalCode;
		this.majorId = majorId;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreet() {
		return street;
	}

	public String getStreetDetail() {
		return streetDetail;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public int getMajorId() {
		return majorId;
	}
	
	@Override
	public String toString() {
		return String.format("%d\n%s\n%s\n%s\n%s\n%s\n%s\n%d\n%d" ,
				id, firstName, lastName, street, streetDetail,
				city, state, postalCode, majorId); 
		
	}
	
	@Override 
	public boolean equals(Object o) {
		if(!getClass().isInstance(o))
		return false; //For now 
		Student s = (Student)o;
		//return type seems far to long. But none of the following fields seem unique.
		return id == s.id && firstName.equals(s.firstName) && lastName.equals(s.lastName) &&
				street.equals(s.street) && streetDetail.equals(s.streetDetail)
				&&city.equals(s.city) && state.equals(s.state) && postalCode == s.postalCode
				&& majorId == s.majorId;
	}
	
	@Override
	//Natural Sorting
	public int compareTo(Student o) { 
		//if last names are equal, sort first name ascending. Requires logic.
		//if object last name	
		
	//	Need first name logic to pair with last name.
		int r = lastName.compareTo(o.lastName);
		if (r == 0) r =	firstName.compareTo(o.firstName);
		return r;
	}		
}
