package kr.co.hta.board.vo;

import java.util.Date;

public class User {

	private String id;
	
	private String pwd;
	
	private String nick;
	
	private Date createDate;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", createDate=" + createDate + "]";
	}

}
