package com.epam.courses.strings.t02;

import org.junit.Test;
import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Narek on 24.01.2017.
 */
public class ResourcePropertyTest {
    private ResourceProperty eng =
            new ResourceProperty(new Locale("en", "US"));
    private ResourceProperty rus =
            new ResourceProperty(new Locale("ru", "RU"));
    private ResourceProperty unknown =
            new ResourceProperty(new Locale("fr", "FR"));

    @Test
    public void resourceTest(){
        assertThat(eng.getQuestion(1),
                is("When does Alexander Pushkin born?"));
        assertThat(eng.getAnswer(1),
                is("1799"));
        assertThat(rus.getQuestion(2),
                is("В каких единицах измеряется магнитный поток?"));
        assertThat(rus.getAnswer(2),
                is("Вебер"));
        assertThat(unknown.getQuestion(3),
                is("Чему равна exp(0)?"));
        assertThat(unknown.getAnswer(3),
                is("1"));
    }
}