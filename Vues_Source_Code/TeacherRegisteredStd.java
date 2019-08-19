
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;


public class TeacherRegisteredStd extends JPanel{
	
	static Object[][] databaseInfo;
	static DefaultTableModel dTableModel;
	TeacherFrame frame;
	int ida;
	String course1tf1,course2tf1,course3tf1;
	
	public TeacherRegisteredStd(TeacherFrame frame,int id){
		this.frame=frame;
		this.ida=id;
		this.setLayout(null);
		this.setBackground(new Color(0,54,54));
		addComponentToPanel();
		addComponentToPanel1();
		addComponentToPanel2();
	}
	
	public void addComponentToPanel()
	{
		JButton logout=new JButton("Log Out");
		logout.setBounds(260,610,100,30);
		this.add(logout);		
		logout.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            Login l=new Login();
			l.setVisible(true);
			frame.setVisible(false);
    }  
    });
		Object[] columns = {"Name", "ID","Dept","Course 1","Course 2","Course 3"};
		dTableModel = new DefaultTableModel(databaseInfo, columns);
				
		ArrayList<Studenttype1> list =studentList();
		Object[] tempRow = new Object[6];
				
		for(int i=0;i<list.size();i++)
		{
					
			tempRow[0]=list.get(i).getStudentName();
			tempRow[1]=list.get(i).getstudentId();
			tempRow[2]=list.get(i).getDept();
			tempRow[3]=list.get(i).getCourse1();
			tempRow[4]=list.get(i).getCourse2();
			tempRow[5]=list.get(i).getCourse3();
					
			dTableModel.addRow(tempRow);
		}
				
		JTable table = new JTable(dTableModel);
		table.setRowHeight(table.getRowHeight()+10);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(100);
				
		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(100);
				
		TableColumn col3 = table.getColumnModel().getColumn(2);
		col3.setPreferredWidth(100);
				
		TableColumn col4 = table.getColumnModel().getColumn(3);
		col4.setPreferredWidth(100);
				
		TableColumn col5 = table.getColumnModel().getColumn(4);
		col5.setPreferredWidth(100);
				
		TableColumn col6 = table.getColumnModel().getColumn(5);
		col6.setPreferredWidth(100);
			
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,50,600,150);
		add(scrollPane);
	
	
	}
	
	public void addComponentToPanel1()
	{
				
		Object[] columns = {"Name", "ID","Dept","Course 1","Course 2","Course 3"};
		dTableModel = new DefaultTableModel(databaseInfo, columns);
				
		ArrayList<Studenttype1> list =studentList1();
		Object[] tempRow = new Object[6];
				
		for(int i=0;i<list.size();i++)
		{
					
			tempRow[0]=list.get(i).getStudentName();
			tempRow[1]=list.get(i).getstudentId();
			tempRow[2]=list.get(i).getDept();
			tempRow[3]=list.get(i).getCourse1();
			tempRow[4]=list.get(i).getCourse2();
			tempRow[5]=list.get(i).getCourse3();
					
			dTableModel.addRow(tempRow);
		}
				
		JTable table = new JTable(dTableModel);
		table.setRowHeight(table.getRowHeight()+10);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(100);
				
		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(100);
				
		TableColumn col3 = table.getColumnModel().getColumn(2);
		col3.setPreferredWidth(100);
				
		TableColumn col4 = table.getColumnModel().getColumn(3);
		col4.setPreferredWidth(100);
				
		TableColumn col5 = table.getColumnModel().getColumn(4);
		col5.setPreferredWidth(100);
				
		TableColumn col6 = table.getColumnModel().getColumn(5);
		col6.setPreferredWidth(100);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,250,600,150);
		add(scrollPane);
	
	
	}
	
	public void addComponentToPanel2()
	{
					
		Object[] columns = {"Name", "ID","Dept","Course 1","Course 2","Course 3"};
		dTableModel = new DefaultTableModel(databaseInfo, columns);
				
		ArrayList<Studenttype1> list =studentList2();
		Object[] tempRow = new Object[6];
				
		for(int i=0;i<list.size();i++)
		{
					
			tempRow[0]=list.get(i).getStudentName();
			tempRow[1]=list.get(i).getstudentId();
			tempRow[2]=list.get(i).getDept();
			tempRow[3]=list.get(i).getCourse1();
			tempRow[4]=list.get(i).getCourse2();
			tempRow[5]=list.get(i).getCourse3();
					
			dTableModel.addRow(tempRow);
		}
				
		JTable table = new JTable(dTableModel);
		table.setRowHeight(table.getRowHeight()+10);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(100);
				
		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(100);
				
		TableColumn col3 = table.getColumnModel().getColumn(2);
		col3.setPreferredWidth(100);
				
		TableColumn col4 = table.getColumnModel().getColumn(3);
		col4.setPreferredWidth(100);
				
		TableColumn col5 = table.getColumnModel().getColumn(4);
		col5.setPreferredWidth(100);
				
		TableColumn col6 = table.getColumnModel().getColumn(5);
		col6.setPreferredWidth(100);
				

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,450,600,150);
		add(scrollPane);
	
	
	}
	
	public ArrayList<Studenttype1> studentList(){
		
		ArrayList<Studenttype1> studentList = new ArrayList<Studenttype1>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM `teacher` WHERE `id`='"+ida+"'");
		
		    while(rs1.next())
			{
				course1tf1=rs1.getString(7);
				course2tf1=rs1.getString(8);
				course3tf1=rs1.getString(9);
			}
			JLabel title=new JLabel(course1tf1);
			title.setBounds(280,20,200,20);
			title.setFont(new Font("Serif", Font.BOLD, 20));
			title.setForeground(Color.white);
			this.add(title);
			
			JLabel title1=new JLabel(course2tf1);
			title1.setBounds(280,220,200,20);
			title1.setFont(new Font("Serif", Font.BOLD, 20));
			title1.setForeground(Color.white);
			this.add(title1);
			
			JLabel title2=new JLabel(course3tf1);
			title2.setBounds(280,420,200,20);
			title2.setFont(new Font("Serif", Font.BOLD, 20));
			title2.setForeground(Color.white);
			this.add(title2);
			
			
			String sql= "select * from student where course1='"+course1tf1+"' or course2='"+course1tf1+"' or course3='"+course1tf1+"'";
			ResultSet rs   = stmt.executeQuery(sql);	
		    Studenttype1 student;
			while(rs.next())
			{
				student = new Studenttype1(rs.getString(4), rs.getInt(1),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				studentList.add(student);
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return studentList;
	}
	
	public ArrayList<Studenttype1> studentList1(){
		
		ArrayList<Studenttype1> studentList1 = new ArrayList<Studenttype1>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			
			String sql= "select * from student where course1='"+course2tf1+"' or course2='"+course1tf1+"' or course3='"+course1tf1+"'";
			ResultSet rs   = stmt.executeQuery(sql);	
		    Studenttype1 student1;
			while(rs.next())
			{
				student1 = new Studenttype1(rs.getString(4), rs.getInt(1),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				studentList1.add(student1);
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return studentList1;
	}
	
	public ArrayList<Studenttype1> studentList2(){
		
		ArrayList<Studenttype1> studentList2 = new ArrayList<Studenttype1>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			
			String sql= "select * from student where course1='"+course3tf1+"' or course2='"+course1tf1+"' or course3='"+course1tf1+"'";
			ResultSet rs   = stmt.executeQuery(sql);	
		    Studenttype1 student2;
			while(rs.next())
			{
				student2 = new Studenttype1(rs.getString(4), rs.getInt(1),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				studentList2.add(student2);
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return studentList2;
	}
	 
}
	