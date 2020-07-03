package com.lankeren.auction;

import com.sun.deploy.util.StringUtils;
import javafx.util.converter.LocalDateTimeStringConverter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//@SpringBootTest
class AuctiononlinesysApplicationTests {

    @Test
    void contextLoads() {

        String[] strings = StringUtils.splitString("[]", "[]");
        System.out.println(strings.length);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now()));
        System.out.println(LocalDateTime.parse("2020-06-24 19:13:55", formatter));

    }

}
