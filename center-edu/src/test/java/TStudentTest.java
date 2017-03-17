import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.matrix.dao.ITStudentDao;
import com.matrix.pojo.dto.LessonSignDto;
import com.matrix.pojo.entity.TStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TStudentTest {

	@Autowired
	private ITStudentDao dao;

	@org.junit.Test
	public void findStudentSignByLessonAndClass() {
	}
}
