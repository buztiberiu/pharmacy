package com.tiberiu.pharmacy.repository;

import com.tiberiu.pharmacy.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByCardSalesGreaterThan(Integer cardSales);

   // @Query("SELECT u FROM Client u WHERE u.cardSales = 1")
   // List<Client> cardSalesGreaterThan(Integer cardSales);


}
