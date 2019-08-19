import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
	
	    private JLabel titel,id,pass,imgLabel;
		private JTextField idTF;
		private JPasswordField passPF;
		private ImageIcon img;
		private JButton login,fp;
		private JPanel panel;
		private ButtonGroup bg;
		private JRadioButton Student, Faculty, Admin;
		int id1,id2,count;
		String pass1,pass2,s2;
	
	public Login(){
		this.setTitle("AIUB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		panel.setBackground(new Color(0,54,54));
		
	
		
		img = new ImageIcon("aiub.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(140,10,400,300);
		panel.add(imgLabel);
		
		titel = new JLabel("AMERICAN INTERNATIONAL UNIVERSITY BANGLADESH");
		titel.setBounds(15,300,680,35);
		//titel.setBackground(Color.WHITE);
		titel.setForeground(Color.WHITE);
		titel.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,27));
		//titel.setOpaque(true);
		panel.add(titel);
		
		id = new JLabel("ID");
		id.setBounds(220,380,100,30);
		id.setForeground(Color.white);
		panel.add(id);
		
		idTF = new JTextField();
		idTF.setBounds(290,380,195,30);
		id.setForeground(Color.white);
		panel.add(idTF);
		
		pass = new JLabel("Password");
		pass.setBounds(220,430,100,30);
		pass.setForeground(Color.white);
		panel.add(pass);
		
		passPF = new JPasswordField();
		passPF.setBounds(290,430,195,30);
		passPF.setBackground(Color.WHITE);
		passPF.setEchoChar('*');
		panel.add(passPF);

		
		login = new JButton("Log in");
		login.setBounds(220,480,265,40);
		login.setForeground(Color.white);
		login.setBackground(new Color(0,54,54));
		login.addActionListener(this);
		panel.add(login);

		fp = new JButton("Forgot Password");
		fp.setBounds(220,600,260,40);
		fp.setForeground(Color.white);
		fp.setBackground(new Color(0,54,54));
		fp.addActionListener(this);
		fp.setToolTipText("Write the word you were told to remember in Password field instead of Password");
		panel.add(fp);		

		Student = new JRadioButton("Student");
		Student.setBounds(225,550,80,20);
		Student.setSelected(true);
		panel.add(Student);
		
		Faculty = new JRadioButton("Teacher");
		Faculty.setBounds(315,550,80,20);
		panel.add(Faculty);
		
		Admin = new JRadioButton("Admin");
		Admin.setBounds(410,550,75,20);
		panel.add(Admin);
		
		bg = new ButtonGroup();
		bg.add(Student);
		bg.add(Faculty);
		bg.add(Admin);

		this.add(panel);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
		Statement stmt = con.createStatement();
		s2=idTF.getText();  
		id2=Integer.parseInt(s2);
		pass1=passPF.getText();
	  if(ae.getSource()==login)
	  {
		  
		  if(Admin.isSelected())
		{
		String sql= "select `id`,`password` from `admin` where `id`='"+id2+"' and `password`='"+pass1+"'";
		ResultSet rs   = stmt.executeQuery(sql);	
		rs.last();
	    count = rs.getRow();
		rs.beforeFirst();
		
		while(rs.next())
		{
			id1=rs.getInt(1);
			pass2=rs.getString(2);
		}
		
		if(count==1)
		{
			AdminFrame f=new AdminFrame();
			f.setVisible(true);
			this.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid ID or Password");
		}
		}
		else if(Student.isSelected())
		{
		String sql= "select `id`,`password` from `student` where `id`='"+id2+"' and `password`='"+pass1+"' or `answer`='"+pass1+"'";
		ResultSet rs   = stmt.executeQuery(sql);	
		rs.last();
	    count = rs.getRow();
		rs.beforeFirst();
		
		while(rs.next())
		{
			id1=rs.getInt(1);
			pass2=rs.getString(2);
		}
		
		if(count==1)
		{
			StudentFrame sf=new StudentFrame(id1);
			sf.setVisible(true);
			this.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid ID or Password");
		}
			
		}
		else if(Faculty.isSelected())
		{
			String sql= "select `id`,`password`,`answer` from `teacher` where `id`='"+id2+"' and `password`='"+pass1+"' or `answer`='"+pass1+"'";
		ResultSet rs   = stmt.executeQuery(sql);	
		rs.last();
	    count = rs.getRow();
		rs.beforeFirst();
		
		while(rs.next())
		{
			id1=rs.getInt(1);
			pass2=rs.getString(2);
		}
		
		if(count==1)
		{
			TeacherFrame f=new TeacherFrame(id1);
			f.setVisible(true);
			this.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid ID or Password");
		}
		}
	  }
	  else if(ae.getSource()==fp)
		  {
			
		  }
		con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
}
}