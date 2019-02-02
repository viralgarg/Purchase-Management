
public class Product {

	private int app_id;
	private String name;
	private String desc;
	private String reason;
	private float cost;
	private String req_specs;
	private String pref_specs;
	
	public Product(int app_id,String name, String desc, String reason, float cost, String req_specs, String pref_specs) {
		this.setApp_id(app_id);
		this.name = name;
		this.desc = desc;
		this.reason = reason;
		this.cost = cost;
		this.req_specs = req_specs;
		this.pref_specs = pref_specs;
	}

	public Product(String name, String desc, String reason, float cost, String req_specs, String pref_specs) {
		this.name = name;
		this.desc = desc;
		this.reason = reason;
		this.cost = cost;
		this.req_specs = req_specs;
		this.pref_specs = pref_specs;
	}

	
	
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getReq_specs() {
		return req_specs;
	}
	public void setReq_specs(String req_specs) {
		this.req_specs = req_specs;
	}
	public String getPref_specs() {
		return pref_specs;
	}
	public void setPref_specs(String pref_specs) {
		this.pref_specs = pref_specs;
	}









	public int getApp_id() {
		return app_id;
	}









	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
}
