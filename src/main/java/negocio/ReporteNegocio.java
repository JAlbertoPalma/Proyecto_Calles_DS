/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import org.json.JSONArray;
import org.json.JSONObject;
import subsistemaReporte.IReporteDAO;
import subsistemaReporte.PersistenciaException;
import subsistemaReporte.ReporteDAO;

/**
 *
 * @author Beto_
 */
public class ReporteNegocio implements IReporteNegocio{
    IReporteDAO reporteDAO;
    private ReporteCvr reporteCvr;

    public ReporteNegocio(EntityManager entityManager) {
        reporteDAO = new ReporteDAO(entityManager);
        this.reporteCvr = new ReporteCvr();
    }

    @Override
    public void validarCampos(ReporteDTO reporteDTO) throws NegocioException {
        // Validar campos obligatorios
        if (reporteDTO.getTitulo() == null || reporteDTO.getTitulo().isEmpty()) {
            throw new NegocioException("El titulo del reporte es obligatorio.");
        }
        
        if (reporteDTO.getDescripcion() == null || reporteDTO.getDescripcion().isEmpty()) {
            throw new NegocioException("La descripción del reporte es obligatoria.");
        }
        
        if (reporteDTO.getCalle() == null || reporteDTO.getCalle().isEmpty()) {
            throw new NegocioException("La calle del reporte es obligatoria.");
        }
        try{
            //Alias repetido
            reporteDAO.guardar(reporteDTO, reporteDTO.getUsuario().getId());
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia :" + pe.getMessage());
        }        
    }
    
    @Override
    public List<ReporteDTO> obtenerReportes() throws NegocioException{
        try{
            return reporteCvr.convListaDTO(reporteDAO.obtenerReportes());
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia :" + pe.getMessage());
        }
    }
    
    @Override
    public List<ReporteDTO> obtenerReportesPorCalle(String filtroCalle) throws NegocioException{
        List<ReporteDTO> reportesFiltro = new ArrayList();
        List<ReporteDTO> reportesAux;
        try{
            reportesAux = reporteCvr.convListaDTO(reporteDAO.obtenerReportes());
            for (ReporteDTO reporteDTO : reportesAux) {
                if(reporteDTO.getCalle().equalsIgnoreCase(filtroCalle)){
                    reportesFiltro.add(reporteDTO);
                }
            }
            return reportesFiltro;
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia :" + pe.getMessage());
        }
    }

    @Override
    public int likearReporte(ReporteDTO reporteDTO, boolean like) throws NegocioException {
        try{
            if(!like){
                reporteDTO.setLikes(reporteDTO.getLikes() + 1);
                reporteDAO.actualizar(reporteDTO.getId(), reporteDTO);
            }
            else if(like && reporteDTO.getLikes() > 0){
                reporteDTO.setLikes(reporteDTO.getLikes() - 1);
                reporteDAO.actualizar(reporteDTO.getId(), reporteDTO);
            }
            return reporteDTO.getLikes();
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia: " + pe.getMessage());
        }
    }

    /**
     * Método genérico para obtener calles de un área definida por coordenadas.
     * @param coordenadas Coordenadas en el formato [minLat, minLon, maxLat, maxLon]
     * @return Un arreglo de nombres de calles
     * @throws NegocioException
     */
    @Override
    public String[] obtenerCalles(double[] coordenadas) throws NegocioException {
        // Endpoint de la API de Overpass
        String overpassUrl = "https://overpass-api.de/api/interpreter";

        //Construímos una la consulta Overpass con las coordenadas
        String query = String.format("""
            [out:json];
            way["highway"](%f,%f,%f,%f);
            out body;
            >;
            out skel qt;
        """, coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);

        //Configuramos la solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(overpassUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("data=" + query))
                .build();

        //Enviamos la solicitud y obtenemos la respuesta
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                //Procesamos la respuesta que esta en formato JSON
                JSONObject respuestaJSON = new JSONObject(response.body());
                JSONArray elementos = respuestaJSON.getJSONArray("elements");

                //Extraemos los nombres de las calles
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
                throw new NegocioException("Error de infraestructura: No se pudieron obtener datos.");
            }
        } catch (IOException | InterruptedException ex) {
            throw new NegocioException("Error de infraestructura: " + ex.getMessage());
        }
    }
}
