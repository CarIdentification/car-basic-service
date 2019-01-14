package com.discern.car.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Keben on 2019-01-03.
 */
public class ImageUtil {


    /**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @return 返回文件名
     * @throws IOException
     */
    public String saveImg(MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = System.currentTimeMillis() + ".jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
