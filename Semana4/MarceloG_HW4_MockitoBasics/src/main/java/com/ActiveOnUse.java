package com;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ActiveOnUse {
	private ActiveCloudOperation cloud;

//	Get the result of the real value of the Active depending on it's market value
	public double calculate(int actDays, int interest) {
		return cloud.calculate(actDays, interest);
	}
	
//	Get state of the Active on the Cloud
	public State getState() {
		return cloud.getState();
	}
}
