/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.otherservicearep;


import static spark.Spark.*;

/**
 *
 * @author Andrés Quintero
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        secure("keystores/ecikeystore.p12", "arep2020","keystores/myTrustStore" , "arep2020");
        get("/otherservice", (request, response) -> "Hola, este es otro servicio web");
    }

    /**
     *
     * @return Retorna el puerto indicado por el entorno, en caso de no
     * encontrarlo retorna el puerto 4567 por defecto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 9000;
    }

}
