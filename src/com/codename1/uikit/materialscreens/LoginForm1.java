/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceUser;


/**
 * The Login form
 *
 * @author Meriem
 */
public class LoginForm1 extends Form {
    public LoginForm1(Resources theme) {
       super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
      
        
        getTitleArea().setUIID("Container");
        
          TextField tfUsername = new TextField("", "Username", 20, TextField.EMAILADDR) ;
         TextField tfEmail= new TextField("", "Email",20, TextField.EMAILADDR);
        TextField tfPassword = new TextField("", "Password", 20, TextField.PASSWORD) ;
        tfUsername.getAllStyles().setMargin(LEFT, 0);
        tfEmail.getAllStyles().setMargin(LEFT, 0);
        tfPassword.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label EmailIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
      
        Button btnValider = new Button("Register");
        btnValider.setUIID("LoginButton");
         
          btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfUsername.getText().length()==0)||(tfPassword.getText().length()==0))
                    Dialog.show("Alert", "Remplir tout les champs", new Command("OK"));
                else
                {
                    try {
                        User u= new User(tfUsername.getText(), tfPassword.getText());
                        if( ServiceUser.getInstance().loginUser(tfUsername.getText(),tfPassword.getText()))
                             Dialog.show("Success","Utilisateur Créer",new Command("OK"));
                                
                       
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
    
      
     
 //   addAll(tfUsername,tfEmail,tfPassword, btnValider);
   getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new ProfileForm(theme).show());
          Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        // We remove the extra space for low resolution devices so things fit better
   
        
        
        Container by = BoxLayout.encloseY(
              
          
       
                spaceLabel,
                BorderLayout.center(tfUsername).
                        add(BorderLayout.WEST, loginIcon),
                  BorderLayout.center(tfEmail).
                        add(BorderLayout.WEST, EmailIcon),
                BorderLayout.center(tfPassword).
                        add(BorderLayout.WEST, passwordIcon),
                btnValider
                
             
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
/*
   loginButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            new WalkthruForm(theme).show();
            Toolbar.setGlobalToolbar(true);
        });
        */