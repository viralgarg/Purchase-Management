import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TenderCategory extends JFrame {

	private JPanel contentPane;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TenderCategory() {
		this.setTitle("Tender Categories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		TenderCategory that =this;
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(271, 69, 200, 24);
		comboBox.addItem("Electrical");
		comboBox.addItem("Logistics");
		comboBox.addItem("I.T.");
		comboBox.addItem("Infrastructure");
		comboBox.addItem("Others");
		contentPane.add(comboBox);
		
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		ArrayList<Application> appl = new ArrayList<Application>();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();
			}
		});
		btnBack.setBounds(234, 341, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setBounds(29, 74, 131, 15);
		contentPane.add(lblSelectCategory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 194, 533, 121);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Tender Name"); 
		model.addColumn("Last Date");
		model.addColumn("Description"); 
		JButton btnViewtenders = new JButton("ViewTenders");
		btnViewtenders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = comboBox.getSelectedItem().toString();
				if(value == "Electrical")
				{
					model.setRowCount(0);
					try {
						Statement stmt = con.createStatement();
						appl.clear();
						ResultSet rs = stmt.executeQuery("select * from application where category='Electrical' and status='Ongoing';");
						while(rs.next()) {
							Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
							model.addRow(new Object [] {"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getFin_date(),a.getDesc()});
							appl.add(a);
						}

					} catch (SQLException e ) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(value == "Logistics")
				{
					model.setRowCount(0);
					appl.clear();
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from application where category='Logistics' and status='Ongoing';");
						while(rs.next()) {
							Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
							model.addRow(new Object [] {"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getFin_date(),a.getDesc()});
							appl.add(a);
						}

					} catch (SQLException e ) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(value == "I.T.")
				{
					model.setRowCount(0);
					appl.clear();
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from application where category='I.T.' and status='Ongoing';");
						while(rs.next()) {
							Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
							model.addRow(new Object [] {"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getFin_date(),a.getDesc()});
							appl.add(a);
						}

					} catch (SQLException e ) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(value == "Infrastructure")
				{
					model.setRowCount(0);
					appl.clear();
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from application where category='Infrastructure' and status='Ongoing';");
						while(rs.next()) {
							Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
							model.addRow(new Object [] {"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getFin_date(),a.getDesc()});
							appl.add(a);
						}

					} catch (SQLException e ) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(value == "Others")
				{
					model.setRowCount(0);
					appl.clear();
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from application where category='Others' and status='Ongoing';");
						while(rs.next()) {
							Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
							model.addRow(new Object [] {"<html><a href=\"\">"+a.getTitle()+"</a></html>",a.getFin_date(),a.getDesc()});
							appl.add(a);
						}

					} catch (SQLException e ) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		table.addMouseListener(new java.awt.event.MouseAdapter()
        {
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
			int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if(col==0) {
					TenderNoticee viewapp = new TenderNoticee(appl.get(row));
					viewapp.setVisible(true);
				}
			}
		});
		table.setEnabled(false);
		btnViewtenders.setBounds(29, 143, 170, 25);
		contentPane.add(btnViewtenders);
		//model.addColumn("Estimated Cost");
		scrollPane.setViewportView(table);
		//scrollPane.setViewportView(table);
	}
}
