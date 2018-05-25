package com.bdqnsxt.oa.utils;

import com.bdqnsxt.oa.conf.application.UploadConfig;
import com.bdqnsxt.oa.exception.ServiceException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jodconverter.DocumentConverter;
import org.jodconverter.office.OfficeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Component
public class FileUtils {

    private static final String DEFAULT_ENCODING = "utf-8";//编码
    private static final int PROTECTED_LENGTH = 512000;// 输入流保护 50KB
    public static final String PDF_SUFFIX = ".pdf";
    public static final String PNG_SUFFIX = ".png";
    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private DocumentConverter documentConverter;

    public File getUploadDirectory(){
        String uploadPath = uploadConfig.getUploadPath();
        File uploadDirectory = new File(uploadPath);
        if(!uploadDirectory.exists()){
            uploadDirectory.mkdir();
        }
        return uploadDirectory;
    }

    public String getUploadPath(){
        return uploadConfig.getUploadPath();
    }

    public  File getPDF(String officeFilePath) throws Exception{
        File officeFile = new File(officeFilePath);
        if(officeFile.exists()){
            String pdfFilePath = officeFilePath.substring(0,officeFilePath.lastIndexOf('.')) + FileUtils.PDF_SUFFIX;
            File pdfFile = new File(pdfFilePath);
            synchronized(this){
                if (pdfFile.exists()) {
                    return pdfFile;
                } else {
                    try {
                        documentConverter.convert(officeFile).to(pdfFile).execute();
                        return pdfFile;
                    } catch (OfficeException e) {
                        e.printStackTrace();
                        throw new ServiceException("pdf转换异常！");
                    }
                }
            }
        }
        return null;
    }

    public   File pdf2Png(File pdfFile) throws Exception{
        if(pdfFile!=null&&pdfFile.exists()){
            try {
                String pdfPath = pdfFile.getAbsolutePath();
                String pngPath = pdfPath.substring(0,pdfPath.lastIndexOf('.')) + PNG_SUFFIX;
                File pngFile = new File(pngPath);
                synchronized(this){
                    if (pngFile.exists()) {
                        return pngFile;
                    } else {
                        PDDocument doc = PDDocument.load(pdfFile);
                        PDFRenderer renderer = new PDFRenderer(doc);
                        int pageCount = doc.getNumberOfPages();
                        for (int i = 0; i < pageCount; i++) {
                            // 方式1,第二个参数是设置缩放比(即像素)
                            //BufferedImage image = renderer.renderImageWithDPI(i, 296);
                            // 方式2,第二个参数是设置缩放比(即像素)
                            BufferedImage image = renderer.renderImage(i, 2.0f);
                            ImageIO.write(image, "PNG", pngFile);
                            return pngFile;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServiceException("pdf转图片失败");
            }
        }
        return null;
    }

    public static String readInfoStream(InputStream input) throws Exception {
        if (input == null) {
            throw new Exception("输入流为null");
        }
        //字节数组
        byte[] bcache = new byte[2048];
        int readSize = 0;//每次读取的字节长度
        int totalSize = 0;//总字节长度
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            //一次性读取2048字节
            while ((readSize = input.read(bcache)) > 0) {
                totalSize += readSize;
                if (totalSize > PROTECTED_LENGTH) {
                    throw new Exception("输入流超出50K大小限制");
                }
                //将bcache中读取的input数据写入infoStream
                infoStream.write(bcache,0,readSize);
            }
        } catch (IOException e1) {
            throw new Exception("输入流读取异常");
        } finally {
            try {
                //输入流关闭
                input.close();
            } catch (IOException e) {
                throw new Exception("输入流关闭异常");
            }
        }

        try {
            return infoStream.toString(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new Exception("输出异常");
        }
    }
}
