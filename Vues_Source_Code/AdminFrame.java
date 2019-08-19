
import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame{
	
	AdminProfile aProfile;
	AdminCCourse aCreate;
	AdminCreateTeacher 	aTeacher;
	AdminOfferedCourse aOffered;
    AdminCreateStudent aStd;
	TeacherList tList;
	StudentList sList;
	JTabbedPane			tab;
	
	public AdminFrame(){
		this.setTitle("Admin Dashbord");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		addComponentToFrame();
		this.setVisible(true);
	}
	
	public void addComponentToFrame(){
		
		this.aProfile 	= new AdminProfile(this);
		this.aCreate	= new AdminCCourse(this);
		this.aTeacher 	= new AdminCreateTeacher(this);
		this.aOffered = new AdminOfferedCourse(this);
		this.aStd = new AdminCreateStudent(this);
		this.tList = new TeacherList(this);
		this.sList = new StudentList(this);
		this.tab = new JTabbedPane();
		
		this.tab.addTab("Profile", this.aProfile);
		this.tab.addTab("Create Course", this.aCreate);
		this.tab.addTab("Offered Course",this.aOffered);
		this.tab.addTab("Create Teacher",this.aTeacher);
		this.tab.addTab("Teacher List",this.tList);
		this.tab.addTab("Create Student",this.aStd);
		this.tab.addTab("Student List",this.sList);
		this.add(tab);
		
	}
}