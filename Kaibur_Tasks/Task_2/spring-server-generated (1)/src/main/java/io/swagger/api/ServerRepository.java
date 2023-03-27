package io.swagger.api;

import io.swagger.model.Server;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ServerRepository {

    List<Server> getAllServers();

    Optional<Server> getServerById(String id);

    Server saveServer(Server server);

    void deleteServer(String id);

    List<Server> findServersByName(String name);
}
