import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminCCourse extends JPanel implements ActionListener{
	
	AdminFrame frame;
	JButton crcourse,ucrcourse,dbut;
	JLabel dname,did;
	JTextField dnametf,didtf;
	JLabel title1,title2;
	JLabel name,uname;
	JLabel id,uid;
	JLabel fee,ufee;
	JLabel credit,ucredit;
	JLabel capacity,ucapacity;
	JLabel dept,udept;
	JTextField nametf,unametf;
	JTextField idtf,uidtf;
	JTextField feetf,ufeetf;
	JTextField credittf,ucredittf;
	JTextField capacitytf,ucapacitytf;
	JTextField depttf,udepttf;
	
	public AdminCCourse(AdminFrame frame){
		this.frame=frame;
		this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
		crcourse.addActionListener(this);
		ucrcourse.addActionListener(this);
		dbut.addActionListener(this);
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
		this.title1=new JLabel("Create Course");
		this.title2=new JLabel("Update Course");
		this.crcourse = new JButton("Create Course");
		this.name=new JLabel("Name: ");
		name.setForeground(Color.white);
		this.id=new JLabel("ID: ");
		id.setForeground(Color.white);
		this.fee=new JLabel("Fee: ");
		fee.setForeground(Color.white);
		this.credit=new JLabel("Credit: ");
		credit.setForeground(Color.white);
		this.capacity=new JLabel("Count: ");
		capacity.setForeground(Color.white);
		this.dept=new JLabel("Dept: ");
		dept.setForeground(Color.white);
		this.nametf=new JTextField();
		this.idtf=new JTextField();
		this.feetf=new JTextField();
		this.credittf=new JTextField();
		this.capacitytf=new JTextField();
		this.depttf=new JTextField();
		this.dname=new JLabel("Name: ");
		dname.setForeground(Color.white);
		this.did=new JLabel("ID: ");
		did.setForeground(Color.white);
		this.dnametf=new JTextField();
		this.didtf=new JTextField();
		
		this.title1.setBounds(70,20,200,20);
		title1.setFont(new Font("Serif", Font.BOLD, 20));
		title1.setForeground(Color.white);
		this.title2.setBounds(470,20,200,20);
		title2.setFont(new Font("Serif", Font.BOLD, 20));
		title2.setForeground(Color.white);
		this.name.setBounds(50,50,100,30);
		this.id.setBounds(50,100,100,30);
		this.fee.setBounds(50,140,100,30);
		this.credit.setBounds(50,180,100,30);
		this.capacity.setBounds(50,220,100,30);
		this.dept.setBounds(50,260,100,30);
		this.dname.setBounds(50,370,100,30);
		this.did.setBounds(50,430,100,30);
		
		this.nametf.setBounds(130,50,100,30);
		this.idtf.setBounds(130,100,100,30);
		this.feetf.setBounds(130,140,100,30);
		this.credittf.setBounds(130,180,100,30);
		this.capacitytf.setBounds(130,220,100,30);
		this.depttf.setBounds(130,260,100,30);
		this.dnametf.setBounds(130,370,100,30);
		this.didtf.setBounds(130,430,100,30);
		this.crcourse.setBounds(50,320,180,30);
		this.dbut = new JButton("Delete Account");
		this.dbut.setBounds(50,500,180,30);
		
		this.add(name);
		this.add(nametf);
		this.add(id);
		this.add(idtf);
		this.add(fee);
		this.add(feetf);
		this.add(credit);
		this.add(credittf);
		this.add(capacity);
		this.add(capacitytf);
		this.add(dept);
		this.add(depttf);
		this.add(crcourse);
		this.add(title1);
		this.add(title2);
		this.add(dname);
		this.add(did);
		this.add(dnametf);
		this.add(didtf);
		this.add(dbut);
		
		
		this.ucrcourse = new JButton("Update Course");
		this.uname=new JLabel("Name: ");
		uname.setForeground(Color.white);
		this.uid=new JLabel("ID: ");
		uid.setForeground(Color.white);
		this.ufee=new JLabel("Fee: ");
		ufee.setForeground(Color.white);
		this.ucredit=new JLabel("Credit: ");
		ucredit.setForeground(Color.white);
		this.ucapacity=new JLabel("Count: ");
		ucapacity.setForeground(Color.white);
		this.udept=new JLabel("Dept: ");
		udept.setForeground(Color.white);
		this.unametf=new JTextField();
		this.uidtf=new JTextField();
		this.ufeetf=new JTextField();
		this.ucredittf=new JTextField();
		this.ucapacitytf=new JTextField();
		this.udepttf=new JTextField();
		
		this.uname.setBounds(400,50,100,30);
		this.uid.setBounds(400,130,100,30);
		this.ufee.setBounds(400,210,100,30);
		this.ucredit.setBounds(400,290,100,30);
		this.ucapacity.setBounds(400,370,100,30);
		this.udept.setBounds(400,450,100,30);
		
		this.unametf.setBounds(500,50,100,30);
		this.uidtf.setBounds(500,130,100,30);
		this.ufeetf.setBounds(500,210,100,30);
		this.ucredittf.setBounds(500,290,100,30);
		this.ucapacitytf.setBounds(500,370,100,30);
		this.udepttf.setBounds(500,450,100,30);
		this.ucrcourse.setBounds(400,500,200,30);
		
		this.add(uname);
		this.add(unametf);
		this.add(uid);
		this.add(uidtf);
		this.add(ufee);
		this.add(ufeetf);
		this.add(ucredit);
		this.add(ucredittf);
		this.add(ucapacity);
		this.add(ucapacitytf);
		this.add(udept);
		this.add(udepttf);
		this.add(ucrcourse);
	}
	
	public void actionPerformed(ActionEvent e)
	
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
	    Statement stmt = con.createStatement();
		if(e.getSource()==crcourse)
		{
			
		String s1=nametf.getText();  
        String s2=idtf.getText();
		int id1=Integer.parseInt(s2);
		String s3=feetf.getText();
		int fee1=Integer.parseInt(s3);
		String s4=credittf.getText();
		int credit1=Integer.parseInt(s4);
		String s5=capacitytf.getText();
		int capacity1=Integer.parseInt(s5);
		String s6=depttf.getText();		
		
		String sql = "INSERT INTO `course`( `name`,`id`,`fee`,`credit`,`capacity`,`dept`) VALUES ('"+s1+"',"+"'"+id1+"',"+"'"+fee1+"',"+"'"+credit1+"',"+"'"+capacity1+"',"+"'"+s6+"')";
		int a = stmt.executeUpdate(sql);
		if (a==1)
		{
			JOptionPane.showMessageDialog(null, "Course Created Successfully!");	
		}

		}
		else if(e.getSource()==ucrcourse)
		{
		String s1=unametf.getText();  
        String s2=uidtf.getText();
		int uid1=Integer.parseInt(s2);
		String s3=ufeetf.getText();
		int ufee1=Integer.parseInt(s3);
		String s4=ucredittf.getText();
		int ucredit1=Integer.parseInt(s4);
		String s5=ucapacitytf.getText();
		int ucapacity1=Integer.parseInt(s5);
		String s6=udepttf.getText();
		
		String sql1="UPDATE `course` SET `name`='"+s1+"',`id`='"+uid1+"',`fee`='"+ufee1+"',`credit`='"+ucredit1+"',`capacity`='"+ucapacity1+"',`dept`='"+s6+"' WHERE `id`='"+uid1+"'";
		int a = stmt.executeUpdate(sql1);
		if (a==1)
		{
			JOptionPane.showMessageDialog(null, "Course Updated Successfully!");	
		}
		}
		else if(e.getSource()==dbut)
		{
		String s1=dnametf.getText();
		String s2=didtf.getText();  
		int didtf=Integer.parseInt(s2);
		
		String sql1="DELETE FROM `course` WHERE `id`='"+didtf+"'";
		int a = stmt.executeUpdate(sql1);
		if (a==1)
		{
			JOptionPane.showMessageDialog(null, "Account Deleted Successfully!");	
		}
		else{
			JOptionPane.showMessageDialog(null, "Course Could Not Be Deleted! Check");
		}
		}
		AdminFrame frame1=new AdminFrame();
		frame1.tab.setSelectedIndex(1);
		frame1.setVisible(true);
		frame.setVisible(false);
		con.close();
		}catch(Exception exp){
			JOptionPane.showMessageDialog(null, "Course Action Could Not Be Performed! Check Carefully");
		}
	}

}