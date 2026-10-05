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
        lion.family = "Félidé";
        lion.name = "Lion";
        lion.age = 5;
        lion.isMammal = true;

        Zoo myZoo = new Zoo();
        myZoo.name = "Parc Animalier";
        myZoo.city = "Tunis";

        System.out.println("Zoo : " + myZoo.name + " à " + myZoo.city);
        System.out.println("Animal : " + lion.name + " (" + lion.family + ")");

        Animal lion1 = new Animal("Félidé", "Lion", 5, true);
        Zoo myZoo1 = new Zoo("Parc Animalier", "Tunis", 20);

        System.out.println("Animal créé : " + lion1.name);
        System.out.println("Zoo créé : " + myZoo1.name + " (" + myZoo.city + ")");

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

        System.out.println("Zoo avec le plus d'animaux : " + zooPlusPeuple.name);
        System.out.println("Nombre d'animaux : " + zooPlusPeuple.nombreAnimaux);

        sc.close();
    }
}