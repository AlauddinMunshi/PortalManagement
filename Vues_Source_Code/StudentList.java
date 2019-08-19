
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;


public class StudentList extends JPanel{
	
	AdminFrame frame;
	static Object[][] databaseInfo;
	static DefaultTableModel dTableModel;
	
	public StudentList(AdminFrame frame){
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
				JLabel title=new JLabel("Student List");
				title.setBounds(280,20,200,20);
				title.setFont(new Font("Serif", Font.BOLD, 20));
				title.setForeground(Color.white);
				this.add(title);
				
				Object[] columns = {"Name", "ID","Password","Answer","Dept","Course 1","Course 2","Course 3"};
				dTableModel = new DefaultTableModel(databaseInfo, columns);
				
				ArrayList<Studenttype> list =studentList();
				Object[] tempRow = new Object[8];
				
				for(int i=0;i<list.size();i++){
					
					tempRow[0]=list.get(i).getStudentName();
					tempRow[1]=list.get(i).getstudentId();
					tempRow[2]=list.get(i).getPassword();
					tempRow[3]=list.get(i).getStudentAnswer();
					tempRow[4]=list.get(i).getDept();
					tempRow[5]=list.get(i).getCourse1();
					tempRow[6]=list.get(i).getCourse2();
					tempRow[7]=list.get(i).getCourse3();
					
					dTableModel.addRow(tempRow);
				}
				
				JTable table = new JTable(dTableModel);
				table.setRowHeight(table.getRowHeight()+10);
				table.setAutoCreateRowSorter(true);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				TableColumn col1 = table.getColumnModel().getColumn(0);
				col1.setPreferredWidth(80);
				
				TableColumn col2 = table.getColumnModel().getColumn(1);
				col2.setPreferredWidth(60);
				
				TableColumn col3 = table.getColumnModel().getColumn(2);
				col3.setPreferredWidth(60);
				
				TableColumn col4 = table.getColumnModel().getColumn(3);
				col4.setPreferredWidth(60);
				
				TableColumn col5 = table.getColumnModel().getColumn(4);
				col5.setPreferredWidth(60);
				
				TableColumn col6 = table.getColumnModel().getColumn(5);
				col6.setPreferredWidth(90);
				
				TableColumn col7 = table.getColumnModel().getColumn(6);
				col7.setPreferredWidth(90);
				
				TableColumn col8 = table.getColumnModel().getColumn(7);
				col8.setPreferredWidth(90);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(50,50,580,530);
				add(scrollPane);
	
	
	}
	
	public ArrayList<Studenttype> studentList(){
		
		ArrayList<Studenttype> studentList = new ArrayList<Studenttype>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			String sql= "select * from student";
			ResultSet rs   = stmt.executeQuery(sql);
			
		    Studenttype student;
			while(rs.next())
			{
				student = new Studenttype(rs.getString(4), rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				studentList.add(student);
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return studentList;
	}
	 
}