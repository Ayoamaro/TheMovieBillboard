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
public class TypeMovie {

	private IntegerProperty idTipo;
	private StringProperty genero;
	
	public TypeMovie(Integer idTipo, String genero) {
		this.idTipo = new SimpleIntegerProperty(idTipo);
		this.genero = new SimpleStringProperty(genero);
	}

	public final IntegerProperty idTipoProperty() {
		return this.idTipo;
	}
	

	public final int getIdTipo() {
		return this.idTipoProperty().get();
	}
	

	public final void setIdTipo(final int idTipo) {
		this.idTipoProperty().set(idTipo);
	}
	

	public final StringProperty generoProperty() {
		return this.genero;
	}
	

	public final String getGenero() {
		return this.generoProperty().get();
	}
	

	public final void setGenero(final String genero) {
		this.generoProperty().set(genero);
	}
	
}
