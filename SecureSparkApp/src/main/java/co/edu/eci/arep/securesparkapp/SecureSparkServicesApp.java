/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.securesparkapp;

/**
 *
 * @author Andrés Quintero
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class SecureSparkServicesApp {

    static String usuariCorrect = "andrew";
    static String passCorrect = "arep2020";
    static Map<String, String> map = null;

    public static void main(String[] args) {
        port(getPort());
        secure("SecureSparkApp/keystores/ecikeystore.p12", "arep2020", "SecureSparkApp/keystores/ecikeystore.p12", "arep2020");
        get("/", (req, res) -> {
            String vistaInicial = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>"
                    + "<title> Inicio </title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<form method = \"post\" action=\"/validar\">\n"
                    + "User: <input name = \"user\" type = \"text\"/>\n"
                    + "Password: <input name = \"passwd\" type = \"password\"/>\n"
                    + "<input name=\"button\" type=\"submit\" value=\"Sign In\"/>\n"
                    + "</form>\n"
                    + "</body>\n"
                    + "</html>\n";

            return vistaInicial;
        });

        /*get("/validar", (req, res) -> {
            String noLog = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>"
                    + "<title> Not welcome </title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1> YOU ARE NOT WELCOME!</h1>"
                    + "</body>\n"
                    + "</html>\n";

            return noLog;
        });*/
        post("/validar", (req, res) -> {

            String usuari = req.queryParams("user");
            String clave = req.queryParams("passwd");

            if (usuari.equals(usuariCorrect) && clave.equals(passCorrect)) {
                map = new HashMap<String, String>();
                map.put("user", usuari);

                String vistaSucces = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>"
                        + "<title> OK </title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<h1>Welcome!</h1>"
                        + "<form method = \"get\" action=\"/otherservice\">\n"
                        + "<input name=\"button\" type=\"submit\" value=\"Ir al otro servicio\"/>\n"
                        + "</form>\n"
                        + "</body>\n"
                        + "</html>\n";

                return vistaSucces;
                //return Client.getService();
            } else {
                String vistaFailed = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>"
                        + "<title> denegado </title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<h1>Access Denied!</h1>"
                        + "</body>\n"
                        + "</html>\n";

                return vistaFailed;
            }
        });

        get("/otherservice", (req, res) -> {

            String view = "";
            try {
               
                URL url = new URL("https://ec2-34-235-153-244.compute-1.amazonaws.com:36000/otherservice");
                view = URLReader.urlprueba(url.toString());
                System.out.println(view);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return view;

        });

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
