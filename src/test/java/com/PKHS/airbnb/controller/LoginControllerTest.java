package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.User;

<<<<<<< Updated upstream
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
=======
import com.PKHS.airbnb.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class LoginControllerTest {

    private static User user;
    private static Long id;
    private static String password = "123456";
    private static String username = "admin";

    static {
        id = 1l;
        user = new User(username, password);
    }

    @InjectMocks
    private LoginController loginController;

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkLogin() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attribute("username", username))
                .andExpect(model().attribute("password", password))
                .andExpect(view().name("/admin"));
    }

    @Test
    public void login() {
    }

    @Test
    public void home() {
    }

    @Test
    public void home_admin() {
    }

    @Test
    public void errors() {
    }
}
