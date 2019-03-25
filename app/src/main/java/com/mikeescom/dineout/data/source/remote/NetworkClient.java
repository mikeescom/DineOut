package com.mikeescom.dineout.data.source.remote;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    private NetworkInterface dineOutApi;

    NetworkClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/api/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        dineOutApi = retrofit.create(NetworkInterface.class);
    }

    Observable<String> getCategories() {
        return dineOutApi.getCategories()
                .flatMapIterable(x -> x)
                .flatMap(repo -> dineOutApi.listRepoContributors(userName, repo.getName()))
                .flatMapIterable(x -> x)
                .filter(c -> c.getContributions() > 100)
                .sorted((a, b) -> b.getContributions() - a.getContributions())
                .map(Contributor::getName)
                .distinct();
    }
}
