package com.example.comfyrental.Models;

import com.example.comfyrental.Enums.TypeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDetailModel {
    private byte[][] imgPathList;
    private Long idL;
    private String addresse;
    private String city;
    private TypeEnums type;
    private String descLocal;
    private String name;
    private String price;
    private byte[] hostPic;
    private String hostName;
    private String dateStart;
    private String dateEnd;
    private long localId;

    public LocalDetailModel(byte[][] imgPathArray, String addresse, String city, TypeEnums type, String descLocal, String name, String price) {
        this.imgPathList = imgPathArray;
        this.addresse = addresse;
        this.city = city;
        this.type = type;
        this.descLocal = descLocal;
        this.name = name;
        this.price = price;
        this.hostName=null;
        this.hostPic=null;
        this.dateStart=null;
        this.dateEnd=null;
        this.localId=0;

    }
}
