import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void word_initiatesCorrectly_true(){
    Word newWord = new Word ("Word");
    assertEquals(true, newWord instanceof Word);
  }

  @Test
  public void word_returnWord_word(){
    Word newWord = new Word("Word");
    assertEquals("Word", newWord.getWord());
  }

  @Test
  public void word_createsDefinitionForWord_definition(){
    Word newWord = new Word("word");
    newWord.addDefinition("some definition");
    assertEquals("some definition", newWord.getDefinition().get(0).getDefinition());
  }

  @Test
  public void word_returnAllDefinitionForWord_2(){
    Word newWord = new Word("word");
    newWord.addDefinition("first definition");
    newWord.addDefinition("second definition");
    assertEquals(2, newWord.getDefinition().size());
  }

  @Test
  public void word_returnAllInstancesOfWord_true(){
    Word fistWord = new Word("Fist Word");
    Word secondWord = new Word("Second Word");
    assertEquals(true, Word.all().contains(fistWord));
    assertEquals(true, Word.all().contains(secondWord));
  }

  @Test
  public void word_returnsId_1(){
    Word newWord = new Word("word");
    assertEquals(1, newWord.getId());
  }

  @Test
  public void word_returnEmptyWordList_0(){
    Word newWord = new Word("word");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

  @Test
  public void word_findWordById_true(){
    Word fistWord = new Word("Fist Word");
    Word secondWord = new Word("Second Word");
    assertEquals(secondWord, Word.find(2));
  }

  @Test
  public void word_findReturnsNullOnId999_null(){
    Word fistWord = new Word("word");
    assertEquals(null, Word.find(999));
  }
}
