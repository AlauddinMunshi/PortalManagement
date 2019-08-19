
public class Studenttype{

	public String studentName;
	public int 	studentId;
	public String password;
	public String answer;
	public String dept;
	public String course1;
	public String course2;
	public String course3;
	
	public Studenttype(String name,int id,String password,String answer,String dept,String course1,String course2,String course3){
		this.studentName=name;
		this.studentId = id;
		this.password=password;
		this.answer=answer;
		this.dept=dept;
		this.course1=course1;
		this.course2=course2;
		this.course3=course3;
	}
	
	
	public void setStudentName(String name){
		this.studentName=name;
	}
	public String getStudentName(){
		return this.studentName;
	}
	public String getDept(){
		return this.dept;
	}
	
	public void setStudentPassword(String password){
		this.password=password;
	}
	public String getStudentAnswer(){
		return this.answer;
	}
	public String getPassword(){
		return this.password;
	}
	public String getCourse1(){
		return this.course1;
	}
	public String getCourse2(){
		return this.course2;
	}
	public String getCourse3(){
		return this.course3;
	}
	
	public void setstudentId(int id){
		this.studentId=id;
	}
	public int getstudentId(){
		return this.studentId;
	}
}