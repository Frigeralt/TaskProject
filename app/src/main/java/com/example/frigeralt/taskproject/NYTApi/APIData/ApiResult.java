package com.example.frigeralt.taskproject.NYTApi.APIData;

import com.example.frigeralt.taskproject.NYTApi.APIData.APIMediaData.MediaData;

import java.util.List;

public class ApiResult {
    public String _abstract;
    public String adx_keywords;
    public Long asset_id;
    public String byline;
    public String column;
    public String count_type;

    /* Remove facets as they can sometimes be arrays of string
     ("org_facet":["HAPPINESS","HARVARD UNIVERSITY"]) or empty string ( "org_facet":"" )
    * */
    //public String[] org_facet = null;
    //public String[] per_facet = null;
    //public String[] geo_facet = null;
    //public String[] des_facet = null;


    public Long eta_id;
    public Long id;
    public MediaData[] mediaData = null;
    public String nytdsection;
    public String published_date;
    public String section;
    public Long share_count;
    public String source;
    public String subscription;
    public String title;
    public String updated;
    public String uri;
    public String url;

}
