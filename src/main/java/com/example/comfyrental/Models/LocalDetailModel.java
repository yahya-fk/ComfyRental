package com.example.comfyrental.Models;

import com.example.comfyrental.Enums.TypeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDetailModel {
    private String[] imgPathList;
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

}
