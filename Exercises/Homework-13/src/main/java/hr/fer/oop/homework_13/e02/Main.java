/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.homework_13.e02;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import jxl.read.biff.BiffException;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {

    public static void main(String[] args) throws IOException, BiffException {

        //save zip from url
        String url = "https://www.izbori.hr/lokalni2021/rezultati/1/zip/ZUP_21.zip";
        String file = "ZUP_21.zip";
        try ( InputStream is = new BufferedInputStream(new URL(url).openStream())) {
            //one line solution to copy Inputstream contents to file
            Files.copy(is, Path.of(file), StandardCopyOption.REPLACE_EXISTING);

            //multi-line solution to copy Inputstream contents to file
//            try ( BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("ZUP_21.zip"))) {
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = is.read(buffer, 0, 1024)) != -1) {
//                    output.write(buffer, 0, bytesRead);
//                }
//            }
        }
    }    
}
