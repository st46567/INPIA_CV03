package com.inpia.cv03;

import com.inpia.cv03.dao.IssueReport;
import com.inpia.cv03.dao.IssueReportRepository;
import com.inpia.cv03.dao.User;
import com.inpia.cv03.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueReportDataFactory {

    @Autowired Creator creator;

    @Autowired
    private IssueReportRepository issueReportRepository;

    @Autowired
    UserRepository userRepository;

    public void saveIssueReport() {
        saveIssueReport("test@email.cz");
    }

    public void saveIssueReport(String email) {
        //User user = saveUser();
        User user = (User) creator.save(new User());

        IssueReport entity = new IssueReport();
        entity.setEmail(email);
        entity.setUser(user);
        issueReportRepository.save(entity);
    }

    private User saveUser() {
        return saveUser(null);
    }

    private User saveUser(String surname) {
        User user = new User();
        user.setFirstName("Pavel");
        if (surname!=null) user.setLastName(surname);
        else user.setLastName("Jetenský");

        userRepository.save(user);
        return user;
    }


}
