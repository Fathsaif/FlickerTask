package com.saif.flickertask.connection;

import com.saif.flickertask.models.Data;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("https://api.flickr.com/services/rest/?method=flickr.photos.search" +
            "&api_key=676776ef6d8a02be87dd478c64f1cfc2&format=json&nojsoncallback=1&" +
            "extras=url_l&safe_search=for%20safe&per_page=20&tags=bird")
    Observable<Data> getData();

}

