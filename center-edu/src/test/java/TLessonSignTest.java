import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.matrix.dao.ITLessonSignDao;
import com.matrix.pojo.entity.TLessonSign;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TLessonSignTest {

	@Autowired
	private ITLessonSignDao dao;

	@org.junit.Test
	public void updateEvaluate() {
		TLessonSign entity = new TLessonSign();
		entity.setScheduleCode("SS2");
		entity.setStudentCode("s1");
		entity.setFlagEvaluate(1);
		entity.setUpdateUser("admin");
		entity.setUpdateTime(new Date());
		dao.updateEvaluate(entity);
	}
}
