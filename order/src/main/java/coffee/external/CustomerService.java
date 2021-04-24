
package coffee.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="customer", url="http://localhost:8081")
public interface CustomerService {

    @RequestMapping(method= RequestMethod.GET, path="/customers")
    public void checkAndModifyPoint(@RequestBody Customer customer);

}