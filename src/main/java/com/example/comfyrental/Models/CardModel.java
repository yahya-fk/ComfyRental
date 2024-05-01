package com.example.comfyrental.Models;

import com.example.comfyrental.Entities.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardModel {
    private String[] imgList;
    private String title;
    private Double price;
    private String dateStart;
    private String dateEnd;
}
