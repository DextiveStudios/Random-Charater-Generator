//Goal: Make a random character design.


//Imports
import java.util.Random;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class RandomCharacter implements ActionListener {
	
	//The Arrays
	String[] SkinUndertone = {"Warm", "Cool"};
	String[] Gender = {"Cisgender Woman", "Cisgender Man", "Transgender Woman", "Transgender Man", "Feminine Nonbinary", "Masculine Nonbinary", "Agender", "Other"};
	String[] Race = {"White", "Black", "East Asian", "Southeast Asian", "Latin", "Indigenous American", "Misc", "Mixed"};
	String[] Age = {"Infant", "Toddler", "Adolescent", "Tween", "Teenager", "Young Adult", "Adult", "Middle-aged", "Elderly", "Absolute geezer"};
	String[] HairStyle = {"Long", "Short", "Wild", "Maintained", "Updo"};
	String[] HairColor = {"Brown", "Blonde", "Black", "Red", "White", "Gray", "Dyed"};
	String[] EyeColor = {"Brown", "Green", "Red", "Blue", "Hazel", "Black", "Gray", "Cosmetic Contacts"};
	String[] Career = {"Artist", "Scholar", "Farmer", "Laborer", "Royal", "Furry", "Student", "Unemployed", "Artisan", "Programmer", "Content creator"};
	String[] FashionTaste = {"Bland", "Leisure", "Casual", "Formal", "Whimsical", "Apathetic", "Alternative", "Preppy", "Pinterest", "Tumblrina", "Tryhard", "Doctor Who"};
	String[] Extra = {"Scarred", "Deformed", "Missing limb", "Mobility aid", "Glasses", "Tattoos", "Piercings", "Freckles"};
	String[] Era = {"Prehistoric", "Medieval", "Rennaisance", "Ancient Rome", "Speculative Future", "Modern", "19th Century", "Undetermined"};
	String[] Genre = {"Fantasy", "Sci-fi", "Romance", "Adventure", "Realism", "Comedy", "Horror", "Thriller", "Western"};
	
	Random r = new Random();
	
	void randomGen() {
		
		int skinIndex = r.nextInt(SkinUndertone.length);
		int genderIndex = r.nextInt(Gender.length);
		int raceIndex = r.nextInt(Race.length);
		int ageIndex = r.nextInt(Age.length);
		int hairstyleIndex = r.nextInt(HairStyle.length);
		int haircolorIndex = r.nextInt(HairColor.length);
		int eyecolorIndex = r.nextInt(EyeColor.length);
		int careerIndex = r.nextInt(Career.length);
		int fashiontasteIndex = r.nextInt(FashionTaste.length);
		int extraIndex = r.nextInt(Extra.length);
		int eraIndex = r.nextInt(Era.length);
		int genreIndex = r.nextInt(Genre.length);
		//Indexes the traits
		
		
		String result = "<html>Skin Undertone: " + SkinUndertone[skinIndex] + "<br>Gender: " + Gender[genderIndex] + "<br>Race: " + Race[raceIndex] + "<br>Age: " + Age[ageIndex] + "<br>Hair Style: " + HairStyle[hairstyleIndex] + "<br>Hair Color: " + HairColor[haircolorIndex] + "<br>Eye Color: " + EyeColor[eyecolorIndex] + "<br>Career: " + Career[careerIndex] + "<br>Fashion Taste: " + FashionTaste[fashiontasteIndex] + "<br>Extra: " + Extra[extraIndex] + "<br>Era: " + Era[eraIndex] + "<br>Genre: " + Genre[genreIndex] + "</html>";
		//Takes the indexes and put them in a single string, using some HTML to make them verticle like a list.
		
		TraitsList.setText(result); //Changes the label to the result
		
	}

	private JLabel TraitsList;
	private JButton Generate;
	
	//Adds the method to the button.
		public void actionPerformed(ActionEvent e) { //If compiler says something can't be implemented, try adding "public" keyword like here!
	
			if (e.getSource() == Generate)

				randomGen();
		}	
	
	//Method for making the frame
	public void makeFrame() {
		
		TraitsList = new JLabel("<html><div style='text-align:center;'>Press the button to generate a random design!</div></html>"); //Makes the label and places it in the center
		TraitsList.setHorizontalAlignment(SwingConstants.CENTER);
		TraitsList.setVerticalAlignment(SwingConstants.CENTER);
		Generate = new JButton("Generate a character!"); //Makes the button
		//Attaches button to action, "this" indicates current
		Generate.addActionListener(this);
		
		Frame mainFrame = new JFrame("Character Randomizer");
		mainFrame.setSize(400,400);
		Generate.setSize(300, 100);
	
		mainFrame.add(Generate, BorderLayout.SOUTH); //Adds the button
		mainFrame.add(TraitsList); //Adds the label
	
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	
		WindowListener listener = new WindowAdapter() { //Adds a listener for closing the window
		
			public void windowClosing(WindowEvent e) {
			
				mainFrame.dispose();
			
			}
		
		}; //Allows the window to close
		
		mainFrame.addWindowListener(listener);
		
	}

	
	public static void main (String[] args) {
		
		new RandomCharacter().makeFrame(); //Frame pops up
		
	}
	
}