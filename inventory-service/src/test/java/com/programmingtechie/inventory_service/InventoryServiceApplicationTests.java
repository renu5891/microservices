// package com.programmingtechie.inventory_service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTestframework.jdbc.core.JdbcTemplate;
// @AutoConfigureMockMvc
// class InventoryServiceApplicationTests {

// 	@Autowired
// 	private JdbcTemplate jdbcTemplate;

// 	@Autowired
// 	private MockMvc mockMvc;

// 	@Test
// 	void contextLoads() {
// 		Integer tableCount = jdbcTemplate.queryForObject(
// 				"SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'INVENTORY_SERVICE' AND TABLE_NAME = 'T_INVENTORY'",
// 				Integer.class);
// 		assertEquals(1, tableCount);
// 	}

// 	@Test
// 	void inventoryEndpointReturnsStockStatus() throws Exception {
// 		mockMvc.perform(get("/api/inventory/iphone_13"))
// 				.andExpect(status().isOk())
// 				.andExpect(content().string("true"));
// 	}

// }
