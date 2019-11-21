package com.sample.doa;

import java.util.List;

import com.sample.bean.SampleBean;

public interface SampleDao {
	void AddSample();
	List<SampleBean>ViewSample();
	void ViewSpecificSample(int sno);
	void UpdateSample(int sno);
	void DeleteSample(int sno);

}
