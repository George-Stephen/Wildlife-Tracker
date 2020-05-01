package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public  class Ranger{
    int id;
    String Name;
    String Phone ;
    String Email;

    public Ranger(String name, String phone, String email) {
        Name = name;
        Phone = phone;
        Email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return Objects.equals(Name, ranger.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }
    public void save() {
        String sql = "INSERT INTO rangers (name,phone,email) VALUES (:name,:phone,:email) ";
        try (Connection con = DB.sql2o.open()) {
            this.id = (int)
            con.createQuery(sql,true)
                    .addParameter("name" , this.Name)
                    .addParameter("phone",this.Phone)
                    .addParameter("email", this.Email)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List all(){
        String sql = "SELECT * FROM rangers";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Ranger.class);
        }
    }
    public static Ranger find(int id){
        String sql = "SELECT * FROM rangers WHERE id = :id";
        try (Connection con = DB.sql2o.open()){
            Ranger ranger = con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Ranger.class);
            return ranger;
        }
    }
    public List<Endangered> found() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where rangerid=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }
    public void delete(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE * FROM  rangers WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
            String sql2 = "DELETE from sightings WHERE animal_id = :id";
            con.createQuery(sql2)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
    public  List<Sighting> allSightings(){
        String sql = "SELECT * FROM sightings WHERE  ranger_id = : id";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
}