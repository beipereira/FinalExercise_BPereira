package org.globant.java.basic.university;

import java.util.ArrayList;
import java.util.List;

public class Teachers extends Students{
	private String teacherID;
	private String teacherName;
	private double teacherSalary;
	public double baseSalary = 1000000;
	private String teacherIntensity; // Part Time or Full Time
	private int teacherYExp; // Year of Experience
	private int teacherAHW; // Active hours per week
	
	protected List<Teachers> teacherList = new ArrayList<Teachers>();
	
	public Teachers addTeacher (String id, String name, String intensity, int ye, int ahw, double salary) {
		Teachers newTeacher = new Teachers();
		newTeacher.teacherID = id;
		newTeacher.teacherName= name;
		newTeacher.teacherIntensity = intensity;
		newTeacher.teacherYExp = ye;
		newTeacher.teacherAHW = ahw;
		newTeacher.teacherSalary = salary;
		return newTeacher;
	}

	public void initializeTeachers() {
		getTeacherList().add(addTeacher("T0001", "Ruddolf McDonal", "PT", 5, 10, 0));
		getTeacherList().add(addTeacher("T0002", "Katerina Koteska", "FT", 10, 20, 0));
		
	}
	
	public void createTeacher() {
		System.out.println("Enter new teacher ID");
		String newTchrId = Main.scan.next();
		Main.scan.nextLine();
		System.out.println("Enter new teacher Name");
		String newTchrName = Main.scan.next();
		Main.scan.nextLine();
		System.out.println("Enter new teacher intensity: PT (Part Time) or FT (Full Time)");
		String newTchrIntensity = Main.scan.next();
		Main.scan.nextLine();
		System.out.println("Enter new teacher year of experience");
		int newTchrYExp = Main.scan.nextInt();
		Main.scan.nextLine();
		System.out.println("Enter new teacher Active Hours per Week");
		int newTchrAHW = Main.scan.nextInt();
		double newTchrSalary = 0;
		getTeacherList().add(addTeacher(newTchrId, newTchrName, newTchrIntensity, newTchrYExp, newTchrAHW, newTchrSalary));
	}
	
	public void printTeachers (List<Teachers> teachers) {
		
		System.out.println("Teachers: ");
		System.out.println("| # | ID | Name | Part Time / Full Time | Year of Experience | Active Hour per Week | Salary | ");
		for(int i = 0; i < teachers.size(); i++) {
            System.out.printf("| " + i + " | " 
            							 + teachers.get(i).getTeacherId() + " | " 
            							 + teachers.get(i).getTeacherName() + " | "
            							 + teachers.get(i).getTeacherIntensity() + " | "
            							 + teachers.get(i).getTeacherYExp() + " | "
            							 + teachers.get(i).getTeacherteacherAHW() + " | "
            							 + "$%.0f\n",
            							 teachers.get(i).getTeacherteacherSalary());
            
        }
	}
		
	public double assignSalary(List<Teachers> teachers) {
		teachers.forEach(item->
		{
		switch(item.teacherIntensity)
		{
		case "FT":
			item.teacherSalary = this.baseSalary*item.teacherYExp*1.1;
			return;
		case "PT":
			item.teacherSalary = this.baseSalary*item.teacherAHW;
			return;
		}
		}
		);		
		return teacherSalary;	
	}

	public List<Teachers> getTeacherList() {
		return teacherList;
	}
	
	public String getTeacherId() {
		return teacherID;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public String getTeacherIntensity() {
		return teacherIntensity;
	}
	
	public int getTeacherYExp() {
		return teacherYExp;
	}
	
	public int getTeacherteacherAHW() {
		return teacherAHW;
	}
	
	public double getTeacherteacherSalary() {
		return teacherSalary;
	}

	public void setTeacherList(List<Teachers> teacherList) {
		this.teacherList = teacherList;
	}	
}
