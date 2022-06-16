/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clie;

import com.formdev.flatlaf.FlatDarculaLaf;
import form.forms.ThreadG;

import javax.swing.*;
import java.util.Locale;

/**
 * @author adgjw
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //System.out.println(Color.getColor(Color.YELLOW.toString()).toString());
        Locale.setDefault(new Locale("en"));
        Thread t2 = new ThreadG();

        t2.start();


    }
}