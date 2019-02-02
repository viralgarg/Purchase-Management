import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VendorQuotRep extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public VendorQuotRep(Application a) {
		this.setTitle("Vendor Quotation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVendorName = new JLabel("Name");
		lblVendorName.setBounds(51, 23, 134, 15);
		contentPane.add(lblVendorName);
		
		JLabel lblContact = new JLabel("Contact ");
		lblContact.setBounds(51, 50, 134, 15);
		contentPane.add(lblContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(51, 77, 134, 15);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(51, 104, 134, 15);
		contentPane.add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(311, 21, 221, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 48, 221, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(311, 75, 221, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(311, 102, 221, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 154, 530, 140);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Name"); 
		model.addColumn("Description");
		model.addColumn("Reason for Purchase"); 
		model.addColumn("Estimated Cost");
		model.addRow(new Object [] {"<html><a href=\\\"\\\">abc</a></html>","gojfshf","fsdb","1000"});
		scrollPane.setViewportView(table);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(213, 364, 117, 25);
		contentPane.add(btnSubmit);
		table.addMouseListener(new java.awt.event.MouseAdapter()
		{																
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				int row=table.rowAtPoint(e.getPoint());
				System.out.println("The Row selected is : "+row);
				int col= table.columnAtPoint(e.getPoint());
				if (col==0) {
					//int intn_id  = (int)model.getValueAt(row, col);
					TendProdDet vap =  new TendProdDet();
					vap.setVisible(true);
				}
			}
		}
		);
	}

}
