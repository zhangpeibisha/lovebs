package org.nix.zpbs.config;


import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;


/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@Service
public class MyUserDetailsServiceImpl implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String username) throws ClientRegistrationException {
        return null;
    }
}
