package org.sms.db;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础数据库操作类
 * 其他DAO继承此类获取常用的数据库操作方法
 * @author ZMZY
 *
 * @param <T>
 */
public interface BaseDaoI<T> {
	/**
	 * 保存一个对象
	 * @param o 对象
	 * @return 对象的ID
	 */
	public Serializable save(T o);
	
	/**
	 * 删除一个对象
	 * @param o 对象
	 */
	public void delete(T o);
	
	/**
	 * 更新一个对象
	 * @param o 对象
	 */
	public void update(T o);
	
	/**
	 * 保存或更新一个对象
	 * @param o 对象
	 */
	public void saveOrUpdate(T o);
	
	
	/**
	 * 通过主键获得对象
	 * @param c 类名.class
	 * @param id 主键
	 * @return 对象
	 */
	public T get(Class<T> c,Serializable id);
	
	/**
	 * 通过HQL语句获取一个对象
	 * @param hql HQL语句
	 * @return 对象
	 */
	public T get(String hql);
	
	/**
	 * 通过HQL语句获取一个对象
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 对象
	 */
	public T get(String hql,Map<String,Object> params);
	
	/**
	 * 获取对象列表
	 * @param hql HQL语句
	 * @return List
	 */
	public List<T> find(String hql);
	
	/**
	 * 获取对象列表
	 * @param hql HQL语句
	 * @param params 参数
	 * @return List
	 */
	public List<T> find(String hql,Map<String,Object> params);
	
	/**
	 * 获得分页后的对象列表
	 * @param hql HQL语句
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @return List
	 */
	public List<T> find(String hql,int page,int rows);
	
	/**
	 * 获得分页后的对象列表
	 * @param hql HQL语句
	 * @param params 参数
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @return List
	 */
	public List<T> find(String hql,Map<String,Object> params,int page,int rows);
	
	/**
	 * 获得分页后的对象列表
	 * @param hql HQL语句
	 * @param params 参数
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @param als 别名
	 * @param clz class
	 * @return List
	 */
	public List<T> find(String hql,Map<String,Object> params,int page,int rows,String als,Class<T> clz);
	
	
	/**
	 * 统计条目
	 * @param hql HQL语句(select count(*) from T)
	 * @return
	 */
	public Long count(String hql);
	
	/**
	 * 统计条目
	 * @param hql HQL语句(select count(*) from T where xx = :xx)
	 * @return
	 */
	public Long count(String hql,Map<String,Object> params);
	
	/**
	 * 统计条目
	 * @param sql
	 * @return
	 */
	public BigInteger countBySql(String sql);
	
	/**
	 * 统计条目
	 * @param sql
	 * @return
	 */
	public BigInteger countBySql(String sql,Map<String,Object> params);
	
	
	/**
	 * 执行一条HQL语句
	 * @param hql HQL语句
	 * @return 影响结果数目
	 */
	public int executeHql(String hql);
	
	/**
	 * 执行一条HQL语句
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 影响结果数目
	 */
	public int executeHql(String hql,Map<String,Object> params);
	
	/**
	 * 执行SQL语句
	 * @param hql SQL语句
	 * @return 影响结果数目
	 */
	public int executeSql(String sql);
	
	/**
	 * 执行SQL语句
	 * @param hql SQL语句
	 * @param params 参数
	 * @return 影响结果数目
	 */
	public int executeSql(String sql,Map<String,Object> params);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @return 结果集
	 */
	public List<T> findListBySql(String sql);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @return 结果集
	 */
	public List findListBySql1(String sql);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @return 结果集
	 */
	public List<T> findListBySql(String sql,int page,int rows);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param params 参数
	 * @return 结果集
	 */
	public List<T> findListBySql(String sql,Map<String,Object> params);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param params 参数
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @return 结果集
	 */
	public List<T> findListBySql(String sql,Map<String,Object> params,int page,int rows);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param params 参数
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @param als 别名
	 * @param clz 类
	 * @return 结果集
	 */
	public List<T> findListBySql(String sql,Map<String,Object> params,int page,int rows,String als,Class<T> clz);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql,int page,int rows);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param params 参数
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql,Map<String,Object> params);
	
	/**
	 * 获取结果集
	 * @param sql SQL语句
	 * @param params 参数
	 * @param page 要显示第几页
	 * @param rows 每页显示多少条
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql,Map<String,Object> params,int page,int rows);
	
	public List<Map> castListMap(String[] columns,List list);
	
	public List<Map> castListMap(String sql,List list) throws Exception ;
	
	public void updateBySql(String sql,Object... values);
	
	public boolean saveOrUpdateAll(Collection<T> entities);
	
	public Object castClasstypeToObject(Class clz,String value);
}
