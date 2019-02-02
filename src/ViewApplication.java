import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ViewApplication extends JFrame {

	private JPanel contentPane;
	MysqlCon sql = new MysqlCon();
	Connection con = sql.Con();

	public ViewApplication(Intender intn,Application a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ViewApplication that = this;
		JLabel lblPurchaseApplication = new JLabel("Purchase Application");
		
		JLabel lblDate = new JLabel(a.getDate_app());
		
		JLabel lblPurchaseTitle = new JLabel("Purchase Title");
		
		JLabel title = new JLabel(a.getTitle());
		
		JLabel lblName = new JLabel("Name");
		
		JLabel name = new JLabel(intn.getName());
		
		JLabel lblDescription = new JLabel("Description");
		
		JLabel desc = new JLabel(a.getDesc());
		
		JLabel lblBudgetRemain = new JLabel("Estimated Cost");
		
		JLabel bgt_rem = new JLabel(Float.toString(a.getEst_total()));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(201)
							.addComponent(lblPurchaseApplication))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPurchaseTitle)
								.addComponent(lblName)
								.addComponent(lblDescription)
								.addComponent(lblBudgetRemain))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
										.addComponent(lblDate)
										.addGap(55))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(name)
										.addContainerGap()))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(title)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(bgt_rem)
								.addContainerGap()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(desc, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(287, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(237))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurchaseApplication)
						.addComponent(lblDate))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurchaseTitle)
						.addComponent(title))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(name))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(desc, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBudgetRemain)
						.addComponent(bgt_rem))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(40))
		);
		
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
				model.addRow(new Object [] {rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
