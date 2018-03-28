/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spritemap2chieu;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rơm
 */
public class Spritemap2chieu {

     public static void join(String inputPath,String outputPath) throws IOException{
        
        File directory= new File(inputPath);
      
        File[] files=directory.listFiles();
        System.out.println(files.length);
       
        BufferedImage sprite= ImageIO.read(files[0]);
        int with=sprite.getWidth()*(files.length/2);
        int height=sprite.getHeight()*(files.length/2);
        System.out.println(with);
        System.out.println(height);
        
        BufferedImage spritemap = new BufferedImage(with, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d=spritemap.createGraphics();
        
       int x=0,y=0, dem=0, row=2;
      
       for(File file:files){
           
           sprite=ImageIO.read(file);
           
            g2d.drawImage(sprite, null, x,y);
            
            x+=sprite.getWidth();
             dem++;
             System.out.println(dem);
             if(dem>=row){
                 y+=sprite.getHeight();
                 x=0;
                 g2d.drawImage(sprite, null, x,y);
                 dem=0;
             }  
       }
       
       ImageIO.write(spritemap, "png", new File(outputPath));
    }
    public static void main(String[] args) {
        try{
         
            Spritemap2chieu.join("C:\\Users\\admin\\Desktop\\pokemon", "C:\\Users\\admin\\Desktop\\output\\pokemon.png");
        }catch(IOException ex){
            System.err.println(ex);}
    }
    
}
