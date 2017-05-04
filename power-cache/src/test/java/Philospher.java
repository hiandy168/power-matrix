import java.util.Random;
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
public class Philospher extends Thread {
	
	private boolean eating;
	private Philospher left;
	private Philospher right;
	private ReentrantLock table;
	private Condition condition;
	private Random random;
	
	private String name ;
	
	public Philospher(ReentrantLock table , String name) {
		this.eating = false;
		this.table = table;
		this.condition = table.newCondition();
		this.random = new Random();
		this.name = name;
	}

	public void setLeft(Philospher left) {
		this.left = left;
	}
	public void setRight(Philospher right) {
		this.right = right;
	}

	public void run(){
		for(int i = 1 ; i < 1000; i ++){
			try {
				this.think(i);
				this.eat(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void think(int i) throws InterruptedException{
		table.lock();
		try {
			eating = false;
			left.condition.signal();
			right.condition.signal();
		}finally{
			table.unlock();   
		}
		
		System.out.println("第 " + i + " 次   " + name + " 在看书 ");
		Thread.sleep(1000);
	}

	private void eat(int i) throws InterruptedException{
		table.lock();
		try {
			while(left.eating || right.eating){
				condition.await();
			}
			eating = true;
		}finally{
			table.unlock();
		}
		System.out.println("第 " + i + " 次   " +name + " 跑去吃饭了 ");
		Thread.sleep(1000); 
	}





	public static void main(String[] args) {
		ReentrantLock table = new ReentrantLock();
		Philospher p1 = new Philospher(table , "东邪");
		Philospher p2 = new Philospher(table , "西毒"); 
		Philospher p3 = new Philospher(table , "中神");
		Philospher p4 = new Philospher(table , "南帝");
		Philospher p5 = new Philospher(table , "北丐");
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
	}

}





























