package com.inpia.cv03.controller;

import com.inpia.cv03.dao.IssueReport;
import com.inpia.cv03.dao.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class IssueRestController {

    @Autowired
    IssueReportRepository repository;

    public IssueRestController(IssueReportRepository issueRespository) {
        this.repository = issueRespository;
    }

    @GetMapping("/api/issues")
    public List<IssueReport> getIssues() {
        return repository.findAll();
    }

}
