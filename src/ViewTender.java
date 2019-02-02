import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ViewTender extends JFrame {

	public ViewTender(Application a,Intender intn) {
		this.setTitle("View all Tenders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		ViewTender that = this;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 576, 220);
		getContentPane().add(scrollPane);
		Object rowData[][] = { { 1, "<html><a href=\"\">xyz </a></html>", "2nd Nov 2018", "2nd Dec 2018" }};
		        Object columnNames[] = { "Id", "Tender Title", "Date of Issue", "Last date for quotation submission" };
		JTable table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);
		table.addMouseListener(new java.awt.event.MouseAdapter()
        {
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
//				int row=table.rowAtPoint(e.getPoint());
//				
//				int col= table.columnAtPoint(e.getPoint());
//				if(col==1) {
//				ViewTender viewtender = new ViewTender();
//				viewtender.setVisible(true);}
			}});
		table.setEnabled(false);
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			that.dispose();
			}
		});
		back.setBounds(257, 331, 117, 25);
		getContentPane().add(back);
	}

}
