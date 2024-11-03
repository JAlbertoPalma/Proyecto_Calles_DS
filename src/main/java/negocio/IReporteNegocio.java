/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.ReporteDTO;

/**
 *
 * @author Beto_
 */
public interface IReporteNegocio {
    public void validarCampos(ReporteDTO reporteDTO) throws NegocioException;
}
