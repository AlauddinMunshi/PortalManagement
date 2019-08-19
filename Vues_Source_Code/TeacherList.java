
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;


public class TeacherList extends JPanel{
	
	AdminFrame frame;
	static Object[][] databaseInfo;
	static DefaultTableModel dTableModel;
	
	public TeacherList(AdminFrame frame){
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
				JLabel title=new JLabel("Teachers List");
				title.setBounds(280,20,200,20);
				title.setFont(new Font("Serif", Font.BOLD, 20));
				title.setForeground(Color.white);
				this.add(title);
				
				Object[] columns = {"Name", "ID","Password","Answer","Dept","Salary"};
				dTableModel = new DefaultTableModel(databaseInfo, columns);
				
				ArrayList<Teachertype> list =teacherList();
				Object[] tempRow = new Object[6];
				
				for(int i=0;i<list.size();i++){
					
					tempRow[0]=list.get(i).getTeacherName();
					tempRow[1]=list.get(i).getTeacherId();
					tempRow[2]=list.get(i).getPassword();
					tempRow[3]=list.get(i).getTeacherAnswer();
					tempRow[4]=list.get(i).getDept();
					tempRow[5]=list.get(i).getSalary();
					
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
				scrollPane.setBounds(85,50,480,530);
				add(scrollPane);
	
	
	}
	
	public ArrayList<Teachertype> teacherList(){
		
		ArrayList<Teachertype> teacherList = new ArrayList<Teachertype>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vues","root","");
			Statement stmt = con.createStatement();
			String sql= "select * from teacher";
			ResultSet rs   = stmt.executeQuery(sql);
			
			Teachertype teacher;
			while(rs.next())
			{
				teacher = new Teachertype(rs.getString(4), rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(6));
				teacherList.add(teacher);
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return teacherList;
	}
	 
}