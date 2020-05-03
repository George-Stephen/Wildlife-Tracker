package models;

import org.sql2o.Connection;
import java.util.List;
import java.util.Objects;
import java.sql.Timestamp;
import java.util.Date;

public class Sighting {
    int id;
    String rangerName;
    String Location;
    private Date date= new Date();
    private Timestamp time;

    public Sighting(String rangerName, String Location) {
        this.rangerName = rangerName;
        this.Location = Location;
        this.time = new Timestamp(date.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return Objects.equals(rangerName, sighting.rangerName) &&
                Objects.equals(Location, sighting.Location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rangerName, Location);
    }

    public void saveSighting(){
        String sql = "INSERT INTO  sightings (location,ranger,date) VALUES (:location,:ranger,now())";
        try(Connection con = DB.sql2o.open()){
            this.id =(int)
            con.createQuery(sql,true)
                    .addParameter("ranger",this.rangerName)
                    .addParameter("location",this.Location)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> allSightings(){
        String sql = "SELECT  *  FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id) {
        String sql = "SELECT * FROM sightings WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            Sighting sights = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sights;
        }
    }
    public void findAnimal(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals WHERE sightingId = :id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeAndFetch(Animal.class);
        }
    }

}