public class Download{
	public static void main(String[] args){
		new Thread(new Down(),"·��һ").start();
		new Thread(new Down(),"·�߶�").start();
	}
}
class Down implements Runnable{
	private int []arr=new int[100];
	public void run(){
		while (true){
		for(int i=0;i<100;i++){
			Thread th=Thread.currentThread();
			String th_name=th.getName();
			System.out.println(th_name+"�������ص�"+i+"���ļ�");
		}
		}
	}
}