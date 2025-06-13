package prg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsClass {

	public static List<Person> getPersons() {
		return Arrays.asList(new Person("Alice", 20, "New York"), new Person("Bob", 17, "Chicago"),
				new Person("Charlie", 22, "New York"), new Person("David", 16, "Los Angeles"),
				new Person("Eva", 19, "New York"), new Person("Frank", 21, "Chicago"),
				new Person("Grace", 23, "New York"), new Person("Hannah", 18, "Boston"));
	}

	public static void main(String[] args) {

		List<List<String>> list = Arrays.asList(

				Arrays.asList("Java", "Python"), Arrays.asList("HTML", "CSS", "Java Script"),
				Arrays.asList("React", "Angular", "Vue")

		);

		List<String> l1 = Arrays.asList("HTML", "CSS", "Java Script");

		Set<List<String>> result = new HashSet<List<String>>();

		Consumer<String> consumer = data -> System.out.println(data);

		list.stream().flatMap(List::stream).filter(s -> s.contains("S")).map(s -> s.toUpperCase()).distinct().sorted()
				.collect(Collectors.toList()).forEach(consumer);

		// Parallel Processing
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> sumOfSquares = nums.parallelStream().map(n -> n * n).reduce(Integer::sum);
		sumOfSquares.ifPresent(System.out::println);

		// Functional Interface
		Function<String, String> modifyString = name -> name + " Lanugage";
		consumer.accept(modifyString.apply("Java"));

		// Predicate Interface
		Predicate<String> predicate = str -> str.contains("java");
		Predicate<String> predicate_2 = str -> str.length() > 5;
		System.out.println(predicate.and(predicate_2).test("java language"));

		List<Person> persons = getPersons();

		// question 1
		Function<List<Person>, Double> computeAverage = listOfAge -> {
			int sumOfAge = listOfAge.stream().map(person -> person.getAge()).reduce(0, Integer::sum);
			return (double) (sumOfAge / list.size());
		};

		Predicate<Person> PersonAgeGreaterThan18 = person -> person.getAge() > 18;
		Predicate<Person> PersonFromCity = person -> person.getCity().equals("New York");
		Comparator<Person> sortPersonByName = Comparator.comparing(Person::getName);
		Comparator<Person> sortPersonByAge = Comparator.comparing(Person::getAge);

		List<Person> res = persons.stream().filter(PersonAgeGreaterThan18.and(PersonFromCity)).sorted(sortPersonByName)
				.collect(Collectors.toList());
		double averageAge = res.stream().mapToInt(Person::getAge).average().orElse(0.0);
		res.stream().forEach(System.out::println);
		System.out.println("Average Age : " + averageAge);

		System.out.println();
		// question 2
		Map<String, List<Person>> groupedByCity = persons.stream()
				.collect(Collectors.groupingBy(person -> person.getCity()));
		System.out.println(groupedByCity);
		Map<String, Optional<Person>> oldestPersonByCity = persons.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.maxBy(Comparator.comparingInt(Person::getAge))));
		oldestPersonByCity.forEach((city,person)->{
			System.out.println(person.get());
		});
	}

}
