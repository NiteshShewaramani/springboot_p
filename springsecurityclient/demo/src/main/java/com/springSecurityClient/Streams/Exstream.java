package com.springSecurityClient.Streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee{
    private String name;
    private String dept;
    private int salary;

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Demo1{
    private String name;
    private String dept;
    private int salary;

}
class ComparatorSalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
public class Exstream {
    public static void main(String[] args) {

        TreeMap<Demo1,String> stMap = new TreeMap<>();
        SortedMap<Demo1,String> sMap = new TreeMap<Demo1, String>( (o1,o2)-> o1.getName().compareTo(o2.getName()) );

        sMap.put(new Demo1("h1","2",1),"1");
        sMap.put(new Demo1("h2","2",1),"1");
        sMap.put(new Demo1("a2","3",1),"1");
        sMap.put(new Demo1("c1","1",1),"1");

        System.out.println(sMap);

        IntStream.of(10).min().getAsInt();

        IntStream.of(10)  //creation
                .distinct()  //processing
                .sorted()
                .limit(3)
                .forEach(System.out::println); //consumption

        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("h","1",20));
        emp.add(new Employee("h2","1",200));
        emp.add(new Employee("h3","1",240));
        emp.add(new Employee("h4","1",230));
        emp.add(new Employee("h5","1",220));


        emp.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .filter(employee -> employee.getSalary()>100)
                .map(Employee::getName)
                .forEach(System.out::println);

        emp.stream()
                .limit(3)
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));// will group by department name map

        Map<String,Employee> ep = emp.stream()
                .limit(3)
                .collect(Collectors.toMap(e->e.getName(),e->e));

        Map<String,List<Employee>>  groupByDept = emp.stream()
                .collect(Collectors.groupingBy(e->e.getDept()));

        ComparatorSalary  obj1 = new ComparatorSalary();

        Map<Integer,Employee> map = new HashMap<>();
        map.put(1,new Employee("h","1",20));
        map.put(2,new Employee("h2","1",200));
        map.put(3,new Employee("h3","1",220));
        map.put(4,new Employee("h4","1",230));
        map.entrySet().stream()
                .map(e -> e.getValue())
                .sorted(obj1)
                .filter(e1 -> e1.getSalary() > 100)
                .forEach(System.out::println);
    }
}
