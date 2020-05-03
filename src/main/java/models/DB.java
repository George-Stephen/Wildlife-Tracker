package models;

import org.sql2o.*;

public class DB{
    // private static String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
     // public static Sql2o sql2o = new Sql2o(connectionString, "stephen", "stephen2020");//
    private static String connectionString = "jdbc:postgresql://ec2-52-87-135-240.compute-1.amazonaws.com:5432/dcgo8sr0t94hgf";
    public static Sql2o sql2o = new Sql2o(connectionString, "axenptosipwifu", "83443395ecafa46edbd7868a81b631c69f7ee08aa8313a4b223bf4c720aacc31");
}