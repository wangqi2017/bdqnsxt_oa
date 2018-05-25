package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.DocumentDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Document;
import com.bdqnsxt.oa.service.DocumentService;
import com.bdqnsxt.oa.utils.FileUtils;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.jodconverter.DocumentConverter;
import org.jodconverter.office.OfficeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    private DocumentDao documentDao;
    @Autowired
    private FileUtils fileUtils;



    @Transactional(readOnly = true)
    @Override
    public PageResult getList(BaseQuery baseQuery) throws Exception {
        return new PageResult(documentDao.getListPage(baseQuery),baseQuery.getPage().getTotal_count());
    }

    @Transactional
    @Override
    public void upload(Document doc, MultipartFile file) throws Exception {
        if(file.isEmpty()){
            throw new ServiceException("上传内容不能为空失败！");
        }
        String fileName = file.getOriginalFilename();

        File out = File.createTempFile(fileName.substring(0,fileName.lastIndexOf(".")),fileName.substring(fileName.lastIndexOf(".")),fileUtils.getUploadDirectory());
        try {
            file.transferTo(out);
        }catch(IOException e){
            throw new ServiceException("文件保存过程出错，请和管理员联系");
        }
        doc.setName(file.getOriginalFilename());
        doc.setLocation(out.getName());
        documentDao.save(doc);
        documentDao.saveDocCat(doc);
    }

    @Transactional
    @Override
    public void delete(Document doc) throws Exception {
        Document document = documentDao.getById(doc);
        //删除文件
        String location = fileUtils.getUploadPath()+ File.separator + document.getLocation();
        File file = new File(location);
        if(file.exists()&&file.isFile()){
            file.delete();
        }
        //删除pdf
        String pdfLocation = location.substring(0,location.lastIndexOf('.')) + FileUtils.PDF_SUFFIX;
        File pdfFile = new File(pdfLocation);
        if(pdfFile.exists()&&pdfFile.isFile()){
            pdfFile.delete();
        }

        documentDao.deleteCenter(doc.getId());
        documentDao.delete(doc);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<byte[]> download(long id) throws Exception {
        Document doc = documentDao.getById(new Document(id));
        HttpHeaders headers = new HttpHeaders();
        if(doc.getLocation()!=null){
            File file = new File(fileUtils.getUploadPath()+ File.separator + doc.getLocation());
            if(file.exists()){
                headers.setContentDispositionFormData("attachment", new String(doc.getName().getBytes("UTF-8"),"iso-8859-1"));
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(file),
                        headers, HttpStatus.CREATED);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> view(long id) throws Exception {
        Document doc = documentDao.getById(new Document(id));
        if(doc.getLocation()!=null){
            String officeFilePath = fileUtils.getUploadPath()+ File.separator + doc.getLocation();
            //File officeFile = new File(officeFilePath);
            File pdfFile = fileUtils.getPDF(officeFilePath);
            File pngFile = fileUtils.pdf2Png(pdfFile);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            return new ResponseEntity<>(org.apache.commons.io.FileUtils.readFileToByteArray(pdfFile),
                    headers, HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }




}