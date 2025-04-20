package com.rs.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;
@Component
public class YunOSS {
    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    // 填写Bucket名称，例如examplebucket。
    private String bucketName = "efps-sys";

    public String upload(MultipartFile file) throws Exception {

        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 获取文件的原始文件名和扩展名
        String originalFileName = file.getOriginalFilename();
        int index = originalFileName.lastIndexOf(".");
        String extname = originalFileName.substring(index);
        // 生成新的文件名
        String fileName = UUID.randomUUID().toString() + extname;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

        try {
            InputStream inputStream = file.getInputStream();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream);

            // 上传文件到 OSS
            ossClient.putObject(putObjectRequest);

            // 生成文件访问 URL
            String url = "https://" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

            return url;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传文件到 OSS 失败");
        } finally {
            // 关闭 OSSClient 实例
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
