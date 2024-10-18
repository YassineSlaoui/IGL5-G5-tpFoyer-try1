package tn.esprit.tpfoyer17.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer17.entities.Bloc;
import tn.esprit.tpfoyer17.repositories.BlocRepository;
import tn.esprit.tpfoyer17.repositories.ChambreRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BlocServiceTest {

    @Mock
    private BlocRepository blocRepository;

    @InjectMocks
    private BlocService blocService;

    @BeforeEach
    void setUp() {
       MockitoAnnotations.openMocks(this);
    }

    @Test
    void addBloc() {
        Bloc bloc = new Bloc();
        when(blocRepository.save(bloc)).thenReturn(bloc);

        Bloc result = blocService.addBloc(bloc);

        assertNotNull(result);
        verify(blocRepository, times(1)).save(bloc);
    }

    @Test
    void getAllBlocs() {
        List<Bloc> blocs = Arrays.asList(new Bloc(), new Bloc());
        when(blocRepository.findAll()).thenReturn(blocs);

        List<Bloc> result = blocService.getAllBlocs();

        assertEquals(2, result.size());
        verify(blocRepository, times(1)).findAll();
    }

    @Test
    void getBlocById() {
        Bloc bloc = new Bloc();
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        Bloc result = blocService.getBlocById(1L);

        assertNotNull(result);
        verify(blocRepository, times(1)).findById(1L);
    }

    @Test
    void deleteBloc() {
        doNothing().when(blocRepository).deleteById(1L);

        blocService.deleteBloc(1L);

        verify(blocRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateBloc() {
        Bloc bloc = new Bloc();
        when(blocRepository.save(bloc)).thenReturn(bloc);

        Bloc result = blocService.updateBloc(bloc);

        assertNotNull(result);
        verify(blocRepository, times(1)).save(bloc);
    }
}