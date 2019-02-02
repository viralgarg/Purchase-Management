public class Application {

	private int ID;
	private int intender_id;
	private String Title;
	private String status;
	private String remarks;
	private String date_app;
	private String desc;
	private float est_total;
	private String fin_date;
	private String category;

	
	public Application(int iD, int intender_id, String title, String status, String remarks, String date_app, String desc,float est_total, String fin_date, String category) {
		this.ID = iD;
		this.intender_id = intender_id ;
		this.Title = title;
		this.status = status;
		this.remarks = remarks;
		this.date_app = date_app;
		this.desc = desc;
		this.est_total = est_total;
		this.fin_date = fin_date;
		this.category = category;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getIntender_id() {
		return intender_id;
	}
	public void setIntender_id(int intender_id) {
		this.intender_id = intender_id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDate_app() {
		return date_app;
	}
	public void setDate_app(String date_app) {
		this.date_app = date_app;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getEst_total() {
		return est_total;
	}
	public void setEst_total(float est_total) {
		this.est_total = est_total;
	}
	public String getFin_date() {
		return fin_date;
	}
	public void setFin_date(String fin_date) {
		this.fin_date = fin_date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
