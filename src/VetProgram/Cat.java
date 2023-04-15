//Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
// а) информационной системой ветеринарной клиники

package VetProgram;

public class Cat {
    public String name;
    public String breed;
    public int age;
    public Owner owner;

    public Cat(String name, String breed, int age, Owner owner) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
    }

    public boolean sleep(boolean param) {
        return param;
    }

    public boolean isIll(boolean param) {
        return param;
    }

    public void eat() {
        System.out.println("Кот ест");
    }

    @Override
    public String toString() {
        return String.format("Cat {name: %s, breed: %s, age: %s}", name, breed, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat)
            return ((Cat) obj).name.equals(this.name) &&
                    ((Cat) obj).breed.equals(this.breed) &&
                    ((Cat) obj).age == this.age &&
                    ((Cat) obj).owner.equals(this.owner);
        else return false;
    }
}
