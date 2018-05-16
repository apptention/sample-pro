package kr.co.hta.board.web.form;

public class UserRegisterForm {

	private String id;
	
	private String pwd;
	
	private String nick;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "UserRegisterForm [id=" + id + ", pwd=" + pwd + ", nick=" + nick + "]";
	}
	
}
