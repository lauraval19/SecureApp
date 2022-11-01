package co.edu.escuelaing.secure.otherservice;

import co.edu.escuelaing.secure.Logger.Logger;

import static spark.Spark.get;
public class Authenticate {

    public Authenticate(Logger loguser){

        get("hello",(req,res)->
                "hello world from other service"
        );

        get("authe",(req,res)->
                loguser.validate(req,res)
        );
    }
}
