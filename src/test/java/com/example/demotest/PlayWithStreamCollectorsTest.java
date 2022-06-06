package com.example.demotest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithStreamCollectorsTest {

	@Test
	public void test() {
		List<Employee> employees = List.of(
						Employee.builder().id(101).name("Glady").designation("Manager").gender("Male").age(25).build(),
						Employee.builder().id(102).name("Vlad").designation("Software Engineer").gender("Female").age(30).build(),
						Employee.builder().id(102).name("Shine").designation("Software Engineer").gender("Female").age(32).build()
		);

		/*
		List<A> out = list.stream()
		                  .collect(Collectors
						                           .collectingAndThen(
										                           Collectors.toMap(ele -> ele.getFieldA(), Function.identity(), (a, b) -> {
											                           a.setFieldB(a.getFieldB() + b.getFieldB());
											                           return a;
										                           }), m -> new ArrayList<>(m.values())));
		*/

		/*
		employees.stream()
		         .collect(Collectors.collectingAndThen(
		         				Collectors.toMap((Employee emp) -> emp.getDesignation(), Function.identity(),
					                           (a, b) -> {return  a.getName() + "-" + b.getName();}),
					          m ->  new ArrayList<>(m.values())
		         ));
		*/
/*

		System.out.println(employees.stream()
		         .collect(Collectors.groupingBy(Employee::getDesignation)));

		System.out.println(employees.stream()
		         .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.counting())));
*/

		Map<Integer, Employee> merge = employees.stream()
		                                        .collect(Collectors.toMap(employee -> employee.getId(),
		                                                                  Function.identity(),
		                                                                  (emp1, emp2) -> Employee.builder()
		                                                                                          .id(emp1.id)
		                                                                                          .name(emp1.name +
						                                                                                                " " + emp2.name)
		                                                                                          .build()
		                                        ));

		Collection<Employee> merge2 = employees.stream()
		                                        .collect(
						                                        Collectors.collectingAndThen(Collectors.toMap(
										                                        employee -> employee.getId(),
										                                        Function.identity(),
										                                        (emp1, emp2) -> Employee.builder()
										                                                                .id(emp1.id)
										                                                                .name(emp1.name +
														                                                                      " " + emp2.name)
										                                                                .build()
						                                        ), empMap -> empMap.values())
		                                        );

		System.out.println(merge);
		System.out.println(merge2);

		System.out.println("***************");
		Map<String, String> map1 = Map.of("K1", "V1");
		Map<String, String> map2 = Map.of("K2", "V2");

		//map1.putAll(map2);www

		//Map.of(map1.entrySet().)

		Map<String, String> collectedMap = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
		                                    .collect(Collectors.toMap(
						                                    Entry::getKey,
						                                    Entry::getValue
		                                    ));

		System.out.println(collectedMap);

	}


}
