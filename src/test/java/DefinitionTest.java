import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initiatesObject_true(){
    Definition newDefinition = new Definition("Definition");
    assertEquals(true, newDefinition instanceof Definition);
  }

  @Test
  public void definition_returnDefinition_definition(){
    Definition newDefinition = new Definition("definition");
    assertEquals("definition", newDefinition.getDefinition());
  }

}
