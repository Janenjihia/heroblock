import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
//Add root route
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
//Add hero form route
        get("/hero-form", (req, re) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());
//Add route to allow us get all instances for hero
        get("/hero", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAllInstances();
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

//        Add route to allow us get hero by id
        get("/new/:id",(req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero", foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

//        Add route for squad form
        get("/squad-form", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());
//        Add route to allow us get all squads
        get("/squad", (req, res) ->{
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
        post("/squad/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer size = Integer.parseInt(req.queryParams("size"));
            String cause = req.queryParams("cause");
            Squad newSquad = new Squad(squadName, size, cause);
            req.session().attribute("item", squadName);
            model.put("item", req.session().attribute("item"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
