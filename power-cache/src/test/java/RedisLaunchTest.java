import com.matrix.redis.core.enums.SRedisEnum;
import com.matrix.redis.launch.RedisLaunch;

/**
 * @descriptions 测试类
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年12月12日 下午11:14:53
 * @version 1.0.1
 */
public class RedisLaunchTest {

	public static void main(String[] args) {
		RedisLaunch.setFactoryService(SRedisEnum.Test).del("22222222");  
		System.out.println("aaa"); 
	}
}
