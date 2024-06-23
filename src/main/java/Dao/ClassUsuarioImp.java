package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuario;
import model.TblProductocl2;
import model.TblUsuariocl2;

public class ClassUsuarioImp implements IUsuario {

	@Override
	public void RegistrarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActualizarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TblUsuariocl2 BuscarUsuario(TblUsuariocl2 usuario) {
	    EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_ANANGA_ALONSO_GARY_ESTEBAN");
	    EntityManager em = fabr.createEntityManager();
	    em.getTransaction().begin();
	    
	    String jpql = "SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :username";
	    TypedQuery<TblUsuariocl2> query = em.createQuery(jpql, TblUsuariocl2.class);
	    query.setParameter("username", usuario.getUsuariocl2());
	    
	    TblUsuariocl2 usuarioencontrado = null;
	    try {
	        usuarioencontrado = query.getSingleResult();
	    } catch (Exception e) {
	        // Posible excepción por usuario no encontrado o múltiples resultados.
	        e.printStackTrace(); // Para depuración
	    }
	    
	    em.getTransaction().commit();
	    em.close();
	    return usuarioencontrado;
	}

	@Override
	public List<TblUsuariocl2> ListadoUsuario() {
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_ANANGA_ALONSO_GARY_ESTEBAN");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los usuarios  de la base de datos
        //***********utilizando jpql
        List<TblUsuariocl2> listadousuario=em.createQuery("select c from TblUsuariocl2 c",TblUsuariocl2.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadousuario;
	}
}
