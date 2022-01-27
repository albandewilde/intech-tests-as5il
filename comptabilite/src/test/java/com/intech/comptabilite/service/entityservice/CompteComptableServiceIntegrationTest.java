package com.intech.comptabilite.service.entityservice;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.intech.comptabilite.model.CompteComptable;

@SpringBootTest
@ActiveProfiles("test")
public class CompteComptableServiceIntegrationTest {
	@Autowired
	private CompteComptableService ccs;
	
	@Test
	public void testGetListCompteComptable() {
		var expected = new ArrayList<CompteComptable>();
		expected.add(new CompteComptable(401, "Fournisseurs"));
		expected.add(new CompteComptable(411, "Clients"));
		
		var got = ccs.getListCompteComptable();
		
		Assertions.assertEquals(expected.size(), got.size());
		for (int i = 0; i < expected.size(); i++) {
			var e = expected.get(i);
			var g = got.get(i);
			
			Assertions.assertEquals(e.getNumero(), g.getNumero());
			Assertions.assertEquals(e.getLibelle(), g.getLibelle());
		}
	}
}
