/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import javax.jms.MessageListener;
/**
 *
 * @author Lucas, Amanda e Tayiuko
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "mydes"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloMessageBean implements MessageListener {
    
    public HelloMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            TextMessage textMessage = (TextMessage)message;
            if(textMessage!=null){
                System.out.println(textMessage.getText());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
