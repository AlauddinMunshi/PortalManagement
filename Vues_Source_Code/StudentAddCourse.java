
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class StudentAddCourse extends JPanel implements ActionListener{
	
	StudentFrame frame;
	JButton btn2;
	static Object[][] databaseInfo;
	static DefaultTableModel dTableModel;
	JLabel dname,did;
	JTextField dnametf,didtf;
	JButton dbut;
	String scourse;
	int flag=0;
	int ida;
	
	
	
	public StudentAddCourse(StudentFrame frame,int id){
		this.frame=frame;
		this.ida=id;
    	this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
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
				JLabel title=new JLabel("Offered Courses");
				title.setBounds(240,20,500,50);
				title.setFont(new Font("Serif", Font.BOLD, 40));
				title.setForeground(Color.white);
				this.add(title);
				this.dnametf=new JTextField();
				this.didtf=new JTextField();
				this.dname=new JLabel("Course Name: ");
				dname.setForeground(Color.white);
				this.did=new JLabel("Course ID: ");
				did.setForeground(Color.white);
				this.dname.setBounds(85,470,120,30);
				this.did.setBounds(85,510,120,30);
				this.dnametf.setBounds(205,470,120,30);
		        this.didtf.setBounds(205,510,120,30);
				this.dbut = new JButton("Add Course");
		        this.dbut.setBounds(85,550,240,30);
				this.add(dname);
				this.add(did);
				this.add(dnametf);
				this.add(didtf);
				this.add(dbut);
				Object[] columns = {"Course Name", "ID","Credit","Fee","Capacity","Dept"};
				dTableModel = new DefaultTableModel(databaseInfo, columns);
				
				ArrayList<Coursetype> list = courseList();
				Object[] tempRow = new Object[6];
				
				for(int i=0;i<list.size();i++){
					
					tempRow[0]=list.get(i).getCourseName();
					tempRow[1]=list.get(i).getCourseId();
					tempRow[2]=list.get(i).getCourseCredit();
					tempRow[3]=list.get(i).getCourseFee();
					tempRow[4]=list.get(i).getCourseCapacity();
					tempRow[5]=list.get(i).getCourseDept();
					
					dTableModel.addRow(tempRow);
				}
				
				JTable table = new JTable(dTableModel);
				table.setRowHeight(table.getRowHeight()+10);
				table.setAutoCreateRowSorter(true);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				TableColumn col1 = table.getColumnModel().getColumn(0);
				col1.setPreferredWidth(150);
				
				TableColumn col2 = table.getColumnModel().getColumn(1);
				col2.setPreferredWidth(50);
				
				TableColumn col3 = table.getColumnModel().getColumn(2);
				col3.setPreferredWidth(60);
				
				TableColumn col4 = table.getColumnModel().getColumn(3);
				col4.setPreferredWidth(70);
				
				TableColumn col5 = table.getColumnModel().getColumn(4);
				col5.setPreferredWidth(90);
				
				TableColumn col6 = table.getColumnModel().getColumn(5);
				col6.setPreferredWidth(50);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(85,80,480,350);
				add(scrollPane);
	
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			String s1=dnametf.getText();
			String s2=didtf.getText();
			int id1=Integer.parseInt(s2);
			
			String chck="SELECT `name` FROM `course` WHERE `name`='"+s1+"' and `id`='"+id1+"'";
			ResultSet rs = stmt.executeQuery(chck);
			while(rs.next())
			{
			 scourse=rs.getString(1);
			} 
			String chck1="SELECT `id` FROM `student` WHERE `course1` IS NULL and `id`='"+ida+"'";
			ResultSet rs1=stmt.executeQuery(chck1);
			rs1.last();
			int count = rs1.getRow();
			rs1.beforeFirst();
			if(count>0 && flag==0)
			{
				 int a=stmt.executeUpdate("UPDATE `student` SET `course1`='"+scourse+"' WHERE `id`='"+ida+"'");
				  if (a==1)
				{
					JOptionPane.showMessageDialog(null, "Course Added Successfully!");	
					flag++;
				}
				else{
					JOptionPane.showMessageDialog(null, "1Course Could Not Be Added! Check");
				}
			}
			String chck2="SELECT `id` FROM `student` WHERE `course2` IS NULL";
			ResultSet rs2=stmt.executeQuery(chck2);
			rs2.last();
			int count1 = rs2.getRow();
			rs2.beforeFirst();
			if(count1>0 && flag==0)
			{
				 int a=stmt.executeUpdate("UPDATE `student` SET `course2`='"+scourse+"' WHERE `id`='"+ida+"'");
				 if (a==1)
				{
					JOptionPane.showMessageDialog(null, "Course Added Successfully!");
					flag++;					
				}
				else{
					JOptionPane.showMessageDialog(null, "2Course Could Not Be Added! Check");
				}
			}
			String chck3="SELECT `id` FROM `student` WHERE `course3` IS NULL";
			ResultSet rs3=stmt.executeQuery(chck3);
			rs3.last();
			int count2 = rs3.getRow();
			rs3.beforeFirst();
			if(count2>0 && flag==0)
			{
				 int a=stmt.executeUpdate("UPDATE `student` SET `course3`='"+scourse+"' WHERE `id`='"+ida+"'");
				  if (a==1)
				{
					JOptionPane.showMessageDialog(null, "Course Added Successfully!");
					flag++;					
				}
				else{
					JOptionPane.showMessageDialog(null, "3Course Could Not Be Added! Check");
				}
			}
			
			if(flag==0)
			{
				JOptionPane.showMessageDialog(null, "Already 3 courses and 9 credits taken");
			}
			StudentFrame frame1=new StudentFrame(ida);
			frame1.tab.setSelectedIndex(1);
			frame1.setVisible(true);
			frame.setVisible(false);
			con.close();
			
		}catch(Exception ed){
			JOptionPane.showMessageDialog(null, "Course Could Not Be Added! Check");
			System.out.println(ed);
		}
	}
	
	public ArrayList<Coursetype> courseList(){
		
		ArrayList<Coursetype> courseList = new ArrayList<Coursetype>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			String sql= "select * from course";
			ResultSet rs   = stmt.executeQuery(sql);
			
			Coursetype course;
			while(rs.next())
			{
				course = new Coursetype(rs.getString(1), rs.getInt(2), rs.getInt(5),rs.getInt(3),rs.getInt(5),rs.getString(6));
				courseList.add(course);
			}
			
			con.close();
			
		}catch(Exception ae){
			System.out.println(ae);
		}
		
		return courseList;
	}
	 
}