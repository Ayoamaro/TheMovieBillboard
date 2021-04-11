package ppp.javafx.moviebillboard.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class Login {

	StringProperty user = new SimpleStringProperty();	// Login user
	StringProperty pswd = new SimpleStringProperty();	// Login password
	
	/**
     * @return StringProperty of user
     */
	public final StringProperty userProperty() {
		return this.user;
	}
	
	/**
	 * Get user
     * @return String of user
     */
	public final String getUser() {
		return this.userProperty().get();
	}
	
	/**
     * Set new user
     * @param user - (String)
     */
	public final void setUser(final String user) {
		this.userProperty().set(user);
	}
	
	/**
     * @return StringProperty of password
     */
	public final StringProperty pswdProperty() {
		return this.pswd;
	}
	
	/**
	 * Get password
     * @return String of password
     */
	public final String getPswd() {
		return this.pswdProperty().get();
	}
	
	/**
     * Set new password
     * @param pswd - (String)
     */
	public final void setPswd(final String pswd) {
		this.pswdProperty().set(pswd);
	}
}
