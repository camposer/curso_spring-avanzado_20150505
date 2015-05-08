package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {
	@Value("${log.nombreArchivo}")
	private String logNombreArchivo;
	
	public void log(Class<? extends Object> clase, String metodo,
			Object[] argumentos) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new FileOutputStream(logNombreArchivo, true));

		String traza = "[ clase = " + clase +   
				", método = " + metodo;

		String stringArgs = "( ";
		for (Object a : argumentos)
			stringArgs += a + ", ";
		stringArgs += " )";
		
		traza += ", argumentos = " + stringArgs + 
				", tiempo = " + new Date().getTime() + " ]"; 

		pw.println(traza);
		pw.close();
	}
	
}
