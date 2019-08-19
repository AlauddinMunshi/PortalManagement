
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegisteredCourse extends JPanel{
	int ida;
	StudentFrame frame;
	JLabel course1,course1tf;
	JLabel course2,course2tf;
	JLabel course3,course3tf;
	JLabel title,t1,t2,t3,t4,t5,t6;
	String course1tf1,course2tf1,course3tf1;
	int course1fac1,course1fac2,course1fac3;
	String coursefac1,coursefac2,coursefac3;
	
	public StudentRegisteredCourse(StudentFrame frame,int idp){
		this.ida=idp;
		this.frame=frame;
		this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
	}
	
	public void addComponentToPanel(){
		JButton logout=new JButton("Log Out");
		logout.setBounds(260,590,100,30);
		this.add(logout);
		logout.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            Login l=new Login();
			l.setVisible(true);
			frame.setVisible(false);
    }  
    });
		JLabel title=new JLabel("Registered Course");
		title.setBounds(210,20,500,50);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.white);
		this.add(title);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `student` WHERE `id`='"+ida+"'");
		
		while(rs.next())
			{
				course1tf1=rs.getString(6);
				course2tf1=rs.getString(7);
				course3tf1=rs.getString(8);
			}

		ResultSet rs1 = stmt.executeQuery("SELECT `id` FROM `teacher` WHERE `course1`='"+course1tf1+"' or `course2`='"+course1tf1+"' or `course3`='"+course1tf1+"'");
		
		while(rs1.next())
			{
				course1fac1=rs1.getInt(1);
			} 
			
		ResultSet rs2 = stmt.executeQuery("SELECT `id` FROM `teacher` WHERE `course1`='"+course2tf1+"' or `course2`='"+course2tf1+"' or `course3`='"+course2tf1+"'");
		
		while(rs2.next())
			{
				course1fac2=rs2.getInt(1);
			} 

		ResultSet rs3 = stmt.executeQuery("SELECT `id` FROM `teacher` WHERE `course1`='"+course3tf1+"' or `course2`='"+course3tf1+"' or `course3`='"+course3tf1+"'");
		
		while(rs3.next())
			{
				course1fac3=rs3.getInt(1);
			} 			
	
	    ResultSet rs4 = stmt.executeQuery("SELECT `name` FROM `teacher` WHERE `id`='"+course1fac1+"'");
		
		while(rs4.next())
			{
				coursefac1=rs4.getString(1);
			}	
			
		ResultSet rs5 = stmt.executeQuery("SELECT `name` FROM `teacher` WHERE `id`='"+course1fac2+"'");
		
		while(rs5.next())
			{
				coursefac2=rs5.getString(1);
			}	

		ResultSet rs6 = stmt.executeQuery("SELECT `name` FROM `teacher` WHERE `id`='"+course1fac3+"'");
		
		while(rs6.next())
			{
				coursefac3=rs6.getString(1);
			}	
		
		this.course1=new JLabel("Course 1: ");
		course1.setForeground(Color.white);
		course1.setFont(new Font("Serif", Font.BOLD, 20));
		this.course2=new JLabel("Course 2: ");
		course2.setForeground(Color.white);
		course2.setFont(new Font("Serif", Font.BOLD, 20));
		this.course3=new JLabel("Course 3: ");
		course3.setForeground(Color.white);
      	course3.setFont(new Font("Serif", Font.BOLD, 20));
		
		this.course1.setBounds(50,150,100,30);
		this.course2.setBounds(50,230,100,30);
		this.course3.setBounds(50,310,100,30);
		this.add(course1);	
		this.add(course2);
		this.add(course3);
		
		this.t1=new JLabel("Teacher: ");
		t1.setForeground(Color.white);
		t1.setFont(new Font("Serif", Font.BOLD, 20));
		this.t2=new JLabel("Teacher: ");
		
		t2.setForeground(Color.white);
		t2.setFont(new Font("Serif", Font.BOLD, 20));
		this.t3=new JLabel("Teacher: ");
		t3.setForeground(Color.white);
		t3.setFont(new Font("Serif", Font.BOLD, 20));
		this.t1.setBounds(400,150,100,30);
		this.t2.setBounds(400,230,100,30);
		this.t3.setBounds(400,310,100,30);
		this.add(t1);	
		this.add(t2);
		this.add(t3);
		
		this.t4=new JLabel(coursefac1);
		t4.setForeground(Color.white);
		t4.setFont(new Font("Serif", Font.BOLD, 20));
		this.t5=new JLabel(coursefac2);
		t5.setForeground(Color.white);
		t5.setFont(new Font("Serif", Font.BOLD, 20));
		this.t6=new JLabel(coursefac3);
		t6.setForeground(Color.white);
		t6.setFont(new Font("Serif", Font.BOLD, 20));
		
		this.t4.setBounds(500,150,100,30);
		this.t5.setBounds(500,230,100,30);
		this.t6.setBounds(500,310,100,30);
		this.add(t4);	
		this.add(t5);
		this.add(t6);

		
		this.course1tf=new JLabel(course1tf1);
		course1tf.setForeground(Color.white);
		course1tf.setFont(new Font("Serif", Font.BOLD, 20));
		this.course2tf=new JLabel(course2tf1);
		course2tf.setForeground(Color.white);
		course2tf.setFont(new Font("Serif", Font.BOLD, 20));
		this.course3tf=new JLabel(course3tf1);
		course3tf.setForeground(Color.white);
      	course3tf.setFont(new Font("Serif", Font.BOLD, 20));
		
		this.course1tf.setBounds(150,150,200,30);
		this.course2tf.setBounds(150,230,200,30);
		this.course3tf.setBounds(150,310,200,30);
		
		this.add(course1tf);	
		this.add(course2tf);
		this.add(course3tf);
		
	    con.close();
		}
		catch(Exception exp){
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
	}
}