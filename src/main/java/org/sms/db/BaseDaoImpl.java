package org.sms.db;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T> implements BaseDaoI<T> {
	@Autowired
	public SessionFactory sessionFactory;
	
	/**
	 * 获取当前事务的session
	 * @return
	 */
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T o) {
		if(o != null)
			return this.getCurrentSession().save(o);
		return null;
	}

	@Override
	public void delete(T o) {
		if(o != null)
			this.getCurrentSession().delete(o);
	}

	@Override
	public void update(T o) {
		if(o != null)
			this.getCurrentSession().update(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		if(o != null)
			this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		return (T)this.getCurrentSession().get(c, id);
	}

	@Override
	public T get(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		List<T> l = query.list();
		if(l != null && l.size() > 0)
			return l.get(0);
		return null;
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		List<T> l = query.list();
		if(l != null && l.size() > 0)
			return l.get(0);
		return null;
	}

	@Override
	public List<T> find(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query query = this.getCurrentSession().createQuery(hql);
		query.setFirstResult((page - 1) * rows)
			.setMaxResults(rows);
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page,
			int rows) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		query.setFirstResult((page - 1) * rows)
			.setMaxResults(rows);
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page,
			int rows, String als, Class<T> clz) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		query.setEntity(als, clz)
			.setFirstResult((page - 1) * rows)
			.setMaxResults(rows);
		List<T> l = query.list();
		return l;
	}

	@Override
	public Long count(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		return (Long)query.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		return (Long)query.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		return (BigInteger)query.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		return (BigInteger)query.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		return query.executeUpdate();
	}

	@Override
	public int executeSql(String sql) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		return query.executeUpdate();
	}

	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		return query.executeUpdate();
	}

	@Override
	public List<T> findListBySql(String sql) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		List<T> l = query.list();
		return l;
	}

	@Override
	public List findListBySql1(String sql) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}

	@Override
	public List<T> findListBySql(String sql, int page, int rows) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		query.setFirstResult((page-1)*rows)
			.setMaxResults(rows);
		return query.list();
	}

	@Override
	public List<T> findListBySql(String sql, Map<String, Object> params) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<T> findListBySql(String sql, Map<String, Object> params,
			int page, int rows) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		query.setFirstResult((page-1)*rows)
			.setMaxResults(rows);
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<T> findListBySql(String sql, Map<String, Object> params,
			int page, int rows, String als, Class<T> clz) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		query.setEntity(als, clz)
			.setFirstResult((page-1)*rows)
			.setMaxResults(rows);
		List<T> l = query.list();
		return l;
	}

	@Override
	public List<Object[]> findBySql(String sql) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}

	@Override
	public List<Object[]> findBySql(String sql, int page, int rows) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		query.setFirstResult((page-1)*rows)
			.setMaxResults(rows);
		return query.list();
	}

	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}

	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params,
			int page, int rows) {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if(params != null && params.size() > 0){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		query.setFirstResult((page-1)*rows)
			.setMaxResults(rows);
		return query.list();
	}

	@Override
	public List<Map> castListMap(String[] columns, List list) {
		List<Map> listvo = new ArrayList<Map>();
		if(list == null || list.size() == 0)
			return listvo;
		if(columns == null || columns.length == 0)
			return null;
		int columnsCount = columns.length;
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Map nmap = new HashMap();
			try {
				Object[] values = (Object[])iterator.next();
				for(int i = 0;i < columnsCount;i++){
					nmap.put(columns[i], values[i]);
				}
				listvo.add(nmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listvo;
	}

	@Override
	public List<Map> castListMap(String sql, List list) throws Exception {
		List<Map> listvo = new ArrayList<Map>();
		if(list == null || list.size() == 0)
			return listvo;
		if(sql == null)
			throw new Exception("castListMap : sql is null");
		List<String> columns = this.getSqlColumns(sql);
		int columnsCount = columns.size();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Map nmap = new HashMap();
			try {
				Object[] values = (Object[])iterator.next();
				for(int i = 0;i < columnsCount;i++){
					nmap.put(columns.get(i), values[i]);
				}
				listvo.add(nmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listvo;
	}

	@Override
	public void updateBySql(String sql, Object... values) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		if(values != null){
			for(int i = 0;i < values.length;i++){
				sqlQuery.setParameter(i, values[i]);
			}
		}
		sqlQuery.executeUpdate();
	}

	@Override
	public boolean saveOrUpdateAll(Collection<T> entities) {
		try {
			for(T entity : entities){
				this.save(entity);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Object castClasstypeToObject(Class clz, String value) {
		if(value == null)
			return null;
		String className = clz.getSimpleName();
		if("String".equals(className))
			return new String(value);
		if("Date".equals(className)){
			try {
				if(value == null || "".equals(value))
					return null;
				if(value.indexOf(":") != -1){
					return DateUtils.parseDate(value, new String[]{"yyyy-MM-dd HH:mm:ss"});
				}else{
					return DateUtils.parseDate(value, new String[]{"yyyy-MM-dd"});
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		try {
			if("int".equals(className))
				return Integer.parseInt(value);
			if("Integer".equals(className))
				return Integer.valueOf(value);
			if("long".equals(className))
				return Long.parseLong(value);
			if("Long".equals(className))
				return Long.valueOf(value);
			if("Double".equals(className))
				return Double.valueOf(value);
			if("double".equals(className))
				return Double.parseDouble(value);
			if("Float".equals(className))
				return Float.valueOf(value);
			if("float".equals(className))
				return Float.parseFloat(value);
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public List<String> getSqlColumns(final String sql){
		final List<String> columns = new ArrayList<String>();
		this.getCurrentSession().doWork(new Work() {
			@Override
			public void execute(Connection con) throws SQLException {
				Statement stamt = con.createStatement();
				ResultSet rs = stamt.executeQuery(sql);
				ResultSetMetaData rsMeta = rs.getMetaData();
				for(int i = 1;i <= rsMeta.getColumnCount();i++){
					columns.add(rsMeta.getColumnName(i));
				}
			}
		});
		return columns;
	}
}
