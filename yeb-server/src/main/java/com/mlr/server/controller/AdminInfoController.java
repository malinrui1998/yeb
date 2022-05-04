package com.mlr.server.controller;

import com.mlr.server.pojo.Admin;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.service.IAdminService;
import com.mlr.server.utils.FastDFSUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 个人中心
 *
 * @author: mlr
 * @date: 2022/4/16 17:05
 * @since: 1.0.0
 */
@RestController
public class AdminInfoController {
    @Resource
    IAdminService adminService;

    @ApiOperation(value = "更新当前用户信息")
    @PutMapping("/admin/info")
    public RespBean updateAdmin(@RequestBody Admin admin, Authentication authentication) {
        if (adminService.updateById(admin)) {
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            admin, null, authentication.getAuthorities()
                    )
            );
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "更新用户密码")
    @PutMapping("/admin/pass")
    public RespBean updateAdminPassword(@RequestBody Map<String, Object> info) {
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer adminId = (Integer) info.get("adminId");
        return adminService.updateAdminPassword(oldPass, pass, adminId);

    }

//    @ApiOperation(value = "更新用户密码1")
//    @PutMapping("/admin/pass")
//    public RespBean updateAdminPassword1(@RequestBody Map<String, Object> info) {
//        String pass = (String) info.get("pass");
//        Integer adminId = (Integer) info.get("adminId");
//        return adminService.updateAdminPassword1(pass,adminId);
//
//    }

    @ApiOperation(value = "更新用户头像")
    @PostMapping("/admin/userface")
    public RespBean updateAdminUserFace(MultipartFile file, Integer id, Authentication authentication) {
        //获取文件上传地址
        String[] uploadPath = FastDFSUtils.upload(file);
        String url = FastDFSUtils.getTrackerUrl() + uploadPath[0] + "/" + uploadPath[1];
        return adminService.updateAdminUserFace(url, id, authentication);
    }
}
