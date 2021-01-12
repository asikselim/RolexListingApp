package com.h5180054.selim_asik_final.network;




import com.h5180054.selim_asik_final.model.SaatModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("rolex.json")
    Observable<List<SaatModel>> saatleriGetir();
}
