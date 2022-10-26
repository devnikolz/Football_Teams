package com.example.peoplelist;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class TeamsFromXML {

    private Context context;

    public Team[] getPeople() {
        return people;
    }

    private Team[] people;

    public TeamsFromXML(Context context){
        this.context = context;

        // make the input stream
        InputStream stream = context.getResources().openRawResource(R.raw.team);
        DocumentBuilder docBuilder = null;
        Document xmlDoc = null;

        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = docBuilder.parse(stream);
        }catch(Exception e){

        }

        // slice xmlDoc
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList addressList = xmlDoc.getElementsByTagName("owner");
        NodeList phoneList = xmlDoc.getElementsByTagName("history");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList urlList = xmlDoc.getElementsByTagName("url");

        people = new Team[nameList.getLength()];

        // populate people
        for(int i=0;i< people.length;i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String owner = addressList.item(i).getFirstChild().getNodeValue();
            String history = phoneList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            people[i] = new Team(name, history, owner, image, url);
        }

    }

    public int getLength(){return people.length;}
    public Team getPerson(int i){return people[i];}
    public String [] getNames(){
        String names [] = new String[people.length];
        for(int i=0;i<getLength();i++){
            names[i] = getPerson(i).getName();
        }
        return names;
    }
}
