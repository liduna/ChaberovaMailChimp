package common;

import net.bytebuddy.utility.RandomString;

public class EmailInput {

    public String insertEmail (String email){

        if (email.equals("validEmail")){

            email = RandomString.make(5) +"@gmail.com";
        }
        else {
            email = "";
        }

        return email;
    }
}
