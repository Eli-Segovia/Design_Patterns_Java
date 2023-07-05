package com.SegoviaEli.Creational.Builder.RecursiveGenerics;

class FluentRecursiveGeneric
{
    public static void main(String[] args)
    {
        EmployeeBuilder eb = new EmployeeBuilder()
                .withName("Dmitri")
                .worksAs("Quantitative Analyst");
        System.out.println(eb.build());
    }
}


// builder inheritance with recursive generics

class Person
{
    public String name;

    public String position;

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

/**
 * This here is a little confusing. However, it has to be done because
 * If we use EmployeeBuilder without this code, as soon as we use the withName() method,
 * we will receive a PersonBuilder reference.
 *
 * This syntax here returns whatever specific PersonBuilder (i.e. EmployeeBuilder)
 */
class PersonBuilder<SELF extends PersonBuilder<SELF>>
{
    protected Person person = new Person();

    // critical to return SELF here
    public SELF withName(String name)
    {
        person.name = name;
        return self();
    }

    protected SELF self()
    {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }

    public Person build()
    {
        return person;
    }
}

/***
 * Here we see that EmployeeBuilder must extend PersonBuilder with EmployeeBuilder as a paramater of PersonBuilder
 * When we return self() in PersonBuilder we will be receiving the right reference to an EmployeeBuilder :)
 */
class EmployeeBuilder
        extends PersonBuilder<EmployeeBuilder>
{
    public EmployeeBuilder worksAs(String position)
    {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self()
    {
        return this;
    }
}
