package com.example.comfyrental.Models;

import com.example.comfyrental.Enums.TypeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDetailModel {
    private Long idL;
    private String[] imgPathList;
    private String addresse;
    private String city;
    private TypeEnums type;
    private String descLocal;
    private String name;
    private String price;

    public LocalDetailModel(String[] imgPathList, String addresse, String city, TypeEnums type, String descLocal, String name, String price) {
        this.imgPathList = imgPathList;
        this.addresse = addresse;
        this.city = city;
        this.type = type;
        this.descLocal = descLocal;
        this.name = name;
        this.price = price;
    }
}
