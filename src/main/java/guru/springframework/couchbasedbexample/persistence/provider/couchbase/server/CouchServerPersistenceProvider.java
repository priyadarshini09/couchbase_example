package guru.springframework.couchbasedbexample.persistence.provider.couchbase.server;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
public class CouchServerPersistenceProvider {
    static final String COUCHBASE_SERVER_HOST_NAME = "127.0.0.1";
    static final String COUCHBASE_SERVER_BUCKET_NAME = "springframeworkguru";
    static final String COUCHBASE_SERVER_BUCKET_PASSWORD = "";

    @Bean
    public Bucket getBucket(){
        Bucket secureBucket = null;
        Cluster cluster = CouchbaseCluster.create(Arrays.asList(COUCHBASE_SERVER_HOST_NAME));
        if(COUCHBASE_SERVER_BUCKET_PASSWORD.isEmpty()){
           secureBucket = cluster.openBucket(COUCHBASE_SERVER_BUCKET_NAME, 30L, TimeUnit.SECONDS);
        }else {
            secureBucket = cluster.openBucket(COUCHBASE_SERVER_BUCKET_NAME, COUCHBASE_SERVER_BUCKET_PASSWORD,30L, TimeUnit.SECONDS);
        }
        return secureBucket;
    }
}
