package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        String zooName = sc.nextLine();

        int nbrCages;

        do {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            nbrCages = sc.nextInt();
        } while (nbrCages <= 0);

        System.out.println(zooName + " comporte " + nbrCages + " cages.");

        Animal lion = new Animal();
        lion.setFamily("Félidé");
        lion.setName("Lion");
        lion.setAge(5);
        lion.setMammal(true);

        Zoo myZoo = new Zoo();
        myZoo.setName("Parc Animalier");
        myZoo.setCity("Tunis");

        System.out.println("Zoo : " + myZoo.getName() + " à " + myZoo.getCity());
        System.out.println("Animal : " + lion.getName() + " (" + lion.getFamily() + ")");

        Animal lion1 = new Animal("Félidé", "Lion", 5, true);
        Zoo myZoo1 = new Zoo("Parc Animalier", "Tunis", 20);

        System.out.println("Animal créé : " + lion1.getName());
        System.out.println("Zoo créé : " + myZoo1.getName() + " (" + myZoo1.getCity() + ")");

        myZoo.displayZoo();
        System.out.println(myZoo);

        Animal tigre = new Animal("Félidé", "Tigre", 4, true);
        Animal elephant = new Animal("Éléphantidé", "Éléphant", 10, true);
        Animal perroquet = new Animal("Oiseau", "Perroquet", 2, false);

        System.out.println(myZoo.addAnimal(lion1));
        System.out.println(myZoo.addAnimal(tigre));
        System.out.println(myZoo.addAnimal(elephant));
        System.out.println(myZoo.addAnimal(perroquet));

        System.out.println("\nListe des animaux :");
        myZoo.displayAnimals();

        System.out.println("\nRecherche du Tigre :");
        int position = myZoo.searchAnimal("Tigre");
        System.out.println("Position : " + position);

        Animal tigre2 = new Animal("Félidé", "Tigre", 4, true);
        System.out.println("Ajout du deuxième Tigre : " + myZoo.addAnimal(tigre2));

        System.out.println("\nSuppression du Tigre :");
        System.out.println(myZoo.removeAnimal(tigre));

        System.out.println("\nAnimaux après suppression :");
        myZoo.displayAnimals();

        System.out.println("\nZoo plein : " + myZoo.isZooFull());

        Zoo zoo2 = new Zoo("Zoo Carthage", "Carthage", 25);

        Animal singe = new Animal("Singe", "Singe", 3, true);
        Animal ours = new Animal("Ours", "Ours", 6, true);

        zoo2.addAnimal(singe);
        zoo2.addAnimal(ours);

        System.out.println("Zoo 2 plein : " + zoo2.isZooFull());

        Zoo zooPlusPeuple = myZoo.compareZoo(zoo2);

        System.out.println("Zoo avec le plus d'animaux : " + zooPlusPeuple.getName());
        System.out.println("Nombre d'animaux : " + zooPlusPeuple.getNombreAnimaux());

        sc.close();
    }
}