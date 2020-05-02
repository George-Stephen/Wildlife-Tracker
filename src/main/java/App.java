import models.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
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
        // display all sightings
        get("/sightings", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("sights",Sighting.all());
            return new ModelAndView(model,"Sightings.hbs");
        },new HandlebarsTemplateEngine());
        // display form to sightings
        get("/sightings/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return  new ModelAndView(model,"Sight-form.hbs");
        },new HandlebarsTemplateEngine());
        // post new sightings
        post("/sightings",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int animal = Integer.parseInt(request.queryParams("Animal_id"));
            int ranger = Integer.parseInt(request.queryParams("rangers_id"));
            int location = Integer.parseInt(request.queryParams("location_id"));
            String report = request.queryParams("Report");
            try {
                Sighting sighting = new Sighting(animal, report, ranger, location);
                sighting.save();
            }catch(IllegalArgumentException exception){
                System.out.println("Enter the right data");
            }
            return new ModelAndView(model,"Sightings.hbs");
        }, new HandlebarsTemplateEngine());
        // get all rangers
        get ( "/rangers",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("rangers", Ranger.all());
            return new ModelAndView(model,"rangers.hbs");
        },new HandlebarsTemplateEngine());
        //display rangers form
        get ( "/rangers/form",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"ranger-form.hbs");
        },new HandlebarsTemplateEngine());
        // post from the form
        //get all animals recorded
        get("/animals",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"animal.hbs");
        },new HandlebarsTemplateEngine());
        // display animals form
        //post from animals form

    }
}