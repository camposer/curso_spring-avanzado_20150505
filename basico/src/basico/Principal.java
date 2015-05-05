package basico;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		HolaMundo hm1 = ctx.getBean("holaMundoImpl", HolaMundo.class);
		System.out.println(hm1.saludar("Rodolfo"));
		
		HolaMundo hm2 = (HolaMundo)ctx.getBean("helloWorld");
		System.out.println(hm2.saludar("Juan"));
	}
}
