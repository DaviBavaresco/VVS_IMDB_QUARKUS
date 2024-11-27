package br.com.mp.quarkusmovie.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.com.mp.quarkusmovie.model.User;

class UserTest {

    //teste unitario da classe user
    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setId(1L);
        user.setName("Alex");
        user.setEmail("Alex@gmail.com");
        user.setPassword("alex123");

        assertEquals(1L, user.getId());
        assertEquals("Alex", user.getName());
        assertEquals("Alex@gmail.com", user.getEmail());
        assertEquals("alex123", user.getPassword());
    }


}
