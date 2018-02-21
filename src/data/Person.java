package data;

public class Person {
    @Override
	public String toString() {
		return "Person [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
				+ "]";
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getLast_name() {
		return last_name;
	}
	public final void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public final String getFirst_name() {
		return first_name;
	}
	public final void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	private int id;
    private String last_name;
    private String first_name;
    private String email;
    
}
