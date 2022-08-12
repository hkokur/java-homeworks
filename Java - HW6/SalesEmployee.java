/*
Name Surname = Hakkı Kokur
NO = 150120033
*/

import java.util.ArrayList;

public class SalesEmployee extends RegularEmployee {
    private ArrayList<Product> sales;
    public static int numberOfSalesEmployees;

    SalesEmployee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence,
    double salary, java.util.Calendar hireDate, Department department, double performanceScore, ArrayList<Product> s ){
        super(id, firstName, lastName, gender, birthDate, marialStatus, hasDriverLicence, salary, hireDate, department, performanceScore);
        sales = s;
        numberOfEmployees +=1;
    }

    SalesEmployee(RegularEmployee re, ArrayList<Product> s){
        super(re.getId(),re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMarialStatus(), 
        re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
        sales = s;
        numberOfEmployees +=1;
    }

    public boolean addSale(Product s){
        sales.add(s);
        return true;
    }

    public boolean removeSale(Product s){
        sales.remove(s);
        return true;
    }

    public ArrayList<Product> getSales(){
        return sales;
    }

 
    public String getProduct(){
        String s;
        s = "				[Product ";
        for(Product product : sales){
            s += "[productName="+ product.getProductName()+", transactionDate="+ product.gSaleDate() +", price="+ product.getPrice() +"]" ;
            if (sales.indexOf(product) != (sales.size()-1)){
                s +=",";
            }
        }
        s += "]";
        return s;
    }



}
