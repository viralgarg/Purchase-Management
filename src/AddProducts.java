import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddProducts extends JFrame {

	private JPanel contentPane;



	private JTextField name;
	private JTextField desc;
	private JLabel lblReasonOfPurchase;
	private JTextField rsn_purch;
	private JButton submit;
	private JButton clr;
	private JLabel lblProductInfo;
	private JTextField cost;
	private JLabel lblRequiredSpecifications;
	private JTextField req_specs;
	private JLabel lblPreferedSpecifications;
	private JTextField pref_specs;

	public AddProducts() {

		this.setTitle("Add Product Info");
		AddProducts that = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(59, 58, 70, 15);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(292, 51, 225, 30);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(59, 104, 124, 15);
		contentPane.add(lblDescription);
		
		desc = new JTextField();
		desc.setBounds(292, 93, 225, 37);
		contentPane.add(desc);
		desc.setColumns(10);
		
		lblReasonOfPurchase = new JLabel("Reason of Purchase :");
		lblReasonOfPurchase.setBounds(59, 147, 159, 15);
		contentPane.add(lblReasonOfPurchase);
		
		rsn_purch = new JTextField();
		rsn_purch.setBounds(292, 142, 225, 37);
		contentPane.add(rsn_purch);
		rsn_purch.setColumns(10);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.setVisible(false);
			}
		});
		submit.setBounds(66, 385, 117, 25);
		contentPane.add(submit);
		
		clr = new JButton("Back");
		clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		clr.setBounds(392, 385, 117, 25);
		contentPane.add(clr);
		
		lblProductInfo = new JLabel("Product Info");
		lblProductInfo.setBounds(244, 12, 99, 15);
		contentPane.add(lblProductInfo);
		
		JLabel lblNewLabel = new JLabel("Estimated Cost");
		lblNewLabel.setBounds(59, 195, 141, 9);
		contentPane.add(lblNewLabel);
		
		cost = new JTextField();
		cost.setBounds(292, 191, 225, 19);
		contentPane.add(cost);
		cost.setColumns(10);
		
		lblRequiredSpecifications = new JLabel("Required Specifications :");
		lblRequiredSpecifications.setBounds(59, 229, 170, 15);
		contentPane.add(lblRequiredSpecifications);
		
		req_specs = new JTextField();
		req_specs.setBounds(292, 222, 225, 51);
		contentPane.add(req_specs);
		req_specs.setColumns(10);
		
		lblPreferedSpecifications = new JLabel("Prefered Specifications :");
		lblPreferedSpecifications.setBounds(59, 291, 170, 15);
		contentPane.add(lblPreferedSpecifications);
		
		pref_specs = new JTextField();
		pref_specs.setBounds(292, 285, 225, 51);
		contentPane.add(pref_specs);
		pref_specs.setColumns(10);
	}
	
	
	
	public String getName() {
		return name.getText();
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getDesc() {
		return desc;
	}

	public void setDesc(JTextField desc) {
		this.desc = desc;
	}

	public JTextField getRsn_purch() {
		return rsn_purch;
	}

	public void setRsn_purch(JTextField rsn_purch) {
		this.rsn_purch = rsn_purch;
	}

	public JTextField getCost() {
		return cost;
	}

	public void setCost(JTextField cost) {
		this.cost = cost;
	}

	public JTextField getReq_specs() {
		return req_specs;
	}

	public void setReq_specs(JTextField req_specs) {
		this.req_specs = req_specs;
	}

	public JTextField getPref_specs() {
		return pref_specs;
	}

	public void setPref_specs(JTextField pref_specs) {
		this.pref_specs = pref_specs;
	}
	
	public JButton getSubmit() {
		return submit;
	}
	public void setSubmit(JButton submit) {
		this.submit = submit;
	}


	
}
