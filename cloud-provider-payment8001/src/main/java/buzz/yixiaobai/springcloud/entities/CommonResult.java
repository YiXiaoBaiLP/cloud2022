package buzz.yixiaobai.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yixiaobai
 * @version 1.0 2022-03-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer id;
    private String message;
    private T data;

    public CommonResult(Integer id, String message){
        this(id, message, null);
    }
}
