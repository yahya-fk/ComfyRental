package com.example.comfyrental.Entities;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdI;
    private String ImagePath;
    @ManyToOne
    private Local local;
    public Image(){
        super();
    }
    public Image(String imagePath, Local local) {
        ImagePath = imagePath;
        this.local = local;
    }

    @Override
    public String toString() {
        return "Image{" +
                "IdI=" + IdI +
                ", ImagePath='" + ImagePath + '\'' +
                ", local=" + local +
                '}';
    }

    public Long getIdI() {
        return IdI;
    }

    public void setIdI(Long idI) {
        IdI = idI;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
