package com.SegoviaEli.Creational.Builder;

public class FacetedBuilder {
    public static void main(String[] args)
    {

        /**
         * Here we switch between the builders by using the works/lives functions
         */
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                .lives()
                  .at("123 London Road")
                  .in("London")
                  .withPostcode("SW12BC")
                .works()
                  .at("Fabrikam")
                  .asA("Engineer")
                  .earning(123000)
                .build();
        System.out.println(person);
    }
}

class Person
{
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString()
    {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// builder facade
class PersonBuilder
{
    // the object we're going to build
    protected Person person = new Person(); // reference!


    /**
     * "works" and "ives" sort of work as a switch to the appropriate Builder. We can switch between builders
     * by calling on the appropriate function
     */
    public PersonJobBuilder works()
    {
        return new PersonJobBuilder(person);
    }

    public PersonAddressBuilder lives()
    {
        return new PersonAddressBuilder(person);
    }

    public Person build()
    {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder
{
    public PersonAddressBuilder(Person person)
    {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress)
    {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode)
    {
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city)
    {
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder
{
    public PersonJobBuilder(Person person)
    {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName)
    {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position)
    {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome)
    {
        person.annualIncome = annualIncome;
        return this;
    }
}