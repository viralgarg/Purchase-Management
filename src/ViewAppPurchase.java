import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ViewAppPurchase extends JFrame {

	private JPanel contentPane;

	public ViewAppPurchase(Application a) {
		this.setTitle("");
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		ArrayList<Product> P = new ArrayList<Product>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchaseApplication = new JLabel("Purchase Application");
		lblPurchaseApplication.setBounds(233, 42, 149, 15);
		contentPane.add(lblPurchaseApplication);
		
		JLabel lblNewLabel = new JLabel("Purchase Title");
		lblNewLabel.setBounds(66, 93, 119, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblPurtitle = new JLabel(a.getTitle());
		lblPurtitle.setBounds(320, 93, 119, 15);
		contentPane.add(lblPurtitle);
		
		JLabel lblNewLabel_1 = new JLabel("Intender");
		lblNewLabel_1.setBounds(66, 120, 119, 15);
		contentPane.add(lblNewLabel_1);
		Intender intn = null;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from intender where id="+a.getIntender_id()+";");
			rs.first();
			intn = new Intender(rs);
		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_2 = new JLabel(intn.getName());
		lblNewLabel_2.setBounds(320, 120, 119, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setBounds(66, 147, 119, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(a.getDesc());
		lblNewLabel_4.setBounds(320, 147, 119, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Budget Remaining");
		lblNewLabel_5.setBounds(66, 174, 140, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(Float.toString(a.getEst_total()));
		lblNewLabel_6.setBounds(320, 174, 119, 15);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 212, 530, 140);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Name"); 
		model.addColumn("Description");
		model.addColumn("Reason for Purchase"); 
		model.addColumn("Estimated Cost");
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product where app_id="+a.getID()+";");
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7));
				P.add(p);
				model.addRow(new Object [] {"<html><a href=\"\">"+rs.getString(2)+"</a></html>", rs.getString(3), rs.getString(4), rs.getString(5)});
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
		
		ViewAppPurchase that =this;
		JButton btnMakePurchase = new JButton("Make Tendor");
		btnMakePurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakePurchase mkpur = new MakePurchase(that,a);
				mkpur.setVisible(true);
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
	}
}
