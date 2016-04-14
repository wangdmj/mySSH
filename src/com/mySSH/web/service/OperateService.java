package com.mySSH.web.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface OperateService {
	public <T> List<T> findAll(Class<T> t );
	public <T> List<T> findLimit(Class<T> t ,final int start ,final int length,String qStr);
	public <T> List<T> findByName(Class<T> t,String str,String qStr );
	public <T> List<T> findByVagueName(Class<T> t,String str ,String qStr);
	public <T> List<T> findMultiConditionCombinationQuery_Vague(Object o) throws DataAccessException, Exception;
	public <T> List<T> findMultiConditionCombinationQuery_Accurate(Object o) throws DataAccessException, Exception;
	public <T> List<T> findMultiConditionCombinationQuery_Vague_Limit(Object o,final int start ,final int length) throws DataAccessException, Exception;
	public <T> List<T> findMultiConditionCombinationQuery_Accurate_Limit(Object o,final int start ,final int length) throws DataAccessException, Exception;
	public <T> T findById(Class<T> t,Serializable id );
	public <T> T findByNameForSingle(Class<T> t,String str ,String qStr);
	public <T> int findCount(Class<T> t);
	public <T> void saveOperate(T t);
	public <T> void updateOperate(T t);
	public <T> void deleteOperate(T t);
	public <T> void deleteOperate(Class<T> t,Serializable id);
	public int findMultiConditionCombinationQuery_Vague_Count(Object o)throws DataAccessException, Exception;
	public int findMultiConditionCombinationQuery_Accurate_Count(Object o)throws DataAccessException, Exception;
}
