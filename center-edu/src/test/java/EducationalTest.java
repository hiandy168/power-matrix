import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.matrix.service.IEducationalService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class EducationalTest {

	@Autowired
	private IEducationalService service;

	@Test
	public void teacherSyllabus() {
		JSONObject obj = service.teacherSyllabus("T1489071763988");
		System.out.println(obj);
	}
}
