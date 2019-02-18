package com.myproject.utils;

import com.mongodb.MongoClient;
import com.myproject.utils.annotation.Carrier;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;


/**
 * Created by tat50037 on 18/12/18.
 */
@Singleton
public class MongoDataStoreFactory {
    final Morphia morphia = new Morphia();
    @Produces
    private Datastore getMongoDataStore(InjectionPoint ip){
        String connString=((Carrier)ip.getAnnotated().getAnnotation(Carrier.class)).value()[0];
        Datastore ds=morphia.createDatastore(new MongoClient(connString.split(":")[0]),connString.split(":")[1]);
        return ds;
    }
}
