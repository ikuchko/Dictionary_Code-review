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

      Word newWord = new Word("someWord");

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



  }
}
