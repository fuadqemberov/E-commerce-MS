package az.company.msorder.client;

import az.company.msorder.exception.CustomFeignException;
import com.fasterxml.jackson.databind.JsonNode;
import feign.Response;
import feign.codec.ErrorDecoder;



import static  az.company.msorder.exception.ErrorMessages.*;
import static az.company.msorder.util.MapperUtil.MAPPER_UTIL;

public class CustomErrorDecoder  implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
       var status = response.status();
       var errorMessage = CLIENT_ERROR.getMessage();

       JsonNode jsonNode;

       try (var body = response.body().asInputStream()){
              jsonNode = MAPPER_UTIL.map(body,JsonNode.class);
       }
       catch (Exception exception){
         throw new CustomFeignException(CLIENT_ERROR.getMessage(),status);
       }

       if(jsonNode.has(JsonFieldName.MESSAGE.getMessage())){
           errorMessage = jsonNode.get(JsonFieldName.MESSAGE.getMessage()).asText();
       }
       return new CustomFeignException(errorMessage,status);
    }
}
