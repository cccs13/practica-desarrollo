package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Empleados;
import modelo.Gastos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T16:19:15")
@StaticMetamodel(Buses.class)
public class Buses_ { 

    public static volatile CollectionAttribute<Buses, Gastos> gastosCollection;
    public static volatile CollectionAttribute<Buses, Empleados> empleadosCollection;
    public static volatile SingularAttribute<Buses, Integer> idbuses;
    public static volatile SingularAttribute<Buses, Integer> capacidadPasajeros;
    public static volatile SingularAttribute<Buses, String> placa;

}