
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class StudentProfile extends JPanel{
	
	StudentFrame frame;
	JLabel course1,course2,course3;
	JLabel id;
	JLabel password;
	JLabel security;
	JLabel answer;
	JLabel name;
	JLabel dept;
	JLabel title;
	JLabel idtf;
	JLabel passwordtf;
	JLabel answertf;
	JLabel nametf;
	JLabel depttf;
	JLabel course1tf,course2tf,course3tf;
	int ida,idtf1;
	String passwordtf1,answertf1,nametf1,depttf1,course1tf1,course2tf1,course3tf1;
	
	public StudentProfile(){
		
	}
	
	public StudentProfile(StudentFrame frame,int idp){
		this.ida=idp;
		this.frame = frame;
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
		JLabel title=new JLabel("Student Profile");
		title.setBounds(230,20,500,40);
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
				idtf1=rs.getInt(1);
				passwordtf1=rs.getString(2);
				answertf1=rs.getString(3);
				nametf1=rs.getString(4);
				depttf1=rs.getString(5);
				course1tf1=rs.getString(6);
				course2tf1=rs.getString(7);
				course3tf1=rs.getString(8);
			} 
		
		this.id=new JLabel("ID: ");
		id.setForeground(Color.white);
		id.setFont(new Font("Serif", Font.BOLD, 20));
		this.password=new JLabel("Password: ");
		password.setForeground(Color.white);
		password.setFont(new Font("Serif", Font.BOLD, 20));
		this.security=new JLabel("Security Question: Write something that you will remember?");
		security.setForeground(Color.white);
		security.setFont(new Font("Serif", Font.BOLD, 20));
		this.answer=new JLabel("Answer: ");
		answer.setForeground(Color.white);
		answer.setFont(new Font("Serif", Font.BOLD, 20));
		this.name=new JLabel("Name: ");
		name.setForeground(Color.white);
		name.setFont(new Font("Serif", Font.BOLD, 20));
		this.dept=new JLabel("Dept: ");
		dept.setForeground(Color.white);
		dept.setFont(new Font("Serif", Font.BOLD, 20));
		this.course1=new JLabel("Course 1: ");
		course1.setForeground(Color.white);
		course1.setFont(new Font("Serif", Font.BOLD, 20));
		this.course2=new JLabel("Course 2: ");
		course2.setForeground(Color.white);
		course2.setFont(new Font("Serif", Font.BOLD, 20));
		this.course3=new JLabel("Course 3: ");
		course3.setForeground(Color.white);
		course3.setFont(new Font("Serif", Font.BOLD, 20));

		
		this.id.setBounds(50,100,100,30);
		this.password.setBounds(50,180,100,30);
		this.security.setBounds(50,260,600,30);
		this.answer.setBounds(50,340,100,30);
		this.name.setBounds(50,420,100,30);
		this.dept.setBounds(50,500,100,30);
		this.course1.setBounds(50,410,100,30);
		this.course2.setBounds(50,470,100,30);
		this.course3.setBounds(50,530,100,30);
		
		String idf = Integer.toString(idtf1);
		this.idtf=new JLabel(idf);
		idtf.setForeground(Color.white);
		this.passwordtf=new JLabel("********");
		passwordtf.setForeground(Color.white);
		this.answertf=new JLabel(answertf1);
		answertf.setForeground(Color.white);
		this.nametf=new JLabel(nametf1);
		nametf.setForeground(Color.white);
		this.depttf=new JLabel(depttf1);
		depttf.setForeground(Color.white);
		this.course1tf=new JLabel(course1tf1);
		course1tf.setForeground(Color.white);
		this.course2tf=new JLabel(course2tf1);
		course2tf.setForeground(Color.white);
		this.course3tf=new JLabel(course3tf1);
		course3tf.setForeground(Color.white);
		
		this.idtf.setBounds(130,100,100,30);
		this.passwordtf.setBounds(150,180,100,30);
		this.answertf.setBounds(130,340,100,30);
		this.nametf.setBounds(130,420,100,30);
		this.depttf.setBounds(130,500,100,30);
		this.course1tf.setBounds(150,410,100,30);
		this.course2tf.setBounds(150,470,100,30);
		this.course3tf.setBounds(150,530,100,30);
		
		this.add(id);
		this.add(idtf);
		this.add(password);
		this.add(passwordtf);
		this.add(security);
		this.add(answer);
		this.add(answertf);
		this.add(name);
		this.add(nametf);
		this.add(dept);
		this.add(depttf);

		con.close();
		}
		catch(Exception exp){
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
		
	}		
	
}