
package com.harmandeep.placementtracker.service;

import com.harmandeep.placementtracker.entity.Company;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    Company saveCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompany(Long id);
    List<Company> searchCompanies(String keyword);
    long getTotalApplications();
    Map<String, Long> getStatusCounts();
    List<Company> getLatestApplications();
}
