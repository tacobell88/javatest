//Name: Ivan Foo
//Student number: 10228006
//Tutorial group: T07
//Declaration: This is my progamme
//
//filename: IvanFoo_Assignment_1.java

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

enum Zodiac
{
	Aries ("ARI", "March 21", "April 19"),
	Taurus ("TAU", "April 20", "May 20"),
	Gemini ("GEM", "May 21", "June 20"),
	Cancer ("CAN", "June 21", "July 22"),
	Leo ("LEO", "July 23", "August 22"),
	Virgo ("VIR", "August 23", "September 22"),
	Libra ("LIB", "September 23", "October 21"),
	Scorpio ("SCO", "October 23", "November 21"),
	Saggittarius ("SAG", "November 22", "Decembe 21"),
	Capricorn ("CAP", "December 22", "January 19"),
	Aquarius ("AQU", "January 20", "February 18"),
	Pisces ("PIS", "February 19", "March 20");

	private final String aka;
	private final String fromDate;
	private final String toDate;

	Zodiac (String aka, String fromDate, String toDate)
	{
		this.aka = aka;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getAbbrev ()
	{
		return aka;
	}

	public String getfromDate ()
	{
		return fromDate;
	}

	public String gettoDate ()
	{
		return toDate;
	}
}

class Set
{
	private ArrayList <Zodiac> set;

	public Set ()
	{
		this.set = new ArrayList <Zodiac> ();
	}

	public Set (Set otherSet)
	{
		this.set =  new ArrayList <Zodiac> ();

		for (Zodiac zod : set)
			otherSet.set.add(zod);
	}

	public boolean isEmpty ()
	{
		return set.isEmpty ();
	}

	public int cardinality ()
	{
		return set.size ();
	}

	public boolean belongTo (Zodiac element)
	{
		return set.contains(element);
	}

	public void addElement (Zodiac element)
	{
		if (belongTo (element) == false)
			set.add (element);
	}

	public boolean subset (Set otherSet)
	{
		return (otherSet.set.containsAll (set));
	}

	public void union (Set otherSet)
	{
		set.removeAll (otherSet.set);
		set.addAll (otherSet.set);
	}

	public void intersection (Set otherSet)
	{
		set.retainAll(otherSet.set);
	}

	public void difference (Set otherSet)
	{
		set.removeAll(otherSet.set);
	}

	public Set complement ()
	{
		ArrayList <Zodiac> comp = new ArrayList <Zodiac> ();

		for (Zodiac zod : Zodiac.values())
		{
			comp.add(zod);
		}

		comp.removeAll(set);
		set = new ArrayList <> (comp);

		Set set1 = new Set ();
		set1.set = set;

		return set1;
	}

	public boolean equality (Set otherSet)
	{
		return set.equals (otherSet.set);
	}

	public String getEnumFormat ()
	{
		String connect = " ";
		for (int i = 0; i < cardinality (); i++)
		{
			switch (i)
			{
				case 0: connect = String.valueOf (set.get (i));
						break;
				default: connect = connect + ", " + String.valueOf (set.get (i));
						break;
			}
		}

		return String.format ("\t A = {%s}", connect);
	}

	public String toString ()
	{
		StringBuilder display = new StringBuilder ();
		display.append ("{");

	    for (Zodiac s : set)
	    {
	    	display.append (s.getAbbrev());
		    display.append (", ");
	    }

	    display.append ("}");

	    return display.toString ();
	}
}

public class IvanFoo_Assignment_1
{

	private static Scanner input = new Scanner (System.in);

	private static void displayZodiac ()
	{
		System.out.printf ("%-15s%-20s%-15s%-15s%n", "Zodiac Sign", "Known as", "From Date", "To Date");

		for (Zodiac z : Zodiac.values ())
		{
			System.out.printf ("%-15s%-20s%-15s%-15s%n", z, z.getAbbrev(), z.getfromDate(), z.gettoDate());
		}
		System.out.println ();
	}

	private static Zodiac getAnElement ()
	{
		Random rand = new Random();

		Zodiac[] zod = Zodiac.values();
		int randIndex = rand.nextInt(zod.length);

		return zod[randIndex];
	}

	private static Set getASet()
	{
		Set set1 = new Set ();
		Random rand = new Random ();

		for (int i = 0; i < (rand.nextInt(12)+1); i++)
		{
		      Zodiac z = getAnElement();

		      if (set1.belongTo (z) == false)
		        set1.addElement (z);
		}

		return set1;
	}

	private static void displayMenu ()
	{
		boolean mainMenu = true;

		while (mainMenu)
		{
			System.out.println(" ");
			System.out.println("Welcome to SIM Set Theory lesson");
			System.out.println();
			System.out.println("0: Propeties of a set");
			System.out.println("1: Union example");
			System.out.println("2: Intersection example");
			System.out.println("3: Subset example");
			System.out.println("4: Difference example");
			System.out.println("5: Complement example");
			System.out.println("6: Sets equality example");
			System.out.println("7: Distributive Law 1");
			System.out.println("9: Quit");

			System.out.print("Your option: ");

			int choice = input.nextInt();

			switch (choice)
			{
				case 0:
					anExample ();
				break;
				case 1:
					unionExample ();
					break;
				case 2:
					intersectExample ();
					break;
				case 3:
					subsetExample ();
					break;
				case 4:
					diffExample ();
					break;
				case 5:
					compExample ();
					break;
				case 6:
					equalExample ();
					break;
				case 7:
					distriExample ();
					break;
				case 9:
					mainMenu = false;
					break;
			}
		}
	}

	private static void unionExample ()
	{
		Set s1 = getASet ();
		Set s2 = getASet ();

		System.out.println ("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString ());
		System.out.printf ("\tB = %s %n", s2.toString ());

		s2.union(s1);

		System.out.printf ("Union of A and B = %s%n1", s2.toString ());
	}

	private static void intersectExample ()
	{
		Set s1 = getASet ();
		Set s2 = getASet ();

		System.out.println ("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString ());
		System.out.printf ("\tB = %s %n", s2.toString ());

		s2.intersection(s1);

		System.out.printf ("Intersection of A and B = %s%n", s2.toString ());
	}

	private static void subsetExample ()
	{
		Set s1 = getASet ();
		Set s2 = getASet ();
		Set temp = new Set (s2);

		System.out.println ("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString ());
		System.out.printf ("\tB = %s %n", s2.toString ());

		System.out.printf ("A subset of B: %b%n", s1.subset(temp));
		System.out.printf ("B subset of A: %b%n", s2.subset(s1));
	}

	private static void diffExample ()
	{
		Set s1 = getASet ();
		Set s2 = getASet ();

		System.out.println ("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString ());
		System.out.printf ("\tB = %s %n", s2.toString ());

		s1.difference (s2);
		System.out.printf ("A - B = %s%n", s1.toString());
	}

	private static void compExample ()
	{
		Set s1 = getASet ();

		System.out.println ("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString ());

		s1.complement ();
		System.out.printf ("\tA' = %s%n", s1.toString ());
	}

	private static void equalExample ()
	{
		Set s1 = getASet ();
		Set s2 = getASet ();
		Set temp = s2;

		System.out.println ("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString());
		System.out.printf ("\tB = %s %n", s2.toString ());
		System.out.printf ("A subset of B: %b%n", s1.subset(s2));
		System.out.printf ("B subset of A: %b%n", s2.subset(s1));
		System.out.println ("Conclusion");

		if (s1.subset(temp) == true && s2.subset(s1) == true)
			System.out.println("\tA equals to B: True");
		else
			System.out.println("\tA equals to B: false");
	}

	private static void distriExample ()
	{
		Set s1 = getASet ();
		Set s2 = getASet ();
		Set s3 = getASet ();
		Set temp1 = s1;
		Set temp2 = s2;
		Set temp3 = s3;

		System.out.println("We wish to prove: A U (B I C) = (A U B) I (A U C)");
		System.out.println();
		System.out.println("Given sets");
		System.out.printf ("\tA = %s %n", s1.toString());
		System.out.printf ("\tB = %s %n", s2.toString ());
		System.out.printf ("\tB = %s %n", s3.toString ());

		s2.intersection(s3);
		s1.union(s2);
		System.out.println ("LHS Analysis");
		System.out.printf ("\t LHS = %s%n", s1.toString());

		temp1.union(temp2);
		temp2.union(temp3);
		temp1.intersection(temp2);
		System.out.println ("RHS Analysis");
		System.out.printf ("\t RHS = %s%n", temp1.toString());

		if (s1.subset(temp1) == true && temp1.subset(s1) == true)
			System.out.println("\tLHS equals to RHS is True");
		else
			System.out.println("\tLHS equals to RHS is false");
	}

	private static void displaySub ()
	{
		System.out.println(" ");
		System.out.println("Some basic operations in a set");
		System.out.println("\t1: Add an element");
		System.out.println("\t2: Check an element");
		System.out.println("\t3: Cardinality");
		System.out.println("\t4: Enum format");
		System.out.println("\t9: Quit");
		System.out.println();
	}

	private static void anExample ()
	{
		Set set1 = getASet ();

		System.out.println ();
		System.out.println ("Here is an example of set ");
		System.out.printf ("\tA = %s%n", set1.toString ());
		System.out.println ("\tAll elements in set are distinct and random order");

		boolean subMenu = true;
		while(subMenu)
		{
			displaySub ();
			System.out.print ("Enter your option: ");
			int option = input.nextInt ();
			System.out.println (" ");

			switch (option)
			{
				case 1:
					System.out.print ("Enter an element: ");
					Zodiac z1 = Zodiac.valueOf (input.next());
					set1.addElement (z1);
					System.out.printf ("\tA = %s%n", set1.toString());
					break;
				case 2:
					System.out.print ("Enter an element: ");
					Zodiac z2 = Zodiac.valueOf (input.next());
					if (set1.belongTo (z2))
					{
						System.out.println ("\tElement " + z2 + " is in set");
					}
					else
					{
						System.out.println ("\tElement " + z2 + " is not in set");
					}
					break;
				case 3:
					System.out.println ("No of elements in set is " + set1.cardinality());
					break;
				case 4:
					System.out.println ("Notation in enum format");
					System.out.printf ("%s%n", set1.getEnumFormat());
					break;
				default:
					displayMenu ();
					break;
			}
		}
	}

	public static void main(String[] args)
	{
		displayZodiac ();
		displayMenu ();
	}

}
