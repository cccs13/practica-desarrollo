package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Empleados;
import modelo.Gastos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T16:19:15")
@StaticMetamodel(Nomina.class)
public class Nomina_ { 

    public static volatile SingularAttribute<Nomina, Gastos> gastosIdgastos;
    public static volatile SingularAttribute<Nomina, Integer> idnomina;
    public static volatile CollectionAttribute<Nomina, Empleados> empleadosCollection;

}