
package com.harmandeep.placementtracker.controller;

import com.harmandeep.placementtracker.entity.Company;
import com.harmandeep.placementtracker.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String dashboard(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Company> companies;
        if (keyword != null && !keyword.trim().isEmpty()) {
            companies = companyService.searchCompanies(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            companies = companyService.getAllCompanies();
        }

        long total = companyService.getTotalApplications();
        Map<String, Long> statusCounts = companyService.getStatusCounts();
        List<Company> latestApplications = companyService.getLatestApplications();

        model.addAttribute("companies", companies);
        model.addAttribute("totalApplications", total);
        model.addAttribute("statusCounts", statusCounts);
        model.addAttribute("latestApplications", latestApplications);
        return "dashboard";
    }

    @GetMapping("/company/new")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "add-company";
    }

    @PostMapping("/company/save")
    public String saveCompany(@Valid @ModelAttribute("company") Company company, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "add-company";
        }
        companyService.saveCompany(company);
        redirectAttributes.addFlashAttribute("message", "Company saved successfully!");
        return "redirect:/";
    }

    @GetMapping("/company/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        if (company == null) {
            return "redirect:/";
        }
        model.addAttribute("company", company);
        return "edit-company";
    }

    @PostMapping("/company/update/{id}")
    public String updateCompany(@PathVariable Long id, @Valid @ModelAttribute("company") Company company, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "edit-company";
        }
        company.setId(id);
        companyService.updateCompany(company);
        redirectAttributes.addFlashAttribute("message", "Company updated successfully!");
        return "redirect:/";
    }

    @GetMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        companyService.deleteCompany(id);
        redirectAttributes.addFlashAttribute("message", "Company deleted successfully!");
        return "redirect:/";
    }
}
