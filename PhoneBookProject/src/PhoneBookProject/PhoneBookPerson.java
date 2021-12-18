package PhoneBookProject;

public class PhoneBookPerson {

	private String firstName;
	private String middleName;
	private String lastName;
	private long phoneNumber;
	private PhoneBookAddress address;
	
	public PhoneBookPerson(String firstName, String middleName, String lastName, long phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		
	}
	
	public void addAddress(String street, String city, String state, String zipCode) {
		PhoneBookAddress tempAddress = new PhoneBookAddress(street, city, state, zipCode);
		address = tempAddress;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public PhoneBookAddress getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(PhoneBookAddress address) {
		this.address = address;
	}
	
	public String getMyCity() {
		return address.getCity();
	}
	
	public String getMyState() {
		return address.getState();
	}
	
	public String getMyZipCode() {
		return address.getZipCode();
	}
	
	public String getMyStreet() {
		return address.getStreet();
	}
	
	public void getPerson() {
		String newPhone = Long.toString(phoneNumber);
		System.out.println("First Name: " + firstName + "\nMiddle Name: " + middleName + "\nLast Name: " + lastName + "\nPhone #: " + "(" + newPhone.substring(0,3) + ")-" + newPhone.substring(3,6) + "-" + newPhone.substring(6,10)
				+ "\n\nAddress:\n " + address);
		System.out.println("-----------------------------\n");
	}

}
