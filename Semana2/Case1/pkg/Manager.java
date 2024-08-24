package pkg;

import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class Manager {

    public static void main(String[] args) {
        Company c1 = new Company("Office Depot", "Street 12, Michigan, EE.UU.");
        Company c2 = new Company("Bing", "Street 39, Ohio, EE.UU.");

        Stream<Active> case1 = Stream.of(
                new Product(9, "Box of pencils 1.5", c1, "Box of pencils of #1.5, for High Schools and Universities."),
                new Product(25, "Box of pencils 1", c1, "Box of pencils of #1, for High Schools and Universities."),
                new Product(12, "Box of pencils 2", c1, "Box of pencils of #2, for High Schools and Universities."),
                new Product(90, "Desks with file cabinet", c2, "Maderkit Neza 3"),
                new Product(1, "Laptop HP", c2, "16GB RAM, 512GB of HDD, Core Intel 7i, color gray with 4K display screen"),
                new Product(1000, "Box of staples", c2, "A box of 1000 staples."),
                new Product(200, "Box of Pocket Larousse Dictionaries (Spanish-English)", c1, "A bunch of books from Larousse"),
                new Service("12-09-2021", "09-09-2022", "Cafeteria de la esquina", c1, "Venta de productos alimenticios para los empleados dentro de la compañía", 12),
                new Service("13-09-2023", "23-07-2024", "Cafeteria tres lobos", c2, "Venta de productos alimenticios para los empleados y clientes dentro del nuevo corporatorio de la compañía", 4)
        );
        /*
        1.- Only Office Depot actives
        2.- Check if those actives are products
        3.- Parse into Products
        4.- Sort them in descendent order
        5.- Limit them to the first 3
        */
        List<Product> listProductsOfficeDepot = case1
                .filter(a -> a.getCompany()==c1)
                .filter(a -> a instanceof Product)
                .map(a -> (Product)a)
                .sorted(Comparator.comparing(Product::getCount).reversed())
                .limit(3)
                .collect(Collectors.toList());

        listProductsOfficeDepot.stream().forEach(System.out::println);
    }

}
