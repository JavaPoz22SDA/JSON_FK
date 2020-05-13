package pl.sda.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static String ADD = "Dodaj studenta na listę";
    final static String READ = "Wczytanie listy";
    final static String REMOVE = "Usuń studenta z listy";
    final static String SHOW = "Wyświetl studentów";
    final static String SAVE = "Zapisz zmiany";
    final static String EXIT = "Zakończ program";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        Menu menu = new Menu();
        menu.add(ADD);
        menu.add(READ);
        menu.add(REMOVE);
        menu.add(SHOW);
        menu.add(SAVE);
        menu.add(EXIT);

        try {
            while (true){
                menu.print();
                switch (menu.showAndGetSelected()){
                    case ADD:
                        Student addStudent = new Student();
                        System.out.println("Dodawanie nowego studenta");
                        System.out.println("Podaj imię");
                        addStudent.setFirstName(scanner.nextLine().trim());
                        System.out.println("Podaj nazwisko");
                        addStudent.setLastName(scanner.nextLine().trim());
                        System.out.println(dataBase.add(addStudent));
                        break;
                    case REMOVE:
                        Student removeStudent = new Student();
                        System.out.println("Usuwanie studenta z listy");
                        System.out.println("Podaj imię");
                        removeStudent.setFirstName(scanner.nextLine().trim());
                        System.out.println("Podaj nazwisko");
                        removeStudent.setLastName(scanner.nextLine().trim());
                        System.out.println(dataBase.deleted(removeStudent));
                        break;
                    case SHOW:
                        System.out.println(dataBase.showList());
                        break;
                    case SAVE:
                        System.out.println(dataBase.saveFile());
                        break;
                    case READ:
                        System.out.println(dataBase.readFile());
                        break;
                    case EXIT:
                        System.exit(0);
                    default:
                        System.out.println("Zły wybór");
                }
            }
        }catch (IndexOutOfBoundsException x){
            System.out.println("Koniec programu");
        }
    }
}
