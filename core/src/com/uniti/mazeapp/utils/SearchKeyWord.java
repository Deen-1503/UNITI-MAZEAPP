package com.uniti.mazeapp.utils;


public enum SearchKeyWord {

    BK1(Keys.BK1, new String[]{"bk1", "bilik kuliah 1"}),
    BK2(Keys.BK2, new String[]{"bk2", "bilik kuliah 2"}),
    BK13(Keys.BK13, new String[]{"bk2", "bilik kuliah 2"}),
    BK14(Keys.BK14, new String[]{"bk2", "bilik kuliah 2"}),
    LIBRARY(Keys.LIBRARY, new String[]{"bk2", "bilik kuliah 2"}),

    ;

    private final Short mIndex;
    private final String[] mTextInput;

    SearchKeyWord(Short index, String[] textInput) {
        mIndex = index;
        mTextInput = textInput;
    }

    public Short getIndex() {
        return mIndex;
    }

    public String[] getText() {
        return mTextInput;
    }
}
