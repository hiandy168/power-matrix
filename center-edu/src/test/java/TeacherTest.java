
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.matrix.dao.ITTeacherDao;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.service.ITTeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TeacherTest {

	@Autowired
	private ITTeacherDao dao;
	@Autowired
	private ITTeacherService service;
	
	public void getSyllabus(){
		String code = "T1489071763988";
		List<TTeacher> list = dao.getSyllabus(code);
		System.out.println(JSONObject.toJSON(list));
	}
	
	public void getLessons(){
		String code = "T1489071763988";
		List<TTeacher> list = dao.getLessons(code);
		System.out.println(JSONObject.toJSON(list));
	}
	
	@Test
	public void getEvaluateDetail(){
		Integer id=20;
		System.out.println(service.getEvaluateDetail(id));
	}
}