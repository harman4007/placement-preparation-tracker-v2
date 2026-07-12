
package com.harmandeep.placementtracker.repository;

import com.harmandeep.placementtracker.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.role) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Company> searchCompanies(@Param("keyword") String keyword);

    @Query("SELECT COUNT(c) FROM Company c WHERE c.status = :status")
    long countByStatus(@Param("status") String status);

    List<Company> findTop5ByOrderByApplicationDateDesc();
}
