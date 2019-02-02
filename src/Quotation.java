public class Quotation{
	
	private int id;
	private int app_id;
	private String v_name;
	private String v_contact;
	private String v_email;
	private String v_add;
	private int tech_rank;
	private String tech_rev;
	private String finc_rev;
	private float total_cost;
	
		public Quotation(int id, int app_id, String v_name, String v_contact, String v_email, String v_add, int tech_rank,String tech_rev, String finc_rev, float total_cost) {
		super();
		this.id = id;
		this.app_id = app_id;
		this.v_name = v_name;
		this.v_contact = v_contact;
		this.v_email = v_email;
		this.v_add = v_add;
		this.tech_rank = tech_rank;
		this.tech_rev = tech_rev;
		this.finc_rev = finc_rev;
		this.total_cost = total_cost;
	}
		
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_contact() {
		return v_contact;
	}
	public void setV_contact(String v_contact) {
		this.v_contact = v_contact;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	public String getV_add() {
		return v_add;
	}
	public void setV_add(String v_add) {
		this.v_add = v_add;
	}
	public int getTech_rank() {
		return tech_rank;
	}
	public void setTech_rank(int tech_rank) {
		this.tech_rank = tech_rank;
	}
	public String getTech_rev() {
		return tech_rev;
	}
	public void setTech_rev(String tech_rev) {
		this.tech_rev = tech_rev;
	}
	public String getFinc_rev() {
		return finc_rev;
	}
	public void setFinc_rev(String finc_rev) {
		this.finc_rev = finc_rev;
	}
	public float getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}
	
}