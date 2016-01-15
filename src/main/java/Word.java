import java.util.ArrayList;

public class Word{
  private String mWord;
  private int id;
  private ArrayList<Definition> definitionList = new ArrayList<Definition>();
  private static ArrayList<Word> wordList = new ArrayList<Word>();

  public Word(String word){
    mWord = word;
    wordList.add(this);
    id = wordList.size();
  }

  public String getWord(){
    return mWord;
  }

  public void addDefinition(String definition){
    Definition newDefinition = new Definition(definition);
    definitionList.add(newDefinition);
  }

  public ArrayList<Definition> getDefinition(){
    return definitionList;
  }

  public static ArrayList<Word> all(){
    return wordList;
  }

  public int getId(){
    return id;
  }

  public static void clear(){
    wordList.clear();
  }

  public static Word find(int id){
    try{
      return wordList.get(id - 1);
    } catch (IndexOutOfBoundsException ioobe){
      return null;
    }
  }

}
