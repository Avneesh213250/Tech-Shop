package com.STS.domain;




public class Login {
	
private String email;

private String psw;




public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
@Override
public String toString() {
	return "login [email=" + email + ", psw=" + psw + "]";
}


}
