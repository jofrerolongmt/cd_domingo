/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAMILIA
 */
@Repository
public class RepositorioReservaciones {
    
            @Autowired
	    private InterfaceReservaciones crud4;
	
	    public List<Reservaciones> getAll(){
	        return (List<Reservaciones>) crud4.findAll();
	    }
	    public Optional<Reservaciones> getReservation(int id){
	        return crud4.findById(id);
	    }
	    public Reservaciones save(Reservaciones reservation){
	        return crud4.save(reservation);
	    }
	    public void delete(Reservaciones reservation){
	        crud4.delete(reservation);
	    }
    public List<Reservaciones> getReservationByStatus(String status){
        return crud4.findAllByStatus(status);
    }

    public List<Reservaciones> getReservationPeriod(Date dateOne, Date dateTwo){
        return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> clientList = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            clientList.add(new CountClient((Long) report.get(i)[1] ,(Cliente)report.get(i)[0]));
            }
        return clientList;
    }
}
