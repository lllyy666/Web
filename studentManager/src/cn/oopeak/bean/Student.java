package cn.oopeak.bean;

/**
 * 学生表实体类
 *
 */
public class Student {
	// 学号
	private Integer sno;
	// 姓名
	private String sname;
	// 生日
	private String birthday;
	// 性別
	private String gender;
	// 班级 
	private String bj;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBj() {
		return bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

	@Override
	public String toString() {
		return "User [sno=" + sno + ", sname=" + sname + ", birthday=" + birthday + ", gender=" + gender + ", bj=" + bj
				+ "]";
	}

}
