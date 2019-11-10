import java.util.Random;
class Storage{
	 private String[]cells=new String[10];
	 private int inPos,outPos;
	 private int count;
	
	public synchronized void put(String name){
	   try{
		   while(count==cells.length){
			   this.wait();
		   }
	   cells[inPos]=name;
	   System.out.println("cells["+inPos+"]登录用户"+cells[inPos]);
	   inPos++;
	   if(inPos==cells.length)
	   inPos=0;
	   count++;
	   this.notify();
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	 }
	public synchronized void get(){
		 try{
			 while(count==0){
				 this.wait();
			 }
	  String name=cells[outPos];
	  System.out.println("cells["+outPos+"]用户注销"+name);
	  cells[outPos]=String.valueOf(0);
	  outPos++;
	  if(outPos==cells.length)
	  outPos=0; 
	  count--;
	  this.notify();
		 }catch(Exception e){
			   e.printStackTrace();
		   }
	  }
}


class Input implements Runnable{
	  private Storage st;
	  Random r=new Random();
	  Input(Storage st){
	  this.st=st;
	  }
	  public void run(){
	    while(true){
	      st.put(String.valueOf(r.nextInt(100)));
	  }
	   try{
	   Thread.sleep(r.nextInt(100));
	   }catch(Exception e){
			   e.printStackTrace();
		   }
	}

class Output implements Runnable{
	   private Storage st;
	   Random r=new Random();
	   Output(Storage st){
	   this.st=st;
	   }
	   public void run(){
	   while(true){
	     st.get();
	         }
	     }
}
public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage st=new Storage();
		Input input=new Input(st);
		Output output=new Output(st);
		new Thread(input).start();
		new Thread(output).start();
	}

}