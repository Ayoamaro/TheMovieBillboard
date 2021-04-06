package ppp.javafx.moviebillboard.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ayoze Amaro
 * @version 06/04/2021
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class Movie {

	private IntegerProperty id;
	private StringProperty nombre;
	private IntegerProperty agno;
	private StringProperty pais;
	private StringProperty director;
	private IntegerProperty idTipo;
	
	public Movie () { }
	
	public Movie(Integer id, String nombre, Integer agno, String pais, String director, Integer idTipo) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.nombre = new SimpleStringProperty(nombre);
		this.agno = new SimpleIntegerProperty(agno);
		this.pais = new SimpleStringProperty(pais);
		this.director = new SimpleStringProperty(director);
		this.idTipo = new SimpleIntegerProperty(idTipo);
	}
	
	public int getId(){
		return id.get();
	}

	public void setId(Integer id){
		this.id = new SimpleIntegerProperty(id);
	}
	
	public String getNombre(){
		return nombre.get();
	}

	public void setNombre(String nombre){
		this.nombre = new SimpleStringProperty(nombre);
	}
	
	public Integer getAgno(){
		return agno.get();
	}

	public void setAgno(Integer agno){
		this.agno = new SimpleIntegerProperty(agno);
	}
	
	public String getPais(){
		return pais.get();
	}

	public void setPais(String pais){
		this.pais = new SimpleStringProperty(pais);
	}

	public String getDirector(){
		return director.get();
	}

	public void setDirector(String director){
		this.director = new SimpleStringProperty(director);
	}
	
	public Integer getIdTipo(){
		return idTipo.get();
	}

	public void setIdTipo(Integer idTipo){
		this.idTipo = new SimpleIntegerProperty(idTipo);
	}
	
}
