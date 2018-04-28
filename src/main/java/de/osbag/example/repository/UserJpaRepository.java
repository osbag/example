package de.osbag.example.repository;

import de.osbag.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bijan.zohouri on 4/24/2018.
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {
}
