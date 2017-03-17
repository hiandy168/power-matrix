
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.matrix.dao.ITTeacherDao;
import com.matrix.pojo.entity.TTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TeacherTest {

	@Autowired
	private ITTeacherDao dao;
	
	@org.junit.Test
	public void getSyllabus(){
		String code = "T1489071763988";
		List<TTeacher> list = dao.getSyllabus(code);
		System.out.println(JSONObject.toJSON(list));
	}
}