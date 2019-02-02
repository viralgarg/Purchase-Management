import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TechReview extends JFrame {

	private JPanel contentPane;

	public TechReview(Intender intn, Application a) {
		this.setTitle("Technical Review");
		TechReview that = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		ArrayList<Quotation> Q = new ArrayList<Quotation>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 77, 476, 88);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Id"); 
		model.addColumn("Vendor Name");
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from quotation where app_id="+a.getID()+";");
			while(rs.next()) {
				Quotation q = new Quotation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getFloat(10));
				model.addRow(new Object [] {"<html><a href=\"\">"+q.getId()+"</a></html>",q.getV_name()});
				Q.add(q);
			}

		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setBounds(37, 227, 97, 15);
		contentPane.add(lblReview);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(120, 217, 385, 126);
		contentPane.add(textPane);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(120, 385, 117, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblQuotations = new JLabel("Quotations");
		lblQuotations.setBounds(37, 27, 145, 15);
		contentPane.add(lblQuotations);
		table.addMouseListener(new java.awt.event.MouseAdapter()
        {
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
			int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if(col==0) {
					QuotRank viewapp = new QuotRank(Q.get(row));
					viewapp.setVisible(true);
				}
			}
		});
		table.setEnabled(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();
			}
		});
		btnBack.setBounds(362, 385, 114, 25);
		contentPane.add(btnBack);
	}
}
