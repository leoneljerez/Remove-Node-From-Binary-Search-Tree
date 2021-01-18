package exercise1.binarysearchtree;

public class Passenger implements Comparable<Passenger>{
	private String firstName = null;
	private String lastName = null;
	private Integer frequentFlyerMiles = null;
	
	public Passenger(String firstName, String lastName, Integer frequentFlyerMiles){
		this.firstName = firstName;
		this.lastName = lastName;
		this.frequentFlyerMiles = frequentFlyerMiles;
	}
	public int compareTo(Passenger other){
		return Integer.compare(this.frequentFlyerMiles, other.frequentFlyerMiles);
	}
	
	public String toString(){
		return firstName + lastName + " - " + frequentFlyerMiles;
	}
}
