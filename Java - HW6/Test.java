/*
Name Surname = Hakkı Kokur
NO = 150120033
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;
import java.util.Calendar;

public class Test {
    
    public static void main(String[] args) throws FileNotFoundException{

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        
        ArrayList<Person> persons = new ArrayList<>();
        // ArrayList<Person> tempPersons = new ArrayList<Person>();
        ArrayList<Object> items = new ArrayList<>();

        while(scan.hasNextLine()){
            String s = scan.nextLine();
            ArrayList<String> sList;
            
            sList = new ArrayList<String>(Arrays.asList(s.split(" ")));


            if(s.startsWith("Department")){
                int id = java.lang.Integer.valueOf(sList.get(1));
                String name = sList.get(2);
                Department d = new Department(id, name);
                items.add(d);
            }
            else if(s.startsWith("Project")){
                String name = sList.get(1);
                String[] numbers = sList.get(2).split("/");
                int year = Integer.parseInt(numbers[2]);
                int month = Integer.parseInt(numbers[1]) -1;
                int day = Integer.parseInt(numbers[0]);
                Calendar c = Calendar.getInstance();
                c.set(year, month+1, day);
                boolean state = Boolean.valueOf(sList.get(3));
                Project p = new Project(name, c, state);
                items.add(p);
            }
            else if(s.startsWith("Product")){
                String name = sList.get(1);
                String[] numbers = sList.get(2).split("/");
                int year = Integer.valueOf(numbers[2]);
                int month = Integer.valueOf(numbers[1]) -1;
                int day = Integer.valueOf(numbers[0]);
                Calendar c = Calendar.getInstance();
                c.set(year, month+1, day);
                double price = Double.valueOf(sList.get(3));
                Product pro = new Product(name, c, price);
                items.add(pro);
            }
            else if(s.startsWith("Person")){
                String name = sList.get(1);
                String lastName = sList.get(2);
                int id = Integer.valueOf(sList.get(3));
                String gender = sList.get(4);
                String[] numbers = sList.get(5).split("/");
                int year = Integer.valueOf(numbers[2]);
                int month = Integer.valueOf(numbers[1]) -1;
                int day = Integer.valueOf(numbers[0]);
                Calendar c = Calendar.getInstance();
                c.set(year, month+1, day);
                String marialStatus = sList.get(6);
                String hasDriverLicence = sList.get(7);
                Person pe = new Person(id, name, lastName, gender, c, marialStatus, hasDriverLicence);
                persons.add(pe);
            }

            else if(s.startsWith("Customer")){
                Person p = new Person();
                for(Person person:persons){
                    if(person.getId() == Integer.valueOf(sList.get(1))){
                        p = person;
                    }
                }
                sList.remove(0);
                sList.remove(0);
                ArrayList<Product> products = new ArrayList<Product>();
                for(int i = 0; i < sList.size(); i++){
                    for(Object obj2:items){
                        if(obj2 instanceof Product){
                            if (((Product)obj2).getProductName() == sList.get(i)){
                                products.add((Product)obj2);
                            }
                        }
                    }
                }
                Customer cu = new Customer(p, products);
                persons.set(persons.indexOf(p), cu);
            }
            else if(s.startsWith("Employee")){
                double salary = Double.valueOf(sList.get(2));
                String[] numbers = sList.get(3).split("/");
                int year = Integer.valueOf(numbers[2]);
                int month = Integer.valueOf(numbers[1]) -1;
                int day = Integer.valueOf(numbers[0]);
                Calendar c = Calendar.getInstance();
                c.set(year, month+1, day);

                Person p = new Person();
                for(Person person:persons){
                    if(person.getId() == Integer.valueOf(sList.get(1))){
                        p = person;
                    }
                }
                
                Employee e = null;
                for(Object obj: items){
                    if(obj instanceof Department){
                        if( ((Department)obj).getDepartmentName().equals(sList.get(4))){
                            e = new Employee(p, salary, c, obj);                        }
                    }
                }
                if (e != null){
                    persons.set(persons.indexOf(p), (Employee)e);
                }
            }
            else if(s.startsWith("Manager")){
                double bonus = Double.valueOf(sList.get(2));
                Employee p = new Employee();
                for(Person person:persons){
                    if(person instanceof Employee){
                        if ( ((Employee)person).getId() == Integer.valueOf(sList.get(1))){
                            p = (Employee)person;
                        }
                    }
                }
                Manager m = new Manager(p, bonus);
                persons.set(persons.indexOf((Employee)p), m);
            }
            else if(s.startsWith("RegularEmployee")){
                double pScore = Double.valueOf(sList.get(2));
                for(Object obj:persons){
                    if(obj instanceof Employee){
                        if ( ((Employee)obj).getId() == Integer.valueOf(sList.get(1))){
                            RegularEmployee re = new RegularEmployee(obj, pScore);
                            persons.set(persons.indexOf((Employee)obj), re);
                        }
                    }
                }
            }
            else if(s.startsWith("SalesEmployee")){
                RegularEmployee re = null;
                ArrayList<Product> prr = new ArrayList<>();
                for(Person person:persons){
                    if(person instanceof RegularEmployee){
                        if ( ((RegularEmployee)person).getId() == Integer.parseInt(sList.get(1))){
                            re = (RegularEmployee)person;
                            sList.remove(0);
                            sList.remove(0);
                           
                            for(int i = 0; i < sList.size(); i++){
                                for(Object obj2:items){
                                    if(obj2 instanceof Product){
                                        if (((Product)obj2).getProductName().equals(sList.get(i))){
                                            prr.add(((Product)obj2));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (re != null){
                    SalesEmployee sm = new SalesEmployee(re, prr);
                    persons.set(persons.indexOf(re), sm);
                }

            }
            else if(s.startsWith("Developer")){
                RegularEmployee re = null;
                ArrayList<Project> prr = new ArrayList<>();
                for(Object person:persons){
                    if(person instanceof RegularEmployee){
                        if ( ((RegularEmployee)person).getId() == Integer.parseInt(sList.get(1))){
                            re = (RegularEmployee)person;
                        }
                    }
                }
                sList.remove(0);
                sList.remove(0);

                for(int i = 0; i < sList.size(); i++){
                    for(Object obj2: items){
                        if(obj2 instanceof Project){
                            if (((Project)obj2).getProjectName().equals(sList.get(i))){
                                prr.add(((Project)obj2));
                            }
                        }
                    }
                }
                if( re != null){
                    Developer dev = new Developer(re, prr);
                    persons.set(persons.indexOf(re), dev);
                }
            }
            else{
                System.out.println("Error");
                System.out.println(s);
                
            }
        }


        for(Object obj : items){
            if ( obj instanceof Department){
                System.out.println("************************************************");
                System.out.println(obj.toString());
                Manager m = null;
                for(Person person: persons){
                    if( person instanceof Manager){
                        if( ((Department)obj).getDepartmentName() == (((Manager)person).getDepartment()).getDepartmentName()){
                            m = (Manager)person;
                        }
                    }
                }

                for (Person person : persons){
                    if (person instanceof RegularEmployee){
                        if (((Department)obj).getDepartmentName() == (((RegularEmployee)person).getDepartment()).getDepartmentName()){
                            m.addEmployee((RegularEmployee)person);
                        }
                    }
                }

                // distribute raised salary
                for(Person person : persons){
                    if(person instanceof Manager){
                        ((Manager)person).distributeBonusBudget();
                        ((Manager)person).raiseSalary(0.2);
                    }
                }
                for(Person person : persons){
                    if(person instanceof RegularEmployee){
                        ((RegularEmployee)person).raiseSalary(0.3);
                    }
                    else if(person instanceof Developer){
                        ((Developer)person).raiseSalary(0.23);
                    }
                    else if(person instanceof SalesEmployee){
                        ((SalesEmployee)person).raiseSalary(0.18);
                    }
                }
                SalesEmployee maxSaler = null;
                for(Person person : persons){
                    if(person instanceof SalesEmployee){
                        if (maxSaler != null){
                            if( ((SalesEmployee)person).getSales().size() > maxSaler.getSales().size()){
                                maxSaler = (SalesEmployee)person;
                            }
                        }
                        else
                            maxSaler = (SalesEmployee)person;
                    }
                }
                maxSaler.raiseSalary(1000);


                if (m != null){
                    System.out.println(m.toString());
                    ArrayList<RegularEmployee> re = m.getRegularEmployees();
                    for(Person person : re){
                        if(person instanceof Developer){
                            Developer dev = (Developer)person;
                            System.out.println("			"+ (re.indexOf(person)+1) +". Developer" );
                            System.out.println("				Person Info " + "[id="+ dev.getId()+", firstName="+ dev.getFirstName()+", lastName="+ 
                                            dev.getLastName()+", gender="+ dev.getGender()+"]");
                            System.out.println("				Employee Info [salary="+ dev.getSalary()+ ", hireDate="+ dev.gHireDate() +"]");
                            System.out.println("				RegularEmployee Info [performanceScore="+ dev.getPerformanceScore()+", bonus="+ dev.getBonus()+"]");
                            System.out.println(dev.getProject());
                        }
                        if(person instanceof SalesEmployee){
                            SalesEmployee se = (SalesEmployee)person;
                            System.out.println("			"+ (re.indexOf(person)+1) +". SalesEmployee" );
                            System.out.println("				Person Info " + "[id="+ se.getId()+", firstName="+ se.getFirstName()+", lastName="+ 
                                                se.getLastName()+", gender="+ se.getGender()+"]");
                            System.out.println("				Employee Info [salary="+ se.getSalary()+ ", hireDate="+ se.gHireDate() +"]");
                            System.out.println("				RegularEmployee Info [performanceScore="+ se.getPerformanceScore()+", bonus="+ se.getBonus()+"]");
                            System.out.println(se.getProduct());
                        }
                        if((person instanceof RegularEmployee) && !(person instanceof Developer) && !(person instanceof SalesEmployee)){
                            RegularEmployee rem = (RegularEmployee)person;
                            System.out.println("			"+ (re.indexOf(person)+1) +". RegularEmployee" );
                            System.out.println("				Person Info " + "[id="+ rem.getId()+", firstName="+ rem.getFirstName()+", lastName="+ 
                                                rem.getLastName()+", gender="+ rem.getGender()+"]");
                            System.out.println("				Employee Info [salary="+ rem.getSalary()+ ", hireDate="+ rem.gHireDate() +"]");
                            System.out.println("				RegularEmployee Info [performanceScore="+ rem.getPerformanceScore()+", bonus="+ rem.getBonus()+"]");
                        }
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        
        System.out.println("**********************CUSTOMERS************************");
        for(Person person: persons){
            if(person instanceof Customer){
                System.out.println(person);
            }
        }
        System.out.println();
        System.out.println();

        System.out.println("**********************PEOPLE************************");
        for(Person person: persons){
            if(!(person instanceof Customer) && !(person instanceof Employee))
                System.out.println("Person " + person.toString());
        }

    }
}
