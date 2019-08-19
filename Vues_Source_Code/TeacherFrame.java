
import javax.swing.*;

public class TeacherFrame extends JFrame{
	
	TeacherProfile 		tProfile;
	TeacherOfferedCourse 	tOffer;
	TeacherRegisteredStd 	tReg;
	TeacherChangePass 	tPass;
	JTabbedPane			tab;
	int ida;
	Login frame;
	
	public TeacherFrame(int id){
		this.ida=id;
		this.frame=frame;
		this.setTitle("Teacher Dashbord");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		addComponentToFrame();
		this.setVisible(true);
	}
	
	public void addComponentToFrame(){
		
		this.tProfile 	= new TeacherProfile(this,ida);
		this.tOffer = new TeacherOfferedCourse(this,ida);
		this.tReg = new TeacherRegisteredStd(this,ida);
		this.tPass=new TeacherChangePass(this,ida);
		this.tab		= new JTabbedPane();
		
		this.tab.addTab("Profile", this.tProfile);
		this.tab.addTab("Offered Courses", this.tOffer);
		this.tab.addTab("Registered Course Students",this.tReg);
		this.tab.addTab("Change Password", this.tPass);
		this.add(tab);
		
	}
}