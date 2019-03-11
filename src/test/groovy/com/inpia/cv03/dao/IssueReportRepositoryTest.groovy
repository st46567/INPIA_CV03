package com.inpia.cv03.dao


import javax.transaction.Transactional;

import com.inpia.cv03.dao.IssueReport;
import com.inpia.cv03.dao.IssueReportRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import com.inpia.cv03.Creator;

@RunWith(SpringRunner.class)
@Import(Creator.class)
@DataJpaTest
@Transactional
public class IssueReportRepositoryTest {
    @Autowired
    Creator creator;

    @Autowired
    IssueReportRepository issueReportRepository;

    @Test
    public void testFindAllByEmail() {
        creator.save(new IssueReport(email: "e1"));
        creator.save(new IssueReport(email: "e2", user: creator.save(new User(lastName: "kodym"))));
        creator.save(new IssueReport(email: "e3"));

        Assert.assertEquals(issueReportRepository.findAllByEmail("e2").size(), 1);


    }


}