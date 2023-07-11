package com.makongit.store.controller;

import com.makongit.store.service.ex.*;
import com.makongit.store.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    /** 操作成功的状态码 */
    public static final int OK = 200;

    /** @ExceptionHandler用于统一处理方法抛出的异常 */
    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("密码匹配失败");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("地址数量超出上限，最大地址数量是20条");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("地址不存在");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("非法访问他人地址");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("产品找不到异常");
        }else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("购物车产品找不到异常");
        }
        else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("用户注册失败");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("用户信息更新失败");
        }else if (e instanceof DeleteException) {
            result.setState(5002);
            result.setMessage("用户删除失败");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("文件为空异常");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("文件上传大小超出限制异常");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("文件类型不匹配");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("文件状态异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("文件读写异常");
        }
        return result;
    }

    /**
     * 从HttpSession对象中获取uid
     * @param session HttpSession对象
     * @return 当前登录的用户的id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从HttpSession对象中获取用户名
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
    /**
     * 从HttpSession对象中获取avatar
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getAvatarFromSession(HttpSession session) {
        return session.getAttribute("avatar").toString();
    }
}
