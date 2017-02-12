package com.epam.courses.strings.t03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 26.01.2017
 * @author Karapetyan N.K
 */
public class ReadFile {
    private static final String REFREGEX = "[\\(][Рр]ис[\\.][\\s]*(([(\\d]{1,2})[^\\)]*[\\)])";
    private static final String SENTREGEX = "([А-ЯЁ])+" +
            "((([СО]<sub>([\\d]|[a-z])*</sub>)|С[\\d]{2}|" +
            "[а-яё]|[a-z]|[\\–«»]|[\\s]|[\\d]|[\\p{Punct}])*"+
            "([\\(][Рр]ис[\\.][\\s]*(([(\\d]{1,2})[^\\)]*[\\)])))+" +
            "((э.д.с.)|[^\\.!?])*[\\.!?]";
    private StringBuilder text = new StringBuilder();
    private StringBuilder sentences = new StringBuilder();
    private Pattern p;
    private Matcher m;
    @SuppressWarnings("WeakerAccess")
    public ReadFile(File file){
        assert file != null;
        read(file);
    }

    @SuppressWarnings("WeakerAccess")
    public boolean isRightSequence(){
        p = Pattern.compile(REFREGEX);
        m = p.matcher(text);
        int previous = -1;
        int current;
        while(m.find()) {
            current = Integer.valueOf(m.group(2));
            if(previous>current)
                return false;
            previous = current;
        }
        return true;
    }

    @SuppressWarnings("WeakerAccess")
    public String getRefSentences(){
        p = Pattern.compile(SENTREGEX);
        m = p.matcher(text);
        while(m.find())
            sentences.append(m.group()).append("\n");
        return sentences.toString();
    }

    @SuppressWarnings("WeakerAccess")
    public String getInitialText(){
        return text.toString();
    }

    @SuppressWarnings("WeakerAccess")
    public int refAmount(CharSequence info){
        p = Pattern.compile(REFREGEX);
        m = p.matcher(info);
        int x=0;
        while(m.find())
            x++;
        return x;
    }

    private void read(File file) {
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), "cp1251")
            )){
                String str;
                while((str = br.readLine())!=null){
                    text.append(str);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file =
                new File("Java.SE.03.Information handling_task_attachment.html");
        ReadFile readFile = new ReadFile(file);
        System.out.print(readFile.getRefSentences());
        }
}
