import models.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App{
    public static void main(String[] args) {
        staticFileLocation("/public");

        // creating the landing page
        get("/",(request, response) ->{
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
        // get new animal
        get( "/animal/form", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/animals/new",(request, response) -> {
           Map<String,Object>model = new HashMap<>();
           String animalName = request.queryParams("Name");
           String health = request.queryParams("health");
           String Age = request.queryParams("age");
           String rangerName = request.queryParams("ranger");
           String location = request.queryParams("location");
           int sightId = Integer.parseInt(request.queryParams("sightingId"));
           try {
               Animal animal = new Animal(animalName, sightId);
               animal.saveAnimal();
               Sighting sight = new Sighting(rangerName, location);
               sight.saveSighting();
           }catch(IllegalArgumentException exception){
               System.out.println("Enter the right data");
           }
           return new ModelAndView(model,"animal.hbs");
        },new HandlebarsTemplateEngine());
        get("/Endangered/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"Endangered-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/Endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String animalName = request.queryParams("Name");
            String health = request.queryParams("health");
            String Age = request.queryParams("age");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            Endangered endangered = new Endangered(animalName,health,Age);
            endangered.save();
            return new ModelAndView(model,"endangered.hbs");
        },new HandlebarsTemplateEngine());

    }
}