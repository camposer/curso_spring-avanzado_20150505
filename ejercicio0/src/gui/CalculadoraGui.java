package gui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.CalculadoraService;

@Component
public class CalculadoraGui {
	private Scanner scanner;
	@Autowired
	private CalculadoraService calculadoraService;
	
	public CalculadoraGui() {
		scanner = new Scanner(System.in);
	}
	
	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("5. Salir");
			System.out.println("? ");
			
			String opcion = scanner.nextLine();
			
			if (opcion.equals("5"))
				break;
			
			System.out.print("a? ");
			Float a = Float.parseFloat(scanner.nextLine()); 
			System.out.print("b? ");
			Float b = Float.parseFloat(scanner.nextLine()); 
			
			if (opcion.equals("1"))
				System.out.println(a + " + " + b + " = " + 
						calculadoraService.sumar(a, b));
			else if (opcion.equals("2"))
				System.out.println(a + " - " + b + " = " + 
						calculadoraService.restar(a, b));
			else if (opcion.equals("3"))
				System.out.println(a + " * " + b + " = " + 
						calculadoraService.multiplicar(a, b));
			else if (opcion.equals("4"))
				System.out.println(a + " / " + b + " = " + 
						calculadoraService.dividir(a, b));
		}
	}

	public void setCalculadoraService(CalculadoraService calculadoraService) {
		this.calculadoraService = calculadoraService;
	}
}






