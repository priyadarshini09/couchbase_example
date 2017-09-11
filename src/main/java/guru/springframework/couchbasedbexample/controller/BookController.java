package guru.springframework.couchbasedbexample.controller;

import guru.springframework.couchbasedbexample.dataaccess.couchbase.server.CouchbaseServerDataAccessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    CouchbaseServerDataAccessImpl couchbaseServerDataAccessImpl;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody String book) throws Exception{
        return couchbaseServerDataAccessImpl.save(book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public String get(@PathVariable String id) throws Exception{
        return couchbaseServerDataAccessImpl.getFilteredResultsById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) throws Exception{
        couchbaseServerDataAccessImpl.delete(id);
    }
}
