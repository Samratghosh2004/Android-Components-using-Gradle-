package com.example.recylerview;

public class contactMedel {
    // INITIALIZE THE VARIABLES ACCORDING TO THE XML FILES WHICH WILL VARY  --->
    int img;
    String name,number;

    // ADD CONSTRACTOR ---->
    public contactMedel(int image, String name, String number) {
        this.img = image;
        this.name = name;
        this.number = number;
    }
    public contactMedel(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
