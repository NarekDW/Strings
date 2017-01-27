package com.epam.courses.strings.t03;

import org.junit.Test;
import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Narek on 26.01.2017.
 */
public class ReadFileTest {
    private File file =
            new File("Java.SE.03.Information handling_task_attachment.html");
    private ReadFile readFile = new ReadFile(file);

    @Test
    public void isRightSequenceTest(){
        assertThat(readFile.isRightSequence(), is(false));
    }

    @Test
    public void referencesTest(){
        String initial = readFile.getInitialText();
        String refsents = readFile.getRefSentences();
        assertThat(readFile.refAmount(initial), is(readFile.refAmount(refsents)));
    }
}