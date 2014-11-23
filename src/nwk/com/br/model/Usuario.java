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
public class Usuario {
    private int cod;
    private String nome;
    private String senha;
    private Date data;
    private boolean update = false;
    
    private SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(String data) {
        try{
            this.data = sdf1.parse(data);
        }catch(Exception e){
              System.out.println("Erro DH Nascimento Funcionario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }

    
    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }


}
