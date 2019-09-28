package greenfox;

import java.util.ArrayList;

public class Test {

  public static void main(String[] args) {
//    Person person = new Person("me", 28, "male");
//    System.out.println(person.getAge());
//    System.out.println(person.getGender());
//    person.getGoal();
//    System.out.println(person.getName());
//    System.out.println();
//    person.introduce();
//
//    System.out.println();
//
//    Student student = new Student("Zi", 28, "male", "Oregional crap");
//    System.out.println(student.getPreviousOrganization());
//    student.introduce();
//    student.skipDays(10);
//    student.introduce();
//
//    System.out.println("===============================================");
//
//    Student randomStudent = new Student();
//    randomStudent.introduce();
//
//    System.out.println("===============================================");
//
//    Mentor mentor = new Mentor("Sunny", 22, "male", "junior");
//    System.out.println(mentor.getName());
//    mentor.getGoal();
//    System.out.println(mentor.getAge());
//    System.out.println(mentor.getGender());
//    mentor.introduce();
//
//    System.out.println("==============================================");
//
//    Sponsor sponsor = new Sponsor("Lajcsi", 34, "male", "Google Hungary");
//    sponsor.introduce();
//    sponsor.hire();
//    sponsor.introduce();
//
//    System.out.println("==============================================");

    ArrayList<Person> people = new ArrayList<>();

    Person mark = new Person("Mark", 46, "male");
    people.add(mark);
    Person jane = new Person();
    people.add(jane);
    Student john = new Student("John Doe", 20, "male", "BME");
    people.add(john);
    Student student = new Student();
    people.add(student);
    Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
    people.add(gandhi);
    Mentor mentor = new Mentor();
    people.add(mentor);
    Sponsor sponsor = new Sponsor();
    people.add(sponsor);
    Sponsor elon = new Sponsor("Elon Musk", 46, "male", "SpaceX");
    people.add(elon);

    student.skipDays(3);

    for (int i = 0; i < 5; i++) {
      elon.hire();
    }

    for (int i = 0; i < 3; i++) {
      sponsor.hire();
    }

    for (Person person : people) {
      person.introduce();
      person.getGoal();
    }

    Cohort awesome = new Cohort("AWESOME");
    awesome.addStudent(student);
    awesome.addStudent(john);
    awesome.addMentor(mentor);
    awesome.addMentor(gandhi);
    awesome.info();
  }
}
