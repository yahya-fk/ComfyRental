package com.example.comfyrental.Security.Repositories;

import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Entities.Role;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
}
