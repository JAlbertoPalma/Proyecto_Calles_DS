/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Beto_
 */
public class OverPassCalles {
    /**
     * Método genérico para obtener calles de un área definida por coordenadas.
     * @param coordenadas Coordenadas en el formato [minLat, minLon, maxLat, maxLon]
     * @return Un arreglo de nombres de calles
     * @throws IOException
     * @throws InterruptedException
     */
    public String[] obtenerCalles(double[] coordenadas) throws IOException, InterruptedException {
        // Endpoint de la API de Overpass
        String overpassUrl = "https://overpass-api.de/api/interpreter";

        // Construye la consulta Overpass con las coordenadas
        String query = String.format("""
            [out:json];
            way["highway"](%f,%f,%f,%f);
            out body;
            >;
            out skel qt;
        """, coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);

        //Se configura la solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(overpassUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("data=" + query))
                .build();

        //Se envía la solicitud y obtiene la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Se procesa la respuesta que está en formato JSON
            JSONObject respuestaJSON = new JSONObject(response.body());
            JSONArray elementos = respuestaJSON.getJSONArray("elements");

            //Se extraen los nombres de las calles
            return elementos.toList().stream()
                    .filter(element -> element instanceof HashMap) // Asegura que sea un HashMap
                    .map(element -> (HashMap<String, Object>) element) // Castea el objeto
                    .filter(map -> map.containsKey("tags")) // Filtra elementos con "tags"
                    .map(map -> (HashMap<String, Object>) map.get("tags")) // Extrae "tags"
                    .filter(tags -> tags.containsKey("name")) // Filtra por nombre
                    .map(tags -> tags.get("name").toString()) // Obtiene el nombre
                    .distinct()
                    .toArray(String[]::new);
        } else {
            System.err.println("Error al obtener los datos: " + response.statusCode());
            return null;
        }
    }
}
