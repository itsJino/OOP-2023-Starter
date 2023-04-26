package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import ie.tudublin.Follow.*;
import ie.tudublin.Word.*;

public class DANI extends PApplet {
	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;
	String[] s;
	String[] w;
	String[] w2;
	String[] line;

	ArrayList<Word> words = new ArrayList<Word>();

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);

		loadFile();

		printModel();
	}

	public void loadFile() {
		s = loadStrings("small.txt");
		w = new String[0];
		w2 = new String[0];

		// from the text file, put all the words into an array of words
		for (int i = 0; i < s.length; i++) {
			line = s[i].split(" ");
			for (int j = 0; j < line.length; j++) {
				w = append(w, line[j]);
			}
		}

		// remove punctuation characters
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i].replaceAll("[^\\w\\s]", "");
			w[i] = w[i].toLowerCase();
		}

		// Put all unique words into String array w2
		for (int i = 0; i < w.length; i++) {
			if(!findWord(w[i])) {
				w2 = append(w2, w[i]);
			}
		}

		// add words to arraylist words
		for (int i = 0; i < w2.length; i++) {
			Word word = new Word(w2[i]);
			
			words.add(word);
		}		
	}

	// Check if word is already in array, if so don't add it, if not add it
	public Boolean findWord(String search) {
		for (int i = 0; i < w2.length; i++) {
			if (w2[i].equals(search)) {
				return true;
			}
		}
		return false;
	}

	public void printModel() {
		for (int i = 0; i < words.size(); i++) {
			Word word = words.get(i);
			System.out.println(word);
		}

	}
}
