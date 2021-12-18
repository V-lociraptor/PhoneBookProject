package PhoneBookProject;

import java.util.*;

public class PhoneBookDirectory {

	// Makes new array of people
	PhoneBookPerson[] book = new PhoneBookPerson[0];

	// adds new person
	public void addPerson(PhoneBookPerson newPerson) {

		PhoneBookPerson[] tempArray = new PhoneBookPerson[book.length + 1];
		for (int i = 0; i < book.length; i++) {
			tempArray[i] = book[i];
		}

		tempArray[tempArray.length - 1] = newPerson;

		book = tempArray;
	}

	public PhoneBookPerson[] getDirectory() {
		return book;
	}

	// searches directory
	public PhoneBookPerson getByPhoneNumber(long phoneNumber) {
		// set a counter for the size of the array
		int foundIndex = 0;
		// for loop to determine the number of people in the new array
		for (int i = 0; i < book.length; i++) {
			if (book[i].getPhoneNumber() == phoneNumber) {
				foundIndex = i;
			}
		}
		return book[foundIndex];
	}

	public PhoneBookPerson[] getByFirstName(String first) {
		// set a counter for the array
		int counter = 0;
		// for loop ...
		for (int i = 0; i < book.length; i++) {
			if (book[i].getFirstName().equals(first)) {
				counter++;
			}
		}
		// create a new array with the counter size
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		// set a counter to align new index values
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getFirstName().equals(first)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	public PhoneBookPerson[] getByLastName(String last) {
		int counter = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getLastName().equals(last)) {
				counter++;
			}
		}
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getLastName().equalsIgnoreCase(last)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	public PhoneBookPerson[] getByFullName(String full) {
		int counter = 0;
		for (int i = 0; i < book.length; i++) {
			if ((book[i].getFirstName() + " " + book[i].getMiddleName() + " " + book[i].getLastName()).equals(full)) {
				counter++;
			}
		}
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if ((book[i].getFirstName() + " " + book[i].getMiddleName() + " " + book[i].getLastName()).equals(full)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	public PhoneBookPerson[] getByStreetAddress(String street) {
		int counter = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyStreet().equals(street)) {
				counter++;
			}
		}
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyStreet().equals(street)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	public PhoneBookPerson[] getByCity(String city) {
		int counter = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyCity().equals(city)) {
				counter++;
			}
		}
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyCity().equals(city)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	public PhoneBookPerson[] getByState(String state) {
		int counter = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyState().equals(state)) {
				counter++;
			}
		}
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyState().equals(state)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	public PhoneBookPerson[] getByZipCode(String zipCode) {
		int counter = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyZipCode().equals(zipCode)) {
				counter++;
			}
		}
		PhoneBookPerson[] newArray = new PhoneBookPerson[counter];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getMyZipCode().equals(zipCode)) {
				newArray[x] = book[i];
				x++;
			}
		}
		return newArray;
	}

	// deletes person
	public void deletePerson(PhoneBookPerson toRemove) {
		int counter = 0;
		PhoneBookPerson[] newBook = new PhoneBookPerson[book.length - 1];
		for (int i = 0; i < book.length; i++) {
			if (book[i] != toRemove) {
				newBook[counter] = book[i];
				counter++;
			}
		}
		book = newBook;
	}

	public void printPersonArray(PhoneBookPerson[] searched) {
		for (int i = 0; i < searched.length; i++) {
			searched[i].getPerson();
		}
	}

	public void printAlphabetically(PhoneBookPerson[] searched) {

		String[] alphabetical = new String[searched.length];

		for (int i = 0; i < book.length; i++) {
			if (book[i].getFirstName().equals(searched[i].getFirstName())) {
				alphabetical[i] = searched[i].getFirstName();
			}
		}
		String temp;
		int j;
		for (int i = 0; i < alphabetical.length; i++) {
			for (j = i + 1; j < book.length; j++) {
				if (alphabetical[i].compareTo(alphabetical[j]) < 0) {
					temp = alphabetical[i];
					alphabetical[i] = alphabetical[j];
					alphabetical[j] = temp;
				}
				System.out.println(alphabetical[j].toString());

			}
		}
//		System.out.println(alphabetical[alphabetical.length-1]);

		for (int i = 0; i < alphabetical.length; i++) {
			if (alphabetical[i] == book[i].getFirstName()) {
				book[i].getPerson();
			}

		}
	}

}
