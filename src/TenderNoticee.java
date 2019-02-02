import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TenderNoticee extends JFrame {

	private JPanel contentPane;

	public TenderNoticee(Application a) {
		this.setTitle("Tender Notice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchaseApplication = new JLabel("Tender Notice");
		lblPurchaseApplication.setBounds(233, 42, 149, 15);
		contentPane.add(lblPurchaseApplication);
		
		JLabel lblNewLabel = new JLabel("Purchase Title");
		lblNewLabel.setBounds(66, 93, 119, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblPurtitle = new JLabel(a.getTitle());
		lblPurtitle.setBounds(320, 93, 253, 15);
		contentPane.add(lblPurtitle);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setBounds(66, 120, 119, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(a.getDesc());
		lblNewLabel_4.setBounds(320, 120, 253, 15);
		contentPane.add(lblNewLabel_4);
		
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		ArrayList<Product> P = new ArrayList<Product>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 212, 530, 140);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Name"); 
		model.addColumn("Description");
		model.addColumn("Estimated Cost");
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product where app_id="+a.getID()+";");
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7));
				P.add(p);
				model.addRow(new Object [] {"<html><a href=\"\">"+p.getName()+"</a></html>", p.getDesc(), p.getCost()});
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		table.addMouseListener(new java.awt.event.MouseAdapter()
		{																
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if (col==0) {
					//int intn_id  = (int)model.getValueAt(row, col);
					
					ViewProduct vap =  new ViewProduct(P.get(row));
					vap.setVisible(true);
				}
			}
		}
		);
		
		TenderNoticee that =this;
		JButton btnMakePurchase = new JButton("Submit Quotation");
		btnMakePurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendorQuotRep tend = new VendorQuotRep(a);
				tend.setVisible(true);
			}
		});
		btnMakePurchase.setBounds(43, 374, 187, 25);
		contentPane.add(btnMakePurchase);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			that.dispose();
			}
		});
		table.setEnabled(false);
		btnBack.setBounds(426, 374, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Total Est Cost");
		lblNewLabel_1.setBounds(66, 147, 138, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("12000");
		label.setBounds(320, 147, 70, 15);
		contentPane.add(label);
	}

}
