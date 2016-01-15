import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      model.put("wordList", Word.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/newWord", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/success.vtl");

      Word newWord = new Word(request.queryParams("word"));

      model.put("newWord", newWord);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/newDefinition", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/definition.vtl");

      Word.find(Integer.parseInt(request.queryParams("word"))).addDefinition("The sweetest animal in the word!");

      model.put("word", Word.find(Integer.parseInt(request.queryParams("word"))));

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }
}
