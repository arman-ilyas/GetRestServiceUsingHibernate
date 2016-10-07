package com.arman.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
	private String status;
	List<Menus> menus = new ArrayList<Menus>();


	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
