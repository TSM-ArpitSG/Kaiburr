package io.swagger.api;

import io.swagger.model.Server;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ServerRepository {
    /**
     * Get a list of all servers.
     *
     * @return List of Server objects.
     */
    List<Server> getAllServers();

    /**
     * Get a specific server by its ID.
     *
     * @param id The ID of the server to retrieve.
     * @return An Optional containing the Server object if found, or an empty Optional if not found.
     */
    Optional<Server> getServerById(String id);

    /**
     * Save a new server to the repository.
     *
     * @param server The Server object to be saved.
     * @return The saved Server object.
     */
    Server saveServer(Server server);

    /**
     * Delete a server from the repository.
     *
     * @param id The ID of the server to be deleted.
     */
    void deleteServer(String id);

    /**
     * Find all servers that match the specified name.
     *
     * @param name The name to search for.
     * @return List of Server objects that match the name.
     */
    List<Server> findServersByName(String name);

}
//Code Written By @Arpit Singh - 19BCG10069