package markov.fun;

import java.util.ArrayList;
import java.util.Random;

public class word {

    ArrayList<String> precursor = new ArrayList();
    ArrayList<String> afterword =  new ArrayList();
    String word;
    Random rand = new Random();
    
    public word(String a, String b, String c) {
        precursor.add(a);
        word = b;
        afterword.add(c);
    }
    public String getPre(){
        return precursor.get(rand.nextInt(precursor.size()+1));
    } 
    public String getAft(){
        
        return afterword.get(rand.nextInt(precursor.size()));
    }
    
    public String getWord(){
        return word;
    }  
    public void addNew(String pre, String aft){
        
    }
    public boolean isEqual(word a, word b){
        return a.word.equals(b.word);
    }
}
