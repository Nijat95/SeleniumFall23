package selenium_intro;

import com.github.javafaker.Faker;

public class FakerPractice {
    public static void main(String[] args) {

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(0,120);
        String address = faker.address().fullAddress();
        String msg = faker.lorem().sentence();

        System.out.println(firstName + " " + lastName);
        System.out.println(age);
        System.out.println(address);
        System.out.println(faker.internet().emailAddress());
        System.out.println(firstName + " " + lastName + "@" + faker.internet().domainSuffix());

    }
}
