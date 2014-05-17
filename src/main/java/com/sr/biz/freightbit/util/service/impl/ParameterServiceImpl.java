package com.sr.biz.freightbit.util.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.sr.biz.freightbit.util.dao.ParameterDao;
import com.sr.biz.freightbit.util.entity.Parameters;
import com.sr.biz.freightbit.util.service.ParameterService;

@Transactional
public class ParameterServiceImpl implements ParameterService {
	
	private ParameterDao parameterDao;
	
	public void setParameterDao(ParameterDao parameterDao) {
		this.parameterDao = parameterDao;
	}

	@Override
	public List<Parameters> getParameterMap(String referenceColumn) {
		List<Parameters> parameterMap = parameterDao.findParameterMapByRefColumn(referenceColumn);
		return parameterMap;
	}

	public List<Parameters> findParametersByProperty(Map<String, Object> params){
		return parameterDao.findParametersByProperty(params);
	}
}
