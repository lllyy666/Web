package cn.oopeak.bean;

/**
 *教师表实体类
 *
 */
public class Teacher {
	// 教工号
	private Integer tno;
	// 姓名
	private String tname;
	// 性別
	private String gender;
	// 密码 
	private String password;

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [tno=" + tno + ", tname=" + tname + ",  gender=" + gender + ", password=" + password
				+ "]";
	}

}
