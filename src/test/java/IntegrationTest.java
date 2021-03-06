import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();


  @Test
  public void rootTest(){
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void createsNewWord_Panda(){
    goTo("http://localhost:4567/");
    fill("#word").with("Panda");
    submit(".btn");
    assertThat(pageSource()).contains("You successfuly create new word");
  }

  @Test
  public void containsDefinitionOfAChosenWord_TheMostSweetAnimal(){
    goTo("http://localhost:4567/");
    fill("#word").with("daw");
    submit(".btn");
    goTo("http://localhost:4567/");
    submit(".btn-link");
    assertThat(pageSource()).contains("Have something to add?");
  }

  // @Test
  // public void containsSuccessMassageIfCreateDefinition_Success(){
  //   // goTo("http://localhost:4567/");
  //   // fill("#word").with("Panda");
  //   // submit(".btn");
  //   // goTo("http://localhost:4567/");
  //   // submit(".btn-link");
  //   fill("#newDefinition").with("Panda the best");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("You successfuly create new definition");
  // }

}
