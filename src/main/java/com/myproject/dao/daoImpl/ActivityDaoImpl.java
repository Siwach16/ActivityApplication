package com.myproject.dao.daoImpl;

import com.myproject.dao.ActivityDao;
import com.myproject.models.Activity;
import com.myproject.utils.annotation.Carrier;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tat50037 on 17/12/18.
 */
public class ActivityDaoImpl implements ActivityDao {

    @Inject
    @Carrier(value = {"localhost:Tags"})
    Datastore mongoDataStore;

    public String addActivity(Activity activity) {
        return mongoDataStore.save(activity).getId().toString();
    }

    public void addActivities(List<Activity> activities) {

    }


    public Activity getActivityByName(String activityName) {
        return mongoDataStore.createQuery(Activity.class).field("activityName").equalIgnoreCase(activityName).get();
    }

    public Activity getActivityById(String id) {
        return mongoDataStore.get(Activity.class, new ObjectId(id));
    }

    public List<Activity> getActivities(List<Activity> activities) {
        return null;
    }

    public List<Activity> getAllActivities() {
        List<Activity> query=mongoDataStore.createQuery(Activity.class).asList();
        return query;
    }

    @Override
    public String updateActivity(Activity activity) {
        return mongoDataStore.save(activity).getId().toString();
    }

    @Override
    public void deleteActivity(String id) {
        mongoDataStore.delete(Activity.class,new ObjectId(id));
    }
}
