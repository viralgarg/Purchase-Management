import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


public class IntendLoginCont {

	public IntendLoginCont(String username) {
		
		MysqlCon con = new MysqlCon();
		Connection conn = con.Con();
		ResultSet rs;
		try {
			Statement stmt = conn.createStatement();
			System.out.println(username);
			rs = stmt.executeQuery("select * from user where username='"+username+"' and type='intender';");
			System.out.println("In intender");
			if(rs.first()) {
//				while(rs.next())
//					System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				rs.first();
				System.out.println(rs.getString(1));
				ResultSet intender = stmt.executeQuery("select * from intender where name='"+rs.getString(4)+"';");
				intender.first();
				Intender intn = new Intender(intender);
				welcomePageIntender welcomeInt = new welcomePageIntender(intn);
				welcomeInt.setVisible(true);
			}
			else {
				JFrame Eframe = new JFrame();
				Eframe.setBounds(100, 100, 450, 300);
				JLabel message = new JLabel("Invalid Username. Please try Again.");
				message.setBounds(100,50,300,40);
				JButton btnOk = new JButton("OK");
				btnOk.setBounds(130,200,100, 40);
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Eframe.setVisible(false);
					}
				});
				Eframe.getContentPane().setLayout(null);
				Eframe.getContentPane().add(message);
				Eframe.getContentPane().add(btnOk);
				Eframe.setVisible(true);
				System.out.println("No Intender user");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
