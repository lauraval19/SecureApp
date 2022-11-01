package co.edu.escuelaing.secure.Logger;

import co.edu.escuelaing.secure.entities.User;
import spark.Request;
import spark.Response;

import java.lang.invoke.StringConcatFactory;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {

    static ConcurrentHashMap<String,String> users = new ConcurrentHashMap<>();
    public Object validate(Request req, Response res) {
        String user = req.queryParams("user");
        String password = req.queryParams("password");

        boolean isValidate = authentication(user,password);

        if(isValidate){
            res.status(200);
            return "<h1>Welcome</h1><br></br>"+user;
        }else{
            res.status(400);
            return "Error al autenticar desde auth";
        }


    }

    private boolean authentication(String user, String password) {
        apimock();
        Iterator<String> iterator = users.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            User newuser = new User(user,password);
            if(newuser.getName().equals(key) && newuser.getPassword().equals(users.get(key))){
                return true;
            }
        }
        return false;
    }

    private void apimock(){
        User user = new User("laura","1234");
        users.put(user.getName(), user.getPassword());
    }
}
