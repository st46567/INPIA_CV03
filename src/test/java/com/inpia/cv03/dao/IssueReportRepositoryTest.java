package com.inpia.cv03.dao;

import com.inpia.cv03.controller.IssueController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueReportRepositoryTest {

    @Autowired
    IssueReportRepository repository;

    @Test
    public void testSave(){
        IssueReport report = new IssueReport();
        report.setDescription("DDD");
        report.setUrl("UUU");
        repository.save(report);

        assertNotNull(report.getId());

        Optional<IssueReport> fromdb = repository.findById(report.getId());
        assertEquals(fromdb.get().getDescription(), "DDD");
    }

    @Test
    @Transactional
    public void testGetByDescription(){
        IssueReport report = new IssueReport();
        report.setDescription("DDD");
        report.setUrl("UUU");
        repository.save(report);

        IssueReport report2 = new IssueReport();
        report2.setDescription("DDDD");
        report2.setUrl("UUUU");
        repository.save(report2);

        assertEquals(repository.findByDescription("DDD").size(), 1);
    }

}