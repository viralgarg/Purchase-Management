import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class PrevPurchases extends JFrame {
	

	public PrevPurchases(Intender intn) {
		setTitle("Previous Applications");
		PrevPurchases that = this;
		
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		ArrayList<Application> appl = new ArrayList<Application>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 576, 228);
		getContentPane().add(scrollPane);
		Object columnNames[] = { "Id", "Purchase Title", "Date of Purchase", "Status" };
		DefaultTableModel model = new DefaultTableModel(columnNames,0); 
		JTable table = new JTable(model); 

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from application where intender_id="+intn.getId()+" and status ='Completed';");
			System.out.println("Showing previous application of "+intn.getName());
			
			while(rs.next()) {
				Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
				model.addRow(new Object [] {a.getID(),"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getDate_app(),a.getStatus()});
				appl.add(a);
			}
			rs = stmt.executeQuery("select * from application where intender_id="+intn.getId()+" and status ='Rejected';");
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
					ViewApplication viewapp = new ViewApplication(intn,appl.get(row));
					viewapp.setVisible(true);
				}
			}
		});
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();;
			}});
		btnBack.setBounds(261, 329, 117, 25);
		getContentPane().add(btnBack);
	}
}
