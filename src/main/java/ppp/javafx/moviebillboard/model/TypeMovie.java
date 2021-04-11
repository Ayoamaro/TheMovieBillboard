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
public class TypeMovie {

	private IntegerProperty idTipo;	// TypeMovie idTipo
	private StringProperty genero;	// TypeMovie genero
	
	/**
     * TypeMovie constructor
     * @param idTipo - (Integer)
     * @param genero - (String)
     */
	public TypeMovie(Integer idTipo, String genero) {
		this.idTipo = new SimpleIntegerProperty(idTipo);
		this.genero = new SimpleStringProperty(genero);
	}

	/**
     * @return IntegerProperty of idTipo
     */
	public final IntegerProperty idTipoProperty() {
		return this.idTipo;
	}
	
	/**
	 * Get idTipo
     * @return Integer of idTipo
     */
	public final int getIdTipo() {
		return this.idTipoProperty().get();
	}
	
	/**
     * Set new idTipo
     * @param idTipo - (Integer)
     */
	public final void setIdTipo(final int idTipo) {
		this.idTipoProperty().set(idTipo);
	}
	
	/**
     * @return StringProperty of genero
     */
	public final StringProperty generoProperty() {
		return this.genero;
	}
	
	/**
	 * Get genero
     * @return String of genero
     */
	public final String getGenero() {
		return this.generoProperty().get();
	}
	
	/**
     * Set new genero
     * @param genero - (String)
     */
	public final void setGenero(final String genero) {
		this.generoProperty().set(genero);
	}
}
