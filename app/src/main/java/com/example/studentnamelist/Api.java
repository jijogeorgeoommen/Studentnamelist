package com.example.studentnamelist;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @FormUrlEncoded
    @POST("api/School/FullStudentList")
    Call<student_Model>name(@Field("schoolId") int schoolid,@Field("classId") int classid,@Field("divisionId") int divisionid);
}
