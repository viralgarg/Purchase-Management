import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class NewApplications extends JFrame {

	private JPanel contentPane;
	MysqlCon sql = new MysqlCon();
	Connection con = sql.Con();
	ArrayList<Application> appl = new ArrayList<Application>();

	public NewApplications() {
		NewApplications that = this;
		this.setTitle("New Applications");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 22, 544, 214);
		contentPane.add(scrollPane);
	    Object columnNames[] = { "Id", "Purchase Title"};
	    DefaultTableModel model = new DefaultTableModel(columnNames,0); 
		JTable table = new JTable(model); 
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from application where status='New';");
			System.out.println("Showing New applications");
			rs.first();
			while(rs.next()) {
				Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10));
//				ResultSet r = stmt.executeQuery("select name from intender where id="+a.getIntender_id()+";");
//				r.first();
				model.addRow(new Object [] {a.getID(),"<html><a href=\"\">"+a.getTitle()+"</a></html>"});
				appl.add(a);
			}
		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if (col==1) {
					ViewAppPurchase vap = new ViewAppPurchase(appl.get(row));
					vap.setVisible(true);
				}
			}
		}
		);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();
			}
		});
		btnBack.setBounds(247, 238, 96, 25);
		contentPane.add(btnBack);
	}
}
