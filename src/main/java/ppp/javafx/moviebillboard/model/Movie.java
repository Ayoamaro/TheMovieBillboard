package ppp.javafx.moviebillboard.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class Movie {

	private IntegerProperty id;	// Movie id
	private StringProperty nombre;	// Movie nombre
	private IntegerProperty agno;	// Movie agno
	private StringProperty pais;	// Movie pais
	private StringProperty director;	// Movie director
	private IntegerProperty idTipo;	// Movie idTipo
	
	/**
     * Movie default constructor
     */
	public Movie () { }
	
	/**
     * Movie constructor
     * @param id - (Integer)
     * @param nombre - (String)
     * @param agno - (Integer)
     * @param pais - (String)
     * @param director - (String)
     * @param idTipo - (Integer)
     */
	public Movie(Integer id, String nombre, Integer agno, String pais, String director, Integer idTipo) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.nombre = new SimpleStringProperty(nombre);
		this.agno = new SimpleIntegerProperty(agno);
		this.pais = new SimpleStringProperty(pais);
		this.director = new SimpleStringProperty(director);
		this.idTipo = new SimpleIntegerProperty(idTipo);
	}
	
	/**
     * @return IntegerProperty of id
     */
	public int getId(){
		return id.get();
	}

	/**
     * Set new id
     * @param id - (Integer)
     */
	public void setId(Integer id){
		this.id = new SimpleIntegerProperty(id);
	}
	
	/**
     * @return StringProperty of nombre
     */
	public String getNombre(){
		return nombre.get();
	}

	/**
     * Set new nombre
     * @param nombre - (String)
     */
	public void setNombre(String nombre){
		this.nombre = new SimpleStringProperty(nombre);
	}
	
	/**
     * @return IntegerProperty of agno
     */
	public Integer getAgno(){
		return agno.get();
	}

	/**
     * Set new agno
     * @param agno - (Integer)
     */
	public void setAgno(Integer agno){
		this.agno = new SimpleIntegerProperty(agno);
	}
	
	/**
     * @return StringProperty of pais
     */
	public String getPais(){
		return pais.get();
	}

	/**
     * Set new pais
     * @param pais - (String)
     */
	public void setPais(String pais){
		this.pais = new SimpleStringProperty(pais);
	}

	/**
     * @return StringProperty of director
     */
	public String getDirector(){
		return director.get();
	}

	/**
     * Set new director
     * @param director - (String)
     */
	public void setDirector(String director){
		this.director = new SimpleStringProperty(director);
	}
	
	/**
     * @return IntegerProperty of idTipo
     */
	public Integer getIdTipo(){
		return idTipo.get();
	}

	/**
     * Set new idTipo
     * @param idTipo - (Integer)
     */
	public void setIdTipo(Integer idTipo){
		this.idTipo = new SimpleIntegerProperty(idTipo);
	}
	
}
