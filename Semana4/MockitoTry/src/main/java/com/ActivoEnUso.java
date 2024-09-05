package com;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ActivoEnUso {
	private ActivoCalculoNube calculoNube;

	double calcular(double valorMercado, int diasActividad, int interesGenerado) {
		return calculoNube.calcular(valorMercado, diasActividad, interesGenerado);
	}
}
