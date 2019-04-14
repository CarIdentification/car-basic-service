package com.discern.car;

import com.discern.car.entity.SearchHistory;
import com.discern.car.service.SearchHistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 11/04/2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearchHistoryServiceTest {
    @Autowired
    private SearchHistoryService searchHistoryService;

    @Test
    public void insert(){
        SearchHistory record = new SearchHistory();
        record.setContent("11");
        record.setId(1000000000);
        record.setUserId(10000);
        searchHistoryService.insert(record);
    }

}
