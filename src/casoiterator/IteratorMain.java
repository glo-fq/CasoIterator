/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoiterator;

public class IteratorMain {          
    public static void main(String[] args) {           
        Employee employee = new Employee("Juan", "CEO",                   
                new Employee("Pedro", "Presidente",                           
                        new Employee("Liliana", "VP",                                   
                                new Employee("Oscar", "Gerente",                                           
                                        new Employee("Mario", "Developer"),
                                        new Employee("Rodolfo", "Developer")),
                                new Employee("Sofia", "Gerente", 
                                        new Employee("Adrián", "Sr Developer"),
                                        new Employee("Rebeca", "Developer")
                                )
                        )
                )
        );
        
        IIterator<Employee> empIterator = employee.createIterator();
        
        while (empIterator.hasNext()) {
            Employee emp = empIterator.next();
            System.out.println("emp > " + emp.toString());
        }
    }
}



