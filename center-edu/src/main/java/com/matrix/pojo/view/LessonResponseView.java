package com.matrix.pojo.view;

import java.util.ArrayList;
import java.util.List;

import com.matrix.pojo.entity.TClasses;
import com.matrix.pojo.entity.TLesson;

public class LessonResponseView {
	
	private LessonView entity;
	private List<TClasses> claList = new ArrayList<>();
	
	public LessonView getEntity() {
		return entity;
	}
	public void setEntity(LessonView entity) {
		this.entity = entity;
	}
	public List<TClasses> getClaList() {
		return claList;
	}
	public void setClaList(List<TClasses> claList) {
		this.claList = claList;
	}

}
