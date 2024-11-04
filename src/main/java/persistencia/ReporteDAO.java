/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.ReporteDTO;
import entidad.ReporteEntidad;
import entidad.UsuarioEntidad;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Beto_
 */
public class ReporteDAO implements IReporteDAO{
    
    private EntityManager entityManager;
    private IUsuarioDAO usuarioDAO;
    
    /**
     * Construye un reporteDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public ReporteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.usuarioDAO = new UsuarioDAO(entityManager);
    }
    
    @Override
    public void guardar(ReporteDTO reporteDTO, Long id_usuario) throws PersistenciaException {
        try{
            entityManager.getTransaction().begin();
            UsuarioEntidad usuarioBuscado = usuarioDAO.obtenerPorId(id_usuario);

            ReporteEntidad reporte = new ReporteEntidad(
                    reporteDTO.getTitulo(),
                    reporteDTO.getDescripcion(),
                    reporteDTO.getCalle(),
                    usuarioBuscado);
            usuarioBuscado.getReportes().add(reporte);
            entityManager.persist(reporte);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void actualizar(Long id, ReporteDTO reporteDTO) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el estudiante a actualizar
            ReporteEntidad reporteBuscado = obtenerPorId(id);
            
            //Se actualizan los valores del reporte
            reporteBuscado.setTitulo(reporteDTO.getTitulo());
            reporteBuscado.setDescripcion(reporteDTO.getDescripcion());
            reporteBuscado.setCalle(reporteDTO.getCalle());
            
            entityManager.merge(reporteBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizarEntidad(ReporteEntidad reporteEntidad) throws PersistenciaException {
        try{
            entityManager.merge(reporteEntidad);
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el reporte a eliminar
            ReporteEntidad reporteBuscado = obtenerPorId(id);
            
            //Elimina el reporte y termina la transacción
            entityManager.remove(reporteBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public ReporteEntidad obtenerPorId(Long id) throws PersistenciaException {
        ReporteEntidad reporteBuscado = entityManager.find(ReporteEntidad.class, id);
        if(reporteBuscado == null){
            throw new PersistenciaException("No se encontró al estudiante con el id");
        }
        return reporteBuscado;
    }

    @Override
    public List<ReporteEntidad> obtenerReportes() throws PersistenciaException {
        List<ReporteEntidad> reportes = entityManager.createQuery("SELECT e FROM ReporteEntidad e", ReporteEntidad.class)
                .getResultList();
        if(reportes == null || reportes.isEmpty()){
            throw new PersistenciaException("No hay reportes por mostrar");
        }
        return reportes;
    }
    
}
