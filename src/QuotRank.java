import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class QuotRank extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public QuotRank(Quotation q) {
		this.setTitle("Quotation");
		
		QuotRank that = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vendor Name");
		lblNewLabel.setBounds(44, 62, 192, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact");
		lblNewLabel_1.setBounds(44, 89, 192, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(44, 116, 192, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(44, 143, 202, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(q.getV_name());
		lblNewLabel_4.setBounds(318, 62, 202, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(q.getV_contact());
		lblNewLabel_5.setBounds(318, 89, 202, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(q.getV_email());
		lblNewLabel_6.setBounds(318, 116, 202, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(q.getV_add());
		lblNewLabel_7.setBounds(318, 143, 202, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setBounds(44, 170, 202, 15);
		contentPane.add(lblRank);
		
		textField = new JTextField();
		textField.setBounds(318, 168, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 238, 495, 115);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Name"); 
		model.addColumn("Description");
		model.addColumn("Reason for Purchase"); 
		model.addColumn("Estimated Cost");
		model.addRow(new Object [] {"<html><a href=\\\"\\\">Data</a></html>","Some Data","Data","1000"});
		model.addRow(new Object [] {"<html><a href=\\\"\\\">Data</a></html>","Some Data","Data","1000"});
		model.addRow(new Object [] {"<html><a href=\\\"\\\">Data</a></html>","Some Data","Data","1000"});
		model.addRow(new Object [] {"<html><a href=\\\"\\\">Data</a></html>","Some Data","Data","1000"});
		model.addRow(new Object [] {"<html><a href=\\\"\\\">Data</a></html>","Some Data","Data","1000"});
		model.addRow(new Object [] {"<html><a href=\\\"\\\">Data</a></html>","Some Data","Data","1000"});
		
		scrollPane.setViewportView(table);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(71, 365, 117, 25);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();
			}
		});
		btnBack.setBounds(360, 365, 114, 25);
		contentPane.add(btnBack);
		table.addMouseListener(new java.awt.event.MouseAdapter()
		{																
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if (col==0) {
					//int intn_id  = (int)model.getValueAt(row, col);
					VendProd vap =  new VendProd();
					vap.setVisible(true);
				}
			}
		}
		);
		
	}
}
