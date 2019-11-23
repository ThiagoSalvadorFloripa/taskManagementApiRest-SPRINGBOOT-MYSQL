
package com.salvador.thiago.taskManagerApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salvador.thiago.taskManagerApiRest.domain.Task;

/**
* <p>Note:Interface responsible for extend JpaRepository 
* methods for data persistence
* </p>
* 
* @author Thiago Salvador - thiago.salvadorpower@gmail.com
*/
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
