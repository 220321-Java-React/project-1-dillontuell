package com.revature.models;

public class ReimbursementType {

	private int type_id;
	private String reimb_type;
	
	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementType(int type_id, String reimb_type) {
		super();
		this.type_id = type_id;
		this.reimb_type = reimb_type;
	}
	
	public ReimbursementType(String reimb_type) {
		super();
		this.reimb_type = reimb_type;
	}
	
	@Override
	public String toString() {
		return "Role [type_id=" + type_id + ", reimb_type=" + reimb_type + "]";
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	
}
