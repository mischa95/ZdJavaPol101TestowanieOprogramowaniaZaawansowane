package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Optional;

public interface AnimalRespository {
    Optional<Animal> findById(long id);
    Optional<Animal> findByType(String type);
    boolean addAnimal(AnimalDto animalDto);
}
