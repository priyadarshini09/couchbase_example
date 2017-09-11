package guru.springframework.couchbasedbexample.dataaccess;

import guru.springframework.couchbasedbexample.dataaccess.factory.DataAccessFactory;

public abstract class AbstractDataAccessAPI {
    public abstract String save(String object) throws Exception;
    public abstract DataAccessFactory.SupportedDatabase type();
    public abstract void delete(String documentId)throws Exception;
    public abstract Long getAutoIncrementedValue() throws Exception;
    public abstract String getFilteredResultsById(String id) throws Exception;
}
