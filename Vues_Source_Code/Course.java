
public class Course{

	public String 	courseName;
	public int 	courseId;
	public int courseCredit;
	public int 	courseFee;
	public int courseCapacity;
	public String dept;
	public Course(){
		this("undefined",0,0,0,0,"undefined") ;
	}
	
	public Course(String name,int id,int credit,int courseFee, int capacity,String dept){
		this.courseName=name;
		this.courseId = id;
		this.courseCredit=credit;
		this.courseFee=courseFee;
		this.courseCapacity=capacity;
		this.dept=dept;
	}
	
	
	public void setCourseName(String name){
		this.courseName=name;
	}
	public String getCourseName(){
		return this.courseName;
	}
	public String getCourseDept(){
		return this.dept;
	}
	
	public void setCourseFee(int courseFee){
		this.courseFee=courseFee;
	}
	public int getCourseCredit(){
		return this.courseCredit;
	}
	public int getCourseFee(){
		return this.courseFee;
	}
	
	public void setCourseId(int courseId){
		this.courseId=courseId;
	}
	public int getCourseId(){
		return this.courseId;
	}
	public int getCourseCapacity(){
		return this.courseCapacity;
	}
}