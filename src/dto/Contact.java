package dto;

public class Contact extends Account{
	
	private int phoneNumber;
	private String email;
	private String adress;
	private int usersId;
	
	public Contact(String name, String surname, int phoneNumber, String email, String adress, int usersId){
		super(name, surname);
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.adress=adress;
		this.usersId=usersId;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Contact [ name=" + name + ", surname=" + surname + "phoneNumber" + phoneNumber + ", email=" + email + ", adress=" + adress + "]";
	}

}
