package com.member;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "member")
@DynamicUpdate
public class Member {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memId;

	@Column(name = "member_name")
	private String mName;
	@Column(name = "member_account")
	private String mAccount;
	@Column(name = "member_password")
	private String mPassword;
	@Column(name = "member_email")
	private String email;
	@Column(name = "member_phone")
	private String phone;
	@Column(name = "member_address")
	private String address;
	@Column(name = "member_state")
	private Byte mState;
	@Column(name = "member_gender")
	private Boolean gender;
	@Column(name = "member_birthday")
	private Date birthday;

	@Lob
	@Column(name = "member_img")
	private byte[] image;

	
	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getmName() {
		return mName;
	}
   
	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAccount() {
		return mAccount;
	}
  
	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getmState() {
		return mState;
	}

	public void setmState(Byte mState) {
		this.mState = mState;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Member [memId=" + memId + ", mName=" + mName + ", mAccount=" + mAccount + ", mPassword=" + mPassword
				+ ", email=" + email + ", phone=" + phone + ", mState=" + mState + ", address=" + address + ", gender="
				+ gender + ", birtday=" + birthday + ", image=" + Arrays.toString(image) + "]";
	}

	public Boolean getGender() {
		// TODO Auto-generated method stub
		return gender;
	}
}
