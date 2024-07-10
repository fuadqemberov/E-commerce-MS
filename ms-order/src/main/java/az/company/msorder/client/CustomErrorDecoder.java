package az.company.msorder.client;

import az.company.msorder.exception.CustomFeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import static  az.company.msorder.exception.ErrorMessages.*;
public class CustomErrorDecoder  implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() >= 400 && response.status()<=499){
            return new CustomFeignException(CLIENT_ERROR.getMessage());
        }
        if(response.status() >= 500 && response.status()<=599){
            return new CustomFeignException(SERVER_ERROR.getMessage());
        }

        return defaultErrorDecoder.decode(methodKey,response);
    }
}
