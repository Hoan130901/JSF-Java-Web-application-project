/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ilove
 */
@Named(value = "multiplicationDetails")
@SessionScoped
public class MultiplicationDetails implements Serializable {

    /**
     * Creates a new instance of MultiplicationDetails
     */
    Integer randomOne;
    Integer randomTwo;
    Integer userInput;
    String response;
 /**
     * Creates a new instance of MultiplicationDetails
     */
    public MultiplicationDetails() {
        Random ranGen = new Random();
        randomOne = ranGen.nextInt(10);
        randomTwo = ranGen.nextInt(10);
    }
    
    public void setRandomOne(Integer randomOne) {
        this.randomOne = randomOne;
    }

    public void setRandomTwo(Integer randomTwo) {
        this.randomTwo = randomTwo;
    }

    public void setUserInput(Integer userInput) {
        this.userInput = userInput;
    }

    public Integer getRandomOne() {
        return randomOne;
    }

    public Integer getRandomTwo() {
        return randomTwo;
    }

    public Integer getUserInput() {
        return userInput;
    }
    public String getResponse() {
        
        Integer answer = randomOne * randomTwo;
        
        //if (userInput == answer)  // this is un-safe
       
        if (Objects.equals(userInput, answer))
        {
            //invalidate user session
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();          
            return "Congratulations! That is correct.";           
        }else
        {
            return" Sorry, that was wrong. Try again.";
        }
    }
    
}
