package VetProgram;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Jhon Snow", "999999999");
        Cat cat = new Cat("Barsik", "siam", 9, owner);
        cat.sleep(true);
        Cat cat1 = new Cat("Barsik", "siam", 9, owner);
        System.out.println(cat);
        System.out.println((cat.equals(cat1)));
    }
}
