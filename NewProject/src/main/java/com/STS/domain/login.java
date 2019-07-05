package com.STS.domain;




public class login {
	
private String name;

private String psw;



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
@Override
public String toString() {
	return "login [name=" + name + ", psw=" + psw + "]";
}


}
