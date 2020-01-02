package biz;
import view.*;
import dao.CourseDao;
import dao.StudentDao;
import entity.Course;
import entity.IEntity;
import entity.Student;
import view.MainUI;
import view.*;
public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	//登录
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			MainUI.show();
		} else {
			System.out.println("密码不正确");
			MainUI.show();
		}

	}
	//注册，业务逻辑实现
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) {
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentGender(studentGender);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			studentDao.update();
			
			System.out.println("注册成功！");
			MainUI.show();
		}else {
			System.out.println("两次密码输入不一致，注册失败，按回车重新注册");
			RegisterUI.show();
		}
	}
	//修改密码
	public void modifypassword(String studentNo,
							   String studentPassword,
							   String firstPassword,
							   String secondPassword){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");
			return;
		} else {
				if (student.getStudentPassword().equals(studentPassword)) {
				System.out.println("旧密码输入成功");
				}
				else{
					System.out.println("旧密码输入错误，请重新输入");
					MainUI.show();
				}
				if(firstPassword.equals(secondPassword)){
					student = new Student();
					student.setStudentPassword(secondPassword);
					studentDao = StudentDao.getInstance();
					studentDao.update();
					System.out.println("修改密码成功！");
					MainUI.show();
				}
				else{
					System.out.println("修改密码失败！两次密码输入不一致！");
					MainUI.show();
				}
		}
		
		
	}
	//删除学生
	public void remove(String studentno){
		studentDao=StudentDao.getInstance();
		Student student2=(Student)studentDao.getEntity(studentno);
		if(student2!=null){
			student2.setStudentNo(null);
			studentDao.delete();
		}else{
			System.out.println("学号输入错误");
		}
		MainUI.show();
	}
}
