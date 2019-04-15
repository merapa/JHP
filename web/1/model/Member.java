package model;

public class Member {
	
	private String id;
	private String pass;
	private String name;
	private String email;
	private String contact;
	private String question;
	private String answer;

	 public String getid() {
	        return id;
	    }
	    public void setid(String id) {
	        this.id = id;
	    }
	    public String getpass() {
	        return pass;
	    }
	    public void setpass(String pass) {
	        this.pass = pass;
	    }
	    public String getname() {
	        return name;
	    }
	    public void setname(String name) {
	        this.name = name;
	    }
	    public String getemail() {
	        return email;
	    }
	    public void setemail(String email) {
	        this.email = email;
	    }
		public String getcontact() {
			// TODO Auto-generated method stub
			return null;
		}
	    public void setcontact(String contact) {
	        this.contact = contact;
	    }
		public String getquestion() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getanswer() {
			// TODO Auto-generated method stub
			return null;
		}

	    
	    @Override
	    public String toString() {
	        return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", contact=" + contact+","
	        		+ " question=" + question + ", answer=" + answer + "]";
	    }



}
