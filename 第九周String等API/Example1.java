
public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  System.out.println("增加学生信息");
  add();
  System.out.println("删除学生信息");
  remove();
  System.out.println("修改学生信息");
  alter();
  System.out.println("查找学生信息");
  find();
	}
public static void add() {
	StringBuffer sb=new StringBuffer("164801001 张三；164801002 李四");
	sb.append("164801001 张三;164801002 李四;164801003 王五");
	 System.out.println("append添加结果："+sb);
	sb.insert(14,"164801003 王五");
	System.out.println("insert添加结果："+sb);
}
public static void remove() {
	StringBuffer sb=new StringBuffer("164801001 张三；164801002 李四");
	sb.delete(1,9);
	System.out.println("删除指定位置学号："+sb);
	sb.deleteCharAt(2);
	System.out.println("删除指定位置信息："+sb);
	sb.delete(0,sb.length());
	System.out.println("删除所有信息："+sb);
}
public static void alter() {
	StringBuffer sb=new StringBuffer("174801001 张三；164801002 李四");
	sb.setCharAt(1,'6');
	System.out.println("修改错误信息："+sb);
	sb.replace(1,3,"11");
	System.out.println("替换指定位置信息："+sb);
	System.out.println("信息翻转结果："+sb.reverse());
}
public static void find() {
	StringBuffer sb=new StringBuffer("164801001 张三；164801002 李四");
	sb.toString();
	System.out.println("第一名学号信息："+sb.substring(0,9));
}
}