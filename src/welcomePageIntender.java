import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class welcomePageIntender extends JFrame {

	private JPanel pur_req;

	public welcomePageIntender(Intender intn) {
		this.setTitle("Welcome Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		pur_req = new JPanel();
		pur_req.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pur_req);
//		welcomePageIntender that = this;
		
		JLabel lblWelcomeUser = new JLabel("WELCOME "+intn.getName());
		
		JButton pur_rqst = new JButton("Create Purchase Request");
		pur_rqst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PurchaseReq purchase =new PurchaseReq(intn);
				purchase.setVisible(true);
			}
		});
	
		JButton prev_pur = new JButton("Show Previous Purchases");
		prev_pur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrevPurchases previous = new PrevPurchases(intn);
				previous.setVisible(true);
			}
		});
		
		JButton app_stat = new JButton("Show Application Status");
		app_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AppStatus app = new AppStatus(intn);
				app.setVisible(true);
			}
		});
		
		JButton log_out = new JButton("Log Out");
		
		JLabel lblBudgetRemaining = new JLabel("Budget Remaining");
		
		JLabel lblBudget = new JLabel(Float.toString(intn.getBudget()));
		
		
		GroupLayout gl_pur_req = new GroupLayout(pur_req);
		gl_pur_req.setHorizontalGroup(
			gl_pur_req.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pur_req.createSequentialGroup()
					.addGap(7)
					.addComponent(lblWelcomeUser, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
					.addComponent(log_out, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_pur_req.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_pur_req.createParallelGroup(Alignment.TRAILING)
						.addComponent(app_stat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
						.addComponent(prev_pur, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
						.addComponent(pur_rqst, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
					.addGap(36))
				.addGroup(Alignment.LEADING, gl_pur_req.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBudgetRemaining, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addComponent(lblBudget, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(200, Short.MAX_VALUE))
		);
		gl_pur_req.setVerticalGroup(
			gl_pur_req.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pur_req.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_pur_req.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWelcomeUser)
						.addComponent(log_out))
					.addGap(38)
					.addGroup(gl_pur_req.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBudgetRemaining)
						.addComponent(lblBudget))
					.addGap(45)
					.addComponent(pur_rqst, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(prev_pur, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(app_stat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
		);
		pur_req.setLayout(gl_pur_req);
	}
}
