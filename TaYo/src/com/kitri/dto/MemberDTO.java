package com.kitri.dto;

public class MemberDTO {
	private String email;	//�̸���
	private String name;	//�̸�
	private String pass;	//��й�ȣ
	private int age;		//����
	private int grade;		//���
	private String gender;	//����

	
	public MemberDTO() {
		
	}

	public MemberDTO(String email, String name, String pass, int age, int grade, String gender) {
		super();
		this.email = email;
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.grade = grade;
		this.gender = gender;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}	
	
	
}
