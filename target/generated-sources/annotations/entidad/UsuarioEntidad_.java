package entidad;

import entidad.ReporteEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-28T15:07:06", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(UsuarioEntidad.class)
public class UsuarioEntidad_ { 

    public static volatile SingularAttribute<UsuarioEntidad, String> alias;
    public static volatile ListAttribute<UsuarioEntidad, ReporteEntidad> reportes;
    public static volatile SingularAttribute<UsuarioEntidad, String> contrasena;
    public static volatile SingularAttribute<UsuarioEntidad, Long> id;

}