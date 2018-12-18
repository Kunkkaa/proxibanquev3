package fr.formation.proxi.metier.service;

public class ChequeStatus {
	
	private String msg;
	
	private boolean chequeOk;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isChequeOk() {
		return chequeOk;
	}

	public void setChequeOk(boolean chequeOk) {
		this.chequeOk = chequeOk;
	}

	public ChequeStatus(String msg, boolean chequeOk) {
		this.msg = msg;
		this.chequeOk = chequeOk;
	}
	
	

}
