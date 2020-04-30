package org.globant.java.basic.university;

import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void menu() {  // Options
		   System.out.println("................................." + "\n" + 
				   			  "Press 1 to print teachers info " + "\n" + 
				   			  "Press 2 to print classes info" + "\n" + 
				   			  "Press 3 to create a new student" + "\n" +
				   			  "Press 4 to create a new class" + "\n" +
				   			  "Press 5 to list classes by student Id" + "\n" +
				   			  "Press 0 to exit" + "\n" + 
				   			  ".................................");	 
		}
	
	public static void menu2() {  // Options
		   System.out.println("................................." + "\n" + 
				   			  "Select the class to print" + "\n" + 
				   			  ".................................");	 
		}
	
	public static void menu3() {  // Options
		   System.out.println("................................." + "\n" +
				   			  "Enter the student Id" + "\n" +
				   			  ".................................");	 
		}
	
	public static int selectOption() { // Action selection
	    int option;
	    option = Main.scan.nextInt();
	    return option;
		}
	
	public static void main(String[] args) {
		
		Teachers newTeacher = new Teachers();
		newTeacher.initializeTeachers();
		newTeacher.assignSalary(newTeacher.getTeacherList()); // Assign Salary to teachers
		
		Students newStudent = new Students();
		newStudent.initializeStudents();
		
		Classes newClass = new Classes();
		newClass.initializeClasses();
		newClass.addInfotoClass(newClass.getClassList());
		
		menu();
	    int choise;
		do {
	    	choise = selectOption();
		switch (choise) {
		  case 1:
			  newTeacher.printTeachers(newTeacher.getTeacherList());
			  menu();
			break;
		  case 2:
			  // Sub menu Select Class to print
			  newClass.printClasses(newClass.getClassList());
			  menu2();
			  int selectedClass = selectOption();
			  newClass.printInfoselectedClass(newClass.getClassInfoList(), selectedClass);
			  menu();
			break;
		  case 3:
			  newStudent.createStudent(); // 3. Create Student / Add it to class
			  newStudent.printStudents(newStudent.getStudentList()); // Print Students
			  // Select the class for a new student
			  System.out.println("Select a class for the new student");
			  newClass.printClasses(newClass.getClassList());
			  int selectedClass1 = selectOption();
			  int selectedStudent = newStudent.getStudentList().size()-1;
			  newClass.addInfotoSelectedClass(newClass.getClassList(), newTeacher.getTeacherList(), newStudent.getStudentList(), selectedClass1, 0, selectedStudent);
			  newClass.printInfoClass(newClass.getClassInfoList());
			  menu();
			break;
		  case 4:
			  newClass.createClass(); // 4. Create Class / Add a Teacher to it / Add Students to it
			  System.out.println("Select a class to add a teacher and a student");
			  newClass.printClasses(newClass.getClassList());
			  int selectedClass11 = selectOption();
			  System.out.println("Select the teacher to add to the class");
			  newTeacher.printTeachers(newTeacher.getTeacherList());
			  int selectedTeacher = selectOption();
			  System.out.println("Select the student to add to the class");
			  newStudent.printStudents(newStudent.getStudentList());
			  int selectedStudent1 = selectOption();
			  newClass.addInfotoSelectedClass(newClass.getClassList(), newTeacher.getTeacherList(), newStudent.getStudentList(), selectedClass11, selectedTeacher, selectedStudent1);
			  newClass.printInfoClass(newClass.getClassInfoList());
			  menu();
			break;
		  case 5:
			  // Sub menu Input Student Id to list classes
			  menu3();
			  newStudent.printStudents(newStudent.getStudentList()); // Print Students by Id
			  menu();
			break;
		  	default: menu();
	    }
	    } while (choise!=0);
		
	}

}
