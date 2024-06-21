package com.assign2.multistreams.student;

import java.util.Objects;

public class Student implements Comparable<Student>{

	private String name;
	private Integer age;
	private String grade;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Integer age, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, grade, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(grade, other.grade) && Objects.equals(name, other.name);
	}
	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return this.grade.compareTo(arg0.grade);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
	
	
}
