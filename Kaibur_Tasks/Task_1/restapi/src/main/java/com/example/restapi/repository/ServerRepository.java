package com.example.restapi.repository;

import java.util.List;
import java.util.Optional;

import com.example.restapi.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Interface for performing CRUD operations on the Server collection in MongoDB
 * This interface extends the MongoRepository interface to provide database operations on the Server model.
 * It defines methods to find a server by name containing a given substring and to find a server by ID.
 * The methods are implemented automatically by Spring Data MongoDB based on method name conventions.
 */
@CrossOrigin(origins = "http://localhost:3000")
public interface ServerRepository extends MongoRepository<Server, String> {

    /**
     * Find servers by name containing the given substring
     * @param name the substring to search for in server names
     * @return a list of servers whose names contain the given substring
     */
    List<Server> findByNameContaining(String name);

    /**
     * Find a server by ID
     * @param id the ID of the server to find
     * @return an Optional containing the server with the given ID, or empty if not found
     */
    Optional<Server> findById(String id);
}
//Code Written By @Arpit Singh - 19BCG10069