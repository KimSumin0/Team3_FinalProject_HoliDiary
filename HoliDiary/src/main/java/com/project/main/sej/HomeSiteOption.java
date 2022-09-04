package com.project.main.sej;

import javax.servlet.http.HttpServletRequest;

public class HomeSiteOption {

	private int postCountPerpage;	// 한 페이지당 sns 개수
	
	public HomeSiteOption() {
		// TODO Auto-generated constructor stub
	}

	public HomeSiteOption(int postCountPerpage) {
		super();
		this.postCountPerpage = postCountPerpage;
	}

	public int getPostCountPerpage() {
		return postCountPerpage;
	}

	public void setPostCountPerpage(int postCountPerpage) {
		this.postCountPerpage = postCountPerpage;
	}
	
	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
		
	}

	
}
