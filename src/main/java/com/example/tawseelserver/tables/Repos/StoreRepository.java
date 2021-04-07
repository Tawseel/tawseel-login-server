package com.example.tawseelserver.tables.Repos;

import com.example.tawseelserver.tables.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store getStoreByEmailAndPassword(String email, String password);
    boolean existsStoreByEmail(String email);
}
