package ata.Util;

import ata.Object.Phrase;
import ata.Object.Picture;
import ata.Object.Snippet;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.xslf.usermodel.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PowerPointUtil {
    public XMLSlideShow CreateSlides(ArrayList samples, XMLSlideShow ppt){
        int size = samples.size();
        for(int i=0;i<size;i++){
            try {
                CreateSingleSlide(samples.get(i),ppt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ppt;
    }

    private  <T> void CreateSingleSlide(T Object, XMLSlideShow ppt) throws IOException {
        if(Object instanceof Snippet ){
            XSLFSlide slide = ppt.createSlide();
            XSLFTextBox textBox = slide.createTextBox();
            Snippet sample = (Snippet) Object;
            textBox.setAnchor(new java.awt.Rectangle(180,100,400,250));
            XSLFTextParagraph tp = textBox.addNewTextParagraph();
            XSLFTextRun tr = tp.addNewTextRun();
            tr.setText(sample.getContent());
            tp.setTextAlign(TextParagraph.TextAlign.CENTER);
            tr.setFontColor(Color.black);
            tr.setFontFamily("Arial");
            tr.setFontSize(14.0);
        }
        else if(Object instanceof Phrase ){
            XSLFSlide slide = ppt.createSlide();
            XSLFTextBox textBox = slide.createTextBox();
            Phrase sample = (Phrase) Object;
            textBox.setAnchor(new java.awt.Rectangle(180,100,400,250));
            XSLFTextParagraph tp = textBox.addNewTextParagraph();
            XSLFTextRun tr = tp.addNewTextRun();
            tr.setText(sample.getContent());
            tp.setTextAlign(TextParagraph.TextAlign.CENTER);
            tr.setFontColor(Color.black);
            tr.setFontFamily("Arial");
            tr.setFontSize(14.0);
        }else if(Object instanceof Picture){
            XSLFSlide slide = ppt.getSlides().get(ppt.getSlides().size()-1);
            Picture pic = (Picture) Object;
            XSLFPictureData pd = ppt.addPicture(new File(pic.getURL()), PictureData.PictureType.JPEG);
            XSLFPictureShape ps = slide.createPicture(pd);
            ps.setAnchor(new java.awt.Rectangle(200,280,250,200));
        }
    }

   public void setTitle(XMLSlideShow ppt, String title){
        XSLFSlide slide = ppt.createSlide();
        XSLFTextBox text = slide.createTextBox();
        XSLFTextParagraph tp = text.addNewTextParagraph();
        XSLFTextRun tr = tp.addNewTextRun();
        text.setAnchor(new java.awt.Rectangle(270,230,200,100));
        tr.setText(title);
        tp.setTextAlign(TextParagraph.TextAlign.CENTER);
        tr.setBold(true);
        tr.setFontColor(Color.BLACK);
        tr.setFontSize(32.);
        tr.setFontFamily("Arial");
   }

//   public void setHeaderFooter(String text, XMLSlideShow ppt){
//        HeadersFooters hf = ppt.;
//        hf.setSlideNumberVisible(true);
//        hf.setFootersText(text);
//   }

   public void OutputSlideShow(String FileName, XMLSlideShow ppt) throws IOException {
        FileOutputStream out = new FileOutputStream(FileName);
        ppt.write(out);
        out.close();
    }
}
