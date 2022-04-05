import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import java.util.OptionalInt;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Person {

    private String name;
    private String surname;
    private String address;
    private int age;

    public static PersonBuilder newBuilder() {
        return new Person().new PersonBuilder();
    }

    public PersonBuilder newChildBuilder() {
        return new Person()
                .new PersonBuilder()
                .setSurname(Person.this.surname)
                .setAddress(Person.this.address);
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class PersonBuilder {

        public PersonBuilder setName(String name) {
            Person.this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            Person.this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (Person.this.age < 0) {
                throw new IllegalArgumentException("Возраст недопустимый");
            }
            Person.this.age = age;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            Person.this.address = address;
            return this;
        }

        public Person build() {
            if (Person.this.name.isEmpty() && Person.this.surname.isEmpty() && Person.this.address.isEmpty()) {
                throw new IllegalArgumentException("Не хватает обязательных полей");
            }
            return Person.this;
        }
    }
}

