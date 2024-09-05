package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MockitoTests {
	@Mock
	ActivoCalculoNube nube;
	
	ActivoEnUso activo;
	
	@BeforeEach
	public void setUp() {
		nube = mock(ActivoCalculoNube.class);
		activo = new ActivoEnUso(nube);
	}
	
	@Test
	void testBasicoCalculo() {
		when(nube.calcular(35.17, 20, 3)).thenReturn(12.01);
		double res = activo.calcular(35.17, 20, 3);
		assertEquals(12.01, res, 0.01, "No es el valor esperado!");
		verify(nube).calcular(35.17, 20, 3);
	}

}
