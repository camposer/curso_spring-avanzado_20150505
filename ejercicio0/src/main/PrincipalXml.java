package main;

import gui.CalculadoraGui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrincipalXml {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		ctx.getBean("calculadoraGui", CalculadoraGui.class).iniciar();
	}
}
