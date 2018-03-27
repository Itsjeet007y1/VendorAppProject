package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tab")
public class User {
	
		@Id
		@Column(name="u_id")
		@GeneratedValue
		private int userId;
		@Column(name="user_nam")
		private String userName;
		@Column(name="user_email")
		private String userEmail;
		@Column(name="user_cnt")
		private String userContact;
		@Column(name="user_pwd")
		private String userPwd;
		@Column(name="user_addr")
		private String userAddrs;
		//default Constructor
		public User() {
			super();
		}
		//1-parameter constructor
		public User(int userId) {
			super();
			this.userId = userId;
		}
		//setters and getters
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserContact() {
			return userContact;
		}
		public void setUserContact(String userContact) {
			this.userContact = userContact;
		}
		public String getUserPwd() {
			return userPwd;
		}
		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}
		public String getUserAddrs() {
			return userAddrs;
		}
		public void setUserAddrs(String userAddrs) {
			this.userAddrs = userAddrs;
		}
		//toString() method
		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName
					+ ", userEmail=" + userEmail + ", userContact="
					+ userContact + ", userPwd=" + userPwd + ", userAddrs="
					+ userAddrs + "]";
		}
}
