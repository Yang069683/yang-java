public class Example4{
	public static void main(String[]args){
		Car c=new Car();
		new Thread(c,"车1").start();
		new Thread(c,"车2").start();
		new Thread(c,"车3").start();
		new Thread(c,"车4").start();
		new Thread(c,"车5").start();
	}
}
class Car implements Runnable{
	private int passenger=100;
	public void run(){
while(true){
if (passenger>0){
			Thread th=Thread.currentThread();
			String th_name=th.getName();
			System.out.println(th_name+"正在载第"+passenger--+"个乘客");
		}
}
}
}