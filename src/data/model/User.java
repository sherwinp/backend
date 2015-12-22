package data.model;

public class User {
	private int Id;
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private int getId() {
		return Id;
	}
	private void setId(int userId) {
		this.Id = userId;
	}
}
