package com.example.authentication.service;

import com.example.authentication.entity.UserApp;
import com.example.authentication.repository.UserAppRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserAppServiceTest {

    @InjectMocks
    private UserAppService userAppService;
    @Mock
    private UserAppRepository userAppRepository;

//    @Test
//    void testEnregistrerUtilisateurExpectUserApp (){
//        UserApp userApp = new UserApp("toto","toto");
//        UserApp userAppCreate = new UserApp(1,"toto","toto");
//
//        Mockito.when(userAppRepository.save(userApp)).thenReturn(userAppCreate);
//        Assertions.assertEquals(userAppCreate,userAppService.enregistrerUtilisateur("toto","toto"));
//    }

}
