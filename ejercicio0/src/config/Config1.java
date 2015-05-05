package config;

import gui.CalculadoraGui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.CalculadoraService;
import service.CalculadoraServiceImpl;

@Configuration
public class Config1 {
	@Bean
	public CalculadoraService calculadoraService() {
		return new CalculadoraServiceImpl();
	}
	
	@Bean
	public CalculadoraGui calculadoraGui() {
		CalculadoraGui calculadoraGui = new CalculadoraGui();
		calculadoraGui.setCalculadoraService(calculadoraService());
		return calculadoraGui;
	}
}






