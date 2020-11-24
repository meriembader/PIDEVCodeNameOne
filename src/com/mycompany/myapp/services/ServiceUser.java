/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;
import com.mycompany.myapp.entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.association;
import com.mycompany.myapp.gui.HomeForm;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Meriem
 */
public class ServiceUser {
    
   
      ArrayList<User> usersLogin = new ArrayList<User>();
    
    public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    public String username;
    public String password;
    

    public ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }


    public boolean addUser(User u ) {
        String url = Statics.BASE_URL + "/api/tasks/newUser"+"?" +"username="+u.getUsername() + "&" +"email=" + u.getEmail()+ "&" +"password="+ u.getPassword();
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
    
    public boolean loginUser(String username,String pass ) {
    String url = Statics.BASE_URL + "/api/tasks/login?username="+username+"&password="+pass;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                String response=new String(req.getResponseData());
                if(response.equals("1"))
                {
                           ProfileForm profile=new ProfileForm();
                        profile.show();

                   
                 }
            }
            });
            NetworkManager.getInstance().addToQueueAndWait(req);
          return resultOK;
                }
}
    
      
                
               
         


  /*  @Override
    public void Create(User obj) {
         ConnectionRequest con = new ConnectionRequest();
       String Url = "http://localhost/Bras_Fort/web/app_dev.php"+"/"+obj.getUsername()+"/"+obj.getEmail()+"/"+obj.getPassword();
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }*/
