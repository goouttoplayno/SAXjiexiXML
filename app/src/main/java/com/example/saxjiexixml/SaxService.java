package com.example.saxjiexixml;

import android.widget.Space;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxService {
    public SaxService(){

    }

    public static List<HashMap<String, String>> readXML(InputStream inputStream, String nodeName){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser sPraser = factory.newSAXParser();
            MyHandler myHandler = new MyHandler(nodeName);
            sPraser.parse(inputStream, myHandler);
            inputStream.close();
            return myHandler.getList();
        } catch (Exception e){

        }

        return null;
    }
}
