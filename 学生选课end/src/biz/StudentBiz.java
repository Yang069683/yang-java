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
	//��¼
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ");
			MainUI.show();
		}

	}
	//ע�ᣬҵ���߼�ʵ��
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
			
			System.out.println("ע��ɹ���");
			MainUI.show();
		}else {
			System.out.println("�����������벻һ�£�ע��ʧ�ܣ����س�����ע��");
			RegisterUI.show();
		}
	}
	//�޸�����
	public void modifypassword(String studentNo,
							   String studentPassword,
							   String firstPassword,
							   String secondPassword){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else {
				if (student.getStudentPassword().equals(studentPassword)) {
				System.out.println("����������ɹ�");
				}
				else{
					System.out.println("�����������������������");
					MainUI.show();
				}
				if(firstPassword.equals(secondPassword)){
					student = new Student();
					student.setStudentPassword(secondPassword);
					studentDao = StudentDao.getInstance();
					studentDao.update();
					System.out.println("�޸�����ɹ���");
					MainUI.show();
				}
				else{
					System.out.println("�޸�����ʧ�ܣ������������벻һ�£�");
					MainUI.show();
				}
		}
		
		
	}
	//ɾ��ѧ��
	public void remove(String studentno){
		studentDao=StudentDao.getInstance();
		Student student2=(Student)studentDao.getEntity(studentno);
		if(student2!=null){
			student2.setStudentNo(null);
			studentDao.delete();
		}else{
			System.out.println("ѧ���������");
		}
		MainUI.show();
	}
}
