package ru.skypro.homework.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private JSONObject testUserDTOJSON = new JSONObject();
    private JSONObject testLoginJSON = new JSONObject();
    @Autowired
    private WebApplicationContext webApplicationContext;


    private void setTestUserDTOJSON() throws JSONException {
        testUserDTOJSON.put("username", "username");
        testUserDTOJSON.put("password", "password");
        testUserDTOJSON.put("firstName", "firstName");
        testUserDTOJSON.put("lastName", "lastName");
        testUserDTOJSON.put("phone", "+79998887766");
        testUserDTOJSON.put("role", "ADMIN");

    }

    private void setTestLoginJSON() throws JSONException {
        testLoginJSON.put("password", "password");
        testLoginJSON.put("username", "username");
    }

    @Test
    void testReg() throws Exception {
        setTestUserDTOJSON();
        setTestLoginJSON();
        mockMvc.perform(
                        post("/register").contentType(MediaType.APPLICATION_JSON).content(testUserDTOJSON.toString()))
                .andExpect(status().isOk());
        mockMvc.perform(
                        post("/login").contentType(MediaType.APPLICATION_JSON).content(testLoginJSON.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void testRegTrow() throws Exception {
        setTestUserDTOJSON();
        mockMvc.perform(
                        post("/register").contentType(MediaType.APPLICATION_JSON).content(testUserDTOJSON.toString()))
                .andExpect(status().is(400));
    }

    @Test
    void testGetUser() throws Exception {
        setTestLoginJSON();
        mockMvc.perform(
                        post("/login").contentType(MediaType.APPLICATION_JSON).content(testLoginJSON.toString()))
                .andExpect(status().isOk());
        mockMvc.perform(
                        get("/users/me")
                                .header("Authorization", "Basic " +
                                        Base64.getEncoder().encodeToString(("username" + ":" + "password").getBytes(StandardCharsets.UTF_8))))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateUser() throws Exception {
        setTestLoginJSON();
        JSONObject testUserUpdateDTOJSON = new JSONObject();
        testUserUpdateDTOJSON.put("firstName", "firstName");
        testUserUpdateDTOJSON.put("lastName", "lastName");
        testUserUpdateDTOJSON.put("phone", "+79998887766");
        mockMvc.perform(
                        post("/login").contentType(MediaType.APPLICATION_JSON).content(testLoginJSON.toString()))
                .andExpect(status().isOk());
        mockMvc.perform(
                        patch("/users/me").contentType(MediaType.APPLICATION_JSON).content(testUserUpdateDTOJSON.toString())
                                .header("Authorization", "Basic " +
                                        Base64.getEncoder().encodeToString(("username" + ":" + "password").getBytes(StandardCharsets.UTF_8))))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateUserPassword() throws Exception {
        setTestLoginJSON();
        JSONObject testNewPasswordJSON = new JSONObject();
        testNewPasswordJSON.put("currentPassword", "password");
        testNewPasswordJSON.put("newPassword", "password111");
        mockMvc.perform(
                        post("/login").contentType(MediaType.APPLICATION_JSON).content(testLoginJSON.toString()))
                .andExpect(status().isOk());
        mockMvc.perform(
                        post("/users/set_password").contentType(MediaType.APPLICATION_JSON).content(testNewPasswordJSON.toString())
                                .header("Authorization", "Basic " +
                                        Base64.getEncoder().encodeToString(("username" + ":" + "password").getBytes(StandardCharsets.UTF_8))))
                .andExpect(status().isOk());
        mockMvc.perform(
                        get("/users/me")
                                .header("Authorization", "Basic " +
                                        Base64.getEncoder().encodeToString(("username" + ":" + "password111").getBytes(StandardCharsets.UTF_8))))
                .andExpect(status().isOk());
    }

    @Test
    void testLoadAvatar() throws Exception {
        setTestLoginJSON();
        MockMultipartFile file = new MockMultipartFile("file", "hello.png", MediaType.IMAGE_PNG_VALUE, "Hello, World!".getBytes());

        mockMvc.perform(
                        post("/login").contentType(MediaType.APPLICATION_JSON).content(testLoginJSON.toString()))
                .andExpect(status().isOk());

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/users/me/image").file(file)
                        .header("Authorization", "Basic " +
                                Base64.getEncoder().encodeToString(("username" + ":" + "password").getBytes(StandardCharsets.UTF_8))))
                .andExpect(status().isOk());
    }
}
