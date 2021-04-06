package common;

import net.bytebuddy.utility.RandomString;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserNameGenerator {

    public String randomizeName(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String validName = "Ludmila"+RandomString.make(2) + dateFormat.format(date);


        return validName;
    }

    public String createLongName(){

        String longUsername = RandomString.make(200);

        return longUsername;
    }

    public String generateUserName (String username){

        if (username.equals("validUsername")){
            username = randomizeName();

        }
        else if (username.equals("usernameTaken")){
            username = "blablaklakla";


        }
        else if (username.equals("longUsername")){
            username = createLongName();

        }

        return username;
    }

}
