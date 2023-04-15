package Homework;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> set = new HashSet<>();
        set.add(new Notebook("Notebook1", 8, "Windows10", "Lenova", "white", 85000));
        set.add(new Notebook("Notebook2", 8, "Windows10", "Lenova", "black", 85000));
        set.add(new Notebook("Notebook3", 16, "Windows10", "Lenova", "white", 95000));
        set.add(new Notebook("Notebook4", 16, "Windows10", "Lenova", "black", 95000));
        set.add(new Notebook("Notebook5", 32, "Windows10", "Lenova", "white", 100000));
        set.add(new Notebook("Notebook6", 32, "Windows10", "Lenova", ",black", 100000));
        set.add(new Notebook("Notebook7", 8, "Linux", "Lenova", "white", 90000));
        set.add(new Notebook("Notebook8", 8, "Linux", "Lenova", "black", 90000));
        set.add(new Notebook("Notebook9", 16, "Linux", "Lenova", "white", 100000));
        set.add(new Notebook("Notebook10", 16, "Linux", "Lenova", "black", 100000));
        set.add(new Notebook("Notebook11", 32, "Linux", "Lenova", "white", 110000));
        set.add(new Notebook("Notebook1", 32, "Linux", "Lenova", ",black", 110000));
        set.add(new Notebook("Notebook1", 8, "Windows10", "Asus", "white", 83000));
        set.add(new Notebook("Notebook2", 8, "Windows10", "Asus", "black", 83000));
        set.add(new Notebook("Notebook3", 16, "Windows10", "Asus", "white", 93000));
        set.add(new Notebook("Notebook4", 16, "Windows10", "Asus", "black", 93000));
        set.add(new Notebook("Notebook5", 64, "Windows10", "Asus", "white", 103000));
        set.add(new Notebook("Notebook6", 64, "Windows10", "Asus", ",black", 103000));

        FilterCharacters operation = new FilterCharacters(set);
        operation.start();



    }
}
