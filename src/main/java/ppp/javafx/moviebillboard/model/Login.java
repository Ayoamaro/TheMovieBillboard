package ppp.javafx.moviebillboard.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ayoze Amaro
 * @version 06/04/2021
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class Login {

	StringProperty user = new SimpleStringProperty();
	StringProperty pswd = new SimpleStringProperty();
	
	public final StringProperty userProperty() {
		return this.user;
	}
	
	public final String getUser() {
		return this.userProperty().get();
	}
	
	public final void setUser(final String user) {
		this.userProperty().set(user);
	}
	
	public final StringProperty pswdProperty() {
		return this.pswd;
	}
	
	public final String getPswd() {
		return this.pswdProperty().get();
	}
	
	public final void setPswd(final String pswd) {
		this.pswdProperty().set(pswd);
	}
}
