import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


class Person {
	String firstName;
	String lastName;
	int age;
	String country;

	public Person(String firstName, String lastName, int age, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return firstName + "|" + lastName + "|" + age + "|" + country;
	}
}

class PersonUtils {
	public static void sortPersons(List<Person> persons, String[] sortBy) {
  // implement the sorting logic
		Stream<Person> personsStream = persons.stream();
		for(String s: sortBy) {
			personsStream.sorted(getComparator(s));
		}
		Person[] pArr = (Person[]) personsStream.toArray();
		persons = new ArrayList<Person>();
		for(int i=0;i<pArr.length;i++) {
			persons.add(pArr[i]);
		}
  }



private static Comparator<Person> getComparator(String sortBy) {
	switch(sortBy) {
	case "firstname":
		return new SortByFirstName();
	case "lastname":
		return new SortByLastName();
	case "country":
		return new SortByCountry();
	case "age":
		return new SortByAge();
	}
	return null;
}
}
class SortByFirstName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
	
}

class SortByLastName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getLastName().compareTo(o2.getLastName());
	}
	
}

class SortByCountry implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getCountry().compareTo(o2.getCountry());
	}
	
}

class SortByAge implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getAge()-o2.getAge();
	}
	
}


public class Solution4 {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        final String fileName = "test";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        int count=0;
        // read the first line the number indicates number of person records below
		    // person records start from 3rd line
        try {
            count = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            count = 0;
        }
      
        // read the 2nd line; the sort options are given in this line
        String sortLine = in.nextLine();
        String[] sortBy = sortLine.split(";");

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
          String inputLine = in.nextLine();
          // the person details are given in this order:
          // first name; last name; age; country
          String[] parts = inputLine.split("[|]");
          Person person = new Person(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
          personList.add(person);
        }
        PersonUtils.sortPersons(personList, sortBy);

        for (Person p : personList) {
          bw.write(p.toString());
          bw.newLine();
        }
      bw.close();
      
      in.close();
    }
}