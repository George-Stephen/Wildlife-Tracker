package models;

import java.util.Objects;

public class Endangered{
    int id;
    String name;
    String health;
    int age;
    int Animal_id;
    int Ranger_id;
       public Endangered(String name, String health, int age,int species,int ranger) {
            this.name = name;
            this.health = health;
            this.age = age;
            this.Animal_id = species;
            this.Ranger_id = ranger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endangered that = (Endangered) o;
        return age == that.age &&
                Animal_id == that.Animal_id &&
                Objects.equals(name, that.name) &&
                Objects.equals(health, that.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age, Animal_id);
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public int getAge() {
        return age;
    }
}