package PT2019.assignment3.Assignment3.model;

public class Client {
	private int id;
	private String name;
	private String address;
	private String email;
	private String phoneNumber;

	public Client() {
		this.id = 0;
		this.name = "";
		this.address = "";
		this.email = "";
		this.phoneNumber = "";
	}

	public Client(int id, String name, String address, String email, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return this.name + ", from" + this.address + ", email " + this.email
				+ ", phone number " + this.phoneNumber + "\n";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
