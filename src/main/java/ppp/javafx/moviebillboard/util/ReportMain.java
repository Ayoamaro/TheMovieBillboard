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
 * @version 06/04/2021
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class ReportMain {
	
	public static void generatePdf(ListProperty<Movie> movieList) throws JRException, IOException {
		
		// compile the report
		JasperReport report = JasperCompileManager.compileReport(ReportMain.class.getResourceAsStream("/reports/billboard.jrxml"));		

		// parameter map for report
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Aplicaction", "The Movie Billboard");
		
		// we generate the report (we combine the compiled report with the data)
		JasperPrint print  = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(movieList));
        
		// export the report to a PDF file
		JasperExportManager.exportReportToPdfFile(print, Config.getConfigDir() + "/TheMovieBillboard.pdf");
        
		//Open the generated PDF file with the system default program
		Desktop.getDesktop().open(new File(Config.getConfigDir() + "/TheMovieBillboard.pdf"));
	}
}
