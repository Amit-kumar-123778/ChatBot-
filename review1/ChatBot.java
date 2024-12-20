// ChatBot.java
import java.sql.*;
import java.util.Scanner;

public class ChatBot {
    private Connection connection;

    public ChatBot() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot_db", "username", "Alx@14356");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getResponse(String userInput) {
        String response = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT response FROM responses WHERE input = ?");
            stmt.setString(1, userInput);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response = rs.getString("response");
            } else {
                response = "I'm sorry, I don't understand.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("ChatBot: Hello! How can I assist you today?");
        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("ChatBot: " + chatBot.getResponse(userInput));
        }
        scanner.close();
    }
}

