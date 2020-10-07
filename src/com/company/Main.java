package com.company;
import java.util.Scanner;
import java.io.File;
public class Main {

    public static void main(String[] args){
        try {
            Scanner in = new Scanner(System.in); // Getting user input later on
            System.out.println("Enter filepath for your file. IF file is invalid, the bee movie will be used");
            String input = in.nextLine(); // Getting file path
            File script;
            boolean check = false;
            try{
                script = new File(input);
                Scanner read = new Scanner(script); // Checks to see if it can create a scanner for the file, it seemed to be the best way to test it
                System.out.println("File check successful!");
                check = true;
            }
            catch (Exception f){
                System.out.println("Invalid file. Bee movie script will be used");
                script = new File("C:\\Users\\jaked\\IdeaProjects\\wordifier\\BeeMovieScript.txt"); //This is just where I am keeping it, it will be wherever you installed this github repository
            }
            Scanner read = new Scanner(script); // Resetting the scanner
            String word1, word2; // word1 is the word being replaced, word2 is the word replacing it
            System.out.println("Enter word to replace: ");
            word1 = in.next();
            in.nextLine();
            System.out.println("Enter word to replace " + word1 + " with: ");
            word2 = in.nextLine();
            int counter = 0, tries = 0;
            while(read.hasNext()){ //Checks if there is another word in the file
                String temp = "";
                String wordChecker = "";
                boolean checker = false;
                temp = read.next();
                for (int i = 0; i < temp.length()-(word1.length()-1); i++) {
                    wordChecker = "";
                    for (int j = 0; j < word1.length(); j++) {
                        wordChecker+=(temp.substring(i + j, i + j + 1));
                    }
                    if (wordChecker.toString().equalsIgnoreCase(word1)){
                        System.out.print(temp.substring(0, i) + word2+ temp.substring(i + word1.length()) + " ");
                        checker = true;
                        counter++;
                        break;
                    }
                }
                if(checker == false)
                    System.out.print(temp + " ");
                tries++;
                if(tries%40==0){
                    System.out.println();
                }
            }
            System.out.println("\n" + counter + " changes made");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
