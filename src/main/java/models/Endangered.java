package models;

import java.util.List;
import org.sql2o.*;


public class Endangered {
    public int id;
    public String name;
    public String health;
    public String age;
    public static final String DATABASE_TYPE = "Endangered";

    public Endangered(String name, String health, String age) {
        this.name = name ;
        this.health = health;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public void save() {
        String sql = "INSERT INTO endangered(name,age,health) VALUES (:name,:age,:health)";
        try (Connection con = DB.sql2o.open()) {
            this.id = (int)
                    con.createQuery(sql, true)
                            .addParameter("name", this.name)
                            .addParameter("age", this.age)
                            .addParameter("health", this.health)
                            .executeUpdate()
                            .getKey();
        }
    }

    public static List<Endangered> all() {
        String sql = "SELECT * FROM endangered";
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