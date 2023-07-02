//package ru.skypro.homework.controller;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SpringBootTest
//@AutoConfigureMockMvc
//@CrossOrigin(value = "http://localhost:3000")
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private JSONObject testJSON = new JSONObject();
//
//    @BeforeEach
//    void setUp() throws JSONException {
//        testJSON.put("username", "username");
//        testJSON.put("password", "password");
//        testJSON.put("firstName", "firstName");
//        testJSON.put("lastName", "lastName");
//        testJSON.put("phone", "+79998887766");
//        testJSON.put("role", "ADMIN");
//    }
//
//    @Test
//    void testReg() throws Exception {
//        mockMvc.perform(
//                post("/register").contentType(MediaType.APPLICATION_JSON).content(testJSON.toString()))
//                        .andExpect(status().isOk());
//
//    }
//
//}
