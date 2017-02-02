# spring-data-mybatis-testing

Sample repo for bugs demos 
 
    git clone git@github.com:kopax/spring-data-mybatis-testing.git
    
## Projection

__Mybatis commit version : f22774e__ (approx 1.0.8.SNAPSHOT, after this commit spring-data-mybatis is corrupt)

Ticket https://github.com/hatunet/spring-data-mybatis/issues/85

    git checkout projection
    ./gradlew build --info && java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Test

    curl http://localhost:8080/siteContents
    
### Expected

HTTP 200
    
### Result

    {"timestamp":1486030282864,"status":500,"error":"Internal Server Error","exception":"org.springframework.http.converter.HttpMessageNotWritableException","message":"Could not write content: Projection type must be an interface! (through reference chain: org.springframework.hateoas.Resources[\"_embedded\"]->java.util.Collections$UnmodifiableMap[\"siteContents\"]->java.util.ArrayList[0]->org.springframework.data.rest.webmvc.json.PersistentEntityJackson2Module$ProjectionResource[\"content\"]->com.sun.proxy.$Proxy118[\"siteFunction\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Projection type must be an interface! (through reference chain: org.springframework.hateoas.Resources[\"_embedded\"]->java.util.Collections$UnmodifiableMap[\"siteContents\"]->java.util.ArrayList[0]->org.springframework.data.rest.webmvc.json.PersistentEntityJackson2Module$ProjectionResource[\"content\"]->com.sun.proxy.$Proxy118[\"siteFunction\"])","path":"/siteContents"}
    


    

        
