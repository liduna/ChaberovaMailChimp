package common;

import net.bytebuddy.utility.RandomString;

public class EmailInput {

    public String insertEmail (String email){

        if (email.equals("validEmail")){

            //UserNameGenerator randomEmail = new UserNameGenerator();

            email = RandomString.make(5) +"@gmail.com";
        }
        else {
            email = "";
           // class = "padding--lv3 !padding-top-bottom--lv0"
            //Please check your entry and try again.
            //--
            // class = "invalid error"
            //Please enter a value
        }

        return email;
    }
}
