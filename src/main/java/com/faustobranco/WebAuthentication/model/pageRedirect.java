package com.faustobranco.WebAuthentication.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class pageRedirect {
    private final ArrayList<HashMap<String, String>> lst_pageRedirect;

    public pageRedirect(ArrayList<HashMap<String, String>> lst_pageRedirect) {
        this.lst_pageRedirect = lst_pageRedirect;
    }

    public ArrayList<HashMap<String, String>> getLst_pageRedirect() {
        return lst_pageRedirect;
    }

    public ArrayList<HashMap<String, String>> get_ListbyRole (String role) {
        boolean bol_IncludeNulls = false;
        ArrayList<HashMap<String, String>> arr_FilteredMap = (ArrayList<HashMap<String, String>>)
                lst_pageRedirect
                        .stream()
                        .filter(article -> (article.get("role") == null ? bol_IncludeNulls : String.valueOf(article.get("role")).contains((String)role)))
                        .collect(Collectors.toList());

        return arr_FilteredMap;
    }
    public ArrayList<HashMap<String, String>> get_ListbyPage (String page) {
        boolean bol_IncludeNulls = false;
        ArrayList<HashMap<String, String>> arr_FilteredMap = (ArrayList<HashMap<String, String>>)
                lst_pageRedirect
                        .stream()
                        .filter(article -> (article.get("page") == null ? bol_IncludeNulls : String.valueOf(article.get("page")).contains((String)page)))
                        .collect(Collectors.toList());

        return arr_FilteredMap;
    }

}
