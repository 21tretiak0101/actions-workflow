package by.example.actions;

import by.example.actions.controller.TaskController;
import by.example.actions.entity.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request
		.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result
		.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result
		.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result
		.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TaskController.class)
class ActionsApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void test() {
		assertEquals(10, 20 - 10);
	}

	@Test
	public void getOne() throws Exception {
		Task first = new Task(1, "first");
		mockMvc.perform(get("/api/test/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content()
						.json(objectMapper.writeValueAsString(first)))
				.andDo(print());
	}

	@Test
	public void getAll() throws Exception {
		List<Task> tasks = Arrays.asList(
				new Task(1, "first"),
				new Task(2, "second")
		);
		mockMvc.perform(get("/api/test"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content()
						.json(objectMapper.writeValueAsString(tasks)))
				.andDo(print());
	}
}
