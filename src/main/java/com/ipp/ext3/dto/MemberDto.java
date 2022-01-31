package com.ipp.ext3.dto;

public class MemberDto {

	private String pId;
	private String pPw;
	private String cName;
	private String cEmail;
	private String cTel;

	public MemberDto() {
	}

	public MemberDto(String pId, String pPw, String cName, String cEmail, String cTel) {
		this.pId = pId;
		this.pPw = pPw;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cTel = cTel;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpPw() {
		return pPw;
	}

	public void setpPw(String pPw) {
		this.pPw = pPw;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

}
