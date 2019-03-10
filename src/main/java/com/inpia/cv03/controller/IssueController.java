package com.inpia.cv03.controller;

import com.inpia.cv03.dao.IssueReport;
import com.inpia.cv03.dao.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class IssueController {

    @Autowired
    IssueReportRepository repository;

    public IssueController(IssueReportRepository issueRespository) {
        this.repository = issueRespository;
    }

    @GetMapping("/issuereport")
    public String showForm(Model model){
        model.addAttribute("issueReport", new IssueReport());
        return "issues/issuereport_form";
    }

    @PostMapping("/issuereport")
    public String issueReportSubmit(IssueReport issueReport, RedirectAttributes ra, Model model){
        model.addAttribute("issueReport", new IssueReport());

        System.out.println("Submitted " + issueReport.getDescription());

        repository.save(issueReport);

        ra.addAttribute("submitted", true);
        return "redirect:/issues";
    }

    @GetMapping("/issues")
    public String getIssueReport(Model model) {
        model.addAttribute("issues", repository.findAll());
        return "issues/issuereport_list";
    }

}
