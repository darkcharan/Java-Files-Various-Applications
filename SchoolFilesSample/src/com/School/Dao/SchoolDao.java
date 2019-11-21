package com.School.Dao;

import java.util.List;

import com.School.baen.SchoolBean;

public interface SchoolDao {
	void AddSchool();
	List<SchoolBean>viewSchool();
	void ViewSpecificSchool(int sno);
	void UpdateSchool(int sno);
	void DeleteSchool(int sno);

}
