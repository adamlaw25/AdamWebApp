package data;

import java.util.Collection;

public class User {
    @Override
	public String toString() {
		return "User [persons=" + persons + "]";
	}

	public final Collection<Person> getPersons() {
		return persons;
	}

	public final void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

	Collection <Person> persons;
    

}
