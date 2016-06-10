package sinauadmin.model;

public class AdminUser {
	private String userId;
	private String email;
	private String name;
	private String phone;
	private String userAddress;
	private String otherSchool;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getOtherSchool() {
		return otherSchool;
	}
	public void setOtherSchool(String otherSchool) {
		this.otherSchool = otherSchool;
	}
}
