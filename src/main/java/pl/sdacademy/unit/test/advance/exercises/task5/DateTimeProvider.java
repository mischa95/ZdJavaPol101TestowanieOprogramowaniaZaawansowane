package pl.sdacademy.unit.test.advance.exercises.task5;

import java.time.LocalDateTime;

public class DateTimeProvider {
    //dzięki temu że wyciągnęliśmy "randomowość" do klasy/interfejsu będzie można tą metodę łatwo zamokować
    public LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}