//CST315 - Fall 2015
//Ruben Acuna

/*****************************************************************************
 * Example of coupling in a system and how to reduce it.							     *
 ****************************************************************************/

//1)Consider the following example. At a glance, it doesn't look too bad. The
//code is simple.
public class PeopleManager 
{

	//bunch of other methods go here.

	boolean samePerson(Person p1, Person p2)
	{
		return(this.getName() == p2.getName());
	}
}

public class Person 
{
	String name;
	String getName() {return name};

	//bunch of other methods go here.
}


//2)Say we add a new ID variable to Person because we realize that names are
//  not unique. (Requirements change!) Then, we must refactor both of the
//  classes:

public class PeopleManager 
{

	//bunch of other methods go here.

	boolean samePerson(Person p1, Person p2) 
	{
		return((this.getName() == p2.getName()) && (this.getID() == p2.getID()));
	}
}

public class Person
{
	String name;
	int id;
	String getName() {return name};
	int getID() {return id};

	//bunch of other methods go here.
}

//3)For the above code, PeopleManage is becoming closely coupled to Person. A
//  better approach is to *delegate* the work of comparison to Person. Afterall,
//  what class could possibly know better than Person how to compare Persons?

public class PeopleManager 
{

	//bunch of other methods go here.

	boolean samePerson(Person p1, Person p2) 
	{
		return(p1.equals(p2));
	}
}

public class Person
{
	String name;
	int id;
	
	String getName() {return name};
	int getID() {return id};

	boolean equals(Person p2)
	{
		return((this.getName() == p2.getName()) && (this.getID() == p2.getID()));
	}

	//bunch of other methods go here.
}

//This example is fairly simple. In the real world, PeopleManager would not
//have a method called samePerson. Someone would notice it is in the wrong
//place and refactor it. Instead, the above scenario happens in parts of
//methods. For example, PeopleManager could have another method that checks
//if the same Person is working two jobs in a list:

boolean hasTwoJobs(Person p)
{
	for(Job j : jobs)
	{
		if((p.getName() == j.getWorker().getName()) && (p.getID() == j.getWorker().getID()))
		{
			return(true);
		}
	}
	return(false);
}

//This would then be refactored into:

boolean hasTwoJobs(Person p)
{
	for(Job j : jobs)
	{
		if(p.equals(j.getWorker())
		{
			return(true);
		}
	}
	return(false);
}


/*****************************************************************************
 * UML relationship examples.						     *
 ****************************************************************************/

//Dependency - PeopleManger sometimes works with Person. In code this looks
//  like PeopleManager accessing Person as a parameter.
public class PeopleManager
{
	//other methods, all sorts other things
	boolean samePerson(Person p1, Person p2) 
	{
		return(p1.equals(p2));
	}
}


//Association - PeopleManger works with Person. In code this looks like
//  PeopleManager maintaining a reference to a Person.

public class PeopleManager 
{
	Person p2;

	void setActivePerson(Person p) { p2 = p;}

	boolean samePerson(Person p1) 
	{
		return(p1.equals(p2));
	}
}


//Aggregation - PeopleManger contains (or "has") a number of Person objects.
//  In code this looks like PeopleManger containing an array (or other
//  collection) of Person objects that other objects may be able to change.
public class PeopleManager 
{
	private Person[] p;

	void setP2(Person p) {...}

	boolean samePerson(Person p1) 
	{
		return(p1.equals(p[0]));
	}

	public addPerson(String name, int id) {...}
	public getPerson(int i) { return p[i];}
	public deletePerson(int i ) {...}
}


//Composition - PeopleManger contains (or "has") a number of Person objects
//  and has primary ownership over those objects. In code this looks like
//  PeopleManger containing an array (or other collection) of Person objects
//  that other objects are not allowed to change.
public class PeopleManager 
{
	private Person[] p;

	private class Person {...}

	boolean samePerson(Person p1) 
	{
		return(p1.equals(p[0]));
	}
}

//Composition alternative: the class may restrict the composed class's scope.
public class PeopleManager 
{
  private Person[] p;
  
  private class Person 
  {
    ...
  }
  
  void setP2(Person p) {...}
  
  boolean samePerson(Person p1) 
  {
		return(p1.equals(p[0]));
  }
}

//Note that different people will see Aggregation vs Composition in different
//ways. The standard UML view is that Composition is a stronger form of
//Aggregation.