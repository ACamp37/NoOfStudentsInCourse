package cms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CourseAnalytics {
	public static void main(String[] args) throws IOException {
		generateCourseCounts();  
	}
	
	private static Map<Integer, Course> loadCourses() throws IOException {
		Map<Integer, Course> courseMap = new LinkedHashMap<Integer, Course>();//LinkedHashMap
		Files.lines(Paths.get("courses.csv")).skip(1).forEach(s->courseMap.put(new Course(s).getId(), new Course(s)));
		return courseMap;
	}  
	
	private static ArrayList<Student> loadStudents()throws IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Files.lines(Paths.get("students.csv")).skip(1).forEach(s->studentList.add(new Student(s)));
		return studentList;
	}  
	
	private static ArrayList<StudentCourse> loadStudentCourses() throws IOException{
		ArrayList<StudentCourse> studentCourseList = new ArrayList<StudentCourse>();
		Files.lines(Paths.get("StudentCourses.csv")).skip(1).forEach(s->studentCourseList.add(new StudentCourse(s)));
		return studentCourseList; 
	}
	 
	private static void generateCourseCounts() throws IOException {
		Map<Integer, Course> courses = loadCourses();
		ArrayList<StudentCourse> studentCourses = loadStudentCourses();
		Map<Integer,Integer> courseCount = new TreeMap<Integer,Integer>();
		for(StudentCourse sc : studentCourses) {
			if(!courseCount.containsKey(sc.getCourseId()))
				courseCount.put(sc.getCourseId(), 1); 
			else
			{
			int counter = courseCount.get(sc.getCourseId()) + 1; 
			courseCount.put(sc.getCourseId(), counter);  
			}
		}
		
		ArrayList<String> sortArray = new ArrayList<String>();
		for(Map.Entry<Integer, Integer> entry: courseCount.entrySet()) {
			String s = entry.getValue().toString() + "_" + entry.getKey().toString();
			sortArray.add(s);
		}
		Collections.sort(sortArray);
		Collections.reverse(sortArray);
		System.out.println(sortArray);
		
		//Code below doesn't work, but its the closest I got i believe to writing a file from arraylist to map of courses.
/*	File file = new File("CourseCounts.csv");  
		FileWriter fw = new FileWriter(file);
		for(String sortStr : sortArray) {
			//sortStr.split("_");
			for(Map.Entry<Integer,Course> entryTwo : courses.entrySet()) {
				sortStr = entryTwo.getValue().getName() + entryTwo.getKey();
				sortArray.add(courses.get(Integer.parseInt(sortStr)).getId(), courses.values()); 
			}
		System.out.println(sortArray); 
		} */
	}
}
			