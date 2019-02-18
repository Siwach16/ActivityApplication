package com.myproject.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.dao.ActivityDao;

import com.myproject.models.Activity;

import lombok.Setter;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;


/**
 * Created by tat50037 on 18/12/18.
 */
@Singleton
@Setter
public class ActivityService {
    @Inject
    ActivityDao activityDao;

    public String addActivity(Activity activity) throws IOException {
        String id=activityDao.addActivity(activity);
        activity.setActivityId(id);
        indexActivity(activity);
        return id;
    }

    public Activity getActivityByName(String activityName){
        return activityDao.getActivityByName(activityName);
    }

    public List<Activity> getAllActivities(){
        return activityDao.getAllActivities();
    }

    public String updateActivity(Activity activity) throws IOException {
        String id=activityDao.updateActivity(activity);
        activity.setActivityId(id);
        indexActivity(activity);
        return id;
    }

    private void indexActivity(Activity activity) throws IOException {
        HttpPost postRequest = new HttpPost(
                "http://localhost:8084/index");
        postRequest.setHeader("Content-Type","application/json");
        postRequest.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(activity)));
        HttpResponse response=new DefaultHttpClient().execute(postRequest);
    }

    private void deleteActivityIndex(String activityID) throws IOException {
        HttpDelete postRequest = new HttpDelete(
                "http://localhost:8084/deleteActivity/"+activityID);
        HttpResponse response=new DefaultHttpClient().execute(postRequest);
    }

    public Activity deleteActivityById(String id) throws IOException {
        deleteActivityIndex(id);
        activityDao.deleteActivity(id);
        return null;
    }
}
