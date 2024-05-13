package com.example.comfyrental.Security.Entities;

import com.example.comfyrental.Entities.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Transactional
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    @Id
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles ;


}
