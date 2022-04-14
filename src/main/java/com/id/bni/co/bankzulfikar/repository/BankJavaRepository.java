package com.id.bni.co.bankzulfikar.repository;

import com.id.bni.co.bankzulfikar.domain.Nasabah;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankJavaRepository extends CrudRepository<Nasabah, String> {
    @Query(value = "SELECT * FROM BANK_JAVA WHERE KEY_GET = 4", nativeQuery = true)
    List<Nasabah> getAllNasabah();

    @Query(value = "SELECT * FROM BANk_JAVA WHERE KEY_GET = 4 AND NO_KTP = :noKtp", nativeQuery = true)
    Nasabah getBankJavaByNoKtp(String noKtp);
}
