
public class Teachertype{

	public String 	teacherName;
	public int 	teacherId;
	public String password;
	public String answer;
	public String dept;
	public int salary;
	
	public Teachertype(String name,int id,String password,String answer,String dept,int salary){
		this.teacherName=name;
		this.teacherId = id;
		this.password=password;
		this.answer=answer;
		this.dept=dept;
		this.salary=salary;
	}
	
	
	public void setTeacherName(String name){
		this.teacherName=name;
	}
	public String getTeacherName(){
		return this.teacherName;
	}
	public String getDept(){
		return this.dept;
	}
	
	public void setTeacherPassword(String password){
		this.password=password;
	}
	public String getTeacherAnswer(){
		return this.answer;
	}
	public String getPassword(){
		return this.password;
	}
	
	public void setTeacherId(int id){
		this.teacherId=id;
	}
	public int getTeacherId(){
		return this.teacherId;
	}
	public int getSalary(){
		return this.salary;
	}
}