import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest(){
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  // @Test
  // public void createsNewWord_Panda(){
  //   goTo("http://localhost:4567/");
  //   fill("#word").with("Panda");
  //   submit(".btn");
  //   goTo("http://localhost:4567/");
  //   //assertThat(pageSource()).contains(".btn btn-link");
  //   assertThat(findFirst(".btn btn-link").getName().contains("Panda"));
  // }

  // @Test
  // public void containsDefinitionOfAChosenWord_TheMostSweetAnimal(){
  //   goTo("http://localhost:4567/");
  //   fill("#word").with("Panda");
  //   submit(".btn");
  //   goTo("http://localhost:4567/");
  //   submit(".btn");
    //assertThat(pageSource()).contains("ADefinition");
  }
}
