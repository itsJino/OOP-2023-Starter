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

		for(int i = 0; i < s.length; i++)
		{
			w =  split(s[i], ' ');
		}
		
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i].replaceAll("[^\\w\\s]", "");
		}

		for (int i = 0; i < w.length; i++) {	
			w[i] = w[i].toLowerCase();
		}	

		for(int i = 0; i < w.length; i++)
		{
			System.out.println(w[i]);
		}
	}

	public Boolean findWord(String search) {
		for (int i = 0; i < w.length; i++) {
			if (w[i].equals(search)) {
				return true;
			}
		}
		return false;
	}

	public void findFollow(String search) {
		Follow follow = new Follow();
		for (int i = 0; i < w.length; i++) {
			if (w[i].equals(search)) {
				follow.setWord(w[i + 1]);
				follow.setCount(follow.getCount() + 1);
			}
		}
	}

	public void printModel() {
		for (int i = 0; i < w.length; i++) {
			System.out.println(w[i]);
		}
	}
}
