package service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	public float sumar(float a, float b) {
		return a + b;
	}

	public float restar(float a, float b) {
		return a - b;
	}

	public float multiplicar(float a, float b) {
		return a * b;
	}

	public float dividir(float a, float b) {
		return a / b;
	}

}
