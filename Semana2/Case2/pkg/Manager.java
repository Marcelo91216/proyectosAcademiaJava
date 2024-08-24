package pkg;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class Manager {

    public static void main(String[] args) {
        Company c1 = new Company("Office Depot", "Street 12, Michigan, EE.UU.");
        Company c2 = new Company("Bing", "Street 39, Ohio, EE.UU.");

        Stream<Active> listOfActives = getStreamOfActives(c1, c2);

        /*
        1.- Remove repeated data
        2.- Get just the services
        3.- Get just services from Bing
        4.- Parse them into Service
        5.- Filter to have services with more than 5 incidents
        6.- Return the service with least incidents
         */
        Optional<Service> nextServiceToInspect = listOfActives
                .distinct()
                .filter(a -> a instanceof Service)
                .filter(s -> s.getCompany() == c2)
                .map(a -> (Service) a)
                .filter(a -> a.getIncidents() > 5)
                .min(Comparator.comparing(Service::getIncidents));

        if (nextServiceToInspect.isPresent()) {
            System.out.println(nextServiceToInspect.get());
        } else {
            System.out.println("There is no Service with more than 5 incidents");
        }

    }

    static Stream<Active> getStreamOfActives(Company c1, Company c2) {
        Product product1 = new Product(9, "Box of pencils 1.5", c1, "Box of pencils of #1.5, for High Schools and Universities.");
        Product product2 = new Product(25, "Box of pencils 1", c1, "Box of pencils of #1, for High Schools and Universities.");
        Product product3 = new Product(12, "Box of pencils 2", c1, "Box of pencils of #2, for High Schools and Universities.");
        Product product4 = new Product(90, "Desks with file cabinet", c2, "Maderkit Neza 3");
        Product product5 = new Product(1, "Laptop HP", c2, "16GB RAM, 512GB of HDD, Core Intel 7i, color gray with 4K display screen");
        Product product6 = new Product(1000, "Box of staples", c2, "A box of 1000 staples.");
        Product product7 = new Product(200, "Box of Pocket Larousse Dictionaries (Spanish-English)", c1, "A bunch of books from Larousse");

        Service service1 = new Service("12-09-2021", "09-09-2022", "Corner Cafeteria", c1, "Food products sales for employees within the company", 12);
        Service service2 = new Service("13-09-2023", "23-07-2024", "Three Wolves Cafeteria", c2, "Food products sales for employees and clients within the new company headquarters", 4);
        Service service3 = new Service("13-09-2023", "23-07-2024", "Three Wolves Cafeteria", c2, "Food products sales for employees and clients within the new company headquarters", 0);
        Service service4 = new Service("01-01-2022", "01-01-2023", "ABC Cleaning Service", c1, "Cleaning service for the main offices", 7);
        Service service5 = new Service("15-02-2022", "15-08-2022", "XYZ Equipment Maintenance", c2, "Preventive maintenance of computer equipment at the main headquarters", 6);
        Service service6 = new Service("01-03-2023", "01-06-2023", "DEF Legal Consulting", c1, "Legal advice for the renewal of employee contracts", 2);
        Service service7 = new Service("01-07-2023", "01-07-2024", "GHI Catering Service", c2, "Catering service for corporate events", 10);
        Service service8 = new Service("01-08-2023", "31-12-2023", "JKL Financial Consulting", c1, "Consulting for the optimization of financial resources in the finance department", 4);
        Service service9 = new Service("01-09-2023", "01-09-2024", "MNO Transportation Service", c2, "Employee transportation to and from the new headquarters", 15);
        Service service10 = new Service("01-10-2023", "31-12-2023", "PQR Gardening Maintenance", c1, "Maintenance of gardens and green areas in the facilities", 3);

        return Stream.of(
                product4, service4, product1, service2, product6,
                service1, service4, product3, service3, product2,
                service6, service4, service10, product7, service7,
                service4, product5, service9, service8, product1,
                service5, service4, product6, service10, service2,
                service7, product3, service10, product7
        );
    }

}
