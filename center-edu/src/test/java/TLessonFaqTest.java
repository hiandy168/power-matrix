import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.matrix.dao.ITLessonFaqDao;
import com.matrix.pojo.entity.TLessonFaq;
import com.matrix.util.UuidUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TLessonFaqTest {

	@Autowired
	private ITLessonFaqDao dao;

	@Test
	public void insert() {
		TLessonFaq entity = new TLessonFaq();
		entity.setUuid(UuidUtil.uid());
		entity.setCode("LF" + System.currentTimeMillis());
		entity.setScheduleCode("SS2");
		entity.setParentCode("LF1489840268503");
		entity.setCreateUser("T1489071763988");
		entity.setUpdateUser("T1489071763988");
		entity.setCreateTime("2017-03-19 19:00:00");
		entity.setUpdateTime("2017-03-19 19:00:00");
		entity.setContent("this is test answer yes");
		dao.insertSelective(entity);
	}

	public void getFaqForStudent() {
		String code = "s1";
		List<TLessonFaq> list = dao.getFaqForStudent(code);
		System.out.println(JSON.toJSON(list));
	}

	public void getFaqForTeacher() {
		String teacherCode = "T1489071763988";
		List<TLessonFaq> list = dao.getFaqForTeacher(teacherCode);
		System.out.println(JSON.toJSON(list));
	}
}
