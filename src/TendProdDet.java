import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class TendProdDet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TendProdDet frame = new TendProdDet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TendProdDet() {
		this.setTitle("View Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(47, 84, 149, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(327, 84, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(47, 112, 149, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(327, 112, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Estimated Cost");
		lblNewLabel_6.setBounds(47, 139, 149, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(327, 139, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Required Specification");
		lblNewLabel_8.setBounds(47, 166, 169, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(327, 166, 70, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Preffered Specification");
		lblNewLabel_10.setBounds(47, 193, 169, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(327, 193, 70, 15);
		contentPane.add(lblNewLabel_11);
		TendProdDet that =this;
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			that.dispose();
			}
		});
		btnBack.setBounds(412, 337, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblProductInfo = new JLabel("Product Info");
		lblProductInfo.setBounds(199, 57, 149, 15);
		contentPane.add(lblProductInfo);
		
		JLabel lblVendorProductDetail = new JLabel("Product Detail");
		lblVendorProductDetail.setBounds(47, 220, 169, 15);
		contentPane.add(lblVendorProductDetail);
		
		textField = new JTextField();
		textField.setBounds(327, 220, 261, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEstCost = new JLabel("Est Cost");
		lblEstCost.setBounds(47, 247, 169, 15);
		contentPane.add(lblEstCost);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 220, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(327, 251, 261, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(35, 337, 117, 25);
		contentPane.add(btnSubmit);
	}

}
