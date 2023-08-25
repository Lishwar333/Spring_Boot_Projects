package com.store.productcatalogue.Cart.Integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.get;
import com.store.productcatalogue.Cart.CartApplication;
import com.store.productcatalogue.Cart.Model.Cart;



@ContextConfiguration(classes = CartApplication.class )
@TestInstance(value = Lifecycle.PER_CLASS)
@TestPropertySource(value = {"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
	
	@LocalServerPort
	private int randomServerPort;
	
	//@Value("bank.test.message")
	String message = "message";
	
	//@Value("bank.test.message.response")
	String response = "Invalid Input";
	
	@BeforeAll
	public void setBaseUrl() {
		
		RestAssured.port = randomServerPort;
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	@Order(1)
	public void searchCartByIdTest1() {
		
	get("/cart/0").then().assertThat().body(message, equalTo(response));
		
	}
	
	@Test
	@Order(2)
	public void searchCartByIdTest2() {
		
	get("/cart/-1").then().assertThat().body(message, equalTo(response));
		
	}
	
	@Test
	@Order(3)
	public void searchCartByIdTest3() {
		
	get("/cart/1004").then().assertThat().body(message, equalTo("No Cart with id: 1004"));
		
	}
	
	@Test
	@Order(4)
	public void searchCartByIdTest4() {
		
	Cart cart = get("/cart/1001").as(Cart.class);
	assertEquals(1001, cart.getCartId());
		
	}

}
