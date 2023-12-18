package com.example.newsroom;

import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api ="92c99c5b03cd457a94ae84432d7afff2";

    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country ="in";

    private RecyclerView recyclerViewofHome;

@Nullable
@Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
    View v=inflater.inflate(R.layout.homefragment,null);

    recyclerViewofHome = v.findViewById(R.id.recyclerViewofHome);
    modelClassArrayList=new ArrayList<>();
    recyclerViewofHome.setLayoutManager(new LinearLayoutManager(getContext()));
    adapter=new Adapter(getContext(),modelClassArrayList);
    recyclerViewofHome.setAdapter(adapter);

    findNews();


    return  v;
}
 // below is the actual method to fetch the actual data from the api using retrofit
    private void findNews() {

    ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<mainNews>() {
        @Override
        public void onResponse(Call<mainNews> call, Response<mainNews> response) {
            if(response.isSuccessful()){
                modelClassArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Call<mainNews> call, Throwable t) {


        }
    });

    }

}
