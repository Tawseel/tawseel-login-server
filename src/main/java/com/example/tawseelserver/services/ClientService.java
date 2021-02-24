package com.example.tawseelserver.services;

import com.example.tawseelserver.tables.Client;
import com.example.tawseelserver.tables.Repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService
{
    @Autowired
    ClientRepository clientRepository;

    public boolean signIn(String email, String password)
    {
        return clientRepository.existsClientsByEmailAndPassword(email, password);
    }

    public void signUp(Client client)
    {
        if(isSignUpDataValid(client))
        {
            clientRepository.saveAndFlush(client);
        }
    }

    private boolean isSignUpDataValid(Client client)
    {
        boolean isValid = client != null;
        isValid = isValid && isAlpha(client.getFirstName());
        isValid = isValid && isAlpha(client.getLastName());
        isValid = isValid && !clientRepository.existsClientsByEmail(client.getEmail());
        isValid = isValid && !clientRepository.existsClientsByPhoneNumber(client.getPhoneNumber());

        return isValid;
    }

    private boolean isAlpha(String string)
    {
        return string != null && string.chars().allMatch(Character::isLetter);
    }
}
