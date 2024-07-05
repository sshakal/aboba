package av.users.manager.Client;

import av.users.manager.Entity.Payloads.UpdateUserPayload;
import av.users.manager.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersRestClient {
    List<User> findAllUsers(String name);
    User createUser(String name,String email,int age);
    Optional<User> findUserById(int id);
    void updateUser(int id, UpdateUserPayload user);
    void deleteUser(int id);
}
