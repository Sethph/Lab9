/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab9;

import edu.tarleton.database.Connection;
import edu.tarleton.database.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author sethp
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Properties prod = new Properties();
        String url;
        String username;
        String password;
        try(InputStream in = Main.class .getClassLoader()
                .getResourceAsStream("db.properties")){
            prod.load(in);
            url = prod.getProperty("url", "");
            username = prod.getProperty("username", "");
            password = prod.getProperty("password", "");
        }
        
        try(Connection con = new Connection(url, username,password)){
            try(Statement st = con.createStatement()){
                st.executeQuery("select * from Car");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
