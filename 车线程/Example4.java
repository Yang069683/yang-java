public class Example4{
	public static void main(String[]args){
		Car c=new Car();
		new Thread(c,"��1").start();
		new Thread(c,"��2").start();
		new Thread(c,"��3").start();
		new Thread(c,"��4").start();
		new Thread(c,"��5").start();
	}
}
class Car implements Runnable{
	private int passenger=100;
	public void run(){
while(true){
if (passenger>0){
			Thread th=Thread.currentThread();
			String th_name=th.getName();
			System.out.println(th_name+"�����ص�"+passenger--+"���˿�");
		}
}
}
}