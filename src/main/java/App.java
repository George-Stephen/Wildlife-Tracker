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
        // get new animals
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
               animal.save();
               Sighting sight = new Sighting(rangerName, location);
               sight.saveSighting();
           }catch(IllegalArgumentException exception){
               System.out.println("Enter the right data");
           }
           return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        get("/animals/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("animals",Animal.allAnimals());
            return new ModelAndView(model,"animal.hbs");
        }, new HandlebarsTemplateEngine());
        // get endangered
        get("/Endangered/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            model.put("animals",Animal.allAnimals());
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"Endangered-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/Endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String animalName = request.queryParams("Name");
            String health = request.queryParams("health");
            String Age = request.queryParams("age");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            Endangered endangered = new Endangered(animalName,health,Age,rangerName);
            endangered.save();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        get("/Endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            model.put("animals",Endangered.all());
            return new ModelAndView(model,"endangered.hbs");
        }, new HandlebarsTemplateEngine());
        get("/ranger/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"ranger-form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/ranger/new",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"ranger.hbs");
        }, new HandlebarsTemplateEngine());
        post("/ranger/new",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("Name");
            String phone = request.queryParams("Phone");
            String email = request.queryParams("Email");
            try {
                Ranger ranger = new Ranger(name, phone, email);
                ranger.save();
            }catch(IllegalArgumentException exception){
                System.out.println("Please enter the correct data");
            }
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

    }
}