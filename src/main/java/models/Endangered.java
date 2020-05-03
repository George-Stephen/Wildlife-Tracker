package models;

import java.util.List;
import org.sql2o.*;


public class Endangered implements methods {
    public int id;
    public String name;
    public String health;
    public String age;
    public String ranger;
    public static final String DATABASE_TYPE = "Endangered";

    public Endangered(String name, String health, String age,String ranger) {
        this.name = name ;
        this.health = health;
        this.age = age;
        this.ranger = ranger;

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
        String sql = "INSERT INTO endangered(name,age,health,ranger) VALUES (:name,:age,:health,:ranger)";
        try (Connection con = DB.sql2o.open()) {
            this.id = (int)
                    con.createQuery(sql, true)
                            .addParameter("name", this.name)
                            .addParameter("age", this.age)
                            .addParameter("health", this.health)
                            .addParameter("ranger",this.ranger)
                            .executeUpdate()
                            .getKey();
        }
    }

    @Override
    public void delete() {
        String sql = "DELETE FROM endangered";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }

    public static List<Endangered> all() {
        String sql = "SELECT * FROM endangered";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
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