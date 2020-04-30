package org.globant.java.basic.university;

import java.util.ArrayList;
import java.util.List;

public class Students {
	private String studentID;
	private String studentName;
	private int studentAge;
	
	protected List<Students> studentList = new ArrayList<Students>();
	
	public List<Students> getStudents()  
    { 
        return getStudentList(); 
    } 
	
	public Students addStudent (String id, String name, int age) {
		Students newStudent = new Students();
		newStudent.studentID = id;
		newStudent.studentName= name;
		newStudent.studentAge= age;
		return newStudent;
	}

	public void initializeStudents() {
		getStudentList().add(addStudent("S0001", "Mike Towers", 16));
		getStudentList().add(addStudent("S0002", "Cliff Austin", 17));
		getStudentList().add(addStudent("S0003", "Sarah Miller", 18));
		getStudentList().add(addStudent("S0004", "Cassey Clinton", 19));
		getStudentList().add(addStudent("S0005", "Robert Smith", 20));
		getStudentList().add(addStudent("S0006", "Anna Williams", 21));
		
	}
	
	public void createStudent() {
		System.out.println("Enter new student ID");
		String newStId = Main.scan.next();
		Main.scan.nextLine();
		System.out.println("Enter new student Name");
		String newStName = Main.scan.next();
		Main.scan.nextLine();
		System.out.println("Enter new student Age");
		int newStAge = Main.scan.nextInt();
		getStudentList().add(addStudent(newStId, newStName, newStAge));
	}
	
	public void printStudents (List<Students> students) {
		
		System.out.println("Students: ");
		System.out.println("| # | ID | Name | Age |");
		for(int i = 0; i < students.size(); i++) {
            System.out.println("| " + i + " | " + students.get(i).getStudentID() + " | " 
            							 	   + students.get(i).getStudentName() + " | "
            							 	   + students.get(i).getStudentAge());
        }
	}

	public List<Students> getStudentList() {
		return studentList;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentList(List<Students> studentList) {
		this.studentList = studentList;
	}
}
