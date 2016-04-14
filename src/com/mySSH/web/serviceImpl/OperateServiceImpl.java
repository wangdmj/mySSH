package com.mySSH.web.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mySSH.web.dao.OperateDao;
import com.mySSH.web.service.OperateService;

@Service("operateService")
public class OperateServiceImpl implements OperateService {

	@Resource
	private OperateDao operateDao;

	@Override
	public <T> List<T> findAll(Class<T> t) {
		return operateDao.findAll(t);
	}

	@Override
	public <T> T findById(Class<T> t, Serializable id) {
		return operateDao.findById(t, id);
	}

	@Override
	public <T> List<T> findByName(Class<T> t, String str, String qStr) {
		return operateDao.findByName(t, str, qStr);
	}

	@Override
	public <T> void saveOperate(T t) {
		operateDao.saveOperate(t);

	}

	@Override
	public <T> void updateOperate(T t) {
		operateDao.updateOperate(t);

	}

	@Override
	public <T> void deleteOperate(T t) {
		operateDao.deleteOperate(t);

	}

	@Override
	public <T> void deleteOperate(Class<T> t, Serializable id) {
		operateDao.deleteOperate(t, id);

	}

	@Override
	public <T> List<T> findLimit(Class<T> t, int start, int length, String qStr) {
		return operateDao.findLimit(t, start, length, qStr);
	}

	@Override
	public <T> T findByNameForSingle(Class<T> t, String str, String qStr) {
		return operateDao.findByNameForSingle(t, str, qStr);
	}

	@Override
	public <T> List<T> findByVagueName(Class<T> t, String str, String qStr) {
		return operateDao.findByVagueName(t, str, qStr);
	}

	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Vague(Object o)
			throws DataAccessException, Exception {
		return operateDao.findMultiConditionCombinationQuery_Vague(o);
	}

	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Accurate(Object o)
			throws DataAccessException, Exception {
		return operateDao.findMultiConditionCombinationQuery_Accurate(o);
	}

	@Override
	public <T> int findCount(Class<T> t) {
		return operateDao.findCount(t);
	}

	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Vague_Limit(Object o,
			final int start, final int length) throws DataAccessException,
			Exception {
		return operateDao.findMultiConditionCombinationQuery_Vague_Limit(o,
				start, length);
	}

	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Accurate_Limit(
			Object o, final int start, final int length)
			throws DataAccessException, Exception {
		return operateDao.findMultiConditionCombinationQuery_Accurate_Limit(o,
				start, length);
	}

	@Override
	public int findMultiConditionCombinationQuery_Vague_Count(Object o)
			throws DataAccessException, Exception {
		return operateDao.findMultiConditionCombinationQuery_Vague_Count(o);
	}

	@Override
	public int findMultiConditionCombinationQuery_Accurate_Count(Object o)
			throws DataAccessException, Exception {
		return operateDao.findMultiConditionCombinationQuery_Accurate_Count(o);
	}
}
