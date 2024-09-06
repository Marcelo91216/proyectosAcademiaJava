package com;

public interface ActiveCloudOperation {
	double calculate(int actDays, int interest);
	
	State getState();
}
