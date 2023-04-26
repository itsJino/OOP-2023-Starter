package ie.tudublin;

import java.util.ArrayList;

public class Word {
    String word;
    ArrayList<Follow> follows = new ArrayList<Follow>();

    public Word(String word) {
        this.word = word;
    }

    public Word() {
        
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }

    public Word(String word, ArrayList<Follow> follows) {
        this.word = word;
        this.follows = follows;
    }

    @Override
    public String toString() {
        return "Word [follows=" + follows + ", word=" + word + "]";
    }
}
