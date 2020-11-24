/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.association;

import com.mycompany.myapp.entities.benevole;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceBenevole {

 
    public ArrayList<benevole> benevoles;
    
    public static ServiceBenevole instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceBenevole() {
         req = new ConnectionRequest();
    }

    public static ServiceBenevole getInstance() {
        if (instance == null) {
            instance = new ServiceBenevole();
        }
        return instance;
    }


   

    public boolean addBenevole(benevole b ) {
        String url = Statics.BASE_URL + "/api/tasks/newBenevole"+"?" +"cin="+b.getCin() + "&" +"address=" + b.getAddress()+ "&" +"mail="+ b.getMail()+ "&" +"telephone="+ b.getTelephone()+ "&" +"niveau="+ b.getNiveau()+ "&" +"gouvernorat="+ b.getGouvernorat();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public ArrayList<benevole> parseBenevoles(String jsonText){
        try {
            benevoles=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                benevole b = new benevole();
                float id = Float.parseFloat(obj.get("id").toString());
                b.setId((int)id);
                float cin = Float.parseFloat(obj.get("cin").toString());
                b.setCin((int)cin);
               b.setAddress(((String)(obj.get("address").toString())));
                float telephone = Float.parseFloat(obj.get("telephone").toString());
                b.setId((int)telephone);
               b.setNiveau(((String)(obj.get("niveau").toString())));
               b.setGouvernorat(((String)(obj.get("gouvernorat").toString())));
               benevoles.add(b);
            }
            
            
        } catch (IOException ex) {
            
        }
        return benevoles;
    }
    
    public ArrayList<benevole> getAllTasks(){
        String url = Statics.BASE_URL+"/api/tasks/allBenevole";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                benevoles = parseBenevoles(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return benevoles;
    }
}
