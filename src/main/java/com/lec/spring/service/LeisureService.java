package com.lec.spring.service;


import com.lec.spring.domain.*;
import com.lec.spring.repository.LeisureFileRepository;
import com.lec.spring.repository.LeisureWriteRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.util.U;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LeisureService {

    @Value("${app.leisure.upload.path}")
    private String uploadDir;
    private LeisureWriteRepository leisureWriteRepository;

    private UserRepository userRepository;
    private LeisureFileRepository leisureFileRepository;

    @Autowired
    public LeisureService(SqlSession sqlSession) {
        leisureWriteRepository = sqlSession.getMapper(LeisureWriteRepository.class);
        userRepository = sqlSession.getMapper(UserRepository.class);
        leisureFileRepository = sqlSession.getMapper(LeisureFileRepository.class);
    }

    // db save
    public int leisureWrite(LeisureWrite leisureWrite,
                            Map<String, MultipartFile> files) {

        User user_id = U.getLoggedUser();
        user_id = userRepository.findById(user_id.getId());
        leisureWrite.setUser_id(user_id);

        int cnt = leisureWriteRepository.save(leisureWrite);

        addFiles(files, leisureWrite.getId());

        return cnt;
    }
//
//    public List<LeisureWrite> selectById(long id) {
//        List<LeisureWrite> list = new ArrayList<>();
//
//        LeisureWrite leisureWrite = leisureWriteRepository.findById(id);
//
//        if (leisureWrite != null) {
//            // ???????????? ?????? ????????????
//            List<LeisureFileDTO> fileList = leisureFileRepository.findByLeisure(leisureWrite.getId());
//            setImage(fileList);   // ????????? ?????? ?????? ??????
//            leisureWrite.setFiles(fileList);
//
//            list.add(leisureWrite);
//        }
//
//        return list;
//    }

    public LeisureWrite selectById2(long id) {
        LeisureWrite leisureWrite = leisureWriteRepository.findById(id);

        if (leisureWrite != null) {
            // ???????????? ?????? ????????????
            List<LeisureFileDTO> fileList = leisureFileRepository.findByLeisure(leisureWrite.getId());
            setImage(fileList);   // ????????? ?????? ?????? ??????
            leisureWrite.setFiles(fileList);

        }
        return leisureWrite;
    }


    // id: leisure_id
    private void addFiles(Map<String, MultipartFile> files, Long id) {
        if (files != null) {
            for (Map.Entry<String, MultipartFile> e : files.entrySet()) {
                System.out.println("\n???????????? ??????: " + e.getKey());
                // U.printFileInfo(e.getValue());

                // upload file
                LeisureFileDTO file = upload2((MultipartFile) e.getValue());

//                LeisureFileDTO file = upload(e.getValue());

                if (file != null) {
                    file.setLeisure_id(id);
                    leisureFileRepository.save(file);
                }

            }
        }
    }

    private LeisureFileDTO upload2(MultipartFile mfile) {
//        MultipartFile mfile = (MultipartFile)files.get("upfile0");
        if(mfile != null) {
//        System.out.println("-----------------------------------------");
//        System.out.println(multipartFile.getOriginalFilename());
//        System.out.println("-----------------------------------------");
            // 'file save' is needed.

            File folder = new File("C:\\DevRoot\\Dropbox\\Web\\Leisurvation\\upload\\leisure");
            if (!folder.exists())
                folder.mkdirs(); // ????????????
            String originalFileName = mfile.getOriginalFilename();
            String saveFileName = originalFileName;
            try {
                mfile.transferTo(new File(folder, saveFileName));  // folder?????? ????????? saveFileName???????????? upload??? ?????? ?????? ??????
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // System.out.println(saveFileName); // ?????????
            LeisureFileDTO leisureFileDTO = new LeisureFileDTO();
            leisureFileDTO.setSource(originalFileName);
            leisureFileDTO.setFile(saveFileName);
            return leisureFileDTO;
        }
        return null;
    }

    private LeisureFileDTO upload(MultipartFile multipartFile) {
        LeisureFileDTO attachment = null;

        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename == null || originalFilename.length() == 0) return null;

        String sourceName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String fileName = sourceName;

        File file = new File(uploadDir + File.separator + sourceName);
        if (file.exists()) {
            int pos = fileName.lastIndexOf(".");
            if (pos > -1) {
                String name = fileName.substring(0, pos);
                String ext = fileName.substring(pos + 1);
                fileName = name + "_" + System.currentTimeMillis() + "." + ext;
            } else {
                fileName += "_" + System.currentTimeMillis();
            }
        }

        Path copyOfLocation = Paths.get(new File(uploadDir + File.separator + fileName).getAbsolutePath());
        System.out.println(copyOfLocation);

        try {
            Files.copy(
                    multipartFile.getInputStream(),
                    copyOfLocation,
                    StandardCopyOption.REPLACE_EXISTING
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        attachment = LeisureFileDTO.builder()
                .file(fileName)
                .source(sourceName)
                .build();

        return attachment;
    } // end upload

    //??????
    public Double getAvgstar(Long id){

        return leisureWriteRepository.selectAvgStar(id);
    }

    @Transactional
    public List<LeisureWrite> leisureDetail(long id) {
        List<LeisureWrite> list = new ArrayList<>();

        LeisureWrite leisureWrite = leisureWriteRepository.findById(id);



        if (leisureWrite != null) {
            List<LeisureFileDTO> files = leisureFileRepository.findByLeisure(leisureWrite.getId());
            setImage(files);
            leisureWrite.setFiles(files);
            list.add(leisureWrite);
        }

        return list;
    }


    private void setImage(List<LeisureFileDTO> fileList) {
        // upload ?????? ???????????? ??????
        String realPath = new File(uploadDir).getAbsolutePath();

        for (LeisureFileDTO fileDto : fileList) {
            BufferedImage imgData = null;
            File f = new File(realPath, fileDto.getFile());  // ??????????????? ?????? File ??????
            try {
                imgData = ImageIO.read(f);
                // ??? ??? ????????? ?????? ?????? ????????? IOExcepion ????????????
                //   ??? ???????????? ?????? ????????? null ??????
            } catch (IOException e) {
                System.out.println("??????????????????: " + f.getAbsolutePath() + " [" + e.getMessage() + "]");
            }

            if (imgData != null) fileDto.setImage(true); // ????????? ?????? ??????
        } // end for
    }

    public List<LeisureWrite> listprice() {
        return leisureWriteRepository.findprice();
    }

    public List<LeisureWrite> liststar() {
        return leisureWriteRepository.findstar();
    }

    public int deleteById(long id) {
        int result = 0;

        LeisureWrite leisureWrite = leisureWriteRepository.findById(id);
        if (leisureWrite != null) {
            result = leisureWriteRepository.delete(leisureWrite);
        }
        return result;
    }

    public int update(LeisureWrite leisurewrite
            , Map<String, MultipartFile> files // ?????? ????????? ???????????????
            , Long[] delfile) {
        int result = 0;

        result = leisureWriteRepository.update(leisurewrite);

        // ???????????? ??????
        addFiles(files, leisurewrite.getId());

        // ????????? ?????????????????? ????????????
        if(delfile != null){
            for(Long fileId : delfile){
                LeisureFileDTO file = leisureFileRepository.findById(fileId);
                if(file != null){
                    delFile(file); // ??????????????? ??????
                   leisureFileRepository.delete(file); // db?????? ??????
                }
            }
        }

        return result;
    }// end update



    private void delFile(LeisureFileDTO file) {
        String saveDirectory = new File(uploadDir).getAbsolutePath();

        File f = new File(saveDirectory, file.getFile()); // ??????????????? ????????? ???????????? ?????? ??????
        System.out.println("????????????--> " + f.getAbsolutePath());

        if (f.exists()) {
            if (f.delete()) { // ??????!
                System.out.println("?????? ??????");
            } else {
                System.out.println("?????? ??????");
            }
        } else {
            System.out.println("????????? ???????????? ????????????.");
        } // end if
    }// end delFile

    //     ?????? ??? ??????
    public int deleteById(Long id) {
        int result = 0;

        LeisureWrite leisureWrite = leisureWriteRepository.findById(id);
        if (leisureWrite != null) {

            // ??????????????? ????????? ????????????(???) ??????
            List<LeisureFileDTO> fileList = leisureFileRepository.findByLeisure(id);
            if (fileList != null && fileList.size() > 0) {
                for (LeisureFileDTO file : fileList) {
                    delFile(file);
                }
            }

            result = leisureWriteRepository.delete(leisureWrite);
        }

        return result;
    }
}