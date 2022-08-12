/*
Name Surname = Hakkı Kokur
NO = 150120033
*/


import java.util.ArrayList;

public class Customer extends Person{
    private ArrayList<Product> products = new ArrayList<Product>();

    Customer(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence, ArrayList<Product> products){
        super(id, firstName, lastName, gender, birthDate, marialStatus, hasDriverLicence);
        setProducts(products);
    }

    Customer(Person person, ArrayList<Product> products){
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMarialStatus(), person.getMarialStatus());
        setProducts(products);

    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

}
