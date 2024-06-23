package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;
import model.TblCliente;

public class ClassClienteImp implements ICliente {

	@Override
	public void RegistrarCliente(TblCliente cliente) {
		// ESTABLECER CONEXION CON LA UNIDAD DE PERSISTENCIA..
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		
		//PERMITE GESTIONAR ENTIDADES
		EntityManager em=fabr.createEntityManager();
		
		//INICIAR TRANSACCION
		em.getTransaction().begin();
		
		//REGISTRAMOS
		em.persist(cliente);
		
		//EMITIMOS MENSAJE POR CONSOLA
		System.out.println("cliente registrado en la BD correctamente");
		
		//CONFIRMAMOS
		em.getTransaction().commit();
		
		//CERRAMOPS LA TRANSACCION
		em.close();
		
	} //FIN DEL METODO REGISTRAR CLIENTE

	@Override
	public void ActualizarCliente(TblCliente cliente) {
		// ESTABLECER CONEXION CON LA UNIDAD DE PERSISTENCIA..
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
				
				//PERMITE GESTIONAR ENTIDADES
				EntityManager em=fabr.createEntityManager();
				
				//INICIAR TRANSACCION
				em.getTransaction().begin();
				
				//ACTUALIZAMOS
			
				em.merge(cliente);
				
				
				//CONFIRMAMOS
				em.getTransaction().commit();
				
				//CERRAMOPS LA TRANSACCION
				em.close();
		
	} //FIN DEL METODO ACTUALIZAR CLIENTE

	@Override
	public void EliminarCliente(TblCliente cliente) {
		// ESTABLECER CONEXION CON LA UNIDAD DE PERSISTENCIA..
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		
		//PERMITE GESTIONAR ENTIDADES
		EntityManager em=fabr.createEntityManager();
		
		//INICIAR TRANSACCION
		em.getTransaction().begin();
		
		//RECUPERAMOS EL CODIGO A ELIMINAR
		TblCliente elim=em.merge(cliente);
		
		//PROCEDEMOS A ELIMINAR EL REGISTRO
		em.remove(elim);
		
		//EMITIMOS MENSAJE POR CONSOLA
		System.out.println("cliente eliminado de la BD correctamente");
		
		//CONFIRMAMOS
		em.getTransaction().commit();
		
		//CERRAMOPS LA TRANSACCION
		em.close();
		
	} //FIN DEL METODO ELIMINAR CLIENTE

	@Override
	public TblCliente BuscarCliente(TblCliente cliente) {
		// ESTABLECER CONEXION CON LA UNIDAD DE PERSISTENCIA..
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
				
		//PERMITE GESTIONAR ENTIDADES
		EntityManager em=fabr.createEntityManager();
				
		//INICIAR TRANSACCION
		em.getTransaction().begin();
				
		//RECUPERAMOS EL CODIGO A BUSCAR
		TblCliente buscliente=em.find(TblCliente.class,cliente.getIdcliente());
		
		//CONFIRMAMOS
		em.getTransaction().commit();
				
		//CERRAMOPS LA TRANSACCION
		em.close();
		
		return buscliente;
	} //FIN DEL METODO BUSCAR CLIENTE

	@Override
	public List<TblCliente> ListadoCliente() {
		// ESTABLECER CONEXION CON LA UNIDAD DE PERSISTENCIA..
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
						
		//PERMITE GESTIONAR ENTIDADES
		EntityManager em=fabr.createEntityManager();
						
		//INICIAR TRANSACCION
		em.getTransaction().begin();
				
		//RECUPERAMOS LOS CLIENTES DE LA BASE DE DATOS
		List<TblCliente> listadoClientes=em.createQuery("select c from TblCliente c",TblCliente.class).getResultList();
		
		//CONFIRMAMOS
		em.getTransaction().commit();
						
		//CERRAMOPS LA TRANSACCION
		em.close();
				
		return listadoClientes;
	} //FIN DEL METODO LISTAR CLIENTE

}
