package com.project.main.sej;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePostDAO {
	
	private int allPostCount;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private HomeSiteOption so;
	
	public int getAllPostCount() {
		return allPostCount;
	}
	
	public void setAllPostCount(int allPostcount) {
		this.allPostCount = allPostcount;
	}
	
	public void calcAllMsgCount() {
		HomePostSelector pSel = new HomePostSelector("", null, null);
		allPostCount = ss.getMapper(Sej_postMapper.class).getPostCount(pSel);
	}
	
	
	
	
	
	

	public void searchPost(HomePostSelector pSel, HttpServletRequest req) {
		req.getSession().setAttribute("search", pSel);
	}

	public void getPost(int pageNo, HttpServletRequest req) {

		int count = so.getPostCountPerpage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		HomePostSelector search = (HomePostSelector) req.getSession().getAttribute("search");
		int postCount = 0;

		if (search == null) {
			search = new HomePostSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(Sej_postMapper.class).getPostCount(search);
		}

		List<PostContent> contents = ss.getMapper(Sej_postMapper.class).getPost(search);
		

		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);

		req.setAttribute("contents", contents);
		req.setAttribute("curPage", pageNo);
		
	}
	
	

	
	
}