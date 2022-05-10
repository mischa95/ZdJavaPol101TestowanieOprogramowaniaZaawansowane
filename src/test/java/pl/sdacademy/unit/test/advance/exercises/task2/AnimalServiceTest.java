package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private static final Animal ANIMAL = new Animal(10L, "kot","Filemon");
    private static final AnimalDto ANIMAL_DTO = new AnimalDto("kot","Filemon");

    @Mock
    private AnimalRespository animalRespository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldReturnAnimalById() {
        //given
        Mockito.when(animalRespository.findById(10L)).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(10L);
        //then
        assertEquals(ANIMAL, result); //junit
        assertThat(result).isEqualTo(ANIMAL);
    }

    @Test
    void shouldReturnThrowExcpetionWhenAnimalNotExist() {
        //given
        Mockito.when(animalRespository.findById(10L)).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> animalService.getById(10L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Animal not exist with id: 10");
    }

    @Test
    void shouldAddNewAnimal() {
        //given
        Mockito.when(animalRespository.addAnimal(any())).thenReturn(true);
        //when
        boolean result = animalService.add(ANIMAL_DTO);
        //then
        assertTrue(result);
        assertThat(result).isTrue();
    }

}