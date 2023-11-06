package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class
ProduitServiceImplTest {

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // initialize mocks

        // Test data setup
        Produit Produit1 = new Produit();

        Produit1.setCodeProduit("Informatique");

        Produit Produit2 = new Produit();

        Produit2.setCodeProduit("Mathématiques");

        // Mock behavior for the repository
        when(produitRepository.findAll()).thenReturn(Arrays.asList(Produit1, Produit2));
        when(produitRepository.save(any(Produit.class))).thenAnswer(invocation -> invocation.getArgument(0));
    }
    @Test
    public void testRetrieveAllProduits() {
        // Créer des produits factices
        Produit produit1 = new Produit();
        Produit produit2 = new Produit();
        List<Produit> produits = Arrays.asList(produit1, produit2);

        // Configurer le comportement simulé de produitRepository.findAll()
        Mockito.when(produitRepository.findAll()).thenReturn(produits);

        // Appeler la méthode à tester
        List<Produit> result = produitService.retrieveAllProduits();

        // Effectuer des assertions pour vérifier le résultat
        assertEquals(2, result.size());
        assertEquals(produit1, result.get(0));
        assertEquals(produit2, result.get(1));
    }

}

