package Homework;


public class Notebook {
    public String name;
    public int noteRAM;
    public String operationSystem;
    public String model;
    public String color;
    public int price;

    public Notebook(String name, int noteRAM, String operationSystem, String model, String color, int price) {
        this.name = name;
        this.noteRAM = noteRAM;
        this.operationSystem = operationSystem;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Notebook {name: %s, model: %s, operationSystem: %s, noteRAM: %s, color: %s, price: %s }", name, model, operationSystem, noteRAM, color, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoteRAM() {
        return noteRAM;
    }

    public void setNoteRAM(int noteRAM) {
        this.noteRAM = noteRAM;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
