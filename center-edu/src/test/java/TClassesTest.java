import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.matrix.dao.ITClassesDao;
import com.matrix.pojo.entity.TClasses;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class TClassesTest {

	@Autowired
	private ITClassesDao dao;

	public void findClassesByCodes() {
		List<String> codes = new ArrayList<String>();
		codes.add("C198797");
		codes.add("C268676");
		List<TClasses> list = dao.findClassesByCodes(codes);
		System.out.println(JSON.toJSON(list));
	}
}
