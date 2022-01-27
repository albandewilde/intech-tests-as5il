package com.intech.comptabilite.service.entityservice;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.intech.comptabilite.model.CompteComptable;
import com.intech.comptabilite.repositories.CompteComptableRepository;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CompteComptableServiceUnitTest {
	@MockBean
	private CompteComptableRepository ccr;
	
	@Autowired
	private CompteComptableService ccs;
	
	@Test
	public void testGetListCompteComptable() {
		var expected = new ArrayList<CompteComptable>();
		Mockito.when(ccr.findAll()).thenReturn(expected);
		
		var got = ccs.getListCompteComptable();
		
		Assertions.assertIterableEquals(expected, got);
		Mockito.verify(ccr, Mockito.times(1)).findAll();
	}
}