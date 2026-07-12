
package com.harmandeep.placementtracker.service.impl;

import com.harmandeep.placementtracker.entity.Company;
import com.harmandeep.placementtracker.repository.CompanyRepository;
import com.harmandeep.placementtracker.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> searchCompanies(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllCompanies();
        }
        return companyRepository.searchCompanies(keyword);
    }

    @Override
    public long getTotalApplications() {
        return companyRepository.count();
    }

    @Override
    public Map<String, Long> getStatusCounts() {
        Map<String, Long> statusCounts = new LinkedHashMap<>();
        String[] statuses = {"Applied", "OA", "Interview", "Selected", "Rejected"};
        for (String status : statuses) {
            statusCounts.put(status, companyRepository.countByStatus(status));
        }
        return statusCounts;
    }

    @Override
    public List<Company> getLatestApplications() {
        return companyRepository.findTop5ByOrderByApplicationDateDesc();
    }
}
