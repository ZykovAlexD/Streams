package Streams.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long count = persons.stream()
                .filter(c -> c.getAge() >= 18)
                .count();
        System.out.println(count);

        List<String> fam = persons.stream()
                .filter(c -> c.getAge() >= 18)
                .filter(c -> c.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(fam);

        List<String> workers = persons.stream()
                .filter(c -> c.getAge() >= 18)
                .filter(c -> c.getAge() <= 60)
                .filter(c -> c.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getEducation))
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(workers);
    }
}
