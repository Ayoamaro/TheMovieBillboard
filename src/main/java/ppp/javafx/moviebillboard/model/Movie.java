package ppp.javafx.moviebillboard.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ayoze Amaro
 *
 */
public class Movie {

	private IntegerProperty id;
	private StringProperty nombre;
	private IntegerProperty agno;
	private StringProperty pais;
	private StringProperty director;
	
	public Movie(Integer id, String nombre, Integer agno, String pais, String director) {
		this.id = new SimpleIntegerProperty(id);
		this.nombre = new SimpleStringProperty(nombre);
		this.agno = new SimpleIntegerProperty(agno);
		this.pais = new SimpleStringProperty(pais);
		this.director = new SimpleStringProperty(director);
	}
	
	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	
	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	
	public final String getNombre() {
		return this.nombreProperty().get();
	}
	
	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	
	public final IntegerProperty agnoProperty() {
		return this.agno;
	}
	
	public final int getAgno() {
		return this.agnoProperty().get();
	}
	
	public final void setAgno(final int agno) {
		this.agnoProperty().set(agno);
	}
	
	public final StringProperty paisProperty() {
		return this.pais;
	}
	
	public final String getPais() {
		return this.paisProperty().get();
	}
	
	public final void setPais(final String pais) {
		this.paisProperty().set(pais);
	}
	
	public final StringProperty directorProperty() {
		return this.director;
	}
	
	public final String getDirector() {
		return this.directorProperty().get();
	}
	
	public final void setDirector(final String director) {
		this.directorProperty().set(director);
	}
	
	
	
	
}
