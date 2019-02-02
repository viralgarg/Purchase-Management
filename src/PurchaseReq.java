import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class PurchaseReq extends JFrame {

	private JTextField p_title;
	private ArrayList<Product> p = new ArrayList<Product>()  ;

	
	@SuppressWarnings("unchecked")
	public PurchaseReq(Intender intn) {
		this.setTitle("New Purchase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		PurchaseReq that = this;
		
		JLabel lblNewLabel = new JLabel("Budget Remain");
		
		JLabel lblNewLabel_1 = new JLabel(Float.toString(intn.getBudget()));
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		
		JLabel lblArtClub = new JLabel(intn.getName());
		
		JLabel lblPurchaseTitle = new JLabel("Purchase Title");
		
		p_title = new JTextField();
		p_title.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		model.addColumn("Name"); 
		model.addColumn("Description");
		model.addColumn("Reason for Purchase"); 
		model.addColumn("Estimated Cost");
		scrollPane.setViewportView(table);
		JButton btnAddProducts = new JButton("Add Products");
		btnAddProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProducts addp = new AddProducts();
				addp.setVisible(true);
				addp.getSubmit().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product P = new Product(addp.getName(),addp.getDesc().getText(),addp.getRsn_purch().getText(),Float.valueOf(addp.getCost().getText()),addp.getReq_specs().getText(),addp.getPref_specs().getText());
						System.out.println("HEllo"+P.getName());
						p.add(P);
						model.addRow(new Object[]{P.getName(),P.getDesc(),P.getReason(),P.getCost()});
						System.out.println(p);
					}
				});
			}
		});
		JTextPane textPane = new JTextPane();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		JLabel lblDasas = new JLabel(dtf.format(localDate));
		
		JLabel lblAddItems = new JLabel("Purchase Application");
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(271, 69, 200, 24);
		comboBox.addItem("Electrical");
		comboBox.addItem("Logistics");
		comboBox.addItem("I.T.");
		comboBox.addItem("Infrastructure");
		comboBox.addItem("Others");
		
//		JLabel Estimated_cost = new JLabel("Total Estimated Cost");
//		JLabel Category = new JLabel("Category");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application appl = new Application(0, intn.getId(), p_title.getText(), "New", " ",dtf.format(localDate),textPane.getText(),0,"",comboBox.getSelectedItem().toString());
				new PurchReqCont(intn,p,appl);
				that.setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//that.setVisible(false);
				that.dispose();
			}
		});
		
		JLabel lblDate = new JLabel("Date");
		
		
		
		
		JLabel lblDescription = new JLabel("Description");
		
		JLabel lblCategory = new JLabel("Category");
		
		
		
		JLabel lblTotalEstimatedCost = new JLabel("Total Estimated Cost");
		
		JLabel lblNewLabel_3 = new JLabel("0");
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					.addComponent(btnAddProducts, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(204))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPurchaseTitle, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescription)
								.addComponent(lblCategory)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(p_title, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(lblArtClub, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, 0, 205, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addComponent(lblAddItems, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(94)
							.addComponent(lblDate)))
					.addGap(32)
					.addComponent(lblDasas)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
					.addGap(24))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblTotalEstimatedCost)
					.addGap(115)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddItems)
						.addComponent(lblDate)
						.addComponent(lblDasas))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurchaseTitle)
						.addComponent(p_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblArtClub))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescription)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCategory)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalEstimatedCost)
						.addComponent(lblNewLabel_3))
					.addGap(32)
					.addComponent(btnAddProducts)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnSubmit))
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);
	}
}
