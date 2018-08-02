package com.css.aimstar.aimstar.networking;

/**
 * Created by sirajm on 21/10/17.
 */


import com.css.aimstar.aimstar.model.CourseDetails;
import com.css.aimstar.aimstar.model.CourseDetailsModelList;
import com.css.aimstar.aimstar.model.NearbyCollegesList;
import com.css.aimstar.aimstar.model.StoryModelList;
import com.css.aimstar.aimstar.model.TrackList;
import com.css.aimstar.aimstar.model.TweetList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by sirajm on 06/06/17.
 */

public class Apis {
    private static final String APIPATH = "http://10.0.2.2:3000";


    private static ApiService apiService = null;

    public static ApiService getApi() {
        if (apiService == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }

    public interface ApiService {


        @GET("/api/v0.0.1/tweets")
        Call<TweetList> getTweets();
        @GET("/api/v0.0.1/stories")
        Call<StoryModelList> getStoryData();
        @GET("/api/v0.0.1/collegelist")
        Call<NearbyCollegesList> getCollegelist();
        @GET("/api/v0.0.1/track")
        Call<TrackList> getTracks();
      //  Call<CourseDetailsModelList> getCollegeList();
//        @GET("/api/v0.0.1/subcategory")
//        Call<SubCategoryList> getSubCategoryList(@Query("category_id") Integer ctId);


//        @GET("/eapp/contrylist.php")
//        Call<CountryList> getResults();
//
//        @GET("/eapp/stateslist.php")
//        Call<StateList> getStateResults(@Query("country_id") Integer countryId);
//
//        @GET("/eapp/citieslist.php")
//        Call<CityList> getCityResults(@Query("state_id") Integer stateId);
//
//        @GET("/eapp/feedsbycountries.php")
//        Call<FeedList> getFeedLists(@Query("country_id") Integer countryId, @Query("ctype") String type);
//
//        @GET("/eapp/feedsbystate.php")
//        Call<FeedList> getStateFeedLists(@Query("country_id") Integer countryId, @Query("state_id") Integer stateId, @Query("ctype") String type);
//
//        @GET("/eapp/feedsbycity.php")
//        Call<FeedList> getCityFeedLists(@Query("country_id") Integer countryId, @Query("state_id") Integer stateId, @Query("city_id") Integer cityId, @Query("ctype") String type);
//        @Multipart
//        @POST("/eapp/retrofit_client.php")
//        Call<ServerResponse> uploadFile(@Part MultipartBody.Part file, @Part("file") RequestBody name);
//
//        @FormUrlEncoded
//        @POST("/eapp/postfeeds.php")
//        Call<Value> insertData(@Field("feeds_desc") String feeds_desc,
//                               @Field("feeds_pic") String feeds_pic,
//                               @Field("user_id") Integer userId,
//                               @Field("country_id") Integer countryId,
//                               @Field("state_id") Integer stateId,
//                               @Field("city_id") Integer cityId,
//                               @Field("type") String type);
//
//
//
//
//
//
//        @FormUrlEncoded
//        @POST("/eapp/user_registration/ar/index.php")
//        Call<Result> logindata(@Field("email") String email,
//                               @Field("upass") String password);
//
//        @FormUrlEncoded
//        @POST("/eapp/user_registration/ar/fpass.php")
//        Call<Result> resetpassword(@Field("remail") String remail);
//
//        @FormUrlEncoded
//        @POST("/eapp/user_registration/ar/fpass.php")
//        Call<Result> resetpassword1(@Field("code") String code,
//                                    @Field("newpass") String newpass,
//                                    @Field("rmail") String rmail);




        /*----------------------------------Shoppers APIS--------------------------------------*/


//        @GET("/eapp/stores/show_store_name.php")
//        Call<StoreList> getStores(@Query("attribute_set") Integer attributeSetId);
//
//
//        @GET("/eapp/stores/show_categories.php")
//        Call<CategoryList> getCategories(@Query("store_id") Integer storeId,@Query("attribute_sid") Integer attributeSetId);
//
//        @GET("/eapp/stores/show_product.php")
//        Call<ProductList> getProducts(@Query("store_id") Integer storeId,@Query("attribute_sid") Integer attributeSetId,@Query("category_id") Integer categoryId,@Query("subcategory_id") Integer subCategoryId);

        /*----------------------------------Nodejs APIS--------------------------------------*/


//        @GET("/api/v1/countries")
//        Call<CountryList> getResults();


//          @GET("/api/v1/stateslist")
//          Call<StateList> getStateResults(@Query("country_id") Integer countryId);


//        @GET("/api/v1/citieslist")
//        Call<CityList> getCityResults(@Query("state_id") Integer stateId);


//        @GET("/api/v1/feedsbycountries")
//        Call<FeedList> getFeedLists(@Query("country_id") Integer countryId, @Query("ctype") String type);

//        @GET("/api/v1/feedsbystates")
//        Call<FeedList> getStateFeedLists(@Query("country_id") Integer countryId, @Query("state_id") Integer stateId, @Query("ctype") String type);

 //       @GET("/api/v1/feedsbycities")
 //       Call<FeedList> getCityFeedLists(@Query("country_id") Integer countryId, @Query("state_id") Integer stateId, @Query("city_id") Integer cityId, @Query("ctype") String type);


    }
}

