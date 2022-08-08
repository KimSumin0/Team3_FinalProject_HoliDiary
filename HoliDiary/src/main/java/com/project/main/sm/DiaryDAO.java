package com.project.main.sm;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryDAO {
	
	@Autowired
	private SqlSession ss;

	// 다이어리 수정 (타이틀, 소개, 컬러)
	public void updateDiary(HttpServletRequest req, Diary d) {

		d = (Diary) req.getAttribute("diary");

		try {
			
			String diaryUserId = req.getParameter("diaryUserId");
			String diaryTitle = req.getParameter("diaryTitle");
			String diaryIntroduce = req.getParameter("diaryIntroduce");
			String themeColor = req.getParameter("themeColor");

			System.out.println(diaryUserId);
			System.out.println(diaryTitle);
			System.out.println(diaryIntroduce);
			System.out.println(themeColor);
			
			d.setDiaryUserId(diaryUserId);
			d.setDiaryTitle(diaryTitle);
			d.setDiaryIntroduce(diaryIntroduce);
			d.setThemeColor(themeColor);

			
			if (ss.getMapper(DiaryMapper.class).diaryUpdate(d) == 1) {
				req.setAttribute("diary", d); // 수정사항이 반영된 m을 다시 넣어줌
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("다이어리 수정 실패");
		}

	}

}
