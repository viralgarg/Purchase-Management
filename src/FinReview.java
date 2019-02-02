import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class FinReview extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinReview frame = new FinReview();
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
	public FinReview() {
		this.setTitle("Financial Review");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppTitle = new JLabel("App Title");
		lblAppTitle.setBounds(26, 60, 166, 15);
		contentPane.add(lblAppTitle);
		
		JLabel lblEstCost = new JLabel("Est Cost");
		lblEstCost.setBounds(26, 87,  166, 15);
		contentPane.add(lblEstCost);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(305, 60, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(305, 87, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 150, 476, 82);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Quotation Id"); 
		model.addColumn("Rank");
		model.addColumn("Vendor Cost"); 
		model.addRow(new Object [] {"2","3","30000"});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("All Specs are Good");
		lblNewLabel_2.setBounds(208, 265, 293, 100);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(26, 436, 470, 128);
		contentPane.add(textPane);
		
		JLabel lblFinancialReview = new JLabel("Financial Review :");
		lblFinancialReview.setBounds(26, 414, 155, 15);
		contentPane.add(lblFinancialReview);
		
		JLabel lblTechnicalReview = new JLabel("Technical Review :");
		lblTechnicalReview.setBounds(26, 308, 149, 15);
		contentPane.add(lblTechnicalReview);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(220, 625, 117, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblAddFinancialReview = new JLabel("Add Financial Review");
		lblAddFinancialReview.setBounds(171, 22, 174, 15);
		contentPane.add(lblAddFinancialReview);
	}

}
