/*
package guru.springframework.couchbasedbexample.config;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CouchbaseConfig {
    Cluster cluster = CouchbaseCluster.create("localhost");
    //CouchbaseEnvironment couchbaseEnvironment = DefaultCouchbaseEnvironment.builder().connectTimeout(10000).kvTimeout(3000).build();
    Bucket bucket = cluster.openBucket("SpringFrameworkGuruOne");
    JsonObject jsonObject = JsonObject.empty().put("bookId","B100").put("name", "Book1").put("isbnNumber", 1234);
    String id = UUID.randomUUID().toString();
    JsonDocument jsonDocument = JsonDocument.create(id, jsonObject);
    JsonDocument inserted = bucket.insert(jsonDocument);


}
*/
