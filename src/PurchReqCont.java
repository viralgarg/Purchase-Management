import java.util.ArrayList;
import java.sql.*;

public class PurchReqCont {
	
	public PurchReqCont(Intender intn, ArrayList<Product> P,Application appl) {
		
		System.out.println("In PurchReqCont");
		MysqlCon sql = new MysqlCon();
		Connection con = sql.Con();
		try {
//			appl.setID(1);
			Statement stmt = con.createStatement();
			float cost = 0;
			for(int i=0;i<P.size();i++) {
				cost = cost + P.get(i).getCost();
			}
			stmt.executeUpdate("insert into application  (intender_id,title,status,remarks,date_app,description,est_total,fin_date,category)  value("+intn.getId()+",'"+appl.getTitle()+"','"+appl.getStatus()+"',' ','"+appl.getDate_app()+"','"+appl.getDesc()+"',"+cost+",'"+appl.getFin_date()+"','"+appl.getCategory()+"');");
			System.out.println("Application added");
			ResultSet r = stmt.executeQuery("select count(*) from application;");
			r.first();
			int id = r.getInt(1);
			for(int i=0;i<P.size();i++) {
				System.out.print("inside for of product ");
				stmt.executeUpdate("insert into product values("+id+",'"+P.get(i).getName()+"','"+P.get(i).getDesc()+"','"+P.get(i).getReason()+"',"+P.get(i).getCost()+",'"+P.get(i).getReq_specs()+"','"+P.get(i).getPref_specs()+"');");				
				System.out.println("Product added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
