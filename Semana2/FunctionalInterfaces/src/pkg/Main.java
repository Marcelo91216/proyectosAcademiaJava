// Marcelo Eduardo Guillen Castillo
// Week 2 - Functional Interfaces
// Xideral
package pkg;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // 4 examples of each of the functional interfaces
        // Supplier

        System.out.println("\n$$ Supplier<T>");
        Supplier<Integer> s1 = () -> 200;
        System.out.println("> () -> 200");
        System.out.println(s1.get());

        Supplier<String> s2 = new Persona()::getName;
        System.out.println("> new Persona()::getName;");
        System.out.println(s2.get());

        Supplier<Integer> s3 = Persona::getIdPlaceholder;
        System.out.println("> Persona::getId;");
        System.out.println(s3.get());

        Supplier<Persona> s4 = Persona::new;
        System.out.println("> Persona::new");
        System.out.println(s4.get());

        // Consumer
        System.out.println("\n$$ Consumer<T>");
        Consumer<Integer> c1 = c -> System.out.println(c);
        System.out.println("> c -> System.out.println(c);");
        c1.accept(Integer.SIZE);

        Persona p1 = new Persona(10, "Escamilla");
        Consumer<String> c2 = p1::setName;
        System.out.println("> p1::setName;");
        c2.accept("Pablo");
        System.out.println(p1.getName());

        Consumer<String> c3 = Persona::printMessage;
        System.out.println("> Persona::printMessage;");
        c3.accept(" como estan todos!");

        Consumer<Persona> c4 = p -> p.print();
        System.out.println("> p -> p.print();");
        c4.accept(p1);

        // BiConsumer<T, U>
        System.out.println("\n$$ BiConsumer<T, U>");
        BiConsumer<Persona, Integer> bc1 = (p, i) -> System.out.println("Persona id plus " + i + ": " + (p.getId() + i));
        System.out.println("> (p, i) -> System.out.println(\"Persona id plus \"+i+\": \"+(p.getId()+i));");
        bc1.accept(new Persona(10, ""), 20);

        BiConsumer<Integer, String> bc2 = (i, s) -> System.out.println("id: " + i + " | nombre: " + s);
        System.out.println("> (i, s) -> System.out.println(\"id: \"+i+\" | nombre: \"+s);");
        bc2.accept(p1.getId(), p1.getName());

        BiConsumer<Persona, String> bc3 = (p, s) -> p.setName(s);
        System.out.println("> (p, s) -> p.setName(s);");
        bc3.accept(p1, "Sancho");
        System.out.println(p1.getName());

        // Predicate<T>
        System.out.println("\n$$ Predicate<T>");
        Predicate<Integer> pre1 = i -> i > 10;
        System.out.println("> i -> i > 10;");
        System.out.println(pre1.test(Integer.SIZE));
        
        Predicate<Integer> pre2 = Main::isGreater20;
        System.out.println("> Main::isGreater20;");
        System.out.println(pre2.test(Integer.BYTES));
        
        Predicate<Persona> pre3 = p -> p.getName().startsWith("S");
        System.out.println("> p -> p.getName().startsWith(\"S\");");
        System.out.println(pre3.test(p1));
        
        Predicate<Persona> pre4 = p1::greaterThan;
        System.out.println("> p1::greaterThan;");
        System.out.println(pre4.test(p1));
        
        // BiPredicate<T, U>
        
        System.out.println("$$ BiPredicate<T, U>");
        BiPredicate<String, Integer> bp1 = (s, i) -> s.length()>i;
        System.out.println("> (s, i) -> s.length()>i;");
        System.out.println(bp1.test(p1.getName(), 5));
        
        BiPredicate<String, Integer> bp2 = Main::strMoreThanI;
        System.out.println("> Main::strMoreThanI;");
        System.out.println(bp2.test(p1.getName(), 5));
        
        BiPredicate<Persona, Integer> bp3 = (p, i) -> p.greaterThanInt(i);
        System.out.println("> (p, i) -> p.greaterThanInt(i);");
        System.out.println(bp3.test(p1, Integer.SIZE));
        
        BiPredicate<Persona, Integer> bp4 = Persona::greaterThanInt;
        System.out.println("> Persona::greaterThanInt;");
        System.out.println(bp4.test(p1, Integer.SIZE));
        
        // Function<T, R>
        Function<String, Integer> f1 = s -> s.length();
        System.out.println("> s -> s.length();");
        System.out.println(f1.apply("four"));
        
        Function<String, Integer> f2 = Main::returnYourStrSize;
        System.out.println("> Main::returnYourStrSize;");
        System.out.println(f2.apply("six"));
        
        Function<Persona, String> f3 = Persona::getName;
        System.out.println("> Persona::getName;");
        System.out.println(f3.apply(p1));
        
        Function<Persona, Integer> f4 = Persona::getId;
        System.out.println("> Persona::getId;");
        System.out.println(f4.apply(p1));
        
        // BiFunction<T, U, R>
        
        System.out.println("$$ BiFunction<T, U, R>");
        BiFunction<String, Integer, String> bf1 = (s, i) -> s+" "+i;
        System.out.println("> (s, i) -> s+\" \"+i;");
        System.out.println(bf1.apply("hello", Integer.SIZE));
        
        BiFunction<String, String, String> bf2 = String::concat;
        System.out.println("> String::concat;");
        System.out.println(bf2.apply("hola ", "mundo"));
        
        BiFunction<Integer, String, Persona> bf3 = Persona::new;
        System.out.println("> Persona::new;");
        System.out.println(bf3.apply(Integer.SIZE, " treinta y dos"));
        
        BiFunction<Persona, Persona, Boolean> bf4 = Persona::greaterThan;
        System.out.println("> Persona::greaterThan;");
        System.out.println(bf4.apply(p1, new Persona(10, "")));
        
        // UnaryOperator
        
        System.out.println("$$ UnaryOperator<T>");
        UnaryOperator<Integer> uo1 = i -> i*2;
        System.out.println("> i -> i*2;");
        System.out.println(uo1.apply(Integer.SIZE));
        
        UnaryOperator<String> uo2 = s -> s.repeat(12);
        System.out.println("> s -> s.repeat(12);");
        System.out.println(uo2.apply("docenas "));
        
        UnaryOperator<Integer> uo3 = Main::alCuadrado;
        System.out.println("> Main::alCuadrado;");
        System.out.println(uo3.apply(3));
        
        UnaryOperator<String> uo4 = s -> s.concat(s);
        System.out.println("> s -> s.concat(s);");
        System.out.println(uo4.apply("hola"));
        
        // BinaryOperator<T, T>
        
        System.out.println("$$ BinaryOperator<T, U>");
        BinaryOperator<Integer> bo1 = (i1, i2) -> i1+i2;
        System.out.println("> (i1, i2) -> i1+i2;");
        System.out.println(bo1.apply(Integer.SIZE, Integer.SIZE));
        
        BinaryOperator<Integer> bo2 = Integer::compare;
        System.out.println("> Integer::compare;");
        System.out.println(bo2.apply(Integer.SIZE, Integer.SIZE));
        
        BinaryOperator<String> bo3 = String::concat;
        System.out.println("> String::concat;");
        System.out.println(bo3.apply("hola ", "mundo"));
        
        BinaryOperator<String> bo4 = new String("hola mundo")::replaceAll;
        System.out.println("> new String(\"hola mundo\")::replaceAll;");
        System.out.println(bo4.apply(" ", "_"));
        
    }

    static boolean isGreater20(int i) {
        return i > 20;
    }
    
    static boolean strMoreThanI(String s, int i){
        return s.length()>i;
    }

    static int returnYourStrSize(String s){
        return s.length();
    }
    
    static int alCuadrado(int n){
        return n*n;
    }
}

class Persona {

    int id;
    String name;

    public String getName() {
        return name;
    }

    public static int getIdPlaceholder() {
        return Integer.MIN_VALUE;
    }

    public int getId() {
        return this.id;
    }

    public Persona() {
        this.id = Integer.MAX_VALUE;
        this.name = "Name";
    }

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persona[ id: " + this.id + ", name: " + this.name + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void print() {
        System.out.println("[id: " + this.id + ", nombre: " + this.name + "]");
    }
    
    public boolean greaterThan(Persona p){
        return this.id>p.id;
    }
    
    public boolean greaterThanInt(int i){
        return this.id>i;
    }
}
