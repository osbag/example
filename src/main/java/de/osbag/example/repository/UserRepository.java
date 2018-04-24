/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.osbag.example.repository;

import de.osbag.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eldin
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
