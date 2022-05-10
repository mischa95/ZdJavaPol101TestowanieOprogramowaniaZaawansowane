package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final User USER = new User(1L, "Jan", "Kowalski");
    private static final UserDto USER_DTO = new UserDto( "Jan", "Kowalski");

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(USER));
        //when
        User result = userService.getUserById(5L);
        //then
        assertEquals(USER, result); //junit
        assertThat(result).isEqualTo(USER); //assertj
    }

    @Test
    void shouldThrowExceptionWhenUserNotExist() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        //when & then
        assertThrows(NoSuchElementException.class,
                () -> userService.getUserById(2L)); //junit
        assertThatThrownBy(() -> userService.getUserById(3L))
                .isInstanceOf(NoSuchElementException.class); //assertj
    }

    @Test
    void shouldCreateUser() {
        //given
        Mockito.when(userValidator.isUserValid(any())).thenReturn(true);
        Mockito.when(userRepository.addUser(any())).thenReturn(USER);
        //when
        User result = userService.createUser(USER_DTO);
        //then
        assertEquals(USER, result); //junit
        assertThat(result).isEqualTo(USER); //assertj
    }

    @Test
    void shouldNotCreateUser() {
        //given
        Mockito.when(userValidator.isUserValid(any())).thenReturn(false);
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser(USER_DTO)); //junit
        assertThatThrownBy(() -> userService.createUser(USER_DTO))
                .isInstanceOf(IllegalArgumentException.class); //assertj
        verifyNoInteractions(userRepository);
    }
}