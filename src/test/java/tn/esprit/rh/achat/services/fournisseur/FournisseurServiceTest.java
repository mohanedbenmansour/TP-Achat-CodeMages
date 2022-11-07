package tn.esprit.rh.achat.services.fournisseur;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.IFournisseurService;

import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceTest {

	@Autowired
	IFournisseurService fs;

	@MockBean
	private FournisseurRepository fr;

	Fournisseur f1 = new Fournisseur();
	Fournisseur f2 = new Fournisseur();	

	/**
	 * 
	 */
	@Test 
    public void retrieveAllProduitsTest() {
    	when(fr.findAll()).thenReturn(Stream
    			.of(f1,f2)
    			.collect(Collectors.toList()));
    	assertEquals(2,fs.retrieveAllFournisseurs().size());
    	System.out.println("Retrieve  All fournisseurs works !");
    }

	@Test
	public void addProduitTest() {
    	when(fr.save(f1)).thenReturn(f1);
    	assertNotNull(f1);
		assertEquals(f1, fs.addFournisseur(f1));
    	System.out.println("Add fournisseur works !");
	}

	@Test
	public void DeleteProduitTest() {
		fr.save(f1);
		fs.deleteFournisseur(f1.getIdFournisseur());
		verify(fr, times(1)).deleteById(f1.getIdFournisseur());
		System.out.println("Delete fournisseurs works !");

	}




}