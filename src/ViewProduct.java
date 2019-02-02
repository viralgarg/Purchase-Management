import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ViewProduct extends JFrame {

	private JPanel contentPane;
	public ViewProduct(Product p) {
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
		
		JLabel lblNewLabel_1 = new JLabel(p.getName());
		lblNewLabel_1.setBounds(327, 84, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(47, 112, 149, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(p.getDesc());
		lblNewLabel_3.setBounds(327, 112, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Reason of Purchase");
		lblNewLabel_4.setBounds(47, 142, 149, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(p.getReason());
		lblNewLabel_5.setBounds(327, 142, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estimated Cost");
		lblNewLabel_6.setBounds(47, 169, 149, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(Float.toString(p.getCost()));
		lblNewLabel_7.setBounds(327, 169, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Required Specification");
		lblNewLabel_8.setBounds(47, 196, 169, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(p.getReq_specs());
		lblNewLabel_9.setBounds(327, 196, 70, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Preffered Specification");
		lblNewLabel_10.setBounds(47, 223, 169, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(p.getReq_specs());
		lblNewLabel_11.setBounds(327, 223, 70, 15);
		contentPane.add(lblNewLabel_11);
		ViewProduct that =this;
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			that.dispose();
			}
		});
		btnBack.setBounds(230, 303, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblProductInfo = new JLabel("Product Info");
		lblProductInfo.setBounds(199, 57, 149, 15);
		contentPane.add(lblProductInfo);
	}

}
