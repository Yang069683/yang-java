public class Example3{
	public static void main(String[] args){
		Teacher t=new Teacher();
		new Thread(t,"陈老师").start();
		new Thread(t,"杨老师").start();
		new Thread(t,"牛老师").start();
	}
}
class Teacher implements Runnable{
	private int notes=80;
	public void run(){
		while(true){
			if (notes<=0){
				break;
			}
			else{
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在发笔记"+notes--);
			}
		}
	}
}
				