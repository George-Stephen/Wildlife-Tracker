package models;

import org.sql2o.*;

public class DB{
    // private static String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
     // public static Sql2o sql2o = new Sql2o(connectionString, "stephen", "stephen2020");//
    private static String connectionString = "postgres://dksgitbwtewwbm:5603f2f69ea00a8bc9d17682f170874eb20ac570bc583bf3557dea5cb9d2a912@ec2-52-6-143-153.compute-1.amazonaws.com:5432/dfjhee4vn5bjve\n";
    public static Sql2o sql2o = new Sql2o(connectionString, "dksgitbwtewwbm", "5603f2f69ea00a8bc9d17682f170874eb20ac570bc583bf3557dea5cb9d2a912\n");
}