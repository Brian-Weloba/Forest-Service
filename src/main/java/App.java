import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //GET
        //homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        // create sighting
        get("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Ranger> rangers = Ranger.getAll();
            model.put("rangers", rangers);
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //POST
        //process new sighting form
        post("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            //endangered animal
            String eName = request.queryParams("eName");
            String eAge = request.queryParams("eAge");
            String eHealth = request.queryParams("eHealth");

            Endangered newEndangered = new Endangered(eName, eHealth, eAge);
            if (eName != null && eAge != null && eHealth != null) {
                newEndangered.save();

                //location
                String lName = request.queryParams("lName");

                Location newLocation = new Location(lName);
                if (lName != null) {
                    newLocation.save();
                }

                //sighting
                int animalId = newEndangered.getId();
                int rangerId = Integer.parseInt(request.queryParams("rangerId"));
                int locationId = newLocation.getId();

                Sighting newSighting = new Sighting(animalId, rangerId, locationId);
                newSighting.save();
            }

            //thriving animal
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");

            NonEndangered newNonEndangered = new NonEndangered(name, health, age);
            if (name != null && age != null && health != null) {
                newNonEndangered.save();

                //location
                String lName = request.queryParams("lName");

                Location newLocation = new Location(lName);
                if (lName != null) {
                    newLocation.save();
                }

                //sighting
                int animalId = newNonEndangered.getId();
                int rangerId = Integer.parseInt(request.queryParams("rangerId"));
                int locationId = newLocation.getId();

                Sighting newSighting = new Sighting(animalId, rangerId, locationId);
                newSighting.save();
            }

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            List<NonEndangered> allThriving = NonEndangered.getAll();
            List<Animal> allAnimal = Animal.getAllAnimals();
//            model.put("thriving", allThriving);
            model.put("animals", allAnimal);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //all sightings
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = Sighting.getAll();
            List<String> allLocations = new ArrayList<>();
            List<String> allCreated = new ArrayList<>();
            List<String> allRanger = new ArrayList<>();
            List<String> allAnimal = new ArrayList<>();

            for (Sighting sighting : allSightings) {
                Timestamp created_at = Sighting.findById(sighting.getId()).getCreated_At();
                allCreated.add(DateFormat.getDateTimeInstance().format(created_at));

                int animalId = Sighting.findById(sighting.getId()).getAnimal_id();
                String animalName = Animal.findById(animalId).getName();
                allAnimal.add(animalName);

                int locationId = Sighting.findById(sighting.getId()).getLocation_id();
                String locationName = Location.findById(locationId).getName();
                allLocations.add(locationName);

                int rangerId = Sighting.findById(sighting.getId()).getRanger_id();
                String rangerName = Ranger.findById(rangerId).getName();
                allRanger.add(rangerName);

            }

            model.put("animals", allAnimal);
            model.put("rangers", allRanger);
            model.put("created_at", allCreated);
            model.put("sightings", allSightings);
            model.put("locations", allLocations);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //show a form to create a new ranger
        get("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "ranger-form.hbs"); //new
        }, new HandlebarsTemplateEngine());

        //process a new ranger form
        post("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            //ranger
            String rName = request.queryParams("rName");
            Ranger newRanger = new Ranger(rName);
            if (rName != null) {
                newRanger.save();
            }

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
