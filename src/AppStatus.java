import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AppStatus extends JFrame {

	private JPanel contentPane;
	
	public AppStatus(Intender intn) {
		AppStatus that = this;
		
		this.setTitle("Application Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		ArrayList<Application> appl = new ArrayList<Application>();		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 576, 215);
		contentPane.add(scrollPane);
		Object columnNames[] = { "Id", "Purchase Title", "Date of Submission", "Status" };
		DefaultTableModel model = new DefaultTableModel(columnNames,0); 
		JTable table = new JTable(model); 
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();;
			}});
		btnBack.setBounds(474, 322, 114, 25);
		contentPane.add(btnBack);
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from application where intender_id="+intn.getId()+" and status ='New';");
			System.out.println("Showing previous application of "+intn.getName());
			
			while(rs.next()) {
				Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
				model.addRow(new Object [] {a.getID(),"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getDate_app(),a.getStatus()});
				appl.add(a);
			}
			rs = stmt.executeQuery("select * from application where intender_id="+intn.getId()+" and status ='Ongoing';");
			System.out.println("Showing previous application of "+intn.getName());
			
			while(rs.next()) {
				Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
				model.addRow(new Object [] {a.getID(),"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getDate_app(),a.getStatus()});
				appl.add(a);
			}
			rs = stmt.executeQuery("select * from application where intender_id="+intn.getId()+" and status ='Quotation Recieved';");
			System.out.println("Showing previous application of "+intn.getName());
			
			while(rs.next()) {
				Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
				model.addRow(new Object [] {a.getID(),"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getDate_app(),a.getStatus()});
				appl.add(a);
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		table.addMouseListener(new java.awt.event.MouseAdapter()
        {
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if(col==1) {
					if(appl.get(row).getStatus().equals("Quotation Recieved")) {
						TechReview tc = new TechReview(intn,appl.get(row));
						tc.setVisible(true);
					}
					else {
						ViewApplication viewapp = new ViewApplication(intn,appl.get(row));
						viewapp.setVisible(true);
					}
				}
			}
		});
		
		table.setEnabled(false);
		

	}
}
