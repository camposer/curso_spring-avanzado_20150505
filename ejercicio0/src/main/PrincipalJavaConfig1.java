package main;

import gui.CalculadoraGui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config1;

public class PrincipalJavaConfig1 {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config1.class);
		
		ctx.getBean("calculadoraGui", CalculadoraGui.class).iniciar();
	}
}
