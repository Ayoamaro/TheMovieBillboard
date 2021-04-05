package ppp.javafx.moviebillboard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public int createData(Connection con) {
		try {
			String sql = "INSERT INTO pelicula (id, nombre, agno, pais, director, idTipo) VALUES (?,?,?,?,?,?)";
			PreparedStatement insert = con.prepareStatement(sql);
		
			insert.setInt(1, id.get());
			insert.setString(2, nombre.get());
			insert.setInt(3, agno.get());
			insert.setString(4, pais.get());
			insert.setString(5, director.get());
			insert.setInt(6, idTipo.get());
			
			return insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int updateData(Connection con, Movie selected) {
		
		try {
			String sql = "UPDATE pelicula SET id=?, nombre=?, agno=?, pais=?, director=?, idTipo=? WHERE id= " + selected.getId();
			PreparedStatement update = con.prepareStatement(sql);

			update.setInt(1, id.get());
			update.setString(2, nombre.get());
			update.setInt(3, agno.get());
			update.setString(4, pais.get());
			update.setString(5, director.get());
			update.setInt(6, idTipo.get());
			
			return update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
