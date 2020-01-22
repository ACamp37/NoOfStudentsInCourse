package cms;

import java.time.LocalDate;

public class StudentCourse {
	private int studentId; 
	private int courseId; 
	private int progress; 
	private LocalDate startDate; //Should be LocalDate type 
	
/*	public StudentCourse(String text) {
		String[] values = text.split("\t");
		for(int i=0;i<text.length();++i) {
			switch(i) {
			case 0: studentId = Integer.parseInt(values[i]);
			case 1: courseId = Integer.parseInt(values[i]);
			case 2: progress = Integer.parseInt(values[i]);
			case 3: startDate = values[i];
			}
		}
	} */
	
	public StudentCourse(String text) {
		String[] values = text.split("\t");
		studentId = Integer.parseInt(values[0]);
		courseId = Integer.parseInt(values[1]);
		progress = Integer.parseInt(values[2]);
		startDate = LocalDate.parse(values[3]);
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public int getProgress() {
		return progress;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	
	@Override 
	public boolean equals(Object o) {
		if(!getClass().isInstance(o))
		return false; //For now
		StudentCourse sc = (StudentCourse)o;
		return studentId == sc.studentId && courseId == sc.courseId && progress == sc.progress
				&& startDate.equals(sc.startDate);//<-- Consider eqauting CourseID, to Course object. Same for Student. 
		
	}
}
