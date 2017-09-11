package guru.springframework.couchbasedbexample.dataaccess.couchbase.server;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import guru.springframework.couchbasedbexample.dataaccess.AbstractDataAccessAPI;
import guru.springframework.couchbasedbexample.dataaccess.factory.DataAccessFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouchbaseServerDataAccessImpl extends AbstractDataAccessAPI{

    @Autowired
    private Bucket couchbaseSErverBucket;

    static final String COUCHBASE_SERVER_BUCKET_NAME = "springframeworkguru";

    @Override
    public String save(String object) throws Exception {
        JSONObject jsonObject = new JSONObject(object);
        String documentId = jsonObject.getString("id");
        JsonDocument jsonDocument = JsonDocument.create(documentId, JsonObject.fromJson(object));
        couchbaseSErverBucket.upsert(jsonDocument);
        return getFilteredResultsById(documentId);
    }

    @Override
    public DataAccessFactory.SupportedDatabase type() {
        return DataAccessFactory.SupportedDatabase.COUCHBASESERVER;
    }

    @Override
    public void delete(String documentId) throws Exception {
        couchbaseSErverBucket.remove(documentId);
    }

    @Override
    public Long getAutoIncrementedValue() throws Exception {
        couchbaseSErverBucket.counter("idGenerator",0 , 0);
        return couchbaseSErverBucket.counter("idGenerator", 1).content();
    }

    @Override
    public String getFilteredResultsById(String id) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM");
        query.append(" ").append(COUCHBASE_SERVER_BUCKET_NAME).append(" WHERE id = '").append(id).append("'");
        N1qlQueryResult queryResult = couchbaseSErverBucket.query(N1qlQuery.simple(query.toString()));
        for (N1qlQueryRow queryRow : queryResult){
            JsonObject jsonObject = (JsonObject) queryRow.value().get(COUCHBASE_SERVER_BUCKET_NAME);
            return jsonObject.toString();
        }
        return "Resource id not available";
    }
}
