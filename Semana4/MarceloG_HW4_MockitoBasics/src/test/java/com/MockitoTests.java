package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class MockitoTests {
//	@Mock
	ActiveCloudOperation cloud;
	
//	@InjectMocks
	ActiveOnUse active;
	
//	Inject the cloud instance of the active into the active in our local program
	@BeforeEach
	public void setUp() {
		cloud = mock(ActiveCloudOperation.class);	//Another alternative to create a mock of a variable
		active = new ActiveOnUse(cloud);			//Another alternative to create a mock of a variable
	}
	
	@Test
	void obtainExpectedResultFromCalculateCloudActive() {
		final double simulated = 12.01;
		final double expected = 12.01;
		when(cloud.calculate(20, 3))
			.thenReturn(simulated);
		final double res = active.calculate(20, 3);
		assertEquals(expected, res, 0.01, "Not the same result!");
		verify(cloud).calculate(20, 3);	//verify that our object has been called, you can even told him how many time you expected being called
	}
	
	@Test
	void obtainStateFromAnActive() {
		final State simulated = State.IN_USE; 
		final State expected = State.IN_USE;
		when(cloud.getState())
			.thenReturn(simulated);
		final State res = active.getState();
		assertEquals(expected, res);
		verify(cloud).getState();
	}

}
