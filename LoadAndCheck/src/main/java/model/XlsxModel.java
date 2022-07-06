package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class XlsxModel {

    //Или кириллица, или латиница
    String series;

    //Или кириллица, или латиница
    String type;

    //Только латиница
    String article;

    //Не нулевое поле
    String name;

    //Массив, не меньше 1 символа, не больше 8
    /*int[] execution;*/
    //Пока побудет Стрингом
    String execution;

    //Могут быть пустые
    int length;

    int width;

    int height;

    double thickness;

    double weight;

    //Может быть пустой
    double perforation;

    //Может быть пустой
    int step;

    String commentSeries;
    String commentType;
    String commentArticle;
    String commentName;
    String commentExecution;
    String commentWeight;
}
