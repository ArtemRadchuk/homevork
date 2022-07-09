package com.example.service;

public interface SeriesValidator {

    boolean validateLatin(String series);

    boolean validateCyrillic(String series);

    String seriesComment(String series);
}
