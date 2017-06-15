package com.masterhash.gui;

public class Table {

	private String name;
	private String username;
	private String password;

	public Table() {
		this.name = "";
		this.username = "";
		this.password = "";
	}

	public Table(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
