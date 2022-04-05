import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonBuilderTest {

    private Person mom;
    private Person son;

    @BeforeEach
    void init() {
        mom = Person.newBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
    }

    @Test
    @DisplayName("Crete Mom Person")
    public void buildMom() {
        Assertions.assertEquals("Анна", mom.getName());
        Assertions.assertEquals("Вольф", mom.getSurname());
        Assertions.assertEquals(31, mom.getAge().getAsInt());
        Assertions.assertEquals("Сидней", mom.getAddress());
    }

    @Test
    @DisplayName("Create Mom's son Person")
    public void buildMomsSon() {
        son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        Assertions.assertEquals("Антошка", son.getName());
        Assertions.assertEquals("Вольф", son.getSurname());
        Assertions.assertEquals("Сидней", son.getAddress());
    }
}
