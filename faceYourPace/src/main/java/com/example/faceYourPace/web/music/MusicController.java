package com.example.faceYourPace.web.music;

import com.example.faceYourPace.domain.music.Play;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
/*
//@RestController
public class MusicController {

    // 경로 수정하기(mp3 파일이 들어있는 폴더 경로)
    private static String FOLDER_PATH = "/Users/hwikyung/Desktop/study/face-your-pace-backend";

    @RequestMapping(value = "/api/music/playlist", method = RequestMethod.POST)
    public @ResponseBody List<Play> getMusicNames(@RequestParam("listName") String listName) throws IOException {
        String filePath = "";

        List<Play> list = new ArrayList<Play>();
        if (!listName.equals("null")) { // 특정 플레이리스트 디렉토리일 경우
            filePath = FOLDER_PATH + listName;
        } else { // 기본 플레이리스트 디렉토리일 경우
            filePath = FOLDER_PATH;
        }

        File directory = new File(filePath);
        File[] files = directory.listFiles();

        try {
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().contains(".mp3"))
                   // list.add(new Play(files[i].getName(), true));
                else {
                    if (files[i].isDirectory())
                        //list.add(new Play(files[i].getName(), false));
                }
            }

        }catch (Exception e){
            System.out.println("error");
        }
        System.out.println("file list request. list size is" + list.size());

        return list;

    }

    // 요청받은 파일이 존재하면 파일을 스트림에 써줌
    // MediaPlayer 객체를 활용하여 서버의 url로 파일을 재생함
    @RequestMapping(value = "/api/music/download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> download(@RequestParam("musicName") String musicname) throws  IOException{
        String decodedString = URLDecoder.decode(musicname, "UTF-8");
        System.out.println("Download" + decodedString);
        File file = new File(FOLDER_PATH + decodedString);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-disposition", "attachment; musicName=" +decodedString);
        return ResponseEntity.ok().headers(headers).contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new FileInputStream(file)));
    }

}

 */
