
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentDropCourse extends JPanel implements ActionListener{
	
	StudentFrame frame;
	JButton btn2;
	int ida;
	JRadioButton course1, course2, course3;
	ButtonGroup bg;
	String course1tf1,course2tf1,course3tf1;
	String sql1;
	
	public StudentDropCourse(StudentFrame frame,int id){
		this.frame=frame;
		this.ida=id;
		this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
		this.btn2 = new JButton("Drop Course");
		this.btn2.setBounds(50, 420, 120, 30);
		this.add(btn2);
		btn2.addActionListener(this);
		
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
		JLabel title=new JLabel("Drop Course");
		title.setBounds(230,20,500,50);
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
		
		
		course1 = new JRadioButton(course1tf1);
		course1.setBounds(50,180,100,30);
		course1.setActionCommand(course1tf1);
		this.add(course1);
		
		course2 = new JRadioButton(course2tf1);
		course2.setBounds(50,260,100,30);
		course2.setActionCommand(course2tf1);
		this.add(course2);
		
		course3 = new JRadioButton(course3tf1);
		course3.setBounds(50,340,100,30);
	    course3.setActionCommand(course3tf1);
		this.add(course3);
		
		bg = new ButtonGroup();
		bg.add(course1);
		bg.add(course2);
		bg.add(course3);

		
		con.close();
		
		}catch(Exception exp){
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
	    Statement stmt = con.createStatement();
		/* String s6=ucourse1tf.getText();
		String s7=ucourse2tf.getText();
		String s8=ucourse3tf.getText();
		 */
		String s1=bg.getSelection().getActionCommand();
		if(s1==course1tf1)
		{
			sql1="UPDATE `student` SET `course1`= null WHERE `id`='"+ida+"'";
		}
		else if(s1==course2tf1)
		{
			sql1="UPDATE `student` SET `course2`= null WHERE `id`='"+ida+"'";
		}
		else if(s1==course3tf1)
		{
			sql1="UPDATE `student` SET `course3`= null WHERE `id`='"+ida+"'";
		}
		
		int a = stmt.executeUpdate(sql1);
		if (a==1)
		{
			JOptionPane.showMessageDialog(null, "Course Dropped Successfully!");	
		}
		StudentFrame frame1=new StudentFrame(ida);
		frame1.tab.setSelectedIndex(2);
		frame1.setVisible(true);
		frame.setVisible(false);
		con.close();
		
		}catch(Exception exp){
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
	}
}