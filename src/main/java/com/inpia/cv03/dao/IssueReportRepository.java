package com.inpia.cv03.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface IssueReportRepository extends JpaRepository<IssueReport, Long> {

    LinkedList<IssueReport> findByDescription(String description);

}
