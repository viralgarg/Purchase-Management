import java.sql.*;
public class Intender {

		private int id;
		private String name;
		private float budget;
		
		public Intender(ResultSet intn) {
			try {
				this.id = intn.getInt(1);
				this.name = intn.getString(2);
				this.budget = intn.getFloat(3);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

}
