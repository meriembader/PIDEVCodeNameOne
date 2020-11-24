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
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
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

import com.mycompany.myapp.entities.benevole;
import com.mycompany.myapp.services.ServiceBenevole;
import com.sendgrid.Response;
import java.util.Map;


/**
 *
 * @author Meriem
 */
public class AddBenevoleForm extends Form {
    
     public AddBenevoleForm(Form previous) {

           super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
           Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome To, ", "WelcomeWhite"),
                new Label("LITO", "WelcomeBlue")
        );
        
      
        
        getTitleArea().setUIID("Container");
     
    //   add(new Label("Benevole ", "TodayTitle"));
      
        setLayout(BoxLayout.y());
        
        TextField tfCin = new TextField("", "cin ",20, TextField.ANY);
        TextField tfAddress= new TextField("", "Address",20, TextField.ANY);
         TextField tfMail= new TextField("", "mail",20, TextField.EMAILADDR);
         TextField tfTelephone = new TextField("","Telephone",20, TextField.ANY);
        TextField tfNiveau= new TextField("", "Niveau",20, TextField.ANY);
         TextField tfGouvernorat = new TextField("","Gouvernorat",20, TextField.ANY);
        
           tfCin.getAllStyles().setMargin(LEFT, 0);
        tfAddress.getAllStyles().setMargin(LEFT, 0);
          tfMail.getAllStyles().setMargin(LEFT, 0);
        tfTelephone.getAllStyles().setMargin(LEFT, 0);
      
        tfNiveau.getAllStyles().setMargin(LEFT, 0);
           tfGouvernorat.getAllStyles().setMargin(LEFT, 0);
           
             Button btnValider = new Button("Soummetre");
        btnValider.setUIID("LoginButton");
        
         /********************************************************** SMS **************************************/
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             com.codename1.io.rest.Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/AC495c0ce0ede61bdacf81b4a9fc5cc379/Messages.json").
        queryParam("To", "+21626334028").
        queryParam("From","+12015810544").
        queryParam("Body", "merci de me confirmer la candidataure").
        header("Authorization", "Basic " + Base64.encodeNoNewline(("AC495c0ce0ede61bdacf81b4a9fc5cc379"+ ":" + "0845479e76224c6db8a2c656e13992f0").getBytes())).
        getAsJsonMap();
        if(result.getResponseData() != null) {
        String error = (String)result.getResponseData().get("error_message");
            if(error != null) {
            ToastBar.showErrorMessage(error);
            }
        } 
        else {
        ToastBar.showErrorMessage("Error sending SMS: " + result.getResponseCode());
        }
            }
        });
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfCin.getText().length()==0)||(tfAddress.getText().length()==0) ||(tfMail.getText().length()==0 || tfTelephone.getText().length()==0)||(tfNiveau.getText().length()==0 || tfGouvernorat.getText().length()==0))
                    Dialog.show("Alert", "Remplir tout les champs", new Command("OK"));
                else
                {
                    try {
                        benevole b= new benevole( Integer.parseInt(tfCin.getText()), tfAddress.getText(), tfMail.getText(), Integer.parseInt(tfTelephone.getText()) , tfNiveau.getText(), tfGouvernorat.getText());
                        if( ServiceBenevole.getInstance().addBenevole(b))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "CIN And Telephone  must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfCin,tfAddress,tfMail, tfTelephone,tfNiveau,tfGouvernorat, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }    
}