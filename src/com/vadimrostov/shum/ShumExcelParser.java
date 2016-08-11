package com.vadimrostov.shum;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Vadim on 09.08.2016.
 */
public class ShumExcelParser {

   /* ShumFieldsFactory getd = new ShumFieldsFactory();
    ShumData data=getd.getData();*/

    HashMap<Double,Double>test=new HashMap<>();
    HashMap<Integer,Double>test1=new HashMap<>();
    int i=0,s3;
    double s1,s2;

    public void setS3(int s3) {
        this.s3 = s3;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }

    public void setS2(double s2) {
        this.s2 = s2;
    }

    public  void parsexls(HashMap<Double, Double> map, String file)  {
        try{InputStream in = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(in);

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {

            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int celli=cell.getColumnIndex();
                   if (celli==0){
                    setS1(cell.getNumericCellValue());

                }
                else if (celli==1){
                    setS2(cell.getNumericCellValue());
                    break;
                }
            }

            map.put(s1,s2);
        }


        }
        catch (IOException c){

        }

    }

    public void parsexls1(HashMap<Integer, Double>map, String file){
        try{InputStream in = new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(in);

            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            while (it.hasNext()) {

                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int celli=cell.getColumnIndex();
                    if (celli==0){
                        setS3((int)cell.getNumericCellValue());

                    }
                    else if (celli==1){
                        setS2(cell.getNumericCellValue());
                        break;
                    }
                }

                map.put(s3,s2);
            }


        }
        catch (IOException c){

        }
    }






}
