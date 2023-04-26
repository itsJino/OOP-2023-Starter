package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import ie.tudublin.Follow;
import ie.tudublin.Word;

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

	Follow follow = new Follow();

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
		}

		// convert string to lower case
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i].toLowerCase();
		}

		for (int i = 0; i < w.length; i++) {
			if(!findWord(w[i])) {
				w2 = append(w2, w[i]);
			}
		}

		// print w2
		System.out.println("Words");
		for (int i = 0; i < w2.length; i++) {
			System.out.println(w2[i]);
		}

	}

	public Boolean findWord(String search) {
		for (int i = 0; i < w2.length; i++) {
			if (w2[i].equals(search)) {
				return true;
			}
		}
		return false;
	}

	public void findFollow(String search) {

		for (int i = 0; i < w.length; i++) {
			if (w[i].equals(search)) {
				follow.setWord(w[i + 1]);
				follow.setCount(follow.getCount() + 1);
			}
		}
	}

	public void printModel() {
		
	}
}
