package PageObjects;

public class Utils {

    public static String generateRandomEmail(int i){
        String theAlphaNumericS;
        StringBuilder builder;
        String email;

        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

        builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {


            int myindex = (int)(theAlphaNumericS.length() * Math.random());

            builder.append(theAlphaNumericS.charAt(myindex));
        }

        email = builder.toString() + "@prueba.com";

        return email;
    }


}
