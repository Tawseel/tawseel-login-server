package com.example.tawseelserver.tables.Repos;

import com.example.tawseelserver.tables.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getClientByEmailAndPassword(String email, String password);
    boolean existsClientByEmail(String email);
}
