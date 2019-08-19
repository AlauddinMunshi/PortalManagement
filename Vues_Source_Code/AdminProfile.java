import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AdminProfile extends JPanel implements ActionListener{
	
	JButton dbut;
	AdminFrame frame;
	JLabel dname,did,pass;
	JLabel hname,hid,hpass;
	JTextField dnametf,didtf,passtf;
	int a;
	String b,c,a1;
	
	public AdminProfile(){
		
	}
	
	public AdminProfile(AdminFrame frame){
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
		dbut.addActionListener(this);
	}
	
	public void addComponentToPanel(){
		JLabel title=new JLabel("Admin Profile");
		title.setBounds(250,20,500,40);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.white);
		this.add(title);
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
	    Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from admin");
		 while(rs.next())
			{
				a=rs.getInt(1);
				b=rs.getString(2);
				c=rs.getString(3);
			} 
		a1=String.valueOf(a);
		
		con.close();
		}catch(Exception exp){
			JOptionPane.showMessageDialog(null, "Check Error");
		}
		hname=new JLabel("Name: "+b);
		hname.setFont(new Font("Serif", Font.BOLD, 20));
		hname.setForeground(Color.white);
		hname.setBounds(50,70,300,30);
		hid=new JLabel("ID: "+a1);
		hid.setFont(new Font("Serif", Font.BOLD, 20));
		hid.setForeground(Color.white);
		hid.setBounds(50,110,300,30);
		hpass=new JLabel("Password: "+c);
		hpass.setFont(new Font("Serif", Font.BOLD, 20));
		hpass.setForeground(Color.white);
		hpass.setBounds(50,150,300,30);
		this.add(hname);
		this.add(hid);
		this.add(hpass);

		JLabel hname=new JLabel("Name");
		this.dname=new JLabel("Name: ");
		dname.setForeground(Color.white);
		this.did=new JLabel("ID: ");
		did.setForeground(Color.white);
		this.pass=new JLabel("Password: ");
		pass.setForeground(Color.white);
		this.dnametf=new JTextField();
		this.didtf=new JTextField();
		this.passtf=new JTextField();
		this.dbut = new JButton("Change Info");
		this.dbut.setBounds(50,400,200,30);
		this.dname.setBounds(50,220,100,30);
		this.did.setBounds(50,280,100,30);
		this.pass.setBounds(50,330,100,30);
		this.passtf.setBounds(130,330,100,30);
		this.dnametf.setBounds(130,220,100,30);
		this.didtf.setBounds(130,280,100,30);
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
		this.add(dname);
		this.add(did);
		this.add(dnametf);
		this.add(didtf);
		this.add(dbut);
		this.add(passtf);
		this.add(pass);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
	    Statement stmt = con.createStatement();	
		String s1=didtf.getText();  
		int id1=Integer.parseInt(s1);
        String s2=passtf.getText();
		String s3=dnametf.getText();
				
		String sql1="UPDATE `admin` SET `id`='"+id1+"',`name`='"+s3+"',`password`='"+s2+"'";
		int a = stmt.executeUpdate(sql1);
		if (a==1)
		{
			JOptionPane.showMessageDialog(null, "Admin Info Updated Successfully!");	
		AdminFrame frame1=new AdminFrame();
		frame1.tab.setSelectedIndex(0);
		frame1.setVisible(true);
		frame.setVisible(false);
		}
		con.close();
		}catch(Exception exp){
			JOptionPane.showMessageDialog(null, "Course Action Could Not Be Performed! Check Carefully");
		}
	}
	
}