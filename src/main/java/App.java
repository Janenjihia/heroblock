
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static void main (String[] args) {
//        getHerokuAssignedPort();
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Hero.setUpNewHero();
        Hero.setUpNewHero1();
        Squad.setUpNewSquad();
        Squad.setUpNewSquad1();
//Add root route
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
//Add hero form route
        get("/hero-form", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//Add route to allow us get all instances for hero
        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAllInstances();
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

//        Add route to allow us get hero by id
        get("/new/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero", foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

//        Add route for squad form
        get("/squad-form", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

//        Add route to allow us get all squads
        get("/squad", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            ArrayList<Hero>members= Hero.getAllInstances();
            model.put("heroes", members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

//        sessions
        post("/squad/new", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            Integer size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(squadName, size, cause);
            request.session().attribute("item", squadName);
            model.put("item", request.session().attribute("item"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        post("/new/hero", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            request.session().attribute("item", name);
            model.put("item", request.session().attribute("item"));
            model.put("newHero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/new/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero", foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/member/:squadId", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            req.session().attribute("selected", req.params("squadId"));
            model.put("selectedSquad", req.session().attribute("selectedSquad"));
            model.put("item", 1);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad/new/:id", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(request.params(":id"));
            Hero newMember = Hero.findById(id);
            Squad newSquad = Squad.findBySquadId(1);
            newSquad.setSquadMembers(newMember);
            model.put("item", newMember.getName());
            model.put("newHero", newSquad.getName());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
