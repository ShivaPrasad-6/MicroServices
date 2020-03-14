package cts.user.pojo;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
	@Entity
	@Table(name="users")
	public class User {
	
	  @Id
	  private String username;
	  @Column(name="password",nullable=false,length=100)
	  private String password;
	  private String confirm;
	  private int phone;
	  private String email;
	  private String usertype;
	  public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public String profileimage;  
	  
	  @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", confirm=" + confirm + ", phone=" + phone
				+ ", email=" + email + ", usertype=" + usertype + ", profileimage=" + profileimage + "]";
	}
	 public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPhone() {
		return phone;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	  public String getUsername() {
	  return username;
	  }
	  public void setUsername(String username) {
	  this.username = username;
	  }
	  public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	  public String getEmail() {
	  return email;
	  }
	  public void setEmail(String email) {
	  this.email = email;
	  }
	}
