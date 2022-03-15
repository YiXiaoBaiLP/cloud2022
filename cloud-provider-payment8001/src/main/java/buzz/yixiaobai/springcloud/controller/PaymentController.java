package buzz.yixiaobai.springcloud.controller;

import buzz.yixiaobai.springcloud.entities.CommonResult;
import buzz.yixiaobai.springcloud.entities.Payment;
import buzz.yixiaobai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (payment)表控制层
 * @author yixiaobai
 * @create 2022/03/15 下午7:58
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("数据查询成功");
        return new CommonResult<>(200, "select success", payment);
    }
}
