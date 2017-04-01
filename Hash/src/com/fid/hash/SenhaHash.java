/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.hash;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author JEFFERSON
 */
public class SenhaHash {
    
    //Inicio do Metodo Emcript
    public String Emcript(String senhaHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        MessageDigest algorithm = MessageDigest.getInstance("MD5"); // Instnciaciando o hash MD5 da classe MessageDigest
            algorithm.update(senhaHash.getBytes()); // atualizando o atributo senhaHash que é uma string para byte 
                byte messageDigest[] = algorithm.digest(senhaHash.getBytes("UTF-8")); // convertendo a senha hash em digesto
            String a = new String(messageDigest); // comvertedo o messageDigest que é em Byte em String
        System.out.println(messageDigest); //imprimindo no shell o digesto
                     
    return a; //retornando a string
 }
 //Fim do metodo Emcript
    //Inicio do metodo novoEmcript
    public byte[] novoEmcript(String senhaHash, String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //inicio da condição Try
        try {
            MessageDigest algorithm = MessageDigest.getInstance(hash); // Instnciaciando o hash MD5 da classe MessageDigest
                algorithm.update(senhaHash.getBytes()); // atualizando o atributo senhaHash que é uma string para byte       
                    return algorithm.digest(); //Retornando os digesto byte
                } catch (NoSuchAlgorithmException e) {
            return null; //retorno nulo ou sei lá
        }
        //fim da condição Try
    }
    //fim do metodo novoEmcript
    
   /** ESQUECE ISSO vvvvv
    public byte[] Escript(String senhaHash) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(senhaHash.getBytes("UTF-8"));
        return messageDigest;
    }
    ESQUECE ISSO ^^^^^
   */
    
    //Inicio do Metodo gerarHash
    public byte[] gerarHash(String frase, String algoritmo) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //Inicio da condição Try
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo); // Instnciaciando o hash da classe MessageDigest
                md.update(frase.getBytes());// atualizando o atributo senhaHash que é uma string para byte
                return md.digest();//Retornando os digesto byte
            } catch (NoSuchAlgorithmException e) {
        return null; //retorno nulo ou sei lá
    }
}
// fim do metodo gerarHash
    
    //Inicio do metodo processaSolicitacao
     public byte[] processaSolicitacao(String frase, String algoritmo) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);  // Instnciaciando o hash da classe MessageDigest
                md.update(frase.getBytes());  // atualizando o atributo senhaHash que é uma string para byte
                    /**
                    BigInteger hash = new BigInteger( 1, md.digest() );  //converter o digeto para BigInteger
                        String retornaSenha = hash.toString( 16 ); //convertendo o hash para string com 16 posissão 
                        System.out.println(retornaSenha); // imprimindo no shell
                    */
                    return md.digest(); //Retornando os digesto byte
             
                } catch (Exception e) {
            return null;//retorno nulo ou sei lá
        }
		 
    }
    //fim do metodo processaSolicitacao
     
     public String retornoString(byte[] a){
         try {
            BigInteger hash = new BigInteger(1, a);  //converter o digeto para BigInteger
                String retornaSenha = hash.toString( 16 ); //convertendo o hash para string com 16 posissão 
                    System.out.println(retornaSenha); // imprimindo no shell
                    return retornaSenha;
             
                } catch (Exception e) {
            return null;//retorno nulo ou sei lá
        }
         
     }

}
