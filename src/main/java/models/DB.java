package models;

import org.sql2o.*;

public class DB{
    // For local use only
     // public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "stephen", "stephen2020");//
    private static String connectionString = "jdbc:postgresql://ec2-52-71-231-180.compute-1.amazonaws.com:5432/d7ibdughsrddip";
    public static Sql2o sql2o = new Sql2o(connectionString, "ksqytqouusqfct", "4cbd75780f8534cc6bd66e462eadcfc7337589ea905d9bc39c7a54826b37189b");
}