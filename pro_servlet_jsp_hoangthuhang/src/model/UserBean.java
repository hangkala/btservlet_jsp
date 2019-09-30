/**
 * Copyright(C) 2019 Luvina JSC
 * UserBean.java, Sep 30, 2019, HangHT
 */
package model;

/**
 * @author HangHT
 *
 */
public class UserBean {
	private int Id;
	private String name, birthday, birthplace;

	/**
	 * 
	 */
	public UserBean() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Override
	public String toString() {
		return "UserBean [Id=" + Id + ", name=" + name + ", birthday=" + birthday + ", birthplace=" + birthplace + "]";
	}
	
	
}
