/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiresthospital.service.admin;

import com.apiresthospital.data.modelDB.ConsultaDB;
import com.apiresthospital.model.Consulta;
import java.util.List;

/**
 *
 * @author luis
 */
public class AdminReportIngresosConsultaService {

    private ConsultaDB consultaDB;

    public AdminReportIngresosConsultaService() {
        this.consultaDB = new ConsultaDB();
    }
    
    public List<Consulta> getAll(){
        return this.consultaDB.getListConsulta();
    }
     public List<Consulta> getAllIntoTimeInterval(String fecha1, String fecha2){
        return this.consultaDB.getListConsulta(fecha1, fecha2);
    }
    
}
