/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TAFARI
 */
public class GenericClass<T> {

    public boolean serializeObject(T object, String fileName) {

        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeObject(object);
            output.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenericClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenericClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(GenericClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }
    
    public T deserializeObject(String fileName){
        
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            Object object = (T)input.readObject();
            input.close();
            return (T)object;
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenericClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenericClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenericClass.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        return null;
    }
}
 
    

