package common;

import net.bytebuddy.utility.RandomString;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserNameGenerator {

    public String randomizeName(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String validName = "Ludmila"+RandomString.make(2) + dateFormat.format(date);
        //System.out.println(dateFormat.format(date));


        return validName;
    }

    public String createLongName(){

        //String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        //StringBuilder builder = new StringBuilder();
       /* RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        String randomLetters = generator.generate(20);*/

        String longUsername = RandomString.make(200);
        return longUsername;
    }

    public String generateUserName (String username){

        if (username.equals("validUsername")){
            username = randomizeName();

        }
        else if (username.equals("usernameTaken")){
            username = "blablaklakla";
            //class invalid-error
            //text "Another user with this username already exists. Maybe it's your evil twin. Spooky."

        }
        else if (username.equals("longUsername")){
            username = createLongName();

        }

        return username;
    }

}
