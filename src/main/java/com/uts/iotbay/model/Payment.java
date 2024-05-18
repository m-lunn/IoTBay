package com.uts.iotbay.model;



public class Payment   {
    
    String expiryDate;
    String cvv;
    String nameOnCard;
    String cardnumber;
    
    public Payment(String cardnumber, String expiryDate, String cvv, String nameOnCard) {
        this.cardnumber = cardnumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
    }
    


    public String getExpiryDate() {
        return expiryDate;
    }


    public String getCvv() {
        return cvv;
    }


    public String getNameOnCard() {
        return nameOnCard;
    }


    public String getCardnumber() {
        return cardnumber;
    }



    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }



    public void setCvv(String cvv) {
        this.cvv = cvv;
    }



    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }



    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }


}

