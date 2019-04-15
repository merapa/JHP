package dao;

public class MemberDTO {
	
	
	private String id;
	private String pass;
	private String name;
	private String contact;
	private String email;
	private String email1;
	private String question;
	private String answer;

	public MemberDTO() {
		super();	
	}
	
	public MemberDTO(String id,String pass,String name,String contact,String email,String email1,String question,String answer) {
		
	
	this.setId(id);
	this.setPass(pass);
	this.setName(name);
	this.setContact(contact);
	this.setEmail(email);
	this.setEmail1(email1);
	this.setQuestion(question);
	this.setAnswer(answer);
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getid() {
		return null;
	}

	public String getpass() {
		return null;
	}

	public String getcontact() {
		return null;
	}

	public String getemail() {
		return null;
	}

	public String getname() {
		return null;
	}

	public String getquestion() {
		return null;
	}

	public String getanswer() {
		return null;
	}
	

}
