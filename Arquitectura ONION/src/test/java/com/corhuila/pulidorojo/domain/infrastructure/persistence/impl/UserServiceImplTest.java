package com.corhuila.pulidorojo.domain.infrastructure.persistence.impl;

import com.corhuila.domain.infrastructure.persistence.impl.UserServiceImpl;
import com.corhuila.domain.model.User;
import com.corhuila.domain.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
        user.setFullname("Juan");
        user.setEmail("juan@example.com");
        user.setPhone("123456789");
        user.setPassword("password123");
        user.setUrl("http://example.com/profile.jpg");
    }

    @Test
    void testFindAll() {
        List<User> lista = Arrays.asList(user);
        when(userRepository.findAll()).thenReturn(lista);

        List<User> result = userService.findAll();

        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getFullname());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.findById(1L);

        assertNotNull(result);
        assertEquals("Juan", result.getFullname());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testSave() {
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);

        assertNotNull(result);
        assertEquals("Juan", result.getFullname());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDelete() {
        doNothing().when(userRepository).delete(1L);

        userService.delete(1L);

        verify(userRepository, times(1)).delete(1L);
    }
}
