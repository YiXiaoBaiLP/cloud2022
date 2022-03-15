package buzz.yixiaobai.springcloud.service.impl;

import buzz.yixiaobai.springcloud.dao.PaymentDao;
import buzz.yixiaobai.springcloud.entities.Payment;
import buzz.yixiaobai.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author yixiaobai
 * @date 2022/03/15 19:39
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }

    /**
     * 查询多条数据
     * @param offset 查询启始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Payment> queryAllByLimit(int offset, int limit) {
        return paymentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insert(Payment payment) {
        this.paymentDao.insert(payment);
        return payment;
    }

    /**
     * 修改数据
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment update(Payment payment) {
        this.paymentDao.update(payment);
        return payment;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Long id) {
        return this.paymentDao.deleteById(id) > 0;
    }
}
