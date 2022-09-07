package com.example.model;


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
    /*int execution;*/
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPerforation() {
        return perforation;
    }

    public void setPerforation(double perforation) {
        this.perforation = perforation;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getCommentSeries() {
        return commentSeries;
    }

    public void setCommentSeries(String commentSeries) {
        this.commentSeries = commentSeries;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public String getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(String commentArticle) {
        this.commentArticle = commentArticle;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentExecution() {
        return commentExecution;
    }

    public void setCommentExecution(String commentExecution) {
        this.commentExecution = commentExecution;
    }

    public String getCommentWeight() {
        return commentWeight;
    }

    public void setCommentWeight(String commentWeight) {
        this.commentWeight = commentWeight;
    }
}
