package org.globant.java.basic.university;

import java.util.ArrayList;
import java.util.List;

public class Classes extends Teachers{ // Classes Class
	private String className;
	private String classRoom;
	private String classNameInfo;
	private String classRoomInfo;
	private String classTeacher;
	private String classStudents;
	
	private List<Classes> classList = new ArrayList<Classes>();
	private List<Classes> classInfoList = new ArrayList<Classes>();
	
	public Classes addClass (String name, String room) {
		Classes newClass = new Classes();
		newClass.className= name;
		newClass.classRoom= room;
		return newClass;
	}
	
	public void initializeClasses() {
		getClassList().add(addClass("Calculus","CR001"));
		getClassList().add(addClass("Economics","CR002"));
		getClassList().add(addClass("Chemistry","CR003"));
		getClassList().add(addClass("Programming","CR004"));
	}
	
	public Classes addInfoClass (String name, String room, String teacher, String students) {
		Classes newClass = new Classes();
		newClass.classNameInfo= name;
		newClass.classRoomInfo= room;
		newClass.classTeacher= teacher;
		newClass.classStudents= students;
		return newClass;
	}
	
	public void addInfotoSelectedClass(List<Classes> classes, List<Teachers> teachers, List<Students> students, int selectedClass, int selectedTeacher, int selectedStudent) {
		getClassInfoList().add(addInfoClass(classes.get(selectedClass).getClassName(), 
											classes.get(selectedClass).getClassRoom(), 
											teachers.get(selectedTeacher).getTeacherName(), 
											students.get(selectedStudent).getStudentName()));
	}
	
	public void addInfotoClass(List<Classes> classes) {
		int j = classes.size()-1;
		for (int i = 0; i > j; i++) {
			getClassInfoList().add(addInfoClass(
					classes.get(i).getClassName(), 
					classes.get(i).getClassRoom(), 
					null, 
					null));
		}
	}
	
	public void createClass() {
		System.out.println("Enter new class Name");
		String newClId = Main.scan.next();
		Main.scan.nextLine();
		System.out.println("Enter new class ClassRoom");
		String newClName = Main.scan.next();
		Main.scan.nextLine();
		getClassList().add(addClass(newClId, newClName));
	}
		
	public void printClasses (List<Classes> classes) { // Print All Classes
		System.out.println("Classes: ");
		System.out.println("| # | ID | Name | Classroom | ");		
		for(int i = 0; i < classes.size(); i++) {
            System.out.println("|" + i 
            		+ " | " + classes.get(i).getClassName() 
            		+ " | " + classes.get(i).getClassRoom());
        }
		
	}
	
	public void printselectedClass (List<Classes> classes, int selectedClass) { // Print Selected Class info
            System.out.println(classes.get(selectedClass).getClassName());
            System.out.println(classes.get(selectedClass).getClassRoom());
            
	}
	
	public void printInfoClass (List<Classes> infoclasses) { // Print Selected Class info
		System.out.println("Classes: ");
		System.out.println("| # | Name | Classroom | Teacher | Students | ");
		for(int i = 0; i < infoclasses.size(); i++) {
            System.out.println("| " + i + " | " + infoclasses.get(i).getClassNameInfo() + " | " 
            							 + infoclasses.get(i).getClassRoomInfo() + " | "
            							 + infoclasses.get(i).getclassTeacher() + " | "
            							 + infoclasses.get(i).getclassStudents());
        }
	}
	
	public void printInfoselectedClass (List<Classes> infoclasses, int selectedClass) { // Print Selected Class info
        System.out.println(infoclasses.get(selectedClass).getClassNameInfo());
        System.out.println(infoclasses.get(selectedClass).getClassRoomInfo());
        System.out.println(infoclasses.get(selectedClass).getclassTeacher());
        System.out.println(infoclasses.get(selectedClass).getclassStudents());
        
}

	public List<Classes> getClassList() {
		return classList;
	}
	
	public void setClassList(List<Classes> classList) {
		this.classList = classList;
	}
	
	public List<Classes> getClassInfoList() {
		return classInfoList;
	}
	
	public void setClassInfoList(List<Classes> classInfoList) {
		this.classInfoList = classInfoList;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getClassRoom() {
		return classRoom;
	}
	
	public String getClassNameInfo() {
		return classNameInfo;
	}
	
	public String getClassRoomInfo() {
		return classRoomInfo;
	}
	
	public String getclassTeacher() {
		return classTeacher;
	}
	
	public String getclassStudents() {
		return classStudents;
	}

	
}
