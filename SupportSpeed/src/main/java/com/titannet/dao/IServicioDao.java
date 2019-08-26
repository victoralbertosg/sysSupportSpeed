package com.titannet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Persona;
import com.titannet.entity.Servicio;
import com.titannet.entity.Trabajador;


public interface IServicioDao extends PagingAndSortingRepository<Servicio , Long> {

	
//	@Query("select s from Servicio s where s.estadoservicio=?1")
	//@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	@Query("select s from Servicio s join s.tiposervicio ts where s.estadoservicio=?1")
	//SELECT c.name, p.name FROM Country c JOIN c.capital p
	public List<Servicio> servicioEstado1 (EstadoServicio es) ;
	
	
	@Query("select s from Servicio s join s.trabajador t where t.persona=?1")
	public List<Servicio> servicioTrabajador (Persona persona);

	@Query("select s from Servicio s join s.trabajador t where t.persona=?1 and s.estadoservicio=?2")
	public List<Servicio> servicioTrabajadorEstado (Persona persona,EstadoServicio es);
	
	
	@Query("select s from Servicio s join s.cliente c where c.persona=?1 and s.estadoservicio=?2")
	public List<Servicio> servicioClienteEstado (Persona persona,EstadoServicio es);
	
}
