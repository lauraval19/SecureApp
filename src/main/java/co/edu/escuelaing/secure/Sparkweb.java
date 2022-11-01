package co.edu.escuelaing.secure;

import co.edu.escuelaing.secure.Logger.Logger;
import co.edu.escuelaing.secure.otherservice.Authenticate;

import static spark.Spark.*;

public class Sparkweb {
    public static void main(String[] args) {

        port(getPort());

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/otherkeystore.p12", String.valueOf(123456), null, null);
        new Authenticate(new Logger());


    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 1234;
    }
}
