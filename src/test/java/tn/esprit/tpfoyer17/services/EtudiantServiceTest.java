package tn.esprit.tpfoyer17.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer17.entities.Etudiant;
import tn.esprit.tpfoyer17.repositories.EtudiantRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EtudiantServiceTest {

    @Mock
    EtudiantRepository etudiantRepository;

    @InjectMocks
    EtudiantService etudiantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addEtudiant() {
        Etudiant etudiant = new Etudiant();
        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);

        Etudiant result = etudiantService.addEtudiant(etudiant);

        assertNotNull(result);
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    void getAllEtudiants() {
        List<Etudiant> etudiants = Arrays.asList(new Etudiant(), new Etudiant());
        when(etudiantRepository.findAll()).thenReturn(etudiants);

        List<Etudiant> result = etudiantService.getAllEtudiants();

        assertEquals(2, result.size());
        verify(etudiantRepository, times(1)).findAll();
    }

    @Test
    void getEtudiantById() {
        Etudiant etudiant = new Etudiant();
        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));

        Etudiant result = etudiantService.getEtudiantById(1L);

        assertNotNull(result);
        verify(etudiantRepository, times(1)).findById(1L);
    }

    @Test
    void deleteEtudiant() {
        doNothing().when(etudiantRepository).deleteById(1L);

        etudiantService.deleteEtudiant(1L);

        verify(etudiantRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateEtudiant() {
        Etudiant etudiant = new Etudiant();
        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);

        Etudiant result = etudiantService.updateEtudiant(etudiant);

        assertNotNull(result);
        verify(etudiantRepository, times(1)).save(etudiant);
    }
}