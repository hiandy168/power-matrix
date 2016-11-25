package com.matrix.base;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.base.interfaces.IBaseDao;
import com.matrix.base.interfaces.IBaseService;

/**
 * @descriptions 底层实现类
 * 
 * @param <T>
 * @param <Pk>
 * @date 2016年5月19日下午4:48:21
 * @author Yangcl
 * @version 1.0.1
 */
public class BaseServiceImpl<T, PK extends Serializable> extends BaseClass implements IBaseService<T, PK> {


	/**
	 * 	   @ Autowired标签按byType(即：Class)自动注入; @ Resource标签默认按byName(即：类型名称)自动注入。
	 * 针对这句代码【public BaseDao<T,PK> baseDao;】如果你用@Resource的方式进行注入
	 * 那么会报这个异常：NoUniqueBeanDefinitionException:No qualifying bean of type
	 * [com.yangcl.springmvc.base.BaseDao] is defined: expected single matching bean
	 * but found 2: bookDao,userDao
	 * 	   原因在于BookDao和UserDao都继承了BaseDao，他们的实现代码是这样的：
	 * public interface BookDao extends BaseDao<Book , Integer>
	 * public interface UserDao extends BaseDao<User, Integer>
	 * 当在这个位置注入了【baseDao】后，Spring会去找对应的实现类，此时出现了2个接口，
	 * 他们都继承了BaseDao，而@Resource标签默认按byName去找实现的Bean，Spring面对
	 * 两个类型名称相同的Bean会无法判断需要注入哪一个。
	 */
	@Autowired
	public IBaseDao<T, PK> baseDao;

	@Override
	public Integer insertSelective(T entity) {
		return baseDao.insertSelective(entity);
	}

	@Override
	public Integer insertGotEntityId(T entity) {
		return baseDao.insertGotEntityId(entity);
	}

	@Override
	public Integer insertGotEntityUuid(T entity) {
		return baseDao.insertGotEntityUuid(entity);
	}

	@Override
	public Integer batchInsert(List<T> list) {
		return baseDao.batchInsert(list);
	}

	@Override
	public Integer updateSelective(T entity) {
		return baseDao.updateSelective(entity);
	}

	@Override
	public Integer batchUpdate(List<T> list) {
		return baseDao.batchUpdate(list);
	}

	@Override
	public Integer deleteById(PK id) {
		return baseDao.deleteById(id);
	}

	@Override
	public Integer batchDelete(List<Integer> list) {
		return baseDao.batchDelete(list);
	}

	@Override
	public <DTO> void deleteByCondition(DTO dto) {
		baseDao.deleteByCondition(dto);
	}

	@Override
	public T find(PK id) {
		return baseDao.find(id);
	}

	@Override
	public List<T> findList(T entity) {
		return baseDao.findList(entity);
	}

	@Override
	public <DTO> List<T> findGroupList(DTO dto) {
		return baseDao.findGroupList(dto);
	}

	@Override
	public int count(T entity) {
		return baseDao.count(entity);
	}

	@Override
	public List<T> queryPage(T entity) {
		return baseDao.queryPage(entity);
	}

	@Override
	public List<T> like(T entity) {
		return baseDao.like(entity);
	}

	@Override
	public Integer selectMaxId() {
		return baseDao.selectMaxId();
	}
	
	@Override
	public JSONObject jsonList(T entity) {
		JSONObject result = new JSONObject();
		List<T> list = baseDao.findList(entity);
		if (list != null && list.size() > 0) {
			result.put("status", "success");
			result.put("list", list);
			return result;
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090001)); // 结果集为空
			return result;
		}
	}

	@Override
	public JSONObject ajaxPageData(T entity, HttpServletRequest request) {
		JSONObject result = new JSONObject();
		String pageNum = request.getParameter("pageNum"); // 当前第几页
		String pageSize = request.getParameter("pageSize"); // 当前页所显示记录条数
		int num = 1;
		int size = 10;
		if (StringUtils.isNotBlank(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		if (StringUtils.isNotBlank(pageSize)) {
			size = Integer.parseInt(pageSize);
		}

		/*
		 * 如果分页参数当前页为空，默认为0，页面最大显示数为空，默认为10
		 */
//		String sortString = "create_time.desc";
//		Order.formString(sortString); 
		PageHelper.startPage(num, size);
		List<T> list = baseDao.queryPage(entity);
		if (list != null && list.size() > 0) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		PageInfo<T> pageList = new PageInfo<T>(list);
		result.put("data", pageList);
		result.put("entity", entity);
		return result;
	}

}
























