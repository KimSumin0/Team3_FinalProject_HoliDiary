package com.project.main.sm;

import com.project.main.js.User;
import com.project.main.sm.Diary;

public interface DiaryMapper {

	public void diaryInsert(User u);
	public int diaryUpdate(Diary d);
	//public Object getDiaryInfo(String user1);
	public Object getDiaryInfo(Diary d);


}
