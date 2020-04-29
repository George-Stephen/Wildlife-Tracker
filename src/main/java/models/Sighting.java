package models;

import java.util.Objects;

public class Sighting {
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
}