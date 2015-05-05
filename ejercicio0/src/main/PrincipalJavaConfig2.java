package main;

import gui.CalculadoraGui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config2;

public class PrincipalJavaConfig2 {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config2.class);
		
		ctx.getBean("calculadoraGui", CalculadoraGui.class).iniciar();
	}
}
