package TestEntidades;

import java.util.List;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl2;

public class TestEntidadUsuario {

	public static void main(String[] args) {
		ClassUsuarioImp crud=new ClassUsuarioImp();
		/*
		//realizamos la respectiva instancia de las clases...
		TblUsuariocl2 usuario1=new TblUsuariocl2();
		TblUsuariocl2 usuario2=new TblUsuariocl2();
		TblUsuariocl2 usuario3=new TblUsuariocl2();

		//asignamos valores
		usuario1.setUsuariocl2("gary");
		usuario1.setPasswordcl2("pass123");
		
		usuario2.setUsuariocl2("alice");
		usuario2.setPasswordcl2("secure456");
		
		usuario3.setUsuariocl2("bob");
		usuario3.setPasswordcl2("789xyz");

		//invocamos al metodo registrar...
		crud.RegistrarUsuario(usuario1);
		crud.RegistrarUsuario(usuario2);
		crud.RegistrarUsuario(usuario3);
		*/
		
		//testeamos el metodo listado
		List<TblUsuariocl2> listado=crud.ListadoUsuario();
		//aplicamos un bucle for...
		for(TblUsuariocl2 lis:listado){
			
			//imprimimos por pantalla
			System.out.println("Usuario: "+lis.getUsuariocl2()+"\n"+
					           "Password: "+lis.getPasswordcl2()+"\n");
		}
		
	}

}
