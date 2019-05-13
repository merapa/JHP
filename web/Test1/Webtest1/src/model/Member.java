package model;

public class Member {
	
	private String id;
	private String pass;
	private String name;
	private String contact;
	private String email;
	private String email1;
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

		public String getEmail1() {
			return email1;
		}
		public void setEmail1(String email1) {
			this.email1 = email1;
		}
		public String getemail1() {
			
			return null;
		}
	
	public void getemail1(String email11) {
	
	
}
	public void setquestion(String question) {

	
}
	public void setanswer(String answer) {

}
	    @Override
	    public String toString() {
	        return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", email1=" + email1 + ", contact=" + contact+","
	        		+ " question=" + question + ", answer=" + answer + "]";
	    }
		public void close() {
		
		}


}
