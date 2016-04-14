package com.mySSH.web.daoImpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mySSH.web.dao.OperateDao;
import com.mySSH.web.utils.HqlUtils;

@Repository("operateDao")
public class OperateDaoImpl extends HibernateDaoSupport implements OperateDao {

	@Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<T> t) {
		List<T> list=this.getHibernateTemplate().find("from "+t.getName());
		return list;
	}

	@Override
	public <T> T findById(Class<T> t, Serializable id) {
		T tid=this.getHibernateTemplate().get(t, id);
		return tid;
	}

	@Override
	public <T> void saveOperate(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public <T> void updateOperate(T t) {
		this.getHibernateTemplate().update(t);
		
	}

	@Override
	public <T> void deleteOperate(T t) {
		if(t!=null)
			this.getHibernateTemplate().delete(t);
		
	}

	@Override
	public <T> void deleteOperate(Class<T> t,Serializable id) {
		deleteOperate(getSession().get(t, id));
	}
	/**
	 * 按字段查找返回
	 */
	@Override
	public <T> List<T> findByName(Class<T> t, String str ,String qStr) {
		@SuppressWarnings("unchecked")
		List<T> list=this.getHibernateTemplate().find("from "+t.getName()+" t where t."+qStr+"=?",str);
		return list;
	}
	
	/**
	 * 分页
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findLimit(Class<T> t,final int start ,final int length,String qStr) {
		final String hql = "from "+t.getName()+ " order by "+qStr+" desc";
		   @SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
		       public Object doInHibernate(Session session)
		         throws HibernateException, SQLException {
		         Query query = session.createQuery(hql);
		         query.setFirstResult(start);
		         query.setMaxResults(length);
		         List list = query.list();
		         return list;
		       }
		   });
		   return list;
	}
	/**
	 * 按字段查找返回一个值
	 */
	@Override
	public <T> T findByNameForSingle(Class<T> t, String str, String qStr) {
		@SuppressWarnings("unchecked")
		List<T> list=this.getHibernateTemplate().find("from "+t.getName()+" a where a."+qStr+"=?",str);
		if (list.size()==0)
			return null;
		else return list.get(0);
	}
	/**
	 * 模糊查询
	 */
	@Override
	public <T> List<T> findByVagueName(Class<T> t, String str, String qStr) {
		@SuppressWarnings("unchecked")
		List<T> list=this.getHibernateTemplate().find("from "+t.getName()+" t where t."+qStr+" like ? ","%"+str+"%");
		return list;
	}
	/**
	 * 多条件组合模糊查询
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Vague(Object o) throws DataAccessException, Exception {
		@SuppressWarnings("unchecked")
		List<T> list=this.getHibernateTemplate().find(HqlUtils.newInstanceByObj(o, true).getHql());
		return list;
	}
	/**
	 * 多条件组合精确查询
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Accurate(Object o) throws DataAccessException, Exception {
		@SuppressWarnings("unchecked")
		List<T> list=this.getHibernateTemplate().find(HqlUtils.newInstanceByObj(o, false).getHql());
		return list;
	}
	
	@Override
	public <T> int findCount(Class<T> t) {
		  int count = (Integer)getHibernateTemplate().find("from "+t.getName()).size();
		  return count;
	}
	
	/**
	 * 多条件组合模糊分页查询
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Vague_Limit(Object o,final int start ,final int length)
			throws DataAccessException, Exception {
		final String hql = HqlUtils.newInstanceByObj(o, true).getHql();
		   @SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
		       public Object doInHibernate(Session session)
		         throws HibernateException, SQLException {
		         Query query = session.createQuery(hql);
		         query.setFirstResult(start);
		         query.setMaxResults(length);
		         List list = query.list();
		         return list;
		       }
		   });
		   return list;
	}

	/**
	 * 多条件组合精确分页查询
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findMultiConditionCombinationQuery_Accurate_Limit(Object o,final int start ,final int length)
			throws DataAccessException, Exception {
		final String hql = HqlUtils.newInstanceByObj(o, false).getHql();
		   @SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
		       public Object doInHibernate(Session session)
		         throws HibernateException, SQLException {
		         Query query = session.createQuery(hql);
		         query.setFirstResult(start);
		         query.setMaxResults(length);
		         List list = query.list();
		         return list;
		       }
		   });
		   return list;
	}
	
	/**
	 * 多条件组合模糊查询,返回条数
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	@Override
	public int findMultiConditionCombinationQuery_Vague_Count(Object o)
			throws DataAccessException, Exception {
		int count = getHibernateTemplate().find(HqlUtils.newInstanceByObj(o, true).getHql()).size();
	    return count;
	}

	/**
	 * 多条件组合精确查询,返回条数
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	@Override
	public int findMultiConditionCombinationQuery_Accurate_Count(
			Object o) throws DataAccessException, Exception {
		int count = getHibernateTemplate().find(HqlUtils.newInstanceByObj(o, false).getHql()).size();
	    return count;
	}
}
