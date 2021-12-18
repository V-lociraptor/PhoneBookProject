package PhoneBookProject;

import java.util.*;

public class PhoneBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		PhoneBookPerson p1 = new PhoneBookPerson("John", "", "Doe", 6366435698L);
		p1.addAddress("114 Market St", "St Louis", "MO", "63403");
		
		PhoneBookPerson p2 = new PhoneBookPerson("John", "E", "Doe", 8475390126L);
		p2.addAddress("324 Main St", "St Charles", "MO", "63303");
	
		PhoneBookPerson p3 = new PhoneBookPerson("John", "Michael West ", "Doe", 5628592375L);
		p3.addAddress("574 Pole Ave", "St. Peters", "MO", "63333");
		
		PhoneBookPerson p4 = new PhoneBookPerson("Anthony", "Edward", "Stark", 1010101010L);
		p4.addAddress("001 Times Square", "New York City", "NY", "12345");
		
		PhoneBookDirectory d1 = new PhoneBookDirectory();
		
		
		d1.addPerson(p1);
		d1.addPerson(p2);
		d1.addPerson(p3);
		d1.addPerson(p4);

		int choice = 0;
		int searchChoice = 0;

		int updateChoice = 0;
		
		while (choice != 6) {
			choice = menu();
			switch (choice) {
			case 1:
				// Breaks when you try to update something...
				// Revision in progress, currently prints data location instead of actual data
				System.out.println("List of people:\n_________________________");
				d1.printAlphabetically(d1.getDirectory());
				break;
			case 2:
				// Works!
				System.out.println("Enter info separated by commas: Ex: Name, Street Address, City, State, Zip, Phone Number");
				String addedPerson = input.nextLine();
				String[] tempInfo = addedPerson.split(", ");
				String name = tempInfo[0];
				String street = tempInfo[1];
				String city = tempInfo[2];
				String state = tempInfo[3];
				String zipCode = tempInfo[4];
				long phoneNum = Long.parseLong(tempInfo[5]);
				
				// Separates name into first, middle and last name.
				String[] tempName = name.split(" ");
				String firstName = tempName[0];
				String lastName = tempName[tempName.length - 1];
				
				String middleName = "";
				for(int i = 1; i < tempName.length - 1; i++) {
					middleName += tempName[i];
					if (i != tempName.length - 2) {
						middleName += " ";
					}
				}
				System.out.println(middleName);
				
				PhoneBookPerson pNew = new PhoneBookPerson(firstName, middleName, lastName, phoneNum);
				pNew.addAddress(street, city, state, zipCode);
				d1.addPerson(pNew);
				break;
			case 3:
				// MOSTLY works.
				System.out.println("How do you want to search?");
				
				while (searchChoice != 9) {
					searchChoice = searchMenu();
					switch (searchChoice) {
					case 1:
						// Works!
						System.out.println("Enter first name.");
						String searchedFirstName = input.next();
						d1.printPersonArray(d1.getByFirstName(searchedFirstName));
						break;
					case 2:
						// Works!
						System.out.println("Enter last name.");
						String searchedLastName = input.next();
						d1.printPersonArray(d1.getByLastName(searchedLastName));
						break;
					case 3:
						// Works!
						System.out.println("Enter full name.");
						String searchedFull = input.nextLine();
						d1.printPersonArray(d1.getByFullName(searchedFull));
						break;
					case 4:
						// Works!
						System.out.println("Enter phone number.");
						long searchedNumber = input.nextLong();
						d1.getByPhoneNumber(searchedNumber).getPerson(); 
						break;
					case 5:
						// Works!
						System.out.println("Enter street address.");
						String searchedStreet = input.next();
						d1.printPersonArray(d1.getByStreetAddress(searchedStreet));
						break;
					case 6:
						// Works!
						System.out.println("Enter city.");
						String searchedCity = input.next();
						d1.printPersonArray(d1.getByCity(searchedCity));
						break;
					case 7:
						// Works!
						System.out.println("Enter state.");
						String searchedState = input.next();
						d1.printPersonArray(d1.getByState(searchedState));
						break;
					case 8:
						// Works!
						System.out.println("Enter zip code.");
						String searchedZipCode = input.next();
						d1.printPersonArray(d1.getByZipCode(searchedZipCode));
						break;
					case 9:
						// Works!
						System.out.println("Stepping back!");
						break;
					default:
						// Works!
						System.out.println("Enter a valid number, please.");
					}
				}
				break;
			case 4:
				System.out.println("Enter phone number of the entry to update.");
				long updatingPerson = input.nextLong();
				d1.getByPhoneNumber(updatingPerson).getPerson();
				
				while (updateChoice != 7) {
					updateChoice = updateMenu();
					switch (updateChoice) {
					case 1:
						System.out.println("Enter new first name.");
						String newFirst = input.next();
						d1.getByPhoneNumber(updatingPerson).setFirstName(newFirst);
						break;
					case 2:
						System.out.println("Enter new last name.");
						String newLast = input.next();
						d1.getByPhoneNumber(updatingPerson).setLastName(newLast);
						break;
					case 3:
						System.out.println("Enter new street address.");
						String newStreet = input.next();
						d1.getByPhoneNumber(updatingPerson).getAddress().setStreet(newStreet);
						break;
					case 4:
						System.out.println("Enter new city.");
						String newCity = input.next();
						d1.getByPhoneNumber(updatingPerson).getAddress().setCity(newCity);
						break;
					case 5:
						System.out.println("Enter new state.");
						String newState = input.next();
						d1.getByPhoneNumber(updatingPerson).getAddress().setState(newState);
						break;
					case 6:
						System.out.println("Enter new zip code.");
						String newZipCode = input.next();
						d1.getByPhoneNumber(updatingPerson).getAddress().setZipCode(newZipCode);
						break;
					case 7:
						// Works!
						System.out.println("Stepping back!");
						break;
					default:
						// Works!
						System.out.println("Enter a valid number.");
					}
				}
//				d1.deletePerson(d1.getByPhoneNumber(updatingPerson));
//				System.out.println("Enter new information, separated by commas. Ex: Name, Street Address, City, State, Zip, Phone Number");
//				String updatedPerson = input.nextLine();
//				String[] updateTempInfo = updatedPerson.split(", ");
//				String updatedName = updateTempInfo[0];
//				String updatedStreet = updateTempInfo[1];
//				String updatedCity = updateTempInfo[2];
//				String updatedState = updateTempInfo[3];
//				String updatedZipCode = updateTempInfo[4];
//				String updatedPhoneNum = updateTempInfo[5];
//				
//				//separate name into first and last name
//				String[] updatedTempName = updatedName.split(" ");
//				String updatedFirstName = updatedTempName[0];
//				String updatedLastName = updatedTempName[updatedTempName.length - 1];
//				
//				String updatedMiddleName = "";
//				for(int i = 1; i < updatedTempName.length - 1; i++) {
//					updatedMiddleName += updatedTempName[i];
//					if (i != updatedTempName.length - 2) {
//						updatedMiddleName += " ";
//					}
//				}
//				PhoneBookPerson pUpdated = new PhoneBookPerson(updatedFirstName, updatedMiddleName, updatedLastName, updatedPhoneNum);
//				pUpdated.addAddress(updatedStreet, updatedCity, updatedState, updatedZipCode);
//				d1.addPerson(pUpdated);
//				System.out.println("Update complete.");
				break;
			case 5:
				// Works!
				System.out.println("Enter the phone number of the entry to delete.");
				long deletingPerson = input.nextLong();
				d1.deletePerson(d1.getByPhoneNumber(deletingPerson));
				System.out.println("Deleted successfully.");
				break;
			case 6:
				// Works!
				System.out.println("See you!");
				break;
			default:
				// Works!
				System.out.println("Enter a valid number, please.");
			}
		}
	}
	
	public static int menu() {
		
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter 1 to show the directory.");
		System.out.println("Enter 2 to add an entry.");
		System.out.println("Enter 3 to search the directory.");
		System.out.println("Enter 4 to update existing entries.");
		System.out.println("Enter 5 to delete an entry.");
		System.out.println("Enter 6 to exit.");
		
		int choice = scan1.nextInt();
		System.out.println();
		return choice;
	}
	public static int searchMenu() {
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter 1 to search by first name.");
		System.out.println("Enter 2 to search by last name.");
		System.out.println("Enter 3 to search by full name.");
		System.out.println("Enter 4 to search by phone number.");
		System.out.println("Enter 5 to search by street address.");
		System.out.println("Enter 6 to search by city.");
		System.out.println("Enter 7 to search by state.");
		System.out.println("Enter 8 to search by zip code.");
		System.out.println("Enter 9 to return to main menu.");
		
		int selection = scan2.nextInt();
		System.out.println();
		return selection;

	}
	public static int updateMenu() {
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Enter 1 to update first name.");
		System.out.println("Enter 2 to update last name.");
		System.out.println("Enter 3 to update street address.");
		System.out.println("Enter 4 to update city.");
		System.out.println("Enter 5 to update state.");
		System.out.println("Enter 6 to update zip code.");
		System.out.println("Enter 7 to return to main menu.");
		
		int updateChoice = scan3.nextInt();
		System.out.println();
		return updateChoice;
	}
	
}
