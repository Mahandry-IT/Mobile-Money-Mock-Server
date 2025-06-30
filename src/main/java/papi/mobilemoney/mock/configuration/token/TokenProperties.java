package papi.mobilemoney.mock.configuration.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "token")
@Data
public class TokenProperties {

    private Authorization authorization;
    private Validity validity;
    private  Identity identity;
    private int ByteLength;

}
