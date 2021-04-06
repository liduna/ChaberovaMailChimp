package common;

public class MessageIdentifier {

    public String identifyMessage(String message){

        if(message.equals("Signup successful")){
            System.out.println("Signup attempt successful");
            message = "Check your email";

        }

        else if (message.equals("noEmailError")){
            System.out.println("No email error.");
            message = "Please enter a value";
        }

        else if (message.equals("longUsernameError")){
            System.out.println("Long username error.");
            message = "Enter a value less than 100 characters long";
        }

        else if (message.equals("usernameTakenError")){
            System.out.println("Username taken error.");
            message = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
        }
        return message;
    }

}
