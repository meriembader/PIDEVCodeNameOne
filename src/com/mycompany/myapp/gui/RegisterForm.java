/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.io.rest.Rest;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
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
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.util.Base64;
import com.mycompany.myapp.entities.User;

import com.mycompany.myapp.entities.benevole;
import com.mycompany.myapp.services.ServiceBenevole;
import com.mycompany.myapp.services.ServiceUser;
import com.sendgrid.Response;
import java.util.Map;


/**
 *
 * @author Meriem
 */
public class RegisterForm extends Form {
    
     public RegisterForm(Form previous) {

           super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome To, ", "WelcomeWhite"),
                new Label("LITO", "WelcomeBlue")
        );
        
      
        
        getTitleArea().setUIID("Container");
     
    //   add(new Label("Benevole ", "TodayTitle"));
      
        setLayout(BoxLayout.y());
               
        TextField tfUsername = new TextField("", "username ");
        TextField tfEmail= new TextField("", "Email");
         TextField tfPassword= new TextField("", "password");
        
        
        Button btnValider = new Button("Ajouter");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfUsername.getText().length()==0)||(tfEmail.getText().length()==0) ||(tfPassword.getText().length()==0))
                    Dialog.show("Alert", "Remplir tout les champs", new Command("OK"));
                else
                {
                    try {
                        User u= new User(tfUsername.getText(), tfEmail.getText(), tfPassword.getText());
                        if( ServiceUser.getInstance().addUser(u))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfUsername,tfEmail,tfPassword, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    }
       
   
