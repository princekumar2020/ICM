package com.icm.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="jwt")
public class JwtConfiguration {

	
    public int expirationTimeMin;
    public String secret;
    public String headerName;

    public int getExpirationTimeMin() {
        return expirationTimeMin;
    }

    public void setExpirationTimeMin(int expirationTimeMin) {
        this.expirationTimeMin = expirationTimeMin;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

}
