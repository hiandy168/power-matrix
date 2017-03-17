import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.matrix.dao.ITStudentEvaluateDao;
import com.matrix.pojo.entity.TStudentEvaluate;
import com.matrix.util.UuidUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TStudentEvaluateTest {

	@Autowired
	private ITStudentEvaluateDao dao;

	@Test
	public void insert() {
		TStudentEvaluate entity = new TStudentEvaluate();
		entity.setUuid(UuidUtil.uid());
		entity.setScheduleCode("123");
		entity.setStudentCode("12321");
		entity.setCreateUser("admin");
		entity.setScore(10);
		entity.setCreateTime(new Date());
		dao.insertSelective(entity);
	}
}
