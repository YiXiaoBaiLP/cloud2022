package buzz.yixiaobai.springcloud.dao;

import buzz.yixiaobai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Payment)表数据库访问层
 */
@Mapper
public interface PaymentDao {

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(@Param("id") Long id);

    /**
     * 查询指定行数据
     * @param offset 查询的启始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Payment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     * @param payment 实例对象
     * @return 对象列表
     */
    List<Payment> queryAll(Payment payment);

    /**
     * 新增数据
     * @param payments 实例对象
     * @return 对象列表
     */
    int insert(Payment payments);

    /**
     * 修改数据
     * @param payment 实例对象
     * @return 影响行数
     */
    int update(Payment payment);
    /**
     * 根据主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") Long id);

}
