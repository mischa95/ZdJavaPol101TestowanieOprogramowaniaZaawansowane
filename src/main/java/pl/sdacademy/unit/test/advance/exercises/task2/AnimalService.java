package pl.sdacademy.unit.test.advance.exercises.task2;

public class AnimalService {
    private AnimalRespository animalRespository;

    public AnimalService(AnimalRespository animalRespository) {
        this.animalRespository = animalRespository;
    }

    public Animal getById(long id) {
        return animalRespository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not exist with id: " + id));
    }

    public boolean add(AnimalDto animalDto) {
        return animalRespository.addAnimal(animalDto);
    }
}
