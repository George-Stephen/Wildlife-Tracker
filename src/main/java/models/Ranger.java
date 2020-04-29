package models;

import java.util.Objects;

public  class Ranger{
    int id;
    String Name;
    String Phone ;
    String Email;
    String Sightings;

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
}