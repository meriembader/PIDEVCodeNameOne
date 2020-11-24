/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.CN.execute;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
    public HomeForm() {
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
          Button btnRegisterTask = new Button("Register");
             Button btnLoginTask = new Button("login");
        Button btnAddTask = new Button("Ajouter Assocdiation");
        Button btnListTasks = new Button("List des Associations");
         Button btnAddBenevole = new Button("Ajouter benevole");
        Button btnListBenevole = new Button("List des benevoles");
        Button btnPDF = new Button("download liste associations PDF");
       Button btnxls = new Button("download liste associations excel");

        btnxls.addActionListener(e-> execute("http://localhost/Bras_Fort/web/app_dev.php/association/excel"));
        btnPDF.addActionListener(e-> execute("http://localhost/Bras_Fort/web/app_dev.php/association/pdf"));
        // btnRegisterTask.addActionListener(e-> new LoginForm1(current).show());
         btnLoginTask.addActionListener(e-> new LoginTaskForm(current).show());
        btnAddTask.addActionListener(e-> new AddTaskForm(current).show());
        btnListTasks.addActionListener(e-> new ListTasksForm(current).show());
        addAll(btnLoginTask,btnRegisterTask,btnAddTask,btnListTasks);
         btnAddBenevole.addActionListener(e-> new AddBenevoleForm(current).show());
        btnListBenevole.addActionListener(e-> new ListBenevoleForm(current).show());
        addAll(btnAddBenevole,btnListBenevole,btnPDF,btnxls);
           
    }

}
