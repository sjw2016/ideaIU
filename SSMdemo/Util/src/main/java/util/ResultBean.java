package util;

import java.io.Serializable;

public class ResultBean <T> implements Serializable {
    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    private static final long serialVersionUID = -783585909126800171L;
    /**
     * 没有登录
     */
    public static final int NO_LOGIN = -1;
    /**
     * 失败
     */
    public static final int FAIL = 0;
    /**
     * 成功
     */
    public static final int SUCCESS = 1;
    /**
     * 返回信息
     */
    private String msg = "success";
    /**
     * 提示码
     */
    private int code = SUCCESS;
    /**
     * 数据
     */
    private T data;

    public ResultBean(){super();}

    /**
     * 报错
     * @param e
     */
    public ResultBean(Throwable e){
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }


    /**
     * 成功
     * @param data
     * @return
     */
    public ResultBean<T> success(T data){
        ResultBean result = new ResultBean();
        result.setMsg(msg);
        result.setCode(SUCCESS);
        result.setData(data);

        return result;
    }

    /**
     * 失败
     * @param data
     * @return
     */
    public ResultBean<T> error(T data){
        ResultBean result = new ResultBean();
        result.setMsg("fail");
        result.setCode(FAIL);
        result.setData(data);

        return result;
    }

    /**
     * 参数
     * @param args
     * @return
     */
    public ResultBean Lack(String args){
        ResultBean result = new ResultBean();
        result.setMsg("参数："+args+"为必填参数");
        result.setCode(FAIL);
        return result;
    }

    /**
     * 参数null
     * @param args
     * @return
     */
    public ResultBean nulls(String args){
        ResultBean result = new ResultBean();
        result.setCode(FAIL);
        result.setMsg("参数:"+args+"为空");
        return result;
    }

    /**
     * 删除
     * @param bool
     * @return
     */
    public ResultBean<T> bool(Boolean bool){
        ResultBean result = new ResultBean();
        if(bool){
            result.setCode(SUCCESS);
            result.setMsg(msg);
        }else{
            result.setCode(FAIL);
            result.setMsg("fail");
        }
        return result;
    }

    /**
     * 添加成功 或 修改成功
     * @param bool
     * @return
     */
    public ResultBean<T> boolAdd(Boolean bool){
        ResultBean result = new ResultBean();
        if(bool){
            result.setCode(SUCCESS);
            result.setMsg(msg);
        }else{
            result.setCode(FAIL);
            result.setMsg("fail");
        }
        return result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }
}
