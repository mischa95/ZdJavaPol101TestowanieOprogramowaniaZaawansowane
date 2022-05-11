package pl.sdacademy.unit.test.advance.exercises.task5;

import java.util.UUID;

public class RandomPasswordProvider {
    //dzięki temu że wyciągnęliśmy "randomowość" do klasy/interfejsu będzie można tą metodę łatwo zamokować
    public String generateNewPassword() {
        return UUID.randomUUID().toString();
    }
}
