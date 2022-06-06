package com.example.demotest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
	int id;
	String name;
	String designation;
	String gender;
	long age;
}
