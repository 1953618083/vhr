/**
 * AjaxResult 类用于封装 HTTP 请求返回的结果。
 */
package com.example.vhr.http;

public class AjaxResult {
    // HTTP 请求返回的状态码
    private Integer status;
    // HTTP 请求返回的消息
    private String msg;
    // HTTP 请求返回的数据对象
    private Object obj;

    /**
     * 构建一个新的 AjaxResult 对象。
     */
    public static AjaxResult build() {
        return new AjaxResult();
    }

    /**
     * 创建一个表示成功的 AjaxResult 对象，并指定返回的消息。
     * @param msg 返回的消息
     * @return AjaxResult 对象
     */
    public static AjaxResult ok(String msg) {
        return new AjaxResult(200, msg, null);
    }

    /**
     * 创建一个表示成功的 AjaxResult 对象，并指定返回的消息和数据对象。
     * @param msg 返回的消息
     * @param obj 返回的数据对象
     * @return AjaxResult 对象
     */
    public static AjaxResult ok(String msg, Object obj) {
        return new AjaxResult(200, msg, obj);
    }

    /**
     * 创建一个表示错误的 AjaxResult 对象，并指定返回的消息。
     * @param msg 返回的消息
     * @return AjaxResult 对象
     */
    public static AjaxResult error(String msg) {
        return new AjaxResult(500, msg, null);
    }

    /**
     * 创建一个表示错误的 AjaxResult 对象，并指定返回的消息和数据对象。
     * @param msg 返回的消息
     * @param obj 返回的数据对象
     * @return AjaxResult 对象
     */
    public static AjaxResult error(String msg, Object obj) {
        return new AjaxResult(500, msg, obj);
    }

    /**
     * 私有构造函数，防止外部直接实例化对象。
     */
    private AjaxResult() {
    }

    /**
     * 私有构造函数，用于构建指定状态码、消息和数据对象的 AjaxResult 对象。
     * @param status 状态码
     * @param msg 消息
     * @param obj 数据对象
     */
    private AjaxResult(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    /**
     * 获取状态码。
     * @return 状态码
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态码。
     * @param status 状态码
     * @return 当前对象
     */
    public AjaxResult setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * 获取消息。
     * @return 消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置消息。
     * @param msg 消息
     * @return 当前对象
     */
    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 获取数据对象。
     * @return 数据对象
     */
    public Object getObj() {
        return obj;
    }

    /**
     * 设置数据对象。
     * @param obj 数据对象
     * @return 当前对象
     */
    public AjaxResult setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
