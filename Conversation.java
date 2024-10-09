import java.util.ArrayList;
import java.util.Scanner;
class Conversation {
  /**
   * ChatBot takes in input from person and has a conversation then gives
   * transcript of the conversation. 
   * @param arguments
   * 
   */

  public static void main(String[] arguments) {
    // You will start the conversation here.
    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    int rounds = input.nextInt();

    //Transcript string holder and response string holder 
    ArrayList < String > transcript = new ArrayList < > ();
    System.out.println("Hi! What would you like to talk about?");
    transcript.add("Hi! What would you like to talk about?");
    String response = input.nextLine();
    response = input.nextLine();
    //add response to the transcript 
    transcript.add(response);

    for (int i = 1; i < rounds; i++) {
      //Mirroring
      String[] newResponse = response.split(" ");
      for (int j = 0; j < newResponse.length; j++) {
        if (newResponse[j].contains("I")) {
          newResponse[j] = newResponse[j].replace("I", "You");

        } else if (newResponse[j].contains("me")) {
          newResponse[j] = newResponse[j].replace("me", "you");

        } else if (newResponse[j].contains("am")) {
          newResponse[j] = newResponse[j].replace("am", "are");

        } else if (newResponse[j].contains("you")) {
          newResponse[j] = newResponse[j].replace("you", "I");

        } else if (newResponse[j].contains("my")) {
          newResponse[j] = newResponse[j].replace("my", "your");

        } else if (newResponse[j].contains("your")) {
          newResponse[j] = newResponse[j].replace("your", "my");

        } else if (newResponse[j].contains(".")) {
          newResponse[j] = newResponse[j].replace(".", "?");

        }
      }
      //Randomly replying with a different response
      String newSentence = "";
      for (int k = 0; k < newResponse.length; k++) {
        if (k == newResponse.length - 1) {
          newSentence += newResponse[k];
        } else {
          newSentence += newResponse[k] + " ";
        }
      }
      if (newSentence == response) {
        double num = Math.random();
        if (num < .25) {
          newSentence = "Oh yeah?";
        } else if (num < .5) {
          newSentence = "That's cool.";
        } else if (num < .75) {
          newSentence = "Wow!";
        } else {
          newSentence = "Mhm";
        }
      }
      System.out.println(newSentence);
      transcript.add(newSentence);

      response = input.nextLine();
    }
    System.out.println("Thanks for talking!");
    // makes sure the last string in response gets added 
    transcript.add(response);
    transcript.add("Thanks for talking!");
    System.out.println();
    System.out.println();
    System.out.println("Transcript:");
    for (String line: transcript) {
      System.out.println(line);
    }

  }
}