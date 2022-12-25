package com.example.openapi.commands.vehiculs;


import com.example.openapi.commands.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateVehiculeCommand extends BaseCommand<String> {
     private int numMatricule;
    private String marque;
    private String model;
    private int fiscalPower;
    private String ownerName;
    private String ownerAddress;
    private String ownerPhone;
    private String ownerEmail;
    private String ownerNationalIdCard;

    public CreateVehiculeCommand(String id, int numMatricule, String marque, String model, int fiscalPower, String ownerName, String ownerAddress, String ownerPhone, String ownerEmail, String ownerNationalIdCard) {
        super(id);
        this.numMatricule = numMatricule;
        this.marque = marque;
        this.model = model;
        this.fiscalPower = fiscalPower;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
        this.ownerEmail = ownerEmail;
        this.ownerNationalIdCard = ownerNationalIdCard;
    }


}
