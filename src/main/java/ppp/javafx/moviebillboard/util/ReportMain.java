package ppp.javafx.moviebillboard.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.ListProperty;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ppp.javafx.moviebillboard.model.Movie;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class ReportMain {
	
	/**
	 * Generate PDF File with JasperReport utils
	 * @param movieList - (ListProperty) All movies of database
	 * @throws JRException
	 * @throws IOException
	 */
	public static void generatePdf(ListProperty<Movie> movieList) throws JRException, IOException {
		
		JasperReport report = JasperCompileManager.compileReport(ReportMain.class.getResourceAsStream("/reports/billboard.jrxml"));		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Aplicaction", "The Movie Billboard");
		
		JasperPrint print  = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(movieList));
		JasperExportManager.exportReportToPdfFile(print, Config.getConfigDir() + "/TheMovieBillboard.pdf");	// Export the Report to a PDF file

		Desktop.getDesktop().open(new File(Config.getConfigDir() + "/TheMovieBillboard.pdf"));	// Open the generated PDF file with the system default program
	}
}
