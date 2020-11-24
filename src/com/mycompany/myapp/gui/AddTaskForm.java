/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.myapp.entities.association;
import com.mycompany.myapp.services.ServiceTask;
import com.sendgrid.*;
import java.io.IOException;

/**
 *
 * @author bhk
 */
public class AddTaskForm extends Form{

    public AddTaskForm(Form previous) {
        
           super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
      
           Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome To, ", "WelcomeWhite"),
                new Label("LITO", "WelcomeBlue")
        );
        
        
        getTitleArea().setUIID("Container");
     
 // add(new Label("Association ", "TodayTitle"));
        setLayout(BoxLayout.y());
        
        TextField tfRaisonSociale = new TextField("", "Raison ",20, TextField.ANY);
        TextField tfAddress= new TextField("", "Address",20, TextField.ANY);
         TextField tfTelephone = new TextField("","Telephone",20, TextField.ANY);
        TextField tfDomaine= new TextField("", "Domaine",20, TextField.ANY);
         TextField tfGouvernorat = new TextField("","Gouvernorat",20, TextField.ANY);
         
             tfRaisonSociale.getAllStyles().setMargin(LEFT, 0);
        tfAddress.getAllStyles().setMargin(LEFT, 0);
          
        tfTelephone.getAllStyles().setMargin(LEFT, 0);
      
        tfDomaine.getAllStyles().setMargin(LEFT, 0);
           tfGouvernorat.getAllStyles().setMargin(LEFT, 0);
           Button btnValider = new Button("Soummetre");
        btnValider.setUIID("LoginButton");
         
     btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               Email from = new Email("meriem.bader1@esprit.tn");
    String subject = "Candidature LITO";
    Email to = new Email("meriembader8@gmail.com");
    Content content = new Content("text/plain", "merci de confirmer la candidature");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid("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");
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
    System.out.println("message non envoyé");
    }
            }
        });
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfRaisonSociale.getText().length()==0)||(tfAddress.getText().length()==0 || tfTelephone.getText().length()==0)||(tfDomaine.getText().length()==0 || tfGouvernorat.getText().length()==0))
                    Dialog.show("Alert", "Remplir tout les champs", new Command("OK"));
                else
                {
                    try {
                        association a = new association( tfRaisonSociale.getText(), tfAddress.getText(), Integer.parseInt(tfTelephone.getText()) , tfDomaine.getText(), tfGouvernorat.getText());
                        if( ServiceTask.getInstance().addAssociation(a))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfRaisonSociale,tfAddress, tfTelephone,tfDomaine,tfGouvernorat, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
