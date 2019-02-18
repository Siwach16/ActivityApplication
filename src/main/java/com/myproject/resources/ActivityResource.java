/**
 * Created by tat50037 on 16/12/18.
 */
package com.myproject.resources;


import com.myproject.models.Activity;

import com.myproject.service.ActivityService;
import lombok.Setter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
@Setter
public class ActivityResource {

    @Inject
    private ActivityService activityService;

    @GET
    @Path("/getActivity/{name}")
    public Activity getActivity(@PathParam("name") String name){
        return activityService.getActivityByName(name);
    }

    @DELETE
    @Path("/deleteActivity/{id}")
    public Activity deleteActivity(@PathParam("id") String id) throws IOException {
        return activityService.deleteActivityById(id);
    }

    @GET
    @Path("/getAllActivities")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities();
    }

    @POST
    @Path("/addActivity")
    public String addActivity(Activity activity) throws IOException {
        return activityService.addActivity(activity);

    }
    @POST
    @Path("/updateActivity")
    public String updateActivity(Activity activity) throws IOException {
        return activityService.updateActivity(activity);

    }

}
