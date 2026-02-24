import java.util.Scanner;

class ChatBot {

    public String getResponse(String input) {

        input = input.toLowerCase();

        if (input.contains("hi") || input.contains("hello")) {
            return "Hello! How can I help you?";
        }

        else if (input.contains("your name")) {
            return "I am an AI Chatbot created in Java.";
        }

        else if (input.contains("how are you")) {
            return "I'm just code, but I'm doing great!";
        }

        else if (input.contains("bye")) {
            return "Goodbye! Have a nice day!";
        }

        else {
            return "Sorry, I don't understand. Can you rephrase?";
        }
    }
}

public class AIChatbotApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChatBot bot = new ChatBot();

        System.out.println("AI Chatbot Started (type 'bye' to exit)");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();

            String response = bot.getResponse(userInput);
            System.out.println("Bot: " + response);

            if (userInput.equalsIgnoreCase("bye")) {
                break;
            }
        }
    }
}