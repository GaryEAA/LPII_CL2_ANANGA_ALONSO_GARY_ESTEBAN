package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl2;

public class ClassProductoImp implements IProducto {

	@Override
	public void RegistrarProducto(TblProductocl2 producto) {
		//establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_ANANGA_ALONSO_GARY_ESTEBAN");
	    //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(producto);
		//emitimos mensaje por consola
		System.out.println("Producto registrado en la BD correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();		
	}

	@Override
	public void ActualizarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TblProductocl2 BuscarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TblProductocl2> ListadoProducto() {
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_ANANGA_ALONSO_GARY_ESTEBAN");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los clientes  de la base de datos
        //***********utilizando jpql
        List<TblProductocl2> listadoproducto=em.createQuery("select c from TblProductocl2 c",TblProductocl2.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadoproducto;
	}

}
