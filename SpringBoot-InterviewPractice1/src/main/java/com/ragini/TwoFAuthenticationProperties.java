package com.ragini;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "feature.2fa")

@Component
public class TwoFAuthenticationProperties {

    private boolean enabled ;

    public String getProvier() {
        return provier;
    }

    public void setProvier(String provier) {
        this.provier = provier;
    }

    private String provier ;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
