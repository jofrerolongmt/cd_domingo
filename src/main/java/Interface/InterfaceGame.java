/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Game;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JOFRE ROLONG STERLING
 */
public interface InterfaceGame  extends CrudRepository<Game,Integer> {
    
}