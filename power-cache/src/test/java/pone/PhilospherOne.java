package pone;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @descriptions 哲学家进餐问题
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年5月4日 下午10:46:23
 * @version 1.0.1
 */
public class PhilospherOne extends Thread {
	
	private static int time = 10;
	
	private boolean eating;
	private PhilospherOne left;
	private PhilospherOne right;
	private ReentrantLock table;
	private Condition condition;
	
	private String name ;
	
	public PhilospherOne(ReentrantLock table , String name) {
		this.eating = false;
		this.table = table;
		this.condition = table.newCondition();
		this.name = name;
	}

	public void setLeft(PhilospherOne left) {
		this.left = left;
	}
	public void setRight(PhilospherOne right) {
		this.right = right;
	}

	public void run(){
		try {
			for(int i = 1 ; i < 101; i ++){
				this.think(i);
				this.eat(i , (i == 100));  
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void think(int i) throws InterruptedException{
		table.lock();
		try {
			eating = false;
			left.condition.signal();       // 唤醒线程
			right.condition.signal();
		}finally{
			table.unlock();   
		}
		
		System.out.println("第 " + i + " 次   " + name + " 在看书 ");
		Thread.sleep(time);
	}

	private void eat(int i , boolean last) throws InterruptedException{
		table.lock();
		try { 
			if( i == 100){
				System.out.println(name); 
			}
			
			if(left.eating || right.eating){
				if(!last){
					condition.await();   // 阻塞线程
				}else{
					eating = false;
					System.out.println(name + " last = " +last); 
				}
				String msg = "";
				if(left.eating && !right.eating){
					msg = left.name + "正在吃饭 ";
				}else if (!left.eating && right.eating){
					msg = right.name + "正在吃饭 ";
				}else if(left.eating && right.eating){
					msg = left.name  + " 和 " + right.name + "都在吃饭 擦擦！！";
				}else{
					msg = left.name  + " 和 " + right.name + "都在参悟";
				}
				
				System.out.println("第 " + i + " 轮   " + name + " 没吃到饭，又去参悟了，然而：" + msg);
			}else{
				eating = true;
				System.out.println("第 " + i + " 轮   " + name + " 吃到饭了 ");
			}
		}finally{
			table.unlock();
		}
		
		Thread.sleep(time);  
	}





	public static void main(String[] args) {
		ReentrantLock table = new ReentrantLock();
		PhilospherOne p1 = new PhilospherOne(table , "东邪");
		PhilospherOne p2 = new PhilospherOne(table , "西毒"); 
		PhilospherOne p3 = new PhilospherOne(table , "中神");
		PhilospherOne p4 = new PhilospherOne(table , "南帝");
		PhilospherOne p5 = new PhilospherOne(table , "北丐");
		p1.setLeft(p5);
		p1.setRight(p2);
		
		p2.setLeft(p1);
		p2.setRight(p3);
		
		p3.setLeft(p2);
		p3.setRight(p4);
		
		p4.setLeft(p3);
		p4.setRight(p5);
		
		p5.setLeft(p4);
		p5.setRight(p1); 
		
		p1.start();   
		p2.start();
		p3.start();   
		p4.start();
		p5.start(); 
		
//		p1.stop();
//		p2.stop();
//		p3.stop();
//		p4.stop();
//		p5.stop(); 
	}

}





























