/**
 * Created by tat50037 on 16/12/18.
 */
package com.myproject.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(value = "Activities", noClassnameStored = true)
public class Activity {
    @NotNull
    @Id
    private String activityId;
    @NotNull
    private String activityName;
    private List<String> tags;

}
