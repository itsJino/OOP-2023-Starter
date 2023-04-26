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
        return word + ": " + follows;
    }

    public void findFollow(String word) {
        for (Follow f : follows) {
            if (f.getWord().equals(word)) {
                f.setCount(f.getCount() + 1);
                return;
            }
        }
        follows.add(new Follow(word, 1));
    }
}
