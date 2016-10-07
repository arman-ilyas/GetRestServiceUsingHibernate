package com.arman.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menus implements Serializable{
	
	@Id
	@Column(name = "menu_id")
	private int menu_id;
	@Column(name = "name")
	private String name;

	public Menus() {
	}

	public Menus(String name) {
		this.name = name;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", name=" + name + "]";
	}

}
