package dto;

import java.sql.Connection;

import util.*;

public class MemberDTO {
	
	Connection con = DatabaseUtil.getConnection();
	
	int no;
	String id;
	String pass;
	String name;
	String contact;
	String email;
	String email1;
	String question;
	String answer;
	
	
	
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public MemberDTO(){
		
	}
	
	
	
	public MemberDTO(int no, String id, String pass, String name, String contact, String email, String email1,
			String question, String answer) {
		super();
		this.no = no;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.email1 = email1;
		this.question = question;
		this.answer = answer;

	}
	
	
	
	
	
	
	
	
	
	

	
	
	

}
	
