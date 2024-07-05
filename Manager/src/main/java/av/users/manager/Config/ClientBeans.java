package av.users.manager.Config;

import av.users.manager.Client.RestClientUsersRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientUsersRestClient productsRestClient(
            @Value("${users.service.list.uri:http://localhost:8081}") String catalogueBaseUri,
            @Value("${users.service.username:}") String username,
            @Value("${users.service.password:}") String password) {
        return new RestClientUsersRestClient(
                RestClient.builder()
                .baseUrl(catalogueBaseUri)
                        .requestInterceptor(new BasicAuthenticationInterceptor(username, password))
                .build());
    }
}
