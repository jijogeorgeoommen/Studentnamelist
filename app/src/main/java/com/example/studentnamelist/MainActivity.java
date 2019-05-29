package com.example.studentnamelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;

    ArrayList<String>student_name;
    ArrayList<Integer>student_id;

    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_name=new ArrayList<String>();
        student_id=new ArrayList<>();

        initview();

    }

    private void initview(){

        recyclerview=findViewById(R.id.rview);
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager=new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutmanager);


        loadjson();
    }



    private void loadjson (){
        Utils ut = new Utils();
        Call<student_Model> profileModelCall=Utils.getApi().name(10085, 30510,30752);
        profileModelCall.enqueue(new Callback<student_Model>() {
            @Override
            public void onResponse(Call<student_Model> call, Response<student_Model> response) {


                if (response.body().isStatus()==true){

                    List<student_Model.UserDataBean> userdatalist=response.body().getUserData();


                    for(int i=0; i<userdatalist.size();i++){
                        student_name.add(userdatalist.get(i).getStundentName());
                        student_id.add(userdatalist.get(i).getStudentId());
                    }

                }

                adapter=new DataAdapter(student_name);
                recyclerview.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<student_Model> call, Throwable t) {

            }
        });
    }
}
