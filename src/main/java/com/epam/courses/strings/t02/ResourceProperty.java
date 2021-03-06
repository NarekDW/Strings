package com.epam.courses.strings.t02;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Date: 24.01.2017
 * @author Karapetyan N.K
 */
public class ResourceProperty {
    private ResourceBundle resourceBundle;
    @SuppressWarnings("WeakerAccess")
    public ResourceProperty(Locale locale){
        resourceBundle = ResourceBundle.getBundle("text", locale);
    }

    @SuppressWarnings("WeakerAccess")
    public String getQuestion(int numQuestion){
        assert numQuestion > 0;
        return resourceBundle.getString(numQuestion+".q");
    }

    @SuppressWarnings("WeakerAccess")
    public String getAnswer(int numAnswer){
        assert numAnswer > 0;
        return resourceBundle.getString(numAnswer+".a");
    }

    @SuppressWarnings("WeakerAccess")
    public void questionsToDisplay(){
        Enumeration e=resourceBundle.getKeys();
        String key;
        int questionNum=0;
        while(e.hasMoreElements()){
            key = String.valueOf(e.nextElement());
            if(key.matches("[\\d]{1,2}[\\.]q"))
                System.out.println(++questionNum+") "
                        +resourceBundle.getString(key));
        }
        System.out.println();
    }

    // Вывод в поток PrintStream всех вопросов, без ответов
    public static void main(String[] args) {
        ResourceProperty eng =
                new ResourceProperty(new Locale("en", "US"));
        ResourceProperty rus =
                new ResourceProperty(new Locale("ru", "RU"));
        ResourceProperty unknown =
                new ResourceProperty(new Locale("fr", "FR"));

        rus.questionsToDisplay();
        eng.questionsToDisplay();
        unknown.questionsToDisplay();
    }
}
