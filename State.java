
public class State {
	String nm;
	String tx;
	String az;
	String ca;
	
	public State() {
		nm = "nm";
		tx = "tx";
		az = "az";
		ca = "ca";
	
	}//end constructor
	public String getNm() {
		return nm;
	}//endgetter
	
	public String getTx() {
		return tx;
	}//endgetter
	
	public String getAz() {
		return az;
	}//endgetter
	
	public String getCa() {
		return ca;
	}//endgetter

	public void setNm(String n) {
		nm = n;
	}//end setter
	
	public void setTx(String t) {
		tx = t;
	}//end setter
	
	public void setAz(String a) {
		az = a;
	}//end setter
	
	public void setCa(String c) {
		ca = c;
	}//end setter



}//end state
