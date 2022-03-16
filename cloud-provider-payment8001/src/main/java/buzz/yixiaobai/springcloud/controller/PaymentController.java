package buzz.yixiaobai.springcloud.controller;

import buzz.yixiaobai.springcloud.entities.CommonResult;
import buzz.yixiaobai.springcloud.entities.Payment;
import buzz.yixiaobai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        if (payment != null) {
            return new CommonResult<>(200, "select success", payment);
        } else {
            return new CommonResult<>(444, "查询失败，没有找到记录。");
        }
    }

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        Payment paymentInsert = paymentService.insert(payment);
        log.info("--------------------------- 数据插入 -------------------------------");
        if(paymentInsert != null){
            return new CommonResult<>(200, "数据插入成功。", paymentInsert);
        }else{
            return new CommonResult<>(444, "数据插入失败 ！");
        }
    }

    @GetMapping("queryAllByLimit")
    public CommonResult<Payment> queryAllByLimit(@RequestParam(defaultValue = "0") int offset,
                                                 @RequestParam(defaultValue = "10") int limit){

        List<Payment> paymentList = paymentService.queryAllByLimit(offset, limit);

        log.info("--------------------------- 数据查询 -------------------------------");
        if(paymentList != null && paymentList.size() > 0 ){
            for(Payment payment : paymentList){
                return new CommonResult<>(200, "数据查询成功。", payment);
            }
        }

        return new CommonResult<>(444, "数据查询失败！");
    }
}
