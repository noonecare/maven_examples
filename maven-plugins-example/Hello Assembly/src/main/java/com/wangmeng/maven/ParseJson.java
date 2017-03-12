/**
 * Created by T440P on 2017/3/4.
 */
package com.wangmeng.maven;

import java.io.*;

import org.json.*;

public class ParseJson {
    public static void main(String[] args) throws IOException{
        // File file = new File(args[1]);
        File file = new File("src/main/resources/test.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInput dataInput = new DataInputStream(fileInputStream);
        String content = dataInput.readLine();
        System.out.println(content) ;
        JSONObject result = new JSONObject(content);
        System.out.println(result.getString("name"));

    }
}
