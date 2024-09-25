import java.util.Scanner;
class Conversation {
/**
 * 
 * @param arguments
 * ChatBot takes in input from person and has a conversation then gives
 * transcript of the conversation. 
 */


  public static void main(String[] arguments) {
    // You will start the conversation here.
    Scanner input = new Scanner(System.in); 
    System.out.println("How many rounds?");
    int rounds = input.nextInt();
     
    //Transcript string holder and response string holder 
    String [] transcript = new String[2 * rounds + 3];
    String newResponse; 
    
    System.out.println("Hi! What would you like to talk about?");
    transcript[0] = "Hi! What would you like to talk about?";
    String response = input.nextLine();
    response = input.nextLine(); 
    //add response to the transcript 
    transcript[1] = response; 
    
    for(int i = 0; i < rounds; i++)
    { 
      //Mirroring
      newResponse = response; 
      if(response.contains("I"))
      { 
        newResponse = newResponse.replace("I", "You");
      
      }
    if(newResponse.contains("me"))
    { 
      newResponse = newResponse.replace("me", "you");
      
    }
    if(newResponse.contains("am"))
    { 
      newResponse = newResponse.replace("am", "are");
      
    }
    if(newResponse.contains("you"))
    { 
      newResponse = newResponse.replace("you", "I");
      
    }
    if(newResponse.contains("my"))
    { 
      newResponse = newResponse.replace("my", "your");
      
    }
     if(newResponse.contains("your"))
    { 
      newResponse = newResponse.replace("your", "my");
      
    }
    if(newResponse.contains("."))
    { 
      newResponse = newResponse.replace(".", "?");
      
    }
    //Randomly replying with a different response
    else 
    { 
      double num = Math.random(); 
      if (num < .25)
      { newResponse = "Oh yeah?"; }
      else if (num < .5)
      { newResponse = "That's cool."; }
      else if (num < .75)
      { newResponse = "Wow!";}
      else 
      { newResponse = "Mhm"; }
    }
    System.out.println(newResponse);
    transcript[2 * i + 1] = response;
    transcript[2 * i + 2] = newResponse; 

    response = input.nextLine();
    }
    System.out.println("Thanks for talking!"); 
// makes sure the last string in response gets added 
    transcript[transcript.length - 2] = response; 
    transcript[transcript.length - 1] = "Thanks for talking!";
    System.out.println();
    System.out.println();
    System.out.println("Transcript:");
    for (String line : transcript)
    { System.out.println(line);}








  }
}
