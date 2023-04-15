package Homework;

import java.util.*;

public class FilterCharacters {
    private Set<Notebook> notebooks = new HashSet<>();
    private List<Character> characterList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void printList(){
        for (Notebook notebook : notebooks){
            if (notebookIsCorrect(notebook)){
                System.out.println(notebook);
            }
        }
    }

    public boolean notebookIsCorrect(Notebook notebook){
        for (Character character : characterList){
            Object valueNotebook = null;

            if (character.property.equals("name")){
                valueNotebook = notebook.getName();
            }else if (character.property.equals("noteRAM")){
                valueNotebook = notebook.getNoteRAM();
            }else if (character.property.equals("operationSystem")){
                valueNotebook = notebook.getOperationSystem();
            }else if (character.property.equals("price")){
                valueNotebook = notebook.getPrice();
            }else if (character.property.equals("model")){
                valueNotebook = notebook.getModel();
            }else if (character.property.equals("color")){
                valueNotebook = notebook.getColor();
            }else {
                continue;
            }

            if (character.value != null && !character.value.equals(valueNotebook)){
                return false;
            }

            if (character.maxValue != null && character.maxValue < Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }

            if (character.minValue != null && character.minValue > Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }
        }

        return true;
    }

    public FilterCharacters(Set<Notebook> notebooks) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public FilterCharacters(Set<Notebook> notebooks, List<Character> characterList){
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
        this.characterList = characterList;
    }

    public int getCharacter(){
        String text = "Введите цифру, соответствующую необходимому критерию: ";
        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++) {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property){
        Map<String, String> descriptionsProperties = descriptionsProperties();
        return descriptionsProperties.get(property);
    }

    public Map<String, String> descriptionsProperties(){
        Map<String, String> map = new HashMap<>();

        map.put("name", "Наименование");
        map.put("noteRAM", "Объем оперативной памяти");
        map.put("operationSystem", "Операционная система");
        map.put("price", "цена");
        map.put("model", "модель");
        map.put("color", "цвет");

        return map;
    }


    public List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("noteRAM");
        list.add("operationSystem");
        list.add("price");
        list.add("model");
        list.add("color");

        return list;
    }

    public String getOperation(){
        String text = "Выберите операцию: \n" +
                "1. Добавить критерий отбора \n" +
                "2. Вывести список \n" +
                "3. Завершить";
        System.out.println(text);
        String answer = scanner.next();
        return answer;
    }

    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("noteRAM");
        set.add("price");

        return set;
    }

    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();

        set.add("name");
        set.add("operationSystem");
        set.add("model");

        return set;
    }

    public void start(){

        boolean flag = true;
        while (flag){

            String operation;
            operation = getOperation();
            if (operation.equals("3")){
                flag = false;
                scanner.close();
                continue;
            }else if(operation.equals("1")){

                int character = getCharacter();
                List<String> properties = propertiesForFilter();
                if (character - 1 < 0 || character - 1 > properties.size() - 1){
                    System.out.println("Введено некорректное значение");
                    continue;
                }
                String property = properties.get(character - 1);
                Character characterObject = null;
                try {
                    if (quantitativeSelection().contains(property)){
                        characterObject = Character.startGetting(scanner, property, true);
                    }else {
                        characterObject = Character.startGetting(scanner, property, false);
                    }
                }catch (Exception e){
                    System.out.println("Ошибка при выборе критерия");
                    continue;
                }
                if (characterObject != null){
                    System.out.println("Критерий добавлен");
                    characterList.add(characterObject);
                }
            }
            else if (operation.equals("2")){
                printList();
            }
        }
    }
}

class Character {

    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    String property;

    public Character(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Character startGetting(Scanner scanner, String property, boolean isQuantitative) {

        if (isQuantitative) {

            String quest = "Выберите тип криетрия: " +
                    "\n 1. Значение" +
                    "\n 2. Меньше" +
                    "\n 3. Больше" +
                    "\n 4. Интервал";
            System.out.println(quest);

            String text = scanner.next();

            Character character = null;

            if (text.equals("1")) {
                System.out.println("Введите значение поиска: ");
                int getValue = scanner.nextInt();
                character = new Character(property, isQuantitative, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.println("Введите максимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                character = new Character(property, isQuantitative, null, null, getValue);
            } else if (text.equals("3")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                character = new Character(property, isQuantitative, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getMin = scanner.nextDouble();
                System.out.println("Введите максимальное предельное значение: ");
                double getMax = scanner.nextDouble();
                character = new Character(property, isQuantitative, null, getMin, getMax);
            }

            return character;
        }

        System.out.println("Введите значение поиска: ");
        String getValue = scanner.next();
        return new Character(property, isQuantitative, getValue, null, null);
    }

}



