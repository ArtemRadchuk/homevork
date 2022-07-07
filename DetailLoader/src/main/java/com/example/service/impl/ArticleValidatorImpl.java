package service.impl;

import service.ArticleValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleValidatorImpl implements ArticleValidator {

    @Override
    public boolean validator(String article){
        Pattern pattern = Pattern.compile("^[A-Z0-9]+$");
        Matcher matcher = pattern.matcher(article);
        return matcher.matches();
    }

    @Override
    public String articleComment(String article){
        if (!validator(article) || article.equals("")){
            return "Поле \"Артикул\" не должно содержать русских букв";
        }else {
            return null;
        }
    }
}
