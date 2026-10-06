package tn.esprit.gestionzoo.entities;

public class Zoo {

    private Animal[] animals = new Animal[25];
    private String name;
    private String city;
    private final int nbrCages;
    private int nombreAnimaux = 0;

    public Zoo() {
        nbrCages = 25;
    }

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.nbrCages = nbrCages;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Le nom du zoo ne doit pas être vide.");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNombreAnimaux() {
        return nombreAnimaux;
    }

    public void displayZoo() {
        System.out.println("Zoo : " + name + ", Ville : " + city + ", Cages : " + nbrCages);
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Cages=" + nbrCages + "]";
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            return false;
        }

        if (searchAnimal(animal.getName()) != -1) {
            return false;
        }

        animals[nombreAnimaux] = animal;
        nombreAnimaux++;

        return true;
    }

    public void displayAnimals() {
        for (int i = 0; i < nombreAnimaux; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(String name) {
        for (int i = 0; i < nombreAnimaux; i++) {
            if (animals[i].getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int position = searchAnimal(animal.getName());

        if (position == -1) {
            return false;
        }

        for (int i = position; i < nombreAnimaux - 1; i++) {
            animals[i] = animals[i + 1];
        }

        animals[nombreAnimaux - 1] = null;
        nombreAnimaux--;

        return true;
    }

    public boolean isZooFull() {
        return nombreAnimaux >= nbrCages;
    }

    public Zoo compareZoo(Zoo zoo) {
        if (this.nombreAnimaux >= zoo.nombreAnimaux) {
            return this;
        } else {
            return zoo;
        }
    }
}