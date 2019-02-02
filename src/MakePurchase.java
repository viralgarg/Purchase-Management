import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MakePurchase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public MakePurchase(ViewAppPurchase parentthat,Application a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MakePurchase that =this;
		JLabel lblLastDateOf = new JLabel("Enter Last Date of Submission");
		lblLastDateOf.setBounds(25, 76, 233, 15);
		contentPane.add(lblLastDateOf);
		
		textField = new JTextField();
		textField.setBounds(260, 74, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeUpdate("update application set status='Ongoing',fin_date ='"+textField.getText()+"' where id="+a.getID()+";");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				that.dispose();
				parentthat.dispose();
			}
		});
		btnSubmit.setBounds(34, 206, 117, 25);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		btnBack.setBounds(257, 206, 117, 25);
		contentPane.add(btnBack);
	}
}
