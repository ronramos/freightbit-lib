package com.sr.biz.freightbit.util.service;

import java.util.List;
import java.util.Map;

import com.sr.biz.freightbit.util.entity.Parameters;

public interface ParameterService {
	
	public List<Parameters> getParameterMap(String referenceColumn);

	public List<Parameters> findParametersByProperty(Map<String, Object> params);
}
