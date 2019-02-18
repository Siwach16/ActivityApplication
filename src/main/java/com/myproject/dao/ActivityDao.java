package com.myproject.dao;

import com.myproject.models.Activity;

import java.util.List;

/**
 * Created by tat50037 on 17/12/18.
 */
public interface ActivityDao {
    String addActivity(Activity activity);
    void addActivities(List<Activity> activity);
    Activity getActivityByName(String activityName);
    Activity getActivityById(String id);
    List<Activity> getAllActivities();

    String updateActivity(Activity activity);

    void deleteActivity(String id);
}
