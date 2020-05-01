package models;

import java.util.List;
import java.util.Objects;
import org.sql2o.*;


public class Endangered extends Animal {
    String health;
    int Ranger;
    public static final String DATABASE_TYPE = "Endangered";

    public Endangered(String name, String health, int age, int species, int ranger) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.Ranger = ranger;
        this.type = DATABASE_TYPE;
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

    public void save() {
        String sql = "INSERT INTO animals(name,age,health,rangerid,type) VALUES (:name,:age,:health,:ranger,:type)";
        try (Connection con = DB.sql2o.open()) {
            this.id = (int)
                    con.createQuery(sql, true)
                            .addParameter("name", this.name)
                            .addParameter("age", this.age)
                            .addParameter("health", this.health)
                            .addParameter("ranger", this.Ranger)
                            .addParameter("type", this.type)
                            .throwOnMappingFailure(false)
                            .executeUpdate()
                            .getKey();
        }
    }

    public static List all() {
        String sql = "SELECT * FROM animals";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }

    public static Endangered find(int id) {
        String sql = "SELECT * FROM animals WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            Endangered animals = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Endangered.class);
            return animals;
        }
    }
}