package ru.easyjava.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepositoryJdbcIT {
    @Inject
    private CustomerRepositoryJdbc testedObject;

    @Test
    public void testAdd() {
        Number id = testedObject.add("new@example.org");

        assertThat(testedObject.getEmail((Long) id), is("new@example.org"));
    }

}