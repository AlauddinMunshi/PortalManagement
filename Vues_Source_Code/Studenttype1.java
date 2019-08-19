
public class Studenttype1{

	public String studentName;
	public int 	studentId;
	public String dept;
	public String course1;
	public String course2;
	public String course3;
	
	public Studenttype1(String name,int id,String dept,String course1,String course2,String course3){
		this.studentName=name;
		this.studentId = id;
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