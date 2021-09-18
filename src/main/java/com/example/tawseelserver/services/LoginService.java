package com.example.tawseelserver.services;

import com.example.tawseelserver.authantication.UsernameAndPassword;
import com.example.tawseelserver.authantication.jwt.TokensManager;
import com.example.tawseelserver.tables.Client;
import com.example.tawseelserver.tables.Repos.ClientRepository;
import com.example.tawseelserver.tables.Repos.StoreRepository;
import com.example.tawseelserver.tables.Store;
import com.example.tawseelserver.tables.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    TokensManager tokensManager;


    public boolean signUp(Client client) {
        boolean isValid = client != null;
        isValid = isValid && client.getEmail() != null;
        isValid = isValid && !clientRepository.existsClientByEmail(client.getEmail());
        isValid = isValid && client.getPassword() != null;
        if(isValid) {
            clientRepository.saveAndFlush(client);
        }

        return isValid;
    }

    public boolean signUp(Store store) {
        boolean isValid = store != null;
        isValid = isValid && store.getEmail() != null;
        isValid = isValid && !storeRepository.existsStoreByEmail(store.getEmail());
        isValid = isValid && store.getPassword() != null;
        if(isValid) {
            storeRepository.saveAndFlush(store);
        }

        return isValid;
    }

    public String signIn(UsernameAndPassword details, UserType userType)
    {
        String token = null;
        if(userType == UserType.Client) {
            token = signInClient(details);
        }
        else if(userType == UserType.Store) {
            token = signInStore(details);
        }

        return token;
    }

    private String signInClient(UsernameAndPassword details) {
        String token = null;
        Client client = clientRepository.getClientByEmailAndPassword(details.getEmail(), details.getPassword());
        if(client != null) {
            int userId = client.getId();
            token = tokensManager.generateToken(userId);
        }
        return token;
    }

    private String signInStore(UsernameAndPassword details) {
        String token = null;
        Store store = storeRepository.getStoreByEmailAndPassword(details.getEmail(), details.getPassword());
        if(store != null) {
            int userId = store.getId();
            token = tokensManager.generateToken(userId);
        }
        return token;
    }
}
