package com.epam.courses.strings.t01;

import org.junit.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Narek on 23.01.2017.
 */
public class CrazyLoggerTest {
    private static TimeZone timeZone = TimeZone.getTimeZone("Europe/Moscow");
    private static Calendar calendar =
            new GregorianCalendar(timeZone);
    private static DateFormat dateFormat =
            new SimpleDateFormat("dd-MM-yyyy : HH-mm");
      @Test
    public void test5() throws InterruptedException {
          CrazyLogger.setLog("Java SE");
          assertThat(CrazyLogger.getLog(),
                  is(dateFormat.format(calendar.getTime())+" - Java SE\n"));
          assertThat(CrazyLogger.searchLog("Java SE"),
                  is(dateFormat.format(calendar.getTime())+" - Java SE\n"));
    }
}