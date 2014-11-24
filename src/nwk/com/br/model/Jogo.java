/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Richard Matheus
 */
public class Jogo {
    private int cod;
    private String nome;
    private String plataforma;
    private Date data;
    private boolean update = false;
    
    //Formata a data de acordo com o formato de exibição
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
    //Formata a data de acordo com o formato de inserção do banco de dados
    private SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Date getData() {
        return data;
    }

    public void setData(String data) {
        try{
            this.data = sdf1.parse(data);
            //System.out.println(this.data + "  " + data);
        }catch(Exception e){
              System.out.println("Erro Data Usuario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }

    
    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public void setDataSelect(String data) {
        try{
            this.data = sdf2.parse(data);
            //System.out.println(this.data + "  " + data);
        }catch(Exception e){
              System.out.println("Erro Data Usuario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }
}
