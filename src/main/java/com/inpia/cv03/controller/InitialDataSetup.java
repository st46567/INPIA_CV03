package com.inpia.cv03.controller;

import com.inpia.cv03.dao.IssueReport;
import com.inpia.cv03.dao.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialDataSetup {

    @Autowired
    IssueReportRepository repository;

    @PostConstruct
    public void addSomeIssues(){
        repository.save(new IssueReport("AAA", "aaa"));
        repository.save(new IssueReport("BBB", "bbb"));
    }

}
