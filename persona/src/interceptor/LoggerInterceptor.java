package interceptor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoggerInterceptor implements MethodInterceptor {
	@Value("${log.nombreArchivo}")
	private String logNombreArchivo;
	private PrintWriter pw;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		log(methodInvocation);
		
		return methodInvocation.proceed();
	}

	private void log(MethodInvocation methodInvocation) throws FileNotFoundException {
		pw = new PrintWriter(new FileOutputStream(logNombreArchivo, true));

		String traza = "[ clase = " + methodInvocation.getThis().getClass() +   
				", método = " + methodInvocation.getMethod().getName();

		String argumentos = "( ";
		for (Object a : methodInvocation.getArguments())
			argumentos += a + ", ";
		argumentos += " )";
		
		traza += ", argumentos = " + argumentos + 
				", tiempo = " + new Date().getTime() + " ]"; 

		pw.println(traza);
		pw.close();
	}
}



