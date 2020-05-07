package c.rowmapper.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Dao dao;

    @GetMapping("/requestparams")
    @ResponseBody
    public Order get(
            @RequestParam
                    String orderId) {
        System.out.println("OrderId: " + orderId);
        return dao.getById(orderId);
    }
}
