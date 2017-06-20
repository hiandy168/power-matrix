import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.matrix.dao.ITLessonRollcallDao;
import com.matrix.pojo.entity.TLessonRollcall;
import com.matrix.util.DateUtil;
import com.matrix.util.UuidUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TLessonRollcallTest {

	@Autowired
	private ITLessonRollcallDao dao;

	@Test
	public void batchInsert() {
		TLessonRollcall entity = new TLessonRollcall();
		entity.setUuid(UuidUtil.uid());
		entity.setCode("RC" + System.currentTimeMillis());
		entity.setScheduleCode("SS2");
		entity.setStudentCode("s1");
		entity.setVerifyCode("123456");
		entity.setCreateUser("admin");
		entity.setCreateTime(DateUtil.getSysDateTime());
		entity.setUpdateUser("admin");
		entity.setUpdateTime(DateUtil.getSysDateTime());
		List<TLessonRollcall> list = new ArrayList<TLessonRollcall>();
		list.add(entity);
		dao.batchInsert(list);
	}
}
