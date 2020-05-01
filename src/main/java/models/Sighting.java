package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Sighting {
    int id;
    int Animal_id;
    String Report;
    int rangers_id;
    int Location_id;

    public Sighting(int animal_id, String report, int rangers_id, int location_id) {
        Animal_id = animal_id;
        Report = report;
        this.rangers_id = rangers_id;
        Location_id = location_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return Animal_id == sighting.Animal_id &&
                rangers_id == sighting.rangers_id &&
                Location_id == sighting.Location_id &&
                Objects.equals(Report, sighting.Report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Animal_id, Report, rangers_id, Location_id);
    }

    public String getReport() {
        return Report;
    }
    public void save(){
        String sql = "INSERT INTO  sightings (animal_id,report,ranger_id,location_id,date) VALUES (:animal,:report,:ranger,:location,now())";
        try(Connection con = DB.sql2o.open()){
            this.id =(int)
            con.createQuery(sql,true)
                    .addParameter("animal",this.Animal_id)
                    .addParameter("report",this.Report)
                    .addParameter("ranger",this.rangers_id)
                    .addParameter("location",this.Location_id)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id) {
        String sql = "SELECT * FROM sightings WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            Sighting sights = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Sighting.class);
            return sights;
        }
    }

}