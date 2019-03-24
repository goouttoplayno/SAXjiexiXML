package com.example.saxjiexixml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private List<HashMap<String, String>> list = null;
    private HashMap<String, String> map = null;
    private String currentTag = null;
    private String currentValue = null;
    private String nodeName = null;

    public MyHandler(String nodeName){
        this.nodeName = nodeName;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        list = new ArrayList<HashMap<String, String>>();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals(nodeName)){
            map = new HashMap<String, String>();
        }
        if (attributes != null && map != null){
            for (int i = 0; i < attributes.getLength(); i++){
                map.put(attributes.getQName(i), attributes.getValue(i));
            }
        }
        currentTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals(nodeName)){
            list.add(map);
            map = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (currentTag != null && map != null){
            currentValue = new String(ch, start, length);
            if (currentValue != null && !currentValue.equals("") && !currentValue.equals("\n")){
                map.put(currentTag, currentValue);
            }
        }
        currentValue = null;
        currentTag = null;
    }

    public List<HashMap<String, String>> getList(){
        return list;
    }

}
