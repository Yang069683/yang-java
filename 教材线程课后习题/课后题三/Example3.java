public class Example3{
	public static void main(String[] args){
		Teacher t=new Teacher();
		new Thread(t,"����ʦ").start();
		new Thread(t,"����ʦ").start();
		new Thread(t,"ţ��ʦ").start();
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
				System.out.println(th_name+"���ڷ��ʼ�"+notes--);
			}
		}
	}
}
				