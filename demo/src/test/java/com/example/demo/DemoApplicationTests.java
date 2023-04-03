package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.src.web.controller.RootController;
import ru.src.web.model.Client;
import ru.src.web.repositories.ClientRepository;
import ru.src.web.service.ClientServiceImpl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {
	private static final long ID = 1l;
	@Mock
	private  ClientRepository clientRepository;
	@InjectMocks
	private ClientServiceImpl clientService;
	@Test
	public void findTest() {
		final Client client = mock(Client.class);
		when(clientRepository.findId(ID)).thenReturn(client);

		final Client actual  = clientService.findClientId(2L);

		assertNotNull(actual);
		assertEquals(client,actual);

	}

	@Test
	public void deteilsproduct() {
		RootController rootController = new RootController();
		String result = rootController.getRoot();
		assertEquals(result, "redirect:/profile");

	}
}
