
import javax.swing.*;

public class StudentFrame extends JFrame{
	Login frame;
	StudentProfile 		sProfile;
	StudentAddCourse 	sAdd;
	StudentDropCourse 	sDrop;
	StudentRegisteredCourse 	sReg;
	StudentChangePass 	sPass;
	JTabbedPane			tab;
	int ida;
	
	public StudentFrame(int id){
		this.ida=id;
		this.frame=frame;
		this.setTitle("Student Dashbord");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		addComponentToFrame();
		this.setVisible(true);
	}
	
	public void addComponentToFrame(){
		
		this.sProfile 	= new StudentProfile(this,ida);
		this.sAdd	= new StudentAddCourse(this,ida);
		this.sDrop 	= new StudentDropCourse(this,ida);
		this.sReg = new StudentRegisteredCourse(this,ida);
		this.sPass = new StudentChangePass(this,ida);
		this.tab		= new JTabbedPane();
		
		this.tab.addTab("Profile", this.sProfile);
		this.tab.addTab("Add Course", this.sAdd);
		this.tab.addTab("Drop Course",this.sDrop);
		this.tab.addTab("Registered Course",this.sReg);
		this.tab.addTab("Change Password",this.sPass);
		
		this.add(tab);
		
	}
}