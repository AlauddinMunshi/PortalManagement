
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TeacherChangePass extends JPanel implements ActionListener{
	
	TeacherFrame frame;
	JButton crstd;
	JLabel opass,password;
	JTextField opasstf,passwordtf;
	String spass;
	int ida;
	public TeacherChangePass(TeacherFrame frame,int ida){
		this.frame=frame;
		this.ida=ida;
		this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
		crstd.addActionListener(this);
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
		this.crstd = new JButton("Save Password");
		this.opass=new JLabel("Old Password: ");
		opass.setForeground(Color.white);
		this.password=new JLabel("New Password: ");
		password.setForeground(Color.white);
		this.opasstf=new JTextField();
		this.passwordtf=new JTextField();
		this.opass.setBounds(50,150,100,30);
		this.password.setBounds(50,200,100,30);
		this.opasstf.setBounds(160,150,100,30);
		this.passwordtf.setBounds(160,200,100,30);
	    this.crstd.setBounds(50,250,230,30);
		this.add(opass);
		this.add(opasstf);
		this.add(password);
		this.add(passwordtf);
		this.add(crstd);
		JLabel title=new JLabel("Change Password");
		title.setBounds(240,30,400,50);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.white);
		this.add(title);
	}
	
	public void actionPerformed(ActionEvent e)
		{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
	    Statement stmt = con.createStatement();
		String s1=opasstf.getText();  
		String s2=passwordtf.getText();
			
		String chck="SELECT `password` FROM `teacher` WHERE `password`='"+s1+"' and `id`='"+ida+"'";	
		ResultSet rs = stmt.executeQuery(chck);		
		while(rs.next())
		{
			spass=rs.getString(1);
		}
		if(spass.equals(s1))
		{
		int a=stmt.executeUpdate("UPDATE `teacher` SET `password`='"+s2+"' WHERE `id`='"+ida+"'");
		if(a==1)
		{
			JOptionPane.showMessageDialog(null, "Password Changed Successfully!");	
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "Password Could Not Be Changed! Wrong Old password");
		}
		
		TeacherFrame frame1=new TeacherFrame(ida);
		frame1.tab.setSelectedIndex(3);
		frame1.setVisible(true);
		frame.setVisible(false);
		con.close();
		}catch(Exception exp){
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}

}
}